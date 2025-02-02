package DomainGeneralizationHierarchy;

import Data.GeneralizationTable;
import Tree.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class DGH {

    //DGH is a data structure that defines how values in a specific domain (set of values) can be generalized to multiple levels
    //Each value in the hierarchy can be replaced with values that are broader and less specific
    //allows creating a hierarchy that defines how and to which levels data can be generalized

    private Tree tree;

    public DGH(Tree tree) {
        this.tree = tree;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public String generalise(String data){
        Node n = tree.bfsSearch(data);
        if(n==null){
            System.out.println("Error, can't find the data in the dgh "+data );
            return "error!";
        }
        if(n.getParent()!=null)return n.getParent().getData();
        else return n.getData();
    }

    public static DGH generateDGH(GeneralizationTable genTable){
        Tree tree = null;
        for(ArrayList<String> ars: genTable.getGenTable()){
            for(int i = ars.size()-1; i>-1; i--){
                String s = ars.get(i);
                if(tree==null) {
                    Node root = new Node(s, null,ars.size() - i - 1);
                    tree = new Tree(root, ars.size());
                }
                else if(tree.bfsSearch(s) == null){
                    Node parent = tree.bfsSearch(ars.get(i+1));
                    Node node = new Node(s, parent, ars.size()- i - 1);
                    tree.insert(parent, node);
                }
            }
        }

        if(tree!=null)return new DGH(tree);
        else return null;
    }

    public static HashMap<String,DGH> generateAllDGH(){
        HashMap<String,DGH> dghList = new HashMap<>();
        for(String fileName: GeneralizationTable.generalisationTableFiles){
            GeneralizationTable genTab = GeneralizationTable.readFileData(fileName);
            Path path = Paths.get(fileName);
            String table = path.getFileName().toString();
            int lastDotIndex = table.lastIndexOf(".");
            if (lastDotIndex != -1) {
                table = table.substring(0, lastDotIndex);
            }
            dghList.put(table,DGH.generateDGH(genTab));
        }
        return  dghList;
    }
}

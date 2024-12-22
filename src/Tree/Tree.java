package Tree;

import java.util.Queue;
import java.util.ArrayDeque;

public class Tree {

    private Node root;
    private int generalizationLevels;

    public Tree(Node root) {
        this.root = root;
    }
    public Tree(Node root, int generalizationLevels) {
        this.root = root;
        this.generalizationLevels = generalizationLevels;
    }

    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    public int getGeneralizationLevels() {
        return generalizationLevels;
    }
    public void setGeneralizationLevels(int generalizationLevels) {
        this.generalizationLevels = generalizationLevels;
    }

    //method for searching for data in a tree
    //BFS is a search that uses a queue to explore all nodes level by level
    //it is used to explore all nodes at the same level before moving to the next level

    public Node bfsSearch(String data){
        Queue<Node> visited = new ArrayDeque<>();
        Queue<Node> unvisited = new ArrayDeque<>();
        visited.add(root);
        unvisited.add(root);
        while(!unvisited.isEmpty()){
            Node current = unvisited.remove();
            visited.add(current);
            if(current.getData().equals(data)){
                return current;
            }
            else{
                for(Node n: current.getChildren()){
                    if(!visited.contains(n)) unvisited.add(n);
                }
            }
        }
        return null;
    }

    public Node getParent(String data){
        Node n = bfsSearch(data);
        if(n!=null)return n.getParent();
        else return null;
    }

    public boolean insert(Node parent, Node child){
        Node n = bfsSearch(parent.getData());
        if(n!=null){
            n.addChild(child);
            return true;
        }
        else return false;
    }

}

package DomainGeneralizationHierarchy;

import Tree.Tree;

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
}

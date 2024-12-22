package Data;

import java.util.ArrayList;

public class GeneralizationTable {

    //The Generalization table gives the rules for how values can be generalized.
    //The goal is to reduce the specificity of the data, making it less recognizable but still useful for analysis.

    private ArrayList<ArrayList<String>> genTable;

    public GeneralizationTable(ArrayList<ArrayList<String>> genTable) {

        this.genTable = genTable;
    }

    public ArrayList<ArrayList<String>> getGenTable() {

        return genTable;
    }

    public void setGenTable(ArrayList<ArrayList<String>> genTable) {
        this.genTable = genTable;
    }
}

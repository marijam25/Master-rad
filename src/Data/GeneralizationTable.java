package Data;

import java.util.ArrayList;

public class GeneralizationTable {

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

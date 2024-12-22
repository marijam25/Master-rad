package Data;

import java.util.ArrayList;

public class QuasiIdentifiers {

    private ArrayList<ArrayList<String>> quasiIdentifiersByRows;

    public QuasiIdentifiers() {

        this.quasiIdentifiersByRows = new ArrayList<>();
    }

    public QuasiIdentifiers(ArrayList<ArrayList<String>> quasiIdentifiersByRows) {
        this.quasiIdentifiersByRows = quasiIdentifiersByRows;
    }

    public ArrayList<ArrayList<String>> getQuasiIdentifiersByRows() {

        return quasiIdentifiersByRows;
    }

    public void setQuasiIdentifiersByRows(ArrayList<ArrayList<String>> quasiIdentifiersByRows) {
        this.quasiIdentifiersByRows = quasiIdentifiersByRows;
    }
}

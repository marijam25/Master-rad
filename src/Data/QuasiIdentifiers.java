package Data;

import java.util.ArrayList;

public class QuasiIdentifiers {

    //Quasi-identifiers are attributes in a data set that, by themselves, may not directly identify a person,
    // but when combined with other data may enable identification of a specific person.
    //they can be used for re-identification, so it is necessary to generalize these data.

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

    public ArrayList<String> getRow(int i){
        return quasiIdentifiersByRows.get(i);
    }

    public int getNumberOfRows(){
        return quasiIdentifiersByRows.size();
    }

    public int getNUmberOfColumns(){
        return quasiIdentifiersByRows.get(0).size();
    }

    public void insertRow(ArrayList<String> row){
        quasiIdentifiersByRows.add(row);
    }
}

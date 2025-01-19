package Data;

import GUI.Main;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class GeneralizationTable {

    //The Generalization table gives the rules for how values can be generalized.
    //The goal is to reduce the specificity of the data, making it less recognizable but still useful for analysis.

    public static final String directory = System.getProperty("user.dir") + File.separator + "data" + File.separator + "values" + File.separator;
    public static final String ageTableFile = directory + "Age.csv";
    public static final String cityTableFile = directory + "City.csv";
    public static final String gpaTableFile = directory + "Gpa.csv";
    public static final String genderTableFile = directory + "Gender.csv";
    public static final String moduleTableFile = directory + "Module.csv";
    public static final String indexTableFile = directory + "IndexNumber.csv";
    public static final String studyYearTableFile = directory + "StudyYear.csv";
    public static final String phoneNumberTableFile = directory + "Phone.csv";
    public static final String jmbgTableFile = directory + "JMBG.csv";
    public static final String[] generalisationTableFiles = {ageTableFile, cityTableFile,
            gpaTableFile, genderTableFile, moduleTableFile,
            indexTableFile, studyYearTableFile, phoneNumberTableFile, jmbgTableFile};


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

    public static GeneralizationTable readFileData(String fileName){
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            ArrayList<ArrayList<String>> values = new ArrayList<>();
            while(line!=null){
                String[] tokens = line.split(",");
                ArrayList<String> lineTokens = new ArrayList<>();
                for(String token:tokens){
                    lineTokens.add(token);
                }
                values.add(lineTokens);
                line = br.readLine();
            }
            return new GeneralizationTable(values);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(Main.frame, "Can't find file: " + fileName );
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(Main.frame, "Can't find file: " + fileName );
            e.printStackTrace();
        }
        return null;
    }
}

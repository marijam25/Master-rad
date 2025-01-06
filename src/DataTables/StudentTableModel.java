package DataTables;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class StudentTableModel extends AbstractTableModel {
    public static String[] columnNames = {"Name", "Surname", "Age", "JMBG", "Gender", "City", "Gpa", "Index Number", "Study Year", "Module", "Phone"};
    private final Class[] columnClasses = {String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class};
    private ArrayList<Student> list;

    public StudentTableModel(ArrayList<Student> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student s = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getName();
            case 1:
                return s.getSurname();
            case 2:
                return s.getAge();
            case 3:
                return s.getJMBG();
            case 4:
                return s.getGender();
            case 5:
                return s.getCity();
            case 6:
                return s.getGpa();
            case 7:
                return s.getIndexNumber();
            case 8:
                return s.getStudyYear();
            case 9:
                return s.getModule();
            case 10:
                return s.getPhone();
            default:
                return "N/A";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }

        public void setCollection(ArrayList<Student> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public Student getSelectedObject(int indexSelected) {
        return this.list.get(indexSelected);
    }
}

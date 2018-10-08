import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
Authors: Mohammed Riaz Khan - 215099613
         Clayton Petersen - 216155231
*/

public class DvdTableModel extends AbstractTableModel {


    public static ArrayList<DVD> dvds;
    private String[] columnHeadings = {"DVD Number", "Title", "Category", "Price", "New Release", "Available"};

    public DvdTableModel(){

        dvds = new ArrayList<>();

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex){

            case 4: return Boolean.class;

            case 5: return Boolean.class;


        }

        return Object.class;

    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        DVD dvd = dvds.get(rowIndex);

        switch (columnIndex){

            case 3:
                dvd.getPrice();
                break;
                
            case 4:
                dvd.setRelease((Boolean) aValue);
                break;
            case 5:
                dvd.setAvailable((Boolean) aValue);
                break;
            
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void addData(DVD dvd){

       dvds.add(dvd);
       fireTableDataChanged();

    }

    public void removeData(int index){

        dvds.remove(index);
        fireTableDataChanged();

    }


    @Override
    public String getColumnName(int column){

        return columnHeadings[column];
    }

    @Override
    public int getRowCount(){

        return dvds.size();

    }

    @Override
    public int getColumnCount(){

        return 6;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        DVD dvd = dvds.get(rowIndex);

        switch (columnIndex){

            case 0:
                return dvd.getDvdNumber();

            case 1:
                return dvd.getTitle();

            case 2:
                return dvd.getCategory();

            case 3:
                return dvd.getPrice();

            case 4:
                return dvd.isNewRelease();

            case 5:
                return dvd.isAvailable();    
                  
            default:
                return null;
        }
    }

  
}

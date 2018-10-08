import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
Authors: Mohammed Riaz Khan - 215099613
         Clayton Petersen - 216155231
*/

public class RentTableModel extends AbstractTableModel{

    static ArrayList<Rental> dvdsRental;
    private String[] columnHeadings = {"Rental Number", "Date Rented", "Date Returned", "Customer Number", "Dvd Number", "Total Penalty Cost (R)"};

    public RentTableModel(){

        dvdsRental = new ArrayList<>();

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        Rental dvdR = dvdsRental.get(rowIndex);
        
        switch(columnIndex){
            
            case 6:
                dvdR.getTotalPenaltyCost();
                break;
            
        }

    }

    public void addData(Rental dvd){

        dvdsRental.add(dvd);
        fireTableDataChanged();

    }

    public void removeData(int index){

        dvdsRental.remove(index);
        fireTableDataChanged();

    }


    @Override
    public String getColumnName(int column){

        return columnHeadings[column];
    }

    @Override
    public int getRowCount(){

        return dvdsRental.size();

    }

    @Override
    public int getColumnCount(){

        return 6;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Rental dvd = dvdsRental.get(rowIndex);

        switch (columnIndex){

            case 0:
                return dvd.getRentalNumber();

            case 1:
                return dvd.getDateRented();

            case 2:
                return dvd.getDateReturned();
                
            case 3:
                return dvd.getCustNumber();

            case 4:
                return dvd.getDvdNumber();

            case 5:
                return dvd.getTotalPenaltyCost();    

            default:
                return null;
        }
    }

}

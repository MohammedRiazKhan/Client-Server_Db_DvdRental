import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
Authors: Mohammed Riaz Khan - 215099613
         Clayton Petersen - 216155231
*/

public class CustomerTableModel extends AbstractTableModel{

    public static ArrayList<Customer> customers = new ArrayList<>();
    private String[] columnHeadings = {"Customer Number", "First Name", "Surname", "Phone Number", "Credit", "Can Rent"};

    public CustomerTableModel(){

    }

    public void updateArrayList(ArrayList<Customer> update){
    
        customers.addAll(update);
        fireTableDataChanged();
        
    }
    
    public void clear(){
        
        
        customers.clear();
    }
    
    
    public void addData(Customer customer){

        customers.add(customer);
        fireTableDataChanged();

    }

    public void removeData(int row){

        customers.remove(row);
        fireTableDataChanged();

    }

    @Override
    public String getColumnName(int column){

        return columnHeadings[column];
    }

    @Override
    public int getRowCount(){

        return customers.size();

    }

    @Override
    public int getColumnCount(){

        return 6;

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex){

            case 5: return Boolean.class;

        }

        return Object.class;

    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        Customer customer = customers.get(rowIndex);

        switch (columnIndex){

            case 5:
                customer.setCanRent((Boolean) aValue);

        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Customer customer = customers.get(rowIndex);

        switch (columnIndex){

            case 0:
                return customer.getCustNumber();

            case 1:
                return customer.getFirstName();

            case 2:
                return customer.getSurname();

            case 3:
                return customer.getPhoneNum();

            case 4:
                return customer.getCredit();
                
            case 5:
                return customer.isCanRent();

            default:
                return null;
                
        }
    }

   
}

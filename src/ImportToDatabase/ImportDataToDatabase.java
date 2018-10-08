import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class ImportDataToDatabase {

    static Database db = new Database();
    
    public static String getProgramPath() throws IOException{
        
        String currentDir = System.getProperty("user.dir");
        
        currentDir = currentDir.replace("\\", "/");
        
        return currentDir;
        
    }
    
    static ArrayList<Customer> customers = new ArrayList<>();;
    static ArrayList<DVD> dvds = new ArrayList<>();
    static ArrayList<Rental> rentals = new ArrayList<>();
 
    public static void loadCusFromFile(File file){
        
        try {
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            
            while(true){
              
                Customer customer = (Customer) ois.readObject();
                
                customers.add(customer);
         
                //System.out.println(customer);
                
            }
            
        } 
        catch(EOFException eof){
            
            System.out.println("End of file");
            
        }
        catch(IOException e){
            
            System.out.println(e.getMessage());
  
        } 
        catch (ClassNotFoundException ex) {
            
            Logger.getLogger(ImportDataToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        db.addCustomersToDb(customers);
    }
    
    public static void loadDvdFromFile(File file){
      
        try {
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            
            while(true){
              
                DVD dvd = (DVD) ois.readObject();
                
                dvds.add(dvd);
                
            }
        } 
        catch(EOFException eof){
            
            System.out.println("End of file");
            
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        
        db.addDvdsToDb(dvds);
    }
    
    public static void loadRentalFromFile(File file){
        
         try {
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            
            while(true){
              
                Rental rental = (Rental) ois.readObject();
                
                rentals.add(rental); 
                
                System.out.println(rental);
                
            }
        } 
        catch(EOFException eof){
            
            System.out.println("End of file");
            
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        } 
         
        db.addRentalsToDb(rentals);
    }
    
    public static void checkIfAllTablesFilledYet(){
        
        if(!ImportDataToDatabase.db.isCustomersEmpty() && !ImportDataToDatabase.db.isDvdsEmpty() && !ImportDataToDatabase.db.isRentalsEmpty()){
                    
            ImportDataToDatabaseGUI.jButton1.setEnabled(true);
            
        }
        else if(ImportDataToDatabase.db.isCustomersEmpty() && !ImportDataToDatabase.db.isDvdsEmpty() && !ImportDataToDatabase.db.isRentalsEmpty()){
            
            ImportDataToDatabaseGUI.jButton1.setEnabled(false);
            
        }
        else if(ImportDataToDatabase.db.isCustomersEmpty() && ImportDataToDatabase.db.isDvdsEmpty() && !ImportDataToDatabase.db.isRentalsEmpty()){
            
            ImportDataToDatabaseGUI.jButton1.setEnabled(false);
            
        }
        else if(!ImportDataToDatabase.db.isCustomersEmpty() && !ImportDataToDatabase.db.isDvdsEmpty() && ImportDataToDatabase.db.isRentalsEmpty()){
            
            ImportDataToDatabaseGUI.jButton1.setEnabled(false);
            
        }
        else if(!ImportDataToDatabase.db.isCustomersEmpty() && ImportDataToDatabase.db.isDvdsEmpty() && ImportDataToDatabase.db.isRentalsEmpty()){
            
            ImportDataToDatabaseGUI.jButton1.setEnabled(false);
            
        }
        else if(ImportDataToDatabase.db.isCustomersEmpty() && !ImportDataToDatabase.db.isDvdsEmpty() && ImportDataToDatabase.db.isRentalsEmpty()){
            
            ImportDataToDatabaseGUI.jButton1.setEnabled(false);
            
        }
       
    }
    
    public static void main(String[] args) {
       
        try {
            
            db.connect();
            
            if(!db.tablesExist("CUSTOMERS") && !db.tablesExist("MOVIES") && !db.tablesExist("RENTALS")){
                
                db.createTables();
                new ImportDataToDatabaseGUI();
                
            }
            else{
               
                new DataPopulatedDialog();
           
            }
        
        } catch (IOException ex) {
            
            Logger.getLogger(ImportDataToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ImportDataToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public static class SerializedFileFilter extends FileFilter {

        
        public String getExtension(String name){
            
            int in = name.lastIndexOf(".");
            
            if(in == -1){
                
                return null;
                
            }
            
            if(in == name.length() -1){
                
                return null;
                
            }
            
            return name.substring(in+1, name.length());
            
        }
        
        @Override
        public boolean accept(File f) {
            
            if(f.isDirectory()){
                
                return true;
                
            }
            
            String name = f.getName();
            
            String ext = getExtension(name);
            
            if(ext == null){
                
                return false;
                
            }
            
            if(ext.equals("ser")){
                
                return true;
                
            }
            
            
            
            return false;
        }

        @Override
        public String getDescription() {
        
            return "Serialized Files (.ser)";
            
        }
    }
}

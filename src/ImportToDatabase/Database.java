import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Database {
    
    Connection con;
    Statement stmt;
    ResultSet resultSet;

    public void connect() throws IOException{

        //file name specifying the locaion of the database file
        String filename = ImportDataToDatabase.getProgramPath() + "/db/dvdRental.accdb";

        //url to the database to make the java connection
        String dbURL = "jdbc:ucanaccess://" + filename.trim() + ";DriverID=22;READONLY=true}";

        //the driver name
        String driverName = "net.ucanaccess.jdbc.UcanaccessDriver";

         try {

            System.out.println("About to Load the JDBC Driver....");

            Class.forName(driverName);

            System.out.println("Driver Loaded Successfully....");
            System.out.println("About to get a connection....");

            con = DriverManager.getConnection(dbURL, "",""); 

            System.out.println("Connection Established Successfully....");

            stmt = con.createStatement();

        }
        catch(Exception err){

              System.out.println("ERROR: " + err);

        }  
    }

    public void disconnect() throws SQLException{

        con.close(); // close the Connection to let the database know we're done with it
        System.out.println("Closed successfully....");

    }
    
    public boolean tablesExist(String tableName){
      
        try {
             DatabaseMetaData metaData = con.getMetaData();
             
            resultSet = metaData.getTables(null, null, tableName, null);
            
            while(resultSet.next()){
                
                String name = resultSet.getString("TABLE_NAME");
                
                if(name.equals(tableName)){
                    
                    return true;
                    
                }
   
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return false;
    }
    
    public boolean isCustomersEmpty(){
        
        try {
            
            resultSet = stmt.executeQuery("SELECT COUNT(*) FROM CUSTOMERS");
            
            if(resultSet.equals(0)){
                
               return true;
                
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return false;
        
    }
    
    public boolean isDvdsEmpty(){
        
        try {
            
            resultSet = stmt.executeQuery("SELECT COUNT(*) FROM MOVIES");
            
            if(resultSet.equals(0)){
                
               return true;
                
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return false;
        
    }
     
    public boolean isRentalsEmpty(){
      
        try {
            
            resultSet = stmt.executeQuery("SELECT COUNT(*) FROM RENTALS");
            
            if(resultSet.equals(0)){
                
               return true;
                
            }
              
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
      
        return false;
        
    }
    
    public void createTables() throws SQLException{
        
        String cus = "CREATE TABLE CUSTOMERS( "
                                            + "Customer_Number INTEGER, "
                                            + "First_Name VARCHAR(30), "
                                            + "Surname VARCHAR(30), "
                                            + "Phone_Num VARCHAR(11), "
                                            + "Credit NUMBER, "
                                            + "Can_Rent VARCHAR(5), "
                                            + "CONSTRAINT cus_pk PRIMARY KEY(Customer_Number)"
                                         + ")"; 

        String dvd = "CREATE TABLE MOVIES( "
                                            + "Dvd_Number INTEGER, "
                                            + "Title VARCHAR(50),"
                                            + "Category VARCHAR(25), "
                                            + "Price NUMBER, "
                                            + "New_Release VARCHAR(5), "
                                            + "Available_For_Rent VARCHAR(5),"
                                            + "CONSTRAINT movie_pk PRIMARY KEY(Dvd_Number)"
                                       + ")";
        
        String rental = "CREATE TABLE RENTALS ("
                                            + "Rental_Number INTEGER, "
                                            + "Date_Rented VARCHAR(25), "
                                            + "Date_Returned VARCHAR(25), "
                                            + "Customer_Number INTEGER, "
                                            + "Dvd_Number INTEGER, "
                                            + "Total_Penalty_Cost NUMBER,"
                                            + "CONSTRAINT rental_pk PRIMARY KEY(Rental_Number),"
                                            + "CONSTRAINT cus_fk FOREIGN KEY(Customer_Number) REFERENCES CUSTOMERS(Customer_Number),"
                                            + "CONSTRAINT dvd_fk FOREIGN KEY(Dvd_Number) REFERENCES MOVIES(Dvd_Number)"
                                            + ")";
        
        stmt.execute(cus);
        stmt.execute(dvd);
        stmt.execute(rental);
        
    }
    
    public void deleteTables() throws SQLException{
        
        String dropConstraint1 = "ALTER TABLE RENTALS DROP CONSTRAINT cus_fk";
        String dropConstraint2 = "ALTER TABLE RENTALS DROP CONSTRAINT dvd_fk";
        
        String dropCus = "DROP TABLE CUSTOMERS";
        String dropMovies = "DROP TABLE MOVES";
        String dropRentals = "DROP TABLE RENTALS";
        
        stmt.execute(dropConstraint1);
        stmt.execute(dropConstraint2);
        
        stmt.executeUpdate(dropCus);
        stmt.executeUpdate(dropMovies);
        stmt.executeUpdate(dropRentals);
        
    }
    
    public void addCustomersToDb(ArrayList<Customer> customers){
   
        
        String insertCus = "INSERT INTO CUSTOMERS(Customer_Number, First_Name, Surname, Phone_Num, Credit, Can_Rent) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            
            
            PreparedStatement pr = con.prepareStatement(insertCus);
            
            for(int i = 0; i < customers.size(); i++){
                
                pr.setInt(1, customers.get(i).getCustNumber());
                pr.setString(2, customers.get(i).getFirstName());
                pr.setString(3, customers.get(i).getSurname());
                pr.setString(4, customers.get(i).getPhoneNum());
                pr.setDouble(5, customers.get(i).getCredit());
                pr.setBoolean(6, customers.get(i).isCanRent());
                
                pr.addBatch();
              
            }
            
            pr.executeBatch();
            
            JOptionPane.showMessageDialog(null, customers.size() + " Records added");
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ImportDataToDatabaseGUI.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public void addDvdsToDb(ArrayList<DVD> dvds){
        
        String insertDvd = "INSERT INTO MOVIES(Dvd_Number, Title, Category, Price, New_Release, Available_For_Rent) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            
            
            PreparedStatement pr2 = con.prepareStatement(insertDvd);
            
            for(int i = 0; i < dvds.size(); i++){
                
                pr2.setInt(1, dvds.get(i).getDvdNumber());
                pr2.setString(2, dvds.get(i).getTitle());
                pr2.setString(3, dvds.get(i).getCategory());
                pr2.setDouble(4, dvds.get(i).getPrice());
                pr2.setBoolean(5, dvds.get(i).isNewRelease());
                pr2.setBoolean(6, dvds.get(i).isAvailable());
                
                pr2.addBatch();
              
            }
            
            pr2.executeBatch();
            
            JOptionPane.showMessageDialog(null, dvds.size() + " Records added");
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ImportDataToDatabaseGUI.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public void addRentalsToDb(ArrayList<Rental> rentals){
        
        String insertRent = "INSERT INTO RENTALS(Rental_Number, Date_Rented, Date_Returned, Customer_Number, Dvd_Number, Total_Penalty_Cost) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            
            
            PreparedStatement pr = con.prepareStatement(insertRent);
            
            for(int i = 0; i < rentals.size(); i++){
                
                pr.setInt(1, rentals.get(i).getRentalNumber());
                pr.setString(2, rentals.get(i).getDateRented());
                pr.setString(3, rentals.get(i).getDateReturned());
                pr.setInt(4, rentals.get(i).getCustNumber());
                pr.setInt(5, rentals.get(i).getDvdNumber());
                pr.setDouble(6, rentals.get(i).getTotalPenaltyCost());
                
                pr.addBatch();
              
            }
            
            pr.executeBatch();
            
            JOptionPane.showMessageDialog(null, rentals.size() + " Records added");
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ImportDataToDatabaseGUI.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
    }
    
    public void addCustomerToDb(Customer customer){
        
        String insertCuss = "INSERT INTO CUSTOMERS(Customer_Number, First_Name, Surname, Phone_Num, Credit, Can_Rent) VALUES(?, ?, ?, ?, ?, ?)";
      
        try {
            
            //ResultSet ex = stmt.executeQuery(getIdToAdd);
        
            //int maxNum = ex.getInt(1) + 10;
            
            PreparedStatement prs = con.prepareStatement(insertCuss);
            
            prs.setInt(1, 111);
            prs.setString(2, customer.getFirstName());
            prs.setString(3, customer.getSurname());
            prs.setString(4, customer.getPhoneNum());
            prs.setDouble(5, customer.getCredit());
            prs.setBoolean(6, customer.isCanRent());
      
            
            prs.executeUpdate();
        
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
     
        
    }
    
    public void addDvdToDb(DVD dvd){
        
        String insertDvdd = "INSERT INTO MOVIES(Dvd_Number, Title, Category, Price, New_Release, Available_For_Rent) VALUES(?, ?, ?, ?, ?, ?)";
      
        try {
            
            //ResultSet ex = stmt.executeQuery(getIdToAdd);
        
            //int maxNum = ex.getInt(1) + 10;
            
            PreparedStatement prs = con.prepareStatement(insertDvdd);
            
            prs.setInt(1, 111);
            prs.setString(2, dvd.getTitle());
            prs.setString(3, dvd.getCategory());
            prs.setDouble(4, dvd.getPrice());
            prs.setBoolean(5, dvd.isNewRelease());
            prs.setBoolean(6, dvd.isAvailable());
      
            
            prs.executeUpdate();
        
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
     
        
    }
     
    public void addRentalToDb(Rental rental){
        
        String insertRentt = "INSERT INTO RENTALS(Rental_Number, Date_Rented, Date_Returned, Customer_Number, Dvd_Number, Total_Penalty_Cost) VALUES(?, ?, ?, ?, ?, ?)";
      
        try {
            
            //ResultSet ex = stmt.executeQuery(getIdToAdd);
        
            //int maxNum = ex.getInt(1) + 10;
            
            PreparedStatement prs = con.prepareStatement(insertRentt);
            
            prs.setInt(1, 111);
            prs.setString(2, rental.getDateReturned());
            prs.setString(3, rental.getDateReturned());
            prs.setInt(4, rental.getCustNumber());
            prs.setInt(5, rental.getDvdNumber());
            prs.setDouble(6, rental.getTotalPenaltyCost());
      
            prs.executeUpdate();
        
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
     
        
    } 
    
}

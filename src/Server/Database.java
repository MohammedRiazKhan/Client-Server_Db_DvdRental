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

    ArrayList<Customer> customersList = new ArrayList<>();
    ArrayList<DVD> dvdsList = new ArrayList<>();
    ArrayList<Rental> rentalsList = new ArrayList<>();
    
    public ArrayList<Customer> populateCustomerTable(){
        
        //clears the arraylist
        customersList.clear();
       
        String customers = "SELECT * FROM CUSTOMERS ORDER BY First_Name";
        
        try {
            
            resultSet = stmt.executeQuery(customers);
            
            while(resultSet.next()){
            
                int id = resultSet.getInt("Customer_Number");
                String name = resultSet.getString("First_Name");
                String surname = resultSet.getString("Surname");
                String phoneNum = resultSet.getString("Phone_Num");
                double credit = resultSet.getDouble("Credit");
                boolean canRent = resultSet.getBoolean("Can_Rent");
                
                Customer customer = new Customer(id, name, surname, phoneNum, credit, canRent);
                
                customersList.add(customer);
                
            }
     
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return customersList;
    
    }
    
    public ArrayList<DVD> populateDvdTable(){
        
        dvdsList.clear();
        
        String dvds = "SELECT * FROM MOVIES ORDER BY Category";
        
        try {
            
            resultSet = stmt.executeQuery(dvds);
            
            while(resultSet.next()){
                
                int id = resultSet.getInt("Dvd_Number");
                String title = resultSet.getString("Title");
                String category = resultSet.getString("Category");
                double price = resultSet.getDouble("Price");
                boolean newRelease = resultSet.getBoolean("New_Release");
                boolean avail = resultSet.getBoolean("Available_For_Rent");
               
                int catNum = 0;
                
                switch(category){
                    
                    case "Horror":
                        catNum = 1;
                        break;
                    
                    case "Sci-fi":
                        catNum = 2;
                        break;    
                        
                    case "Drama":
                        catNum = 3;
                        break;
                    
                    case "Romance":
                        catNum = 4;
                        break;    
                        
                    case "Comedy":
                        catNum = 5;
                        break;
                    
                    case "Action":
                        catNum = 6;
                        break;    
                       
                    case "Cartoon":
                        catNum = 7;
                        break;
                   
                    
                }
             
                DVD dvd = new DVD(id, title, catNum, newRelease, avail);
              
                dvdsList.add(dvd);
                        
            }
            
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dvdsList;
    }
    
    public ArrayList<Rental> populateRentalTable(){
        
        rentalsList.clear();
        
        String rentals = "SELECT * FROM RENTALS ORDER BY Date_Rented";
        
        try {
            
            resultSet = stmt.executeQuery(rentals);
            
            while(resultSet.next()){
                
                int id = resultSet.getInt("Rental_Number");
                String datR = resultSet.getString("Date_Rented");
                String dateR = resultSet.getString("Date_Returned");
                int cusId = resultSet.getInt("Customer_Number");
                int dvdId = resultSet.getInt("Dvd_Number");
                double penalty = resultSet.getDouble("Total_Penalty_Cost");
                
                Rental rent = new Rental(id, datR, dateR, cusId, dvdId);
                
                rentalsList.add(rent);
                
            }
     
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return rentalsList;
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

    public void connect() throws IOException{

        //file name specifying the locaion of the database file
        String filename = DvdRentalServer.getProgramPath() + "/db/dvdRental.accdb";

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
     
    public void addCustomerToDb(Customer customer){
        
        String insertCuss = "INSERT INTO CUSTOMERS(Customer_Number, First_Name, Surname, Phone_Num, Credit, Can_Rent) VALUES(?, ?, ?, ?, ?, ?)";
      
       String max = "SELECT MAX(Customer_Number) FROM CUSTOMERS";
        
        try {
            
            resultSet = stmt.executeQuery(max);
            
            resultSet.next();
            
            int maximum = resultSet.getInt(1) + 1;

            PreparedStatement prs = con.prepareStatement(insertCuss);
            
            prs.setInt(1, maximum);
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
      
        String max = "SELECT MAX(Dvd_Number) FROM MOVIES";
        
        try {
            
            resultSet = stmt.executeQuery(max);
            
            resultSet.next();
            
            int maximum = resultSet.getInt(1) + 1;
            
            PreparedStatement prs = con.prepareStatement(insertDvdd);
            
            prs.setInt(1, maximum);
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
      
        String max = "SELECT MAX(Rental_Number) FROM RENTALS";
        
        try {
            
            resultSet = stmt.executeQuery(max);
            
            resultSet.next();
            
            int maximum = resultSet.getInt(1) + 1;

            PreparedStatement prs = con.prepareStatement(insertRentt);
            
            prs.setInt(1, maximum);
            prs.setString(2, rental.getDateRented());
            prs.setString(3, rental.getDateReturned());
            prs.setInt(4, rental.getCustNumber());
            prs.setInt(5, rental.getDvdNumber());
            prs.setDouble(6, rental.getTotalPenaltyCost());
      
            prs.execute();
        
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
     
        
    } 

    //getting all customers that can rent a dvd 
    public ArrayList<Customer> getAllCustomers(){
        
        String getAllCus = "SELECT * FROM CUSTOMERS WHERE Can_Rent = 'true'";
        
        ArrayList<Customer> customersArray = new ArrayList<>();
                
        try {
            
            resultSet = stmt.executeQuery(getAllCus);
            
            while(resultSet.next()){
            
                int id = resultSet.getInt("Customer_Number");
                String name = resultSet.getString("First_Name");
                String surname = resultSet.getString("Surname");
                String phoneNum = resultSet.getString("Phone_Num");
                double credit = resultSet.getDouble("Credit");
                boolean canRent = resultSet.getBoolean("Can_Rent");
                
                Customer customer = new Customer(id, name, surname, phoneNum, credit, canRent);
                
                customersArray.add(customer);
                
            }
     
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       
        return customersArray;
        
    }
    
    public ArrayList<DVD> getAllDvds(){
        
        
        String dvds = "SELECT * FROM MOVIES WHERE Available_For_Rent = 'true'";
        
        ArrayList<DVD> dvdsArray = new ArrayList<>();
        
        try {
            
            resultSet = stmt.executeQuery(dvds);
            
            while(resultSet.next()){
                
                int id = resultSet.getInt("Dvd_Number");
                String title = resultSet.getString("Title");
                String category = resultSet.getString("Category");
                double price = resultSet.getDouble("Price");
                boolean newRelease = resultSet.getBoolean("New_Release");
                boolean avail = resultSet.getBoolean("Available_For_Rent");
               
                int catNum = 0;
                
                switch(category){
                    
                    case "Horror":
                        catNum = 1;
                        break;
                    
                    case "Sci-fi":
                        catNum = 2;
                        break;    
                        
                    case "Drama":
                        catNum = 3;
                        break;
                    
                    case "Romance":
                        catNum = 4;
                        break;    
                        
                    case "Comedy":
                        catNum = 5;
                        break;
                    
                    case "Action":
                        catNum = 6;
                        break;    
                       
                    case "Cartoon":
                        catNum = 7;
                        break;
                   
                    
                }
             
                DVD dvd = new DVD(id, title, catNum, newRelease, avail);
              
                dvdsArray.add(dvd);
                        
            }
     
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dvdsArray;
    }
    
    public ArrayList<Rental> getAllRentals(){
           
        rentalsList.clear();
        
        String rentals = "SELECT * FROM RENTALS WHERE Date_Returned = 'NA'";
        
         ArrayList<Rental> rentalsList = new ArrayList<>();
        
        try {
            
            resultSet = stmt.executeQuery(rentals);
            
            while(resultSet.next()){
                
                int id = resultSet.getInt("Rental_Number");
                String datR = resultSet.getString("Date_Rented");
                String dateR = resultSet.getString("Date_Returned");
                int cusId = resultSet.getInt("Customer_Number");
                int dvdId = resultSet.getInt("Dvd_Number");
                double penalty = resultSet.getDouble("Total_Penalty_Cost");
                
                Rental rent = new Rental(id, datR, dateR, cusId, dvdId);
                
                rentalsList.add(rent);
                
            }
     
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return rentalsList;
    }
    
    public ArrayList<Customer> getAllReturnCustomers(){
        
        String getAllRtCus = "SELECT * FROM CUSTOMERS WHERE Can_Rent = 'false' ";
        
        ArrayList<Customer> customerDvdReturn = new ArrayList<>();
                
        try {
            
            resultSet = stmt.executeQuery(getAllRtCus);
            
            while(resultSet.next()){
            
                int id = resultSet.getInt("Customer_Number");
                String name = resultSet.getString("First_Name");
                String surname = resultSet.getString("Surname");
                String phoneNum = resultSet.getString("Phone_Num");
                double credit = resultSet.getDouble("Credit");
                boolean canRent = resultSet.getBoolean("Can_Rent");
                
                Customer customerR = new Customer(id, name, surname, phoneNum, credit, canRent);
                
                customerDvdReturn.add(customerR);
                
            }
     
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       
        return customerDvdReturn;
        
    }
    
    public ArrayList<DVD> getAllReturnDvds(){
        
        
        String dvds = "SELECT * FROM MOVIES WHERE Available_For_Rent = 'false'";
        
        ArrayList<DVD> dvdsArray = new ArrayList<>();
        
        try {
            
            resultSet = stmt.executeQuery(dvds);
            
            while(resultSet.next()){
                
                int id = resultSet.getInt("Dvd_Number");
                String title = resultSet.getString("Title");
                String category = resultSet.getString("Category");
                double price = resultSet.getDouble("Price");
                boolean newRelease = resultSet.getBoolean("New_Release");
                boolean avail = resultSet.getBoolean("Available_For_Rent");
               
                int catNum = 0;
                
                switch(category){
                    
                    case "horror":
                        catNum = 1;
                        break;
                    
                    case "Sci-fi":
                        catNum = 2;
                        break;    
                        
                    case "Drama":
                        catNum = 3;
                        break;
                    
                    case "Romance":
                        catNum = 4;
                        break;    
                        
                    case "Comedy":
                        catNum = 5;
                        break;
                    
                    case "Action":
                        catNum = 6;
                        break;    
                       
                    case "Cartoon":
                        catNum = 7;
                        break;
                   
                    
                }
             
                DVD dvd = new DVD(id, title, catNum, newRelease, avail);
              
                dvdsArray.add(dvd);
                        
            }
     
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dvdsArray;
    }
     
    //gets all dvds based on the category
    public ArrayList<String> getMovieTitle(String category){
        
        String selectMovies = "SELECT Title FROM MOVIES WHERE Available_For_Rent = 'true' AND Category like '?'";
        
        ArrayList<String> titles = new ArrayList<>();
        
        try {
    
            PreparedStatement prs = con.prepareStatement(selectMovies);
            
            prs.setString(1, category);
            
            resultSet = stmt.executeQuery(selectMovies);
            
            while(resultSet.next()){
              
                String title = resultSet.getString("Title");
                
                titles.add(title);
               
                
            }
      
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return titles;
        
    }
    
    //gets all rental numbers
    public ArrayList<String> getRentalNumber(String rented){
        
        String selectRented = "SELECT Rental_Number FROM RENTALS";
        
        ArrayList<String> rental = new ArrayList<>();
        
        try {
    
            PreparedStatement prs = con.prepareStatement(selectRented);
            
            prs.setString(1, rented);
            
            resultSet = stmt.executeQuery(selectRented);
            
            while(resultSet.next()){
              
                String rentNum = resultSet.getString("Rental_Number");
                
                rental.add(rentNum);
               
                
            }
      
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return rental;
        
    }
    
    public ArrayList<Rental> getAllDailyRentals(Rental date){
        
        
        String getDailyRentals = "SELECT * FROM RENTALS WHERE Date_Rented = ?";
    
        rentalsList.clear();
        
        
        try {
            
            PreparedStatement prs = con.prepareStatement(getDailyRentals);
            
            prs.setString(1, date.getDateRented());      
              
            resultSet = stmt.executeQuery(getDailyRentals);
            
            while(resultSet.next()){
                
                int id = resultSet.getInt("Rental_Number");
                String datR = resultSet.getString("Date_Rented");  //String datR = resultSet.getString(date.getDateRented());
                String dateR = resultSet.getString("Date_Returned");
                int cusId = resultSet.getInt("Customer_Number");
                int dvdId = resultSet.getInt("Dvd_Number");
                double penalty = resultSet.getDouble("Total_Penalty_Cost");
                
                Rental rent = new Rental(id, datR, dateR, cusId, dvdId);
                
                rentalsList.add(rent);
                
            }
     
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return rentalsList;
        
    }
    
    public void updateCustCred(double credit, Rental returnRental){
        
        String updateCanRent = "UPDATE CUSTOMERS SET Credit = ? WHERE Customer_Number = ?";
        
         try {
    
            PreparedStatement prs = con.prepareStatement(updateCanRent);
            
            prs.setDouble(1, credit);
            
            prs.setInt(2, returnRental.getCustNumber());
     
            prs.execute();
        
      
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public void updateCust(int cusNum, double cusCredit){
        
        String updateCanRent = "UPDATE CUSTOMERS SET Can_Rent = 'false', Credit = ?  WHERE Customer_Number = ?";
        
         try {
    
            PreparedStatement prs = con.prepareStatement(updateCanRent);
            
            prs.setDouble(1, cusCredit);
            
            prs.setInt(2, cusNum);
     
            prs.execute();
        
      
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public void updateDvd(int dvdNum){
        
        
        String updateCanRent = "UPDATE MOVIES SET Available_For_Rent = 'false' WHERE Dvd_Number = ?";
        
         try {
    
            PreparedStatement prs = con.prepareStatement(updateCanRent);
            
            prs.setInt(1, dvdNum);
            
            prs.execute();
      
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public void updateReturnDate(Rental rental){
        
        String insertRentt = "UPDATE RENTALS SET Date_Returned = ?, Total_Penalty_Cost = ? WHERE Rental_Number = ?";
              
        try {

            PreparedStatement prs = con.prepareStatement(insertRentt);
            
            prs.setString(1, rental.getDateReturned());
            prs.setDouble(2,rental.getTotalPenaltyCost());
            prs.setInt(3, rental.getRentalNumber());
            prs.execute();
        
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
 
    }
        
    public void updateCustReturn(Rental returnRentalObj){
        
        String updateCanRent = "UPDATE CUSTOMERS SET Can_Rent = 'true' WHERE Customer_Number = ?";
        
         try {
    
            PreparedStatement prs = con.prepareStatement(updateCanRent);
            
            prs.setInt(1, returnRentalObj.getCustNumber());      
            
            prs.execute();
        
      
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public void updateDvdReturn(int dvdNum){
        
        
        String updateCanRent = "UPDATE MOVIES SET Available_For_Rent = 'true' WHERE Dvd_Number = ?";
        
         try {
    
            PreparedStatement prs = con.prepareStatement(updateCanRent);
            
            prs.setInt(1, dvdNum);
            
            prs.execute();
      
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public void updateDvd(Rental returnRentalObj) {
        
        String updateMov = "UPDATE MOVIES SET Available_For_Rent = 'false' WHERE Dvd_Number = ?";

        try {

            PreparedStatement ps12 = con.prepareStatement(updateMov);
            ps12.setInt(1, returnRentalObj.getDvdNumber());
            ps12.execute();
   
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    public void returnRental(Rental returnRentalObj) {
        
    String updateRent = "UPDATE RENTALS SET Date_Returned = ?, Total_Penalty_Cost = ? WHERE Rental_Number = ?";
        
        try {
               
            PreparedStatement ps13 = con.prepareStatement(updateRent);
            ps13.setString(1, returnRentalObj.getDateReturned());
            ps13.setDouble(2, returnRentalObj.getTotalPenaltyCost());
            ps13.setInt(3, returnRentalObj.getRentalNumber());
            ps13.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    
    public int getLatestCusNum(){
        
        String max = "SELECT MAX(Customer_Number) FROM CUSTOMERS";
        
        int maximum = 0;
        
        try {
            
            resultSet = stmt.executeQuery(max);
            
            resultSet.next();
            
            maximum = resultSet.getInt(1) + 1;
            
        }
        catch(SQLException s){
            
            System.out.println("Blah");
        }
        
        return maximum;
        
    }
    
     public int getLatestRentalNum(){
         
        
        String max = "SELECT MAX(Rental_Number) FROM RENTALS";
        
        int maximum = 0;
        
        try {
            
            resultSet = stmt.executeQuery(max);
            
            resultSet.next();
            
            maximum = resultSet.getInt(1) + 1;
            
        }
        catch(SQLException s){
            
            System.out.println("Blah");
        }
        
        return maximum;
        
    }
    
      public int getLatestDvdNum(){
        
        String max = "SELECT MAX(Dvd_Number) FROM MOVIES";
        
        int maximum = 0;
        
        try {
            
            resultSet = stmt.executeQuery(max);
            
            resultSet.next();
            
            maximum = resultSet.getInt(1) + 1;
            
        }
        catch(SQLException s){
            
            System.out.println("Blah");
        }
        
        return maximum;
        
    }
      
    public ArrayList<Rental> getAllRentalss(){
        
        String renals = "SELECT * FROM RENTALS";
        
        ArrayList<Rental> renalss = new ArrayList<>();
                Rental temp = new Rental(1, "--Select Date--", "s", 0, 0);
        renalss.add(temp);
        
        try{
         
            PreparedStatement prs = con.prepareStatement(renals);
            
            resultSet = stmt.executeQuery(renals);
            
            while(resultSet.next()){
                
                int id = resultSet.getInt("Rental_Number");
                String datR = resultSet.getString("Date_Rented");  //String datR = resultSet.getString(date.getDateRented());
                String dateR = resultSet.getString("Date_Returned");
                int cusId = resultSet.getInt("Customer_Number");
                int dvdId = resultSet.getInt("Dvd_Number");
                double penalty = resultSet.getDouble("Total_Penalty_Cost");
                
                Rental rent = new Rental(id, datR, dateR, cusId, dvdId);
                
                renalss.add(rent);
                
            }
            
        }
        catch(SQLException se){
            
            System.out.println("some error");
            
        }
        
        return renalss;
    }
      
}

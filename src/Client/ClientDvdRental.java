
/*
Authors: Mohammed Riaz Khan - 215099613
         Clayton Petersen - 216155231
*/


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane; 

public class ClientDvdRental {

    private Object[] choices = {"Pay fee cash"};
    
    static CustomerTableModel cusModel = new CustomerTableModel();
    static DvdTableModel dvdModel = new DvdTableModel();
    static RentTableModel rentModel = new RentTableModel();
 
    private static Socket server;
    public static ObjectInputStream receiveFromServer;
    public static ObjectOutputStream sendToServer;
    
    public ClientDvdRental(){

        try{

            server = new Socket("127.0.0.1", 12345);

        }

        catch (IOException ioe){

            System.out.println("IOException: " + ioe.getMessage());

        }
    }

    public void communicate(){

        try{

            //stream to server
            sendToServer = new ObjectOutputStream(server.getOutputStream());
            sendToServer.flush();

            //stream from server
            receiveFromServer = new ObjectInputStream(server.getInputStream());
//
//            String fromServer = " ";

//            //transactions
//            while(!fromServer.equals("exit")){
//
//                Object fromServerObject = receiveFromServer.readObject();
//                 
//                fromServer = (String) receiveFromServer.readObject();
//
//                
//                
//
//            }
            
//            //close the connections after transactions occur
//            sendToServer.close();
//            receiveFromServer.close();
//            server.close();*/

        }

        catch (IOException ioe){

            System.out.println("IOException: " + ioe.getMessage());

        }
        catch (Exception cnfe){

            System.out.println("Class not found: " + cnfe.getMessage());

        }
    }

    public static String getProgramPath() throws IOException{
        
        String currentDir = System.getProperty("user.dir");
        
        currentDir = currentDir.replace("\\", "/");
        
        return currentDir;
        
    }

    public static void main(String[] args) {
       
     
        ClientDvdRental client = new ClientDvdRental();
        client.communicate();
        
        new Home();
     
    }
    
    public String getCurrentDate(){
        
        Date today = new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        String da = sdf.format(today);
        
        return da;
    }
    
    public String getCurrentTime(){
        
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        return sdf.format(today);
        
    }
    
    public static void closeConnection(){
        
        try {
            
            sendToServer.writeObject("exit");
            sendToServer.close();
            receiveFromServer.close();
            server.close();
            
        } catch (IOException ex) {
            System.out.println("Could not close connection");
        }
           
    }

    public ArrayList<Customer> getAllCustomers(){
        
        ArrayList<Customer> customers = null;
        
         try {
       
           sendToServer.writeObject("popCus");
           
           customers  = (ArrayList <Customer>) receiveFromServer.readObject();
        
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return customers;
        
    }
    
    //populate tables from database
    public void populateCustomerTable(){
        
        try {
       
           sendToServer.writeObject("popCus");
           
           ArrayList<Customer> customers  = (ArrayList <Customer>) receiveFromServer.readObject();
 
           cusModel.clear();
           cusModel.updateArrayList(customers);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void populateMovieTable(){

        try {
            
            sendToServer.writeObject("popDvds");
            
            ArrayList<DVD> dvds = (ArrayList <DVD>) receiveFromServer.readObject();
            
            DvdTableModel.dvds.clear();
            DvdTableModel.dvds.addAll(dvds);
            
            dvdModel.fireTableDataChanged();
            
            
        } catch (IOException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void populateRentalTable(){
        
        try {
            
            sendToServer.writeObject("popRentals");
            
            ArrayList<Rental> rents = (ArrayList<Rental>) receiveFromServer.readObject();
            
            RentTableModel.dvdsRental.clear();
            RentTableModel.dvdsRental.addAll(rents);
            
            if(Home.extras.size() != 0){
                
                for (int i = 0; i < Home.extras.size(); i++) {
                    
                    Rental r = Home.extras.get(i);
                    
                    RentTableModel.dvdsRental.add(r);
                    
                }
                
            }
 
            rentModel.fireTableDataChanged();
            
        } catch (IOException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void addNewCustomer(Customer newCust){//add parameters to send from gui

        try {
            
            System.out.println(newCust);
            
            sendToServer.writeObject(newCust);
           
            JOptionPane.showMessageDialog(null, "New Customer Added Successfully!");
            
            populateCustomerTable();//repopulates table
            
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
            
        }  
        
        
        
    }
    
    public void addNewDvd(DVD newDvd){
        
        try {
            
            
            System.out.println(newDvd);
            
            sendToServer.writeObject(newDvd);
            
            JOptionPane.showMessageDialog(null, "New DVD added Successfully!");
            
            //repopulates it when new row is inserted
            populateMovieTable();
            
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
            
        }  
        
        
    }

    public void rentDvd(ArrayList<Customer> customers, int cus, ArrayList<DVD> dvds, int dvd){
        
        double dvdPrice = 0;
        double oldCredit = 0;
        double newCredit = 0;
        
        /*Calendar c = Calendar.getInstance();
        
        int year = c.get(Calendar.YEAR);
        int mont = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);
        
        String date = year + "/" + mont + "/" + day;
        
        String rentDate = date;
        */
        
        Date date = new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        String rentDate = sdf.format(date);
        
        Customer customer = null;
        DVD dvdd = null;
        
        //finds the customers information from cusNum
        for(int i = 0; i < customers.size(); i++){
            
            if(cus == customers.get(i).getCustNumber()){
                
                customer = customers.get(i);
               
                break;
            }  
        }
        
        //finds the dvd information from dvdNum
        for(int i = 0; i < dvds.size(); i++){
            
            if(dvd == dvds.get(i).getDvdNumber()){
                
                dvdd = dvds.get(i);
                
                break;
            }
            
        }
        
        int rental = getRecentRentalNum();
        
        Rental newRent = new Rental(rental, rentDate, cus, dvd);
        
        try {
            
            sendToServer.writeObject(newRent);
            
            //initial send
            String readd = (String) receiveFromServer.readObject();
            //should be the result of the question
       
            if(readd.equals("cash")){

                for(int i = 0; i < DvdTableModel.dvds.size(); i++){

                    if(dvd ==  DvdTableModel.dvds.get(i).getDvdNumber()){

                         DvdTableModel.dvds.get(i).setAvailable(false);
                         dvdPrice = DvdTableModel.dvds.get(i).getPrice();
                         break;

                    }
                }
        
                //check for the cus to update
                for(int i = 0; i < CustomerTableModel.customers.size(); i++){

                    if(cus == CustomerTableModel.customers.get(i).getCustNumber()){

                         CustomerTableModel.customers.get(i).setCanRent(false);
                         //oldCredit = CustomerTableModel.customers.get(i).getCredit();

                         if(dvd > dvdPrice){

                         }

                         //newCredit = oldCredit - dvdPrice;

                        // CustomerTableModel.customers.get(i).setCredit(oldCredit);
                         break;

                    }
                }
                //rentModel.addData(newRent);
                Home.extras.add(newRent);

//                boolean exist = false;
//                 
//                 int i = 0;
//                
//                 while(i < Home.dailyRental.getSize()){
//                     
//                     if(Home.dailyRental.getElementAt(i).equals(newRent.getDateRented())){
//                         exist = true;
//                     }
//                     i++;
//                 }
//                 
//                 if(!exist){
                     Home.dailyRental.addElement(newRent.getDateRented());
//                     Home.rList.add(newRent);
//                     
//                 }
                
                rentModel.fireTableDataChanged();
                cusModel.fireTableDataChanged();
                dvdModel.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Cash Payment Accepted! Movie Successfully Rented.");
                
            }
            else if(readd.equals("credit")){
                
                for(int i = 0; i < DvdTableModel.dvds.size(); i++){

                    if(dvd ==  DvdTableModel.dvds.get(i).getDvdNumber()){

                         DvdTableModel.dvds.get(i).setAvailable(false);
                         dvdPrice = DvdTableModel.dvds.get(i).getPrice();
                         break;

                    }
                }
        
                //check for the cus to update
                for(int i = 0; i < CustomerTableModel.customers.size(); i++){

                    if(cus == CustomerTableModel.customers.get(i).getCustNumber()){

                         CustomerTableModel.customers.get(i).setCanRent(false);
                         oldCredit = CustomerTableModel.customers.get(i).getCredit();

                         if(dvdPrice > oldCredit){

                             newCredit = oldCredit + 100;
                             newCredit = newCredit - dvdPrice;
                             
                         }
                         CustomerTableModel.customers.get(i).setCredit(newCredit);
                         break;

                    }
                }
                
                JOptionPane.showMessageDialog(null, "Successfully Loaded Credit, Movie Rented");
                 //rentModel.addData(newRent);

                 Home.extras.add(newRent);
//                 
//                 boolean exist = false;
//                 
//                 int i = 0;
//                
//                 while(i < Home.dailyRental.getSize()){
//                     
//                     if(Home.dailyRental.getElementAt(i).equals(newRent.getDateRented())){
//                         exist = true;
//                     }
//                     i++;
//                 }
//                 
//                 if(!exist){
                     Home.dailyRental.addElement(newRent.getDateRented());
//                     Home.rList.add(newRent);
//                 }
                 
                 
                rentModel.fireTableDataChanged();
                cusModel.fireTableDataChanged();
                dvdModel.fireTableDataChanged();
            }
            else if(readd.equals("cancel")){
                
               JOptionPane.showMessageDialog(null, "Operation Cancelled");
                
            }
            else if(readd.equals("noProb")){
                
                for(int i = 0; i < DvdTableModel.dvds.size(); i++){

                    if(dvd ==  DvdTableModel.dvds.get(i).getDvdNumber()){

                         DvdTableModel.dvds.get(i).setAvailable(false);
                         dvdPrice = DvdTableModel.dvds.get(i).getPrice();
                         break;

                    }
                }
        
                //check for the cus to update
                for(int i = 0; i < CustomerTableModel.customers.size(); i++){

                    if(cus == CustomerTableModel.customers.get(i).getCustNumber()){

                         CustomerTableModel.customers.get(i).setCanRent(false);
                         oldCredit = CustomerTableModel.customers.get(i).getCredit();

                         if(dvd > dvdPrice){

                         }

                         newCredit = oldCredit - dvdPrice;

                        CustomerTableModel.customers.get(i).setCredit(newCredit);
                         break;

                    }
                }
                
                 //rentModel.addData(newRent);

                 Home.extras.add(newRent);
              
//                 boolean exist = false;
//                 
//                 int i = 0;
                
//                 while(i < Home.dailyRental.getSize()){
//                     
//                     if(Home.dailyRental.getElementAt(i).equals(newRent.getDateRented())){
//                         exist = true;
//                     }
//                     i++;
//                 }
//                 
//                 if(!exist){
                     Home.dailyRental.addElement(newRent.getDateRented());
//                     Home.rList.add(newRent);
//                 }
//             
                rentModel.fireTableDataChanged();
                cusModel.fireTableDataChanged();
                dvdModel.fireTableDataChanged();
                
               // String last = (String) receiveFromServer.readObject();
               JOptionPane.showMessageDialog(null, "Movie Successfully Rented");
                
            }
 
               
        } catch (IOException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void returnDvd(int rentalNum){
    
        int[] returnDvd = new int[1];
        
        returnDvd[0] = rentalNum;
        
        try {
             
            sendToServer.writeObject(returnDvd);
     
            Rental rentalInQ = null;
            Rental rentExtra = null;

            for(int i = 0; i < RentTableModel.dvdsRental.size(); i++){

                if(rentalNum ==  RentTableModel.dvdsRental.get(i).getRentalNumber()){

                    rentalInQ = RentTableModel.dvdsRental.get(i);

                }

            }
            
            if(!Home.extras.isEmpty()){
                
                for(int i = 0; i < Home.extras.size(); i++){

                    if(rentalNum ==  Home.extras.get(i).getRentalNumber()){

                        rentExtra = Home.extras.get(i);

                    }

                }
                
            }
  
            //check for the cus to update
            for(int i = 0; i < CustomerTableModel.customers.size(); i++){


                if(rentalInQ.getCustNumber() == CustomerTableModel.customers.get(i).getCustNumber()){

                     CustomerTableModel.customers.get(i).setCanRent(true);
                     break;

                }


            }

            for(int i = 0; i < DvdTableModel.dvds.size(); i++){


                if(rentalInQ.getDvdNumber() ==  DvdTableModel.dvds.get(i).getDvdNumber()){

                     DvdTableModel.dvds.get(i).setAvailable(true);
                     break;

                }


            }

            Date date = new Date();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

            String returnDate = sdf.format(date);

            for(int i = 0; i < RentTableModel.dvdsRental.size(); i++){

                if(rentalInQ.getRentalNumber() ==  RentTableModel.dvdsRental.get(i).getRentalNumber()){

                     RentTableModel.dvdsRental.get(i).setDateReturned(returnDate);
                     break;

                }
            }
            
            if(!Home.extras.isEmpty()){
                
                for(int i = 0; i < Home.extras.size(); i++){

                    if(rentExtra.getRentalNumber() ==  Home.extras.get(i).getRentalNumber()){

                         Home.extras.get(i).setDateReturned(returnDate);
                         break;

                    }
                }
                
            }
      
            rentModel.fireTableDataChanged();
            
            String serverMes = (String) receiveFromServer.readObject();
            
            JOptionPane.showMessageDialog(null, serverMes);
            rentModel.fireTableDataChanged();
        } 
         catch (IOException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public void custCredit(double credit){
    
        double[] newCred = new double[1];
        
        newCred[0] = credit;
        
         try {
             
            sendToServer.writeObject(newCred);
            JOptionPane.showMessageDialog(null, "Credit updated!");
            
        } 
         catch (IOException ex) {
             
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        
         }

    }
    
    public void getSelectedDate(String date){
    
        String[] dailyRental = new String[1];
        
        dailyRental[0] = date;
        
         try {
             
            sendToServer.writeObject(dailyRental);
            
            ArrayList<Rental> rents = (ArrayList<Rental>) receiveFromServer.readObject();
            
            RentTableModel.dvdsRental.clear();
            RentTableModel.dvdsRental.addAll(rents);
            
            rentModel.fireTableDataChanged();
            
            String updated = (String) receiveFromServer.readObject();
            JOptionPane.showMessageDialog(null, updated);
            
        } catch (IOException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Customer> populateCusCombobox(){
        
        ArrayList<Customer> cusInfo = null;
        
        try {
            
            sendToServer.writeObject("getCusInfo");
            
            cusInfo = (ArrayList<Customer>) receiveFromServer.readObject();
   
        } catch (IOException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return cusInfo;
       
    }
    
    public ArrayList<DVD> populateDvdCatCombobox(){
        
        ArrayList<DVD> dvdInfo = null;
        
        try {
            sendToServer.writeObject("getDvdInfo");
            
             dvdInfo = (ArrayList<DVD>) receiveFromServer.readObject();
         
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return dvdInfo;
    }
    
    public ArrayList<Rental> populateRentalComboBox(){
        
        ArrayList<Rental> rentInfo = null;
        
        try {
            
            sendToServer.writeObject("getRentInfo");
            
            //Object temp = receiveFromServer.readObject();
            
            //System.out.println(temp.toString());
            
            
            
            rentInfo = (ArrayList<Rental>) receiveFromServer.readObject();
             System.out.println(rentInfo);
            RentTableModel.dvdsRental.clear();
            RentTableModel.dvdsRental.addAll(rentInfo);
            
            rentModel.fireTableDataChanged();
            
//            String updated = (String) receiveFromServer.readObject();
//            JOptionPane.showMessageDialog(null, updated);
            
        } catch (IOException ex) {
            
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (ClassNotFoundException ex) {
         
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
       return rentInfo;
       
    }
    
    public ArrayList<Rental> populateDateComboBox(){
        
        ArrayList<Rental> dates = null;
        
        try {
            
            sendToServer.writeObject("popDates");
            
             dates = (ArrayList<Rental>) receiveFromServer.readObject();
            
        } catch (IOException ex) {
            
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (ClassNotFoundException ex) {
         
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
       return dates;
       
    }
     
     //customers with outstanding rentals 
     public ArrayList<Customer> populateReturnCustComboBox(){
        
        ArrayList<Customer> returnDvd = null;
        
        try {
            
            sendToServer.writeObject("getReturnInfo");
            
             returnDvd = (ArrayList<Customer>) receiveFromServer.readObject();
            
        } catch (IOException ex) {
            
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (ClassNotFoundException ex) {
         
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
       return returnDvd;
       
    }
     
     //populates titles of movies currently rented 
     public ArrayList<DVD> populateReturnDvdTitle(){
        
        ArrayList<DVD> returnDvdTitle = null;
        
        try {
            
            sendToServer.writeObject("getReturnDvdInfo");
            
             returnDvdTitle = (ArrayList<DVD>) receiveFromServer.readObject();
            
        } catch (IOException ex) {
            
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (ClassNotFoundException ex) {
         
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
       return returnDvdTitle;
       
    }
     
     public ArrayList<Customer> populatePhoneNums(){
        
        ArrayList<Customer> returnPhone = null;
        
        try {
            
            sendToServer.writeObject("getPhoneNum");
            
             returnPhone = (ArrayList<Customer>) receiveFromServer.readObject();
            
        } catch (IOException ex) {
            
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (ClassNotFoundException ex) {
         
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
       return returnPhone;
       
    }
     
     public ArrayList<DVD> populateDvdTitle(){
        
        ArrayList<DVD> returnTitle = null;
        
        try {
            
            sendToServer.writeObject("popDvds");
            
             returnTitle = (ArrayList<DVD>) receiveFromServer.readObject();
            
        } catch (IOException ex) {
            
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (ClassNotFoundException ex) {
         
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
       return returnTitle;
       
    }
     
     public int getLatestCusNumber(){
        
       int max  = 0;
        
       try {
            
            sendToServer.writeObject("max");
            
            max = (int) receiveFromServer.readObject();
             
            
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
            
        } catch (ClassNotFoundException ex) {  
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return max;
        
    }

     
     public int getLatestDvdNumber(){
        
       int max  = 0;
        
       try {
            
            sendToServer.writeObject("maxed");
            
            max = (int) receiveFromServer.readObject();
             
            
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
            
        } catch (ClassNotFoundException ex) {  
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return max;
        
    }
     
     public int getRecentRentalNum(){
        
       int max  = 0;
        
       try {
            
            sendToServer.writeObject("maxedd");
            
            max = (int) receiveFromServer.readObject();
             
            
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
            
        } catch (ClassNotFoundException ex) {  
            Logger.getLogger(ClientDvdRental.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return max;
        
    }
    
    

}

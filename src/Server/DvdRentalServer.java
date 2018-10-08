import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class DvdRentalServer {

    static Database db = new Database();

    private Object[] choices = {"Pay fee cash", "Load Credit", "Cancel"};
    private Object[] choicess = {"Pay fee cash"};
   
    public static String getProgramPath() throws IOException{
        
        String currentDir = System.getProperty("user.dir");
        
        currentDir = currentDir.replace("\\", "/");
        
        return currentDir;
        
    }
    
    public static void main(String[] args) {
     
        try {
            db.connect();
            System.out.println("Db connected");
        } catch (IOException ex) {
            Logger.getLogger(DvdRentalServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DvdRentalServer server = new DvdRentalServer();
        server.listen();
    }
    
    //creates socket which listens to the data being sent from the client
    private ServerSocket listener;

    private Socket client;

    public static ObjectInputStream receiveFromClient;
    public static ObjectOutputStream sendToClient;

    public DvdRentalServer(){

        //dvdList = db.getAllDvds();
        
        try{

            listener = new ServerSocket(12345, 10);

        }
        catch (IOException ioe){

            System.out.println("IOException: " + ioe.getMessage());

        }

    }

    //this method will listen to any incoming messages from the client
    public void listen(){

        try {

            new ServerGUI();
            client = listener.accept();
            System.out.println("Now moving onto processClient");

            processClient();

        }
        catch(IOException ioe){

            System.out.println("IO Exception: " + ioe.getMessage());

        }
    }

    public void processClient(){

        try{

            //creating and establishing streams/connections
            sendToClient = new ObjectOutputStream(client.getOutputStream());
            sendToClient.flush();

            receiveFromClient = new ObjectInputStream(client.getInputStream());

            //transactions
            String messageToSend = " ";

            while(!messageToSend.equals("exit")) {

               Object fromClient = receiveFromClient.readObject();
               
               if(fromClient instanceof Customer){
                   
                   Customer newCust = (Customer) fromClient;
                   
                   DvdRentalServer.db.addCustomerToDb(newCust);
                   
                   //sendToClient.writeObject("Customer Added Successfully");
               
               }
               
               else if(fromClient instanceof DVD){
                     
                   DVD newDvd = (DVD) fromClient;
                   
                   DvdRentalServer.db.addDvdToDb(newDvd);
                   
               }
               
               else if(fromClient instanceof Rental){
                   
                   String dvdN = "";
                   String cusN = "";
                   
                   Rental newRental = (Rental) fromClient;
                   
                   double currentCred = 0;
                   double dvdPrice = 0;
                   double newCredit = 0;
                    
                   ArrayList<Customer> customerlist  = db.getAllCustomers();
                   ArrayList<DVD> dvdList = db.getAllDvds();
                    
                   int custNum = newRental.getCustNumber();
                    
                   //checking all customers 
                   for(int i = 0; i < customerlist.size(); i++){

                        int custInList = customerlist.get(i).getCustNumber();

                        if(custInList == custNum){

                             currentCred = customerlist.get(i).getCredit(); 
                             cusN = customerlist.get(i).getFirstName();
                                     
                             break;

                         }

                    }

                  int dvd = newRental.getDvdNumber();
                  
                  //Checking all dvds
                  for(int i = 0; i < dvdList.size(); i++){

                        int dvdNum = dvdList.get(i).getDvdNumber();

                        if(dvdNum == dvd){

                            dvdPrice = dvdList.get(i).getPrice();
                            dvdN = dvdList.get(i).getTitle();
                            break;
                        }

                    }
                      
                 if(dvdPrice > currentCred){

                     JDialog dialog = new JDialog();
                     dialog.setAlwaysOnTop(true);
                     
                    int confirm = JOptionPane.showOptionDialog(dialog,
                            "You have insufficient credit", "Credit", 
                            JOptionPane.DEFAULT_OPTION, 
                            JOptionPane.INFORMATION_MESSAGE, 
                            null, choices, choices[0]);
     
                       switch (confirm) {
                           case JOptionPane.YES_OPTION:
  
                               DvdRentalServer.db.updateCust(newRental.getCustNumber(), currentCred);
                               DvdRentalServer.db.updateDvd(newRental.getDvdNumber());
                               DvdRentalServer.db.addRentalToDb(newRental);
                               
                               //JOptionPane.showMessageDialog(null, "Cash payment successful", "Payment", JOptionPane.INFORMATION_MESSAGE);
                               newCredit = 0;
                               currentCred = 0;
                               dvdPrice = 0;
                               
                               sendToClient.writeObject("cash");
                               break;
                               
                           case JOptionPane.NO_OPTION:
                               
                               newCredit = (100 + currentCred) - dvdPrice;
                               
                               DvdRentalServer.db.addRentalToDb(newRental);
                               DvdRentalServer.db.updateCust(newRental.getCustNumber(), newCredit);
                               DvdRentalServer.db.updateDvd(newRental.getDvdNumber());
                               
                               //JOptionPane.showMessageDialog(null, "Account credit successful", "Payment", JOptionPane.INFORMATION_MESSAGE);
                               newCredit = 0;
                               currentCred = 0;
                               dvdPrice = 0;
                               
                               sendToClient.writeObject("credit");
                               break;
                               
                           case JOptionPane.CANCEL_OPTION:
                               
                              
                               //JOptionPane.showMessageDialog(null, "Operation cancelled");
                               sendToClient.writeObject("cancel");
                               break;
                               
                           default:
                               break;
                       }
      
                   } 
                   
                 
                 else if(dvdPrice < currentCred){
                     
                       newCredit = currentCred - dvdPrice;

                       DvdRentalServer.db.addRentalToDb(newRental);

                       DvdRentalServer.db.updateCust(newRental.getCustNumber(), newCredit);

                       DvdRentalServer.db.updateDvd(newRental.getDvdNumber()); 
                       
                       sendToClient.writeObject("noProb");
                       
                       //JOptionPane.showMessageDialog(null, "Successfully Rented");

                }
                     
            }  
               
               else if(fromClient instanceof int[]){
               
                    int[] returns = (int[]) fromClient;

                    ArrayList<Rental> rList = db.getAllRentals();
                    ArrayList<Customer> cList = db.getAllReturnCustomers();
                    ArrayList<DVD> dList = db.getAllReturnDvds();
                    
                    int returnNum = returns[0];
                    double credit = 0;
                    double newCredit = 0;
                    
                    Rental returnM = null;
     
                    Date date = new Date();
        
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

                    String returnDate = sdf.format(date);

                    //finds the customers information from cusNum
                    for(int i = 0; i < rList.size(); i++){

                        if(rList.get(i).getRentalNumber() == returnNum){

                            returnM = rList.get(i);
                            break;
                            
                        }  
                    }
                    
                    for(int i = 0; i < cList.size(); i++){

                        if(cList.get(i).getCustNumber() == returnM.getCustNumber()){
                            
                            credit = cList.get(i).getCredit();  
                        } 
                    }
                    
                    Rental rentalReturn = new Rental(returnNum, returnM.getDateRented(), returnDate, returnM.getCustNumber(), returnM.getDvdNumber());
                    
                    System.out.println(rentalReturn);
                    
                    double pen = rentalReturn.getTotalPenaltyCost();
             
                    if(pen > credit){
                        
                        JDialog dialog = new JDialog();
                        dialog.setAlwaysOnTop(true);
                
                        int confirm = JOptionPane.showOptionDialog(dialog,
                            "You have insufficient credit", "Credit", 
                            JOptionPane.DEFAULT_OPTION, 
                            JOptionPane.INFORMATION_MESSAGE, 
                            null, choicess, choicess[0]);
                
                        switch(confirm){
                    
                            case JOptionPane.YES_OPTION:{

                                db.updateCustReturn(rentalReturn);
                                db.updateDvdReturn(rentalReturn.getDvdNumber());
                                db.returnRental(rentalReturn);
                                sendToClient.writeObject("Cash Payment Successful, Movie Returned!");
                                break;
                            }  

                            case JOptionPane.CANCEL_OPTION:{

                                  sendToClient.writeObject("Operation cancelled");
                                  
                                  break;
                            } 
                            default:
                                   break;
                    
                        }
                     
                    }
                    else if(credit > pen){
                        
                        newCredit = credit - pen;

                        db.updateCustReturn(rentalReturn);
                        db.updateDvdReturn(rentalReturn.getDvdNumber());
                        db.returnRental(rentalReturn);

                        db.updateCustCred(newCredit, rentalReturn);
                         
                        sendToClient.writeObject("Movie Returned Successfully!");
                                
                        
                    }


                    
               }

               
               else if(fromClient instanceof String []){
               
                    String[] date = (String[]) fromClient;
                   
                    ArrayList<Rental> rList = db.populateRentalTable();
                    
                    String rentedDate = date[0];
                    
                    Rental returnM = null;

                    //finds the customers information from cusNum
                    for(int i = 0; i < rList.size(); i++){

                        if(rList.get(i).getDateRented().equals(rentedDate)){

                            returnM = rList.get(i);
                            break;
                            
                        }  
                    }



                    Rental daily = new Rental(returnM.getRentalNumber(),returnM.getDateRented(), returnM.getDateReturned(), returnM.getCustNumber(), returnM.getDvdNumber());
                    
                    ArrayList<Rental> rent = db.getAllDailyRentals(daily);
                    sendToClient.writeObject(rent);
                    
//                    sendToClient.writeObject("Selected date worked");
               
               }
               
               else if(fromClient instanceof String){
                   
                   String mess = (String) fromClient;
                   
                   if(mess.equals("exit")){
                       
                       messageToSend = "exit";
                   }
                   else if(mess.equals("popCus")){
                       
                       ArrayList<Customer> cus = DvdRentalServer.db.populateCustomerTable();
                       sendToClient.writeObject(cus);
                          
                   }
                   else if(mess.equals("popDvds")){
                       
                       ArrayList<DVD> dvds = DvdRentalServer.db.populateDvdTable();
                       sendToClient.writeObject(dvds);
                     
                   }
                   else if(mess.equals("popRentals")){
                       
                       ArrayList<Rental> rent = DvdRentalServer.db.populateRentalTable();
                       sendToClient.writeObject(rent);
                   
                       
                   }
                   else if(mess.equals("popDates")){
                       
                       ArrayList<Rental> dates = DvdRentalServer.db.populateRentalTable();
                       sendToClient.writeObject(dates);
                   
                       
                   }
                   else if(mess.equals("getCusInfo")){
                       
                       ArrayList<Customer> cus = DvdRentalServer.db.getAllCustomers();
                       sendToClient.writeObject(cus);
                       
                   }
                   else if(mess.equals("getDvdInfo")){
                       
                       ArrayList<DVD> dvds = DvdRentalServer.db.getAllDvds();
                       sendToClient.writeObject(dvds);
                       
                   }
                   
                   else if(mess.equals("getRentInfo")){
                       
                       ArrayList<Rental> rentalList = DvdRentalServer.db.getAllRentals();
                       sendToClient.writeObject(rentalList);
                       
                   }
                   
                   else if(mess.equals("getReturnInfo")){
                       
                       ArrayList<Customer> returnList = DvdRentalServer.db.getAllReturnCustomers();
                       sendToClient.writeObject(returnList);
                       
                   }
                   
                   else if(mess.equals("getReturnDvdInfo")){
                       
                       ArrayList<DVD> dvdReturnList = DvdRentalServer.db.getAllReturnDvds();
                       sendToClient.writeObject(dvdReturnList);
                       
                   }
                   
                   else if(mess.equals("getPhoneNum")){
                       
                       ArrayList<Customer> phNum = DvdRentalServer.db.populateCustomerTable();
                       sendToClient.writeObject(phNum);
                       
                   }
                   else if(mess.equals("max")){
                       
                       int max = db.getLatestCusNum();
                       
                       sendToClient.writeObject(max);
                       
                       
                   }
                   else if(mess.equals("maxed")){
                       
                       int max = db.getLatestDvdNum();
                       
                       sendToClient.writeObject(max);
                       
                       
                   }
                   else if(mess.equals("maxedd")){
                       
                       int max = db.getLatestRentalNum();
                       
                       sendToClient.writeObject(max);
                       
                       
                   }
                   
                
               }
               else if (fromClient instanceof Object[]){
                   
                   
                   Object[] chAndR = (Object[]) receiveFromClient.readObject();
                   
                   int choice = (int) chAndR[1];
                   int returnNum = (int) chAndR[0];
                   
                           
                            ArrayList<Rental> rList = db.getAllRentals();
                            ArrayList<Customer> cList = db.getAllReturnCustomers();
                            ArrayList<DVD> dList = db.getAllReturnDvds();

                            double credit = 0;
                            //double newCredit = 0;

                            Rental returnM = null;

                            Date date = new Date();

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

                            String returnDate = sdf.format(date);

                            //finds the customers information from cusNum
                            for(int i = 0; i < rList.size(); i++){

                                if(rList.get(i).getRentalNumber() == returnNum){

                                    returnM = rList.get(i);
                                    break;

                                }  
                            }

                            for(int i = 0; i < cList.size(); i++){

                                if(cList.get(i).getCustNumber() == returnM.getCustNumber()){

                                    credit = cList.get(i).getCredit();  
                                } 
                            }

                            Rental rentalReturn = new Rental(returnNum, returnM.getDateRented(), returnDate, returnM.getCustNumber(), returnM.getDvdNumber());

                            db.updateCustReturn(rentalReturn);
                            db.updateDvdReturn(rentalReturn.getDvdNumber());
                            db.returnRental(rentalReturn);

                            db.updateCust(rentalReturn.getCustNumber(), credit);
                            
                            //db.updateCustCred(newCredit, rentalReturn);

                            sendToClient.writeObject("Cash payment successful");
                           
                     
               }

            }

            //closing the connections after processing the transactions
            sendToClient.close();
            receiveFromClient.close();
            client.close();

            System.out.println("Closing");
            
            System.exit(0);

        }
        catch (IOException ioe){

            System.out.println("IOException: " + ioe.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DvdRentalServer.class.getName()).log(Level.SEVERE, null, ex);
        }


    } 
    

}

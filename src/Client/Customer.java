import java.io.*;
public class Customer implements Serializable{
    
    private int custNumber;
    private String firstName;
    private String surname;
    private String phoneNum;
    private double credit;
    private boolean canRent;
    
    public Customer(){
        
    }
    
    public Customer(int custNumber, String fName, String lName, String phone, double credAmt, boolean can){
        
        setCustNumber(custNumber);
        setFirstName(fName);
        setSurname(lName);
        setPhoneNum(phone);
        setCredit(credAmt);
        setCanRent(can);
    }

    public int getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(int custNumber) {
        this.custNumber = custNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public boolean isCanRent() {
        return canRent;
    }

    public void setCanRent(boolean canRent) {
        this.canRent = canRent;
    }

    //this method can be edited to format strings differently
    @Override
    public String toString(){
        
        return String.format("%-8d%-10s%-10s%-10s     %.2f\t%-6b", getCustNumber(), getFirstName(), getSurname(),
                getPhoneNum(), getCredit(), canRent);
    }      
}

import java.io.*;
public class DVD implements Serializable{
    
    private int dvdNumber;
    private String title;
    private String category;
    private double price;
    private boolean newRelease;
    private boolean availableForRent;
    
    //empty constructor
    public DVD(){
        
    }
    
    //constructor that takes 4 arguments to initialize the instance variables
    public DVD(int dvdNumber, String title, int category, boolean newRelease, boolean avail){
        
        setDvdNumber(dvdNumber);
        setTitle(title);
        setCategory(category);
        setRelease(newRelease);
        setAvailable(avail);
        
    }
    
    // set methods
    public void setDvdNumber(int dvdNumber){
        
        this.dvdNumber = dvdNumber;
        
    }
    public void setTitle(String sTitle){
        
        title = sTitle;
    }
    
    public void setCategory(int sCategory){
        
        switch(sCategory){
            
            case 1:
                category = "Horror";
                break;
            case 2:
                category = "Sci-fi";
                break;
            case 3:
                category = "Drama";
                break;
            case 4:
                category = "Romance";
                break;
            case 5:
                category = "Comedy";
                break;
            case 6:
                category = "Action";
                break;
            case 7:
                category = "Cartoon";
                break;
        }
    }
    
    public void setRelease(boolean sRelease)
    {
        newRelease = sRelease;
        setPrice();//sets the price based on whether movie is new release or not
    }
    private void setPrice()
    {
        if(newRelease)
            price = 15;
        else
            price = 10;    
    }
    
    public void setAvailable(boolean sAvailable)
    {
        availableForRent = sAvailable;
    }
    
    //get methods
    public int getDvdNumber()
    {
        return dvdNumber;
    }    
    public String getTitle()
    {
        return title;
    }
    
    public String getCategory()
    {
        return category;
    }
    public double getPrice()
    {
        return price;
    }
    //checks if the movie is a new release
    public boolean isNewRelease()
    {
        return newRelease;
    }
    
    //checks if the movie is available
    public boolean isAvailable()
    {
        return availableForRent;
    }
    
    //overrides the object method
    @Override 
    public String toString()
    {
        return String.format("Dvd number: %-8dTitle: %-30sCategory:%-12sPrice:R%.2f\nNew Release:%b\tAvailable:%b\n", dvdNumber, title,category,price,newRelease,availableForRent);
    }
}

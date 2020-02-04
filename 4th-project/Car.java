package Rental;


import BasicIO.*;


public class Car {
    
    
    public  static final String[] CATEGORIES = {"Economy","Full Size","Van","SUV"};
    private static final double[] RATES = {0.25,0.50,1.00,1.25};
    
    
    private String licence;
    private int mileage;
    private int category;
   
    
    /* Instance Variables */
    
    
    public Car ( ASCIIDataFile in ) {
        
        licence=in.readString();
        if(!in.isEOF()){
        
        mileage=in.readInt();
        category=in.readInt();
        
        
        }
      
      
    };  // constructor
    
    
    public String getLicence ( ) {
        
      return licence;
      
      
    };  // getLicence
    
    
    public int getMileage ( ) {
        
      return mileage;

    };  // getMileage
    
    
    public int getCategory ( ) {
        
        return category;

    };  // getCategory
    
    
    public double getRate ( ) {
        
        return RATES[category];

    };  // getRate
    
    //computes the rental cost and updates the mileage
    public double returned ( int m ) {
        
        double charge;
        charge= (m-mileage)*getRate();
        mileage=m;
          
          return charge;

    };  // returned
    
    
}  // Car
package Billing;


import BasicIO.*;


public class Account {
    
 private static final double RATE=1.525;
 
 private String acctNum;
 private String name;
 private double prevReading;
 private double currReading;
    /* Instance Variables */
    
    
    public Account ( ASCIIDataFile from ) {
        
        acctNum= from.readString();
        if(! from.isEOF()){
        
        name=from.readString();
        prevReading=from.readDouble();
        currReading=from.readDouble();
        
        }
        
      
    };  // constructor
    
    
    public String getAcctNum ( ) {

        return acctNum;
        
    };  // getAcctNum
    
    
    public String getName ( ) {
        
        return name;
        
    };  // getName
    
    
    public double getPrevReading ( ) {
        
        return prevReading;
        
   };  // getPrevReading
    
    
    public double getCurrReading ( ) {
        
        return currReading;        
        
    };  // getCurrReading
    
    
    public void takeReading ( double reading ) {
        
      currReading=reading;
        
    };  // takeReading
    
    
    public double billForUsage ( ) {
        
      double consumption;
      consumption=currReading- prevReading;
      prevReading=currReading;
        return consumption * RATE;
        
    };  // billForUsage
    
    
    public void write ( ASCIIOutputFile to ) {
        
      to.writeString(acctNum);
      to.writeString(name);
      to.writeDouble(prevReading);
      to.writeDouble(currReading);
      to.newLine();
        
    };  // write
    
    
}  // Account
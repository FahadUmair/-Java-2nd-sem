package Rental;


import BasicIO.*;
import static BasicIO.Formats.*;


public class Rental {
  
  private Node avail;
  private Node rented;
  private ASCIIDisplayer display;
  private BasicForm form;
  /** Instance Variables */
  
  public Rental ( ) {
    
    int button;
    form=new BasicForm("Rent","Return","List","Quit");
    display=new ASCIIDisplayer();
    avail=null;
    rented=null;
    loadCars();
    for(;;){
      
      button=form.accept();
      
      if(button==3)break;
      
      switch(button){
        
        case 0: {                  //Rent
          doRent();
          break;}
        
        case 1: {                 //Return
          doReturn();
          break;}
        
        case 2: {                 //List
          doList();
          break;}
        
      }
      
    }
    form.close();
    display.close();
    
  }; // constructor
  
  //removes car from front of available list and insertes it into rented list
  private void doRent(){
    Car aCar; //car to be rented
    
        
    aCar= removeAvail();
    if(aCar==null){
      display.writeString("No cars availble");}
    
    else{
    addRented(aCar);
    display.writeString("Rented: "+ aCar.getLicence());
    }
    display.newLine();
  }
  //removes car from front of rented list and insertes it into availble list
  private void doReturn(){
    Car aCar;// car being returned
    
  }
  
  //list availble and rented cars
  private void doList(){
    Car aCar;

    }
    
  
  
  //load cars from ASCIIDataFile. Creates a car object and adds it to the list of availble cars
  private void loadCars(){
    
    ASCIIDataFile carFile;
    Car aCar;
    
    carFile=new ASCIIDataFile();
    
    for(;;){
      
      aCar=new Car(carFile);
      
      if(carFile.isEOF()) break;
      addAvail(aCar);
      
    }
    
  }
  //inserts a car at front of the linked list
  private void addAvail( Car aCar){
    
    avail=new Node(aCar, avail);
    
  }
  
  private void addRented( Car aCar){
    
    rented=new Node(aCar, rented);
    
  }
  
  private Car removeAvail(){
  
  Car result;
  return result;
  
  }
  
  
    private Car removeTented(){
  
  Car result;
  return result;
  
  }
  
  
  //Sequentially transverse the linked list and print the results on the displayer
  private void listAvail(){
    
    Node p;
    p=avail;
    while (p!=null){
      display.writeString(p.item.getLicence());
      display.writeInt(p.item.getMileage());
      display.writeInt(p.item.getCategory());
      display.newLine();
      p=p.next;
    }
    display.newLine();
  }
  
    private void listRented(){
    
    Node p;
    p=avail;
    while (p!=null){
      display.writeString(p.item.getLicence());
      display.writeInt(p.item.getMileage());
      display.writeInt(p.item.getCategory());
      display.newLine();
      p=p.next;
    }
    display.newLine();
  }
  
  
  
  public static void main ( String[] args ) { Rental r = new Rental(); };
  
  
}  // Rental
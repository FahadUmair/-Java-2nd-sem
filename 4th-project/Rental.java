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
    setUpForm();
    for(;;){
      form.clearAll();
      button=form.accept("Rent","Return","List","Quit");
      
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
      form.accept("OK");
    }
    form.close();
    display.close();
    
  }; // constructor
  
  //removes car from front of available list and insertes it into rented list
  private void doRent(){
    Car aCar; //car to be rented
    int cat;
    
    cat=form.readInt("cat");
    aCar= removeAvail(cat);
    if(aCar==null){
      form.writeString("msg","No cars availble");}
    
    else{
      fillForm(aCar);
      addRented(aCar);
      form.writeString("msg","Rented: "+ aCar.getLicence());
    }
    display.newLine();
  }
  //removes car from front of rented list and insertes it into availble list
  private void doReturn(){
    Car     aCar;     // car being returned
    double cost;
    int mileage;
    String licence;
    licence=form.readString("licence");
    aCar = removeRented();
    if ( aCar == null ) {
      form.writeString("msg","No cars currently rented");
    }
    else {
      fillForm(aCar);
      form.accept("OK");
      mileage=form.readInt("nMileage");
      cost=aCar.returned(mileage);
      form.writeDouble("amt",cost);
      addAvail(aCar);
      form.writeString("msg","Returned: "+aCar.getLicence());
    };
    display.newLine();
    
  }
  
  //list availble and rented cars
  private void doList(){
    
    display.writeLine("Availble");
    listAvail();
    
    display.writeLine("Rented");
    listRented();
    
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
    
    Node p;
    Node q;
    
    q=null;
    p=avail;
    
    while(p!=null){
      
      q=p;
      p= p.next;
      
    }
    if(q==null){
      
      
      avail=new Node(aCar, null);
      
    }
    else{
      
      q.next=new Node(aCar,avail);
    }
    
    
    
  }
  
  private void addRented( Car aCar){
    
    rented=new Node(aCar, rented);
    
  }
  
  private Car removeAvail(int cat){
    
    Car result;
    Node p;
    Node q;
    
    q=null;
    p=avail;
    
    while (p!= null && p.item.getCategory() !=cat){
      
      q=p;
      p=p.next;
      
    }
    
    if (p==null){
      result= null;
    }
    
    else{
      result=p.item;
      
      if(q==null){
        avail=p.next;
      }
      
      else{q.next=p.next;}
      
    }
    
    
    return result;
    
  }
  
  
  private Car removeRented(){
    
    Car result;
    Node p;
    Node q;
    q=null;
    p=rented;
//    if (rented==null){result=null;}
//    else{result=rented.item;
//      rented=rented.next;}
//    
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
  
  private void setUpForm ( ) {
    
    form.setTitle("Acme Rentals");
    form.addTextField("licence","Licence",8,10,10);
    form.addRadioButtons("cat","Category",true,10,40,Car.CATEGORIES);
    form.addTextField("rate","Rate",getCurrencyInstance(),8,294,40);
    form.setEditable("rate",false);
    form.addTextField("oMileage","Rental Mileage",getIntegerInstance(),
                      8,10,160);
    form.setEditable("oMileage",false);
    form.addTextField("nMileage","Returned Mileage",getIntegerInstance(),
                      8,222,160);
    form.addTextField("amt","Amount",getCurrencyInstance(),10,10,190);
    form.setEditable("amt",false);
    form.addTextField("msg","Message",45,10,220);
    form.setEditable("msg",false);
    
  };  // setupForm 
  
  private void fillForm(Car aCar){
    
    form.writeString("licence",aCar.getLicence());
    form.writeInt("oMileage",aCar.getMileage());
    form.writeInt("cat",aCar.getCategory());
    form.writeDouble("rate",aCar.getRate());
    
    
  }
  
  public static void main ( String[] args ) { Rental r = new Rental(); };
  
  
}  // Rental
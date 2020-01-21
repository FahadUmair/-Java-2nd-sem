package Billing;


import BasicIO.*;
import static BasicIO.Formats.*;


public class Update {
  
  /* Instance Variables */
  
  private static final int MAX_ACCT=100;
  
  private ASCIIDataFile    accountFile;
  
  private ASCIIOutputFile  newAccountFile;
  
  private Account[]        accounts;
  
  private int              numAccts;
    
  private BasicForm        usageForm;  // meter reading form
  
  
  public Update ( ) {
    
    Account anAcct;
    
    int button;
    
    accountFile= new ASCIIDataFile();
      
    usageForm=new BasicForm();
   
    setUpForm();
    loadAccts();
    
    accountFile.close();
    
    for(;;){
    
    usageForm.clearAll();
    button=usageForm.accept("Find","Quit");
    if (button==1) break;
    
    anAcct=findAcct(usageForm.readString("acctNum"));
    
    if (anAcct !=null){
    
      fillForm(anAcct);
      usageForm.accept("Update");
      anAcct.takeReading(usageForm.readDouble("reading"));
    }
    
    
    }
    
    usageForm.close();
    
    newAccountFile=new ASCIIOutputFile();
    writeAccts();
    newAccountFile.close();
    
    
  };  // construtor
  
  
  private void loadAccts ( ) {
    
    Account anAcct;
    
    accounts=new Account[MAX_ACCT];
    numAccts=0;
    
    for(;;){
    
      anAcct=new Account(accountFile);
      
      if (accountFile.isEOF()) break;
      
      accounts[numAccts]= anAcct;
      
      numAccts=numAccts+1;
    
    }
    
  };  // loadAccts
  
  
  private void writeAccts ( ) {
    
    for (int i=0; i<numAccts; i++){
    
    accounts[i].write(newAccountFile);
    
    }
    
  };  // writeAccts
  
  
  private Account findAcct ( String acctNum ) {
    
    Account result;
    int low;
    int high;
    int pos;
    
    result=null;
    low=0;
    high=numAccts-1;
    
    while (low<= high){
    
    pos=(low+high)/2;
    
    if (acctNum.compareTo(accounts[pos].getAcctNum())==0){
    
    
    result=accounts[pos];
    break;
    
    }
    
    if(acctNum.compareTo(accounts[pos].getAcctNum())>0){
      low=pos+1;
    }
   
    else{
    high=pos-1;
    
    }}
    
    return result;
    
  };  // findAcct
  
  
  private void setUpForm ( ) {
    
    usageForm.setTitle("Over The Horizon Utilities");
    usageForm.addTextField("acctNum","Account #",getIntegerInstance(),
                           6,10,10);
    usageForm.addTextField("name","Name",20,10,40);
    usageForm.addTextField("prev","Previous Reading",getDecimalInstance(1),
                           6,10,70);
    usageForm.addTextField("reading","Current Reading",getDecimalInstance(1),
                           6,10,100);
    
  };  // setUpForm
  
  
  private void fillForm ( Account anAcct ) {
    
    usageForm.writeString("acctNum",anAcct.getAcctNum());
    usageForm.writeString("name",anAcct.getName());
    usageForm.writeDouble("prev",anAcct.getPrevReading());
    usageForm.clear("reading");
    
  };  // fillForm
  
  
  public static void main ( String[] args ) { Update u = new Update(); };
  
  
}  // Update
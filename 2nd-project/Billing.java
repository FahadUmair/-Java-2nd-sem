package Billing;


import BasicIO.*;
import static BasicIO.Formats.*;


public class Billing {
    
    
    private ASCIIDataFile    accountFile;
    private ASCIIOutputFile  newAccountFile;
    private ReportPrinter    billReport;
    
    
    public Billing ( ) {
        
        Account  anAcct;
        double   previous;
        double   bill;
        double   totBilled;
        
        accountFile = new ASCIIDataFile();
        newAccountFile = new ASCIIOutputFile();
        billReport = new ReportPrinter();
        setUpReport();
        totBilled = 0;
        for ( ; ; ) {
            anAcct = new Account(accountFile);
        if ( accountFile.isEOF() ) break;
            previous = anAcct.getPrevReading();
            bill = anAcct.billForUsage();
            writeDetail(anAcct,previous,bill);
            anAcct.write(newAccountFile);
            totBilled = totBilled + bill;
        };
        writeSummary(totBilled);
        accountFile.close();
        newAccountFile.close();
        billReport.close();
        
    };  // construtor
    
    
    private void setUpReport ( ) {
        
        billReport.setTitle("Over The Horizon Utilities","Billing Report");
        billReport.addField("acctNum","Account #",10);
        billReport.addField("name","Name",20);
        billReport.addField("prev","Previous",getDecimalInstance(1),8);
        billReport.addField("reading","Current",getDecimalInstance(1),8);
        billReport.addField("bill","Charge",getCurrencyInstance(),10);
        
    };  // setUpReport
    
    
    private void writeDetail ( Account anAcct, double previous, double bill ) {
        
        billReport.writeString("acctNum",anAcct.getAcctNum());
        billReport.writeString("name",anAcct.getName());
        billReport.writeDouble("prev",previous);
        billReport.writeDouble("reading",anAcct.getCurrReading());
        billReport.writeDouble("bill",bill);
        
    };  // writeDetailLine
    
    
    private void writeSummary ( double totBilled ) {
        
        billReport.writeString("name","Total Billed");
        billReport.writeDouble("bill",totBilled);
        
    };  // writeSummary
    
    
    public static void main ( String[] args ) { Billing b = new Billing(); };
    
    
}  // Billing
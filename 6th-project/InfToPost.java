package InfToPost;

import CharStacks.*;
import BasicIO.*;


/** This class is a program to perform infix to postfix conversion. It
  * consecutively reads strings representing infix expressions and then produces
  * and displays the equivalent postfix expression. The process involves a stack
  * of characters.
  *
  * @see  CharStack
  * @see  ConCharStack
  *
  * @author  your name
  *
  * @version  1.0 (Feb. 2015)                                                    */

public class InfToPost {
    
    
    private BasicForm  display;  // form for UI
    CharStack stack;
    
    /** The constructor repeatedly reads infix expressions, converts them to
      * postfix and displays them.                                               */
    
    public InfToPost ( ) {
      
      display=new BasicForm("Convert","Clear","Quit");
      buildForm();
      
      stack=new ConCharStack();
      
      
      while(true){
        
        switch(display.accept()){
          case 0:
            String infix=display.readString("infix");
          
            display.writeString("postfix", infix);
            break;
            
          case 1:
            display.clearAll();
          
          case 2:
            break formLoop;
        }
      }
      display.close();
        
    }; // constructor
    
    
    /** This method builds the form for expression string IO.                    */
    
    private void buildForm ( ) {
        
        display.setTitle("Infix to Postfix");
        display.addTextField("infix","Infix");
        display.addTextField("postfix","Postfix");
        
    };  // buildForm
    
    
    /** This method does the actual conversion from infix to postfix. It
      * concatenates a dummy operator to the end of the input string and then
      * processes the string from left to right, placing operands into the output
      * string and pushing or popping operators to a stack depending on their
      * relative priorities.
      *
      * @param  in  the infix expression to be converted.
      *
      * @return   String  the equivalent postfix expression.                     */
    
    private String translate ( String in ) {
      in= in + "#";
      stack.push('$');
      
      char[] array=in.toCharArray();
      String post="";
      
      for(int i=0;i<array.length;i++){
        
        int p=prio(array[i]);
        if (p==0){
          post += array[i];
        }
        else{
          if (p>prio(stack.top())){
            stack.puch(array[i]);
          }
          else{
            post +=stack.pop();
            i--;
          }
          
        }
      }
      
        return post;
        
    }; // translate
    
    
    /** This method returns the relative priority of an operator.
      *
      * @param  c  the operator
      *
      * @return  int  the relative priority of c.                                */
    
    private int prio ( char c ) {
        
      switch (c) {
        case '$':  return 1;
        case '#':  return 2;
        case '-':  return 5;
        case '+':  return 5;
        case '*':  return 8;
        case '/':  return 8;
        case '^':  return 10;
      }
      
       return 0;
      
    }; // prio
    
    
    public static void main ( String[] args ) { InfToPost i = new InfToPost(); };
    
    
} // InfToPost
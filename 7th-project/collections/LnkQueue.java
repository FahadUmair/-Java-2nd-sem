package Collections;
import java.io.*;

/** This interface defines the generic data type queue representing a FIFO
  * collection of objects of the same type (E).
  * 
  * @see  NoSpaceException
  * @see  NoItemException
  * 
  * @author  D. Hughes
  * 
  * @version  1.0 (Jan. 2014)                                                    */

public class LnkQueue <E> implements Queue<E>, Serializable {
    
    private Node<E> front;
    private Node<E> rear;
    private int count;
    
    public LnkQueue(){
    
    front=null;
    rear=null;
    count=0;
    }
  
  
  
    /** This method adds an item to the end of the queue. Queue overflow occurs if
      * there is no room to add another item.
      * 
      * @param  item  the item to be added.
      * 
      * @exception  NoSpaceException  no more room to add to queue.              */
    
    public void enter ( E i )
    {
    
      Node<E> t;
      t=new Node<E> (i,null);
      
      if (count<=0){front =t;}
      else {rear.next=t;}
      rear=t;
      count=count+1;
    
    }
    
    /** This method removes the front item from the queue. Queue underflow occurs
      * if there are no more items left.
      * 
      * @return  E  the item removed.
      * 
      * @exception  NoItemException  no items available in queue.                */
    
    public E leave ( )
    {
    E i;
    if (count<=0){
      throw new NoItemException();
    
    }else{
      i=front.item;
      front=front.next;
      count=count-1;
      if(count<=0){rear=null;}
      return i;
    }
    }
    
    /** This method returns the front item of the queue. Queue underflow occurs if
      * there are no more items left.
      * 
      * @return  E  the front item
      * 
      * @exception  NoItemException  no items available in queue.                */
    
    public E front ( )
    {if (count<=0){throw new NoItemException();}
      else{return front.item;}}
    
    /** This method returns true if the queue contains no items.
      * 
      * @return  boolean  whether the queue is empty.                            */
    
    public boolean empty ( )
    {
      return count <=0;
    }
    
    /** This method returns the number of items currently in the queue.
      * 
      * @return  int  the number of items in the queue.                          */
    
    public int length ( )
    {return count;}
    
} // Queue
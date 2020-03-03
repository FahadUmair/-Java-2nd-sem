package Path;


import BasicIO.*;
import Collections.*;


public class Path {
    
    
    private ASCIIDataFile   map;
    private ASCIIDisplayer  display;
    private double[][]      dist;
    
    
    public Path ( ) {
       
      int nv, v1, v2;
      double d;
      
      map=new ASCIIDataFile();
      display=new ASCIIDisplayer();
      nv=map.readInt();
      dist=new double [nv][nv];
      
      for (int i=0;i<nv; i++){
        for (int j=0; j<nv; j++){
        
          d=map.readDouble();
          if (d==-1){
            dist[i][j]=Double.MAX_VALUE;
          }
          else{
            dist[i][j]=d;
          }
        
        }
      
      }
      
      v1=map.readInt();  //source vertex
      v2=map.readInt();  // destination vertex
      map.close();
      displayMap();
      d=distance (v1,v2);
      display.writeString("Path from "+v1+ " to "+v2+ " = "+d);
      
    };  // constructor
    
    
    private double distance ( int from, int to ) {
      
      double[] dTo;//aray of shortest distances found
      Queue<Integer> toVisit;
      int v;
      double d;
      
      dTo=new double[dist.length];
      for (int i=0; i<dTo.length; i++){
        dTo[i]=Double.MAX_VALUE;
      }
      toVisit=new LnkQueue<Integer>();
      dTo[from]=0;
      toVisit.enter(from);
      while(!toVisit.empty()){
        v=toVisit.leave();
        for (int i=0; i<dist[v].length; i++){
          d=dTo[v]+dist[v][i];
          if (d<dTo[i]){
            dTo[i]=d;
            toVisit.enter(i);
          
          }
        }
      
      }
      return dTo[to];
        
    };  // distance
    
    private void displayMap(){
      for (int i=0;i<dist.length;i++){
        for (int j=0; j<dist[i].length;j++){
          if (dist[i][j]==Double.MAX_VALUE){
            display.writeString ("INF");
          }
          else{display.writeDouble(dist[i][j]);}
        }
        display.newLine();
      }
      
    
    }
    
    
    public static void main ( String[] args ) { Path p = new Path(); };
    
    
}  // Path
            
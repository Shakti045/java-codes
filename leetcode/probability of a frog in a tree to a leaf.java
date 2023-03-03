import java.util.*;
public class Shakti {
    public static class Node{
        int  source;
        int dest;
        Node(int source,int dest){
            this.source=source;
            this.dest=dest;
        }
    }
    public static void creategraph(ArrayList<Node>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Node(0,1));
        graph[0].add(new Node(0,2));
        graph[0].add(new Node(0,6));
        graph[1].add(new Node(1,3));
        graph[1].add(new Node(1,5));
        graph[2].add(new Node(2,4));
        graph[4].add(new Node(4,7));
        graph[4].add(new Node(4,8));
        graph[4].add(new Node(4,10));
        graph[8].add(new Node(8,9));
        graph[9].add(new Node(9,11));
        graph[9].add(new Node(9,12));
        graph[9].add(new Node(9,13));
    }

  static  double [] child=new double[14];
  public static void childcount(ArrayList<Node> [] graph){

        for(int i=0;i< graph.length;i++){
            child[i]=graph[i].size();
            if(child[i]==0){
                child[i]=1;
            }
        }
//
//        for(double i:child){
//            System.out.print(i+" ");
//        }
  }
  static double ans=1;
  public static void findprobability(int source,int dest,ArrayList<Node>[] graph){
      if(source==dest){
          System.out.println(ans);
          return;

      }

      ans=ans* (1/child[source]);
      for(int i=0;i<graph[source].size();i++){
          findprobability(graph[source].get(i).dest,dest,graph);

      }
      ans=ans/(1/child[source]);


  }
    public static void main(String[] args) {
        ArrayList[] graph=new ArrayList[14];
        creategraph(graph);
        childcount(graph);
         findprobability(0,10,graph);
    }
}

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Shakti {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
public static void print(Node root){

    Queue<Node> q=new LinkedList<>();
    q.add(root);
    q.add(null);
    while(!q.isEmpty()){
        Node curr=q.poll();
        if(curr==null){
            System.out.println();
            if(!q.isEmpty()){
                q.add(null);
            }
        }else{
            System.out.print(curr.data+" ");
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
    }
}public static int sum(Node root){
        if(root==null){
            return 0;
        }
        return root.data+sum(root.left)+sum(root.right);
    }


    public static void converttosumtree(Node root){
        if(root==null){
            return;
        }
        int a=sum(root);
        root.data=a-root.data;
        converttosumtree(root.left);
        converttosumtree(root.right);

    }
    public static Node lca(Node root,int n1,int n2){
        if(root==null){
            return null;
        }
        if(root.data==n1 || root.data==n2){
            return root;
        }
        Node left=lca(root.left,n1,n2);
        Node right=lca(root.right,n1,n2);
        if(left!=null && right!=null){
            return root;
        }
        if(left!=null){
            return root.left;
        }
      if(right!=null){
          return root.right;
      }
      return null;
    }
    public static int getdistance(Node root,int n1){
        if(root==null){
            return -1;
        }
        if(root.data==n1){
            return 0;
        }
        int left=getdistance(root.left,n1);
        int right=getdistance(root.right,n1);
        if(left==-1 && right==-1){
            return -1;
        }
        if(left!=-1){
            return getdistance(root.left,n1)+1;
        }

            return getdistance(root.right,n1)+1;

    }
    public static int getmindistance(Node root,int n1,int n2){
        Node lca=lca(root, n1, n2);
           int a=getdistance(lca,n1);
           int b=getdistance(lca,n2);
           return a+b+1;
    }

    public static int kthances(Node root,int n,int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int left=kthances(root.left,n,k);
        int right=kthances(root.right,n,k);
        if(left==-1 && right==-1){
            return -1;
        }
        if(left!=-1){
            if(left+1==k){
                System.out.println(root.data);
            }
            return left+1;
        }
        if(right!=-1){
            if(right+1==k){
                System.out.println(root.data);
            }
            return right+1;
        }
        return -1;
    }
    public static int getheight(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(getheight(root.left),getheight(root.right))+1;
    }

    public static int getdia(Node root){
        if(root==null){
            return 0;
        }
        int leftheight=getheight(root.left);
        int rightheight=getheight(root.right);
        return Math.max(leftheight+rightheight+1,Math.max(getdia(root.left),getdia(root.right)));
    }
   /* public static class Info{
        int dia;
        int ht;
        Info(int dia,int ht){
            this.dia=dia;
            this.ht=ht;
        }
    }

    public static Info finddia(Node root){
        if(root==null){
            return new Info(0,0);

        }
        Info leftinfo=finddia(root.left);
        Info rightinfo=finddia(root.right);
        int mydia=Math.max(Math.max(leftinfo.dia, rightinfo.dia), leftinfo.ht+ rightinfo.ht+1);
        int myht=Math.max(leftinfo.ht,rightinfo.ht)+1;
        return new Info(mydia,myht);
    }*/
    public static Node findnode(Node root1,Node root2){
        if(root1==null){
            return null;
        }
        if(root1.data== root2.data){
            return root1;
        }
       Node leftfind= findnode(root1.left,root2);
        Node rightfind=findnode(root1.right,root2);
        if(leftfind==null && rightfind==null){
            return null;
        }
        if(leftfind!=null){
            return leftfind;
        }

            return rightfind;

    }
    public static boolean isequal(Node root1,Node root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if (root1.data!= root2.data){
            return false;
        }
        boolean l=isequal(root1.left,root2.left);
        boolean d=isequal(root1.right,root2.right);
        return l && d;
    }
    public static boolean issubtree(Node root1,Node root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        Node find=findnode(root1,root2);
        if(find!=null){
          return   isequal(find,root2);
        }
        return false;
    }
    public static class Info{
        int d;
        Node n;
        public Info(Node n,int d){
            this.n=n;
            this.d=d;
        }
    }
    public static void topview(Node root){
        HashMap<Integer,Node> hs=new HashMap<>();
        Queue<Info> q=new LinkedList<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        q.add(new Info(root,0));
        while (!q.isEmpty()){
            Info curr=q.poll();
          if(!hs.containsKey(curr.d)) {
              hs.put(curr.d, curr.n);
          }
            if(curr.n.left!=null){
                q.add(new Info(curr.n.left,curr.d-1));
                min=Math.min(min,curr.d-1);

            }
            if(curr.n.right!=null){
                q.add(new Info(curr.n.right,curr.d+1));
                max=Math.max(curr.d+1,max);
            }
        }
        for(int i=min;i<=max;i++){
            System.out.print(hs.get(i).data+" ");
        }
        System.out.println();
    }
    static int index=-1;
    public static Node buildtree(int nodes[]){
        index++;
        if(nodes[index]==-1){
            return null;
        }
        Node root=new Node(nodes[index]);
        root.left=buildtree(nodes);
        root.right=buildtree(nodes);
        return root;
    }

    public static void main(String[] args) {

   int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
   Node root=buildtree(nodes);
   print(root);
    }
}

public class Shakti {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static void addfirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    public static void addlast(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
    }
    public static void print(Node head){
        if(head==null){
            System.out.println("null node");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }
    public static Node findmid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static Node mergesort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node mid=findmid(head);
        Node rig=mid.next;
        mid.next=null;

       Node lefthead= mergesort(head);
       Node righthead= mergesort(rig);
       return merge(lefthead,righthead);
    }
    public static Node merge(Node lefthead,Node righthead){
        Node temp1=lefthead;
        Node temp2=righthead;
        Node ans=new Node(-1);
        Node temp=ans;
        while(temp1!=null && temp2!=null){
            if(temp1.data<=temp2.data){
                temp.next=temp1;
                temp1=temp1.next;
                temp=temp.next;
            }else{
                temp.next=temp2;
                temp=temp.next;
                temp2=temp2.next;
            }
        }
        while(temp1!=null){
            temp.next=temp1;
            temp1=temp1.next;
            temp=temp.next;
        }
        while(temp2!=null){
            temp.next=temp2;
            temp=temp.next;
            temp2=temp2.next;
        }
        return ans.next;
    }
    public static void main(String[] args) {
        addlast(2);
        addlast(42);
        addlast(14);
        addlast(6);
        addlast(18);
        addlast(1);
        addlast(3);
        addlast(32);
        addlast(4);
        addlast(22);
        addlast(0);
        print(head);
        Node heads=mergesort(head);
        System.out.println();
        print(heads);
    }
}

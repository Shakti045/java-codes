class MinStack {
class MinStack {
        Node head;
    
    public void push(int val) {
        if(head==null){
            Node newnode=new Node(val,val);
            addfirst(newnode);
        }else{
            Node newnode=new Node(val,Math.min(val,head.min));
            addfirst(newnode);
        }
    }
    public void addfirst(Node newnode){
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    public void pop() {
        head=head.next;
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
    public class Node{
        int data;
        Node next;
        int min;

        public Node(int data,int min){
            this.data=data;
            this.min=min;
            this.next=null;
        }
    }
}



public class Queue {
    public static void main(String[] args){

        QueueOperations qo = new QueueOperations(4);
        qo.enqueue(12);
        qo.enqueue(15);
        qo.enqueue(17);

        qo.display();

        qo.dequeue();
        qo.dequeue();

        qo.display();

        qo.enqueue(21);
        qo.enqueue(25);
        
        qo.display();
    }
}

class QueueOperations {
    int n, f, r;
    int[] q;

    public QueueOperations(int size){
        n = size;
        f = r = -1;
        q = new int[n];
    }

    public void enqueue(int value){
        if(r >= n-1){
            System.out.println("\nQueue Overflow");
            return;
        }
        r++;
        q[r] = value;
        System.out.println(value+" is Innserted in Queue");

        if(f == -1){
            f = 0;
        }
    }

    public int dequeue(){
        if(f == -1){
            System.out.println("\nQueue Underflow");
            return 0;
        }

        int y = q[f];
        q[f] = 0;
        System.out.println(y+" is Removed from Queue");

        if(f == r){
            f = r = -1;
        }
        else{
            f++;
        }
        return y;
    }

    public void display(){
        System.out.println("\nQueue Elements are...");
        for(int i=f; i<=r; i++){
            System.out.println("Element "+(i+1)+" = "+q[i]);
        }
        System.out.println();
    }
}

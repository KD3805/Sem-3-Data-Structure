public class CircularQueue {
    public static void main(String[] args){

        QueueOperations qo = new QueueOperations(5);
        qo.cqInsert_Rear(0);
        qo.cqInsert_Rear(1);
        qo.cqInsert_Rear(2);
        qo.cqInsert_Rear(3);
        qo.cqInsert_Rear(4);

        qo.display();

        qo.cqDelete_Front();
        qo.cqDelete_Front();

        qo.display();

        qo.cqInsert_Front(21);
        qo.cqInsert_Front(25);
        qo.cqInsert_Front(28);
        
        qo.display();

        qo.cqDelete_Rear();
        qo.cqDelete_Rear();
        qo.cqInsert_Rear(31);
        qo.cqInsert_Rear(42);
        qo.cqInsert_Rear(55);
        qo.cqInsert_Rear(63);

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

    public void cqInsert_Rear(int value){
        if(r == n-1){
            r = 0;
        } else{
            r++;
        }
        if(f == r){
            System.out.println("Queue Overflow");
        }

        q[r] = value;
        System.out.println(value+" is Innserted in Rear of Queue");

        if(f == -1){
            f = 0;
        }
    }

    public void cqInsert_Front(int value){
        if(f == -1){
            System.out.println("Queue is Empty");
            return;
        } 
        if(f == 0){
            System.out.println("Queue Overflow");
            return;
        }

        f--;
        q[f] = value;
        System.out.println(value+" is Innserted in Front of Queue");
    }

    public int cqDelete_Front(){
        if(f == -1){
            System.out.println("\nQueue Underflow");
            return 0;
        }

        int y = q[f];
        q[f] = 0;
        System.out.println(y+" is Removed from Front of Queue");

        if(f == r){
            f = r = -1;
        }

        if(f == n-1){
            f = 0;
        } else{
            f++;
        }

        return y;
    }

    public int cqDelete_Rear(){
        if(r == -1){
            System.out.println("\nQueue Underflow");
            return 0;
        }

        int y = q[r];
        q[r] = 0;
        System.out.println(y+" is Removed from Rear of Queue");

        if(f == r){
            f = r = -1;
        } else{
            r--;
        }

        return y;
    }

    public void display(){

        System.out.println("\nQueue Elements are...");
        for(int i=0; i<n; i++){
            System.out.println("Element "+(i+1)+" = "+q[i]);
        }
        System.out.println();
        
    }
}

import java.util.*;
import org.w3c.dom.Node;

class GraphCreation {

  public static void main(String[] args) {
    // Node a = new Node(1);
    // Node b = new Node(2);
    // Node c = new Node(3);

    // a.node_list.add(b);
    // a.node_list.add(c);
    // b.node_list.add(c);

    // System.out.println("a : "+a.value);
    // System.out.println("b : "+a.node_list.get(0).value);
    // System.out.println("c : "+a.node_list.get(1).value);

    CreateNode cn = new CreateNode();

    ArrayList<Node> list = new ArrayList<Node>();

    list.add(cn.createNode(0, 'a'));
    list.add(cn.createNode(2, 'b'));
    list.add(cn.createNode(3, 'c'));
    list.add(cn.createNode(4, 'd'));

    int[][] mtx = {
      { 1, 0, 1, 1 },
      { 1, 1, 1, 0 },
      { 1, 1, 1, 0 },
      { 1, 1, 1, 0 },
    };
    Node a, b;

    for (int i = 0; i < mtx.length; i++) {
      for (int j = 0; j < mtx.length; j++) {
        if (mtx[i][j] == 1) {
          a = list.get(i);
          b = list.get(j);

          a.node_list.add(b);
        }
      }
    }

    for (int i = 0; i < list.size(); i++) {
      a = list.get(i);
      System.out.println("Node : " + a.ch);

      System.out.print("\tChild : ");
      for (int j = 0; j < a.node_list.size(); j++) {
        b = a.node_list.get(j);
        System.out.print("(" + b.ch + " : " + b.value + ") ");
      }
      System.out.println();
    }
  }

  // public static void bfs(ArrayList list[], int n) {
  //   Queue<Integer> q = new LinkedList<>();
  //   boolean vis[] = new boolean[n];

  //   q.add(0);

  //   while (!q.isEmpty()) {
  //     int frontNode = q.poll();

  //     if(vis[frontNode] == false) {
  //       System.out.print(frontNode+" ");
  //       vis[frontNode] = true;

  //       for(int i=0; i < list[frontNode].size(); i++) {
  //           Node nn = list[frontNode].get(i);
  //           q.add(nn.value);
  //       }
  //   }
  //   }
  // }
  }

  public static void bfs(ArrayList<Node> graph[], int n) {
    Queue<Integer> q = new LinkedList();
    boolean vis[] = new boolean[n];

    q.add(0);

    while(!q.isEmpty()) {
        int curr = q.remove();

        if(vis[curr] == false) {
            System.out.print(curr+" ");
            vis[curr] = true;

            for(int i=0; i < list[curr].size(); i++) {
                Node e = list[curr].get(i);
                q.add(e.dest);
            }
        }
    }
  }
  private static class Node {

    int value;
    char ch;
    ArrayList<Node> node_list = new ArrayList<Node>();

    private Node(int value, char c) {
      this.value = value;
      this.ch = c;
    }
  }

  public static class CreateNode {

    Node createNode(int x, char ch) {
      return (new Node(x, ch));
    }
  }

  public static class Matrix {

    public static void adj_matrix() {
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter No. of Nodes : ");
      int n = sc.nextInt();

      int[][] mtx = new int[n][n];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          System.out.print(
            "Enter element (" + (i + 1) + ", " + (j + 1) + ") : "
          );
          mtx[i][j] = sc.nextInt();
        }
      }
      // for (int i = 0; i < n; i++) {
      //     for (int j = 0; j < n; j++) {
      //         System.out.print("Element (" + (i + 1) + ", " + (j + 1) + ") : " + mtx[i][j] + "\n");
      //     }
      // }
    }
  }
}

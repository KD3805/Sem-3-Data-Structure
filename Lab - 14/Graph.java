import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class Graph {

  public static class Edge {
    int src;
    int dest;
    int weight;

    public Edge(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.weight = w;
    }
  }

  static void implementGraph(ArrayList<Edge> list[]) {
    for (int i = 0; i < list.length; i++) {
      list[i] = new ArrayList<>();
    }

    /*
      list (Array of ArrayList<Edge>)
      ├── [0] → ArrayList<Edge> (contains edges from vertex 0)
      │   ├── Edge(0,1,1)
      │   └── Edge(0,2,1)
      ├── [1] → ArrayList<Edge> (contains edges from vertex 1)
      │   ├── Edge(1,0,1)
      │   └── Edge(1,3,1)
      ├── [2] → ArrayList<Edge> (contains edges from vertex 2)
      │   ├── Edge(2,0,1)
      │   └── Edge(2,4,1)
      └── ... and so on
     */

    list[0].add(new Edge(0, 1, 1));
    list[0].add(new Edge(0, 2, 1));

    list[1].add(new Edge(1, 0, 1));
    list[1].add(new Edge(1, 3, 1));

    list[2].add(new Edge(2, 0, 1));
    list[2].add(new Edge(2, 4, 1));

    list[3].add(new Edge(3, 1, 1));
    list[3].add(new Edge(3, 4, 1));
    list[3].add(new Edge(3, 5, 1));

    list[4].add(new Edge(4, 2, 1));
    list[4].add(new Edge(4, 3, 1));
    list[4].add(new Edge(4, 5, 1));

    list[5].add(new Edge(5, 3, 1));
    list[5].add(new Edge(5, 4, 1));
    list[5].add(new Edge(5, 6, 1));

    list[6].add(new Edge(6, 5, 1));
  }

  public static void bfs(ArrayList<Edge> list[], int n) {
    Queue<Integer> q = new LinkedList<Integer>();
    boolean vis[] = new boolean[n];

    q.add(0);

    while (!q.isEmpty()) {
      int curr = q.remove();

      if (vis[curr] == false) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < list[curr].size(); i++) {
          Edge e = list[curr].get(i);
          q.add(e.dest);
        }
      }
    }
  }

  public static void printGraph(ArrayList<Edge> list[]) {
    System.out.println("\nAdjacency List of the Graph:");
    for (int i = 0; i < list.length; i++) {
      System.out.print("Vertex " + i + " -> ");
      for (Edge e : list[i]) {
        System.out.print("(" + e.src + ", " + e.dest + ") ");
      }
      System.out.println();
    }
  }

  // Recursive DFS implementation
  public static void dfsRecursive(ArrayList<Edge> list[], int curr, boolean vis[]) {
    System.out.print(curr + " ");
    vis[curr] = true;

    for (int i = 0; i < list[curr].size(); i++) {
      Edge e = list[curr].get(i);
      if (!vis[e.dest]) {
        dfsRecursive(list, e.dest, vis);
      }
    }
  }

  // Iterative DFS implementation using Stack
  public static void dfsIterative(ArrayList<Edge> list[], int n) {
    Stack<Integer> s = new Stack<>();
    boolean vis[] = new boolean[n];
    
    s.push(0);
    
    while (!s.isEmpty()) {
      int curr = s.pop();
      
      if (!vis[curr]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        
        // Push neighbors in reverse order to maintain same order as recursive
        for (int i = list[curr].size() - 1; i >= 0; i--) {
          Edge e = list[curr].get(i);
          if (!vis[e.dest]) {
            s.push(e.dest);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    /*
          1 --- 3
         /      | \
        0       |  5 -- 6
         \      | /
          2 --- 4
    */

    int n = 7;
    ArrayList<Edge> list[] = new ArrayList[n];
    implementGraph(list);
    
    System.out.println("Graph Structure:");
    printGraph(list);
    
    System.out.println("\nBFS Traversal:");
    bfs(list, n);
    System.out.println();
    
    System.out.println("\nDFS Recursive Traversal:");
    boolean vis[] = new boolean[n];
    dfsRecursive(list, 0, vis);
    System.out.println();
    
    System.out.println("\nDFS Iterative Traversal:");
    dfsIterative(list, n);
    System.out.println();
  }
}

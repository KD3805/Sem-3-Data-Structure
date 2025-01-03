import java.util.*;

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
    Queue<Integer> q = new LinkedList();
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
    bfs(list, n);
    System.out.println();
  }
}

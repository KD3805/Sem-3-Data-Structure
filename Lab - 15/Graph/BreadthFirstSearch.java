import java.util.*;
public class BreadthFirstSearch{

    static Map<Integer, List<Integer>> adjList = new HashMap<>();

    static void addEdge(int u, int v, boolean direction) {
        if (!adjList.containsKey(u)) {
            adjList.put(u, new ArrayList<>());
        }
        adjList.get(u).add(v);
        
        if (!direction) { // For undirected graph
            if (!adjList.containsKey(v)) {
                adjList.put(v, new ArrayList<>());
            }
            adjList.get(v).add(u);
        }
    }

    static void bfs(int src) {
        Queue<Integer> q = new LinkedList<Integer>();
        Map<Integer, Boolean> visited = new HashMap<>();

        queue.add(src);
        visited.put(src, true);

        while (!queue.isEmpty()) {
            int frontNode = queue.poll();
            System.out.print(frontNode + ",");

            for (int neighbor : adjList.get(frontNode)) {
                if (!visited.getOrDefault(neighbor, false)) {
                    queue.add(neighbor);
                    visited.put(neighbor, true);
                }
            }
        }
    }

    public static void main(String[] args){
        addEdge(0, 1,false);
        addEdge(1, 2,false);
        addEdge(1, 3,false);
        addEdge(3, 5,false);
        addEdge(3, 7,false);
        addEdge(7, 6,false);
        addEdge(7, 4,false);

        System.out.println("Breadth-First Traversal (starting from vertex 0):");
        bfs(0);
    }
}

// void bfs(int src){
//     //create a queue:
//     queue<int> q;
//     //create adjlist:
//     unordered_map<int,boolean> visited;
//     //push sorce into queue:
//     q.push(src);
//     visited[src]=True;

//     while(!q.isEmpty()){
//         int frontNode = q.front();
//         q.pop();
//         System.out.println(frontNode);

//         //insert neighbours
//         //i do not know syntax in java so i have written auto.i want all neighbours of FrontNode
//         for(auto neighbour:adjlist[frontNode]){
//             if(!visited[neighbour]){
//                 q.push(neighbour);
//                 visited[neighbour]=true;
//             }
//         }
//     }
// }
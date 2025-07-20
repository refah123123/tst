import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    private boolean[] visited;
    private int[] distance;
    private Queue<Integer> queue = new LinkedList<>();

    public Graph(int N) {
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Edge>());
        }
        visited = new boolean[N];
        distance = new int[N];
    }

    public void addEdge(int source, int dest, int weight, boolean directed) {
        adj.get(source).add(new Edge(dest, weight));
        if (!directed) {
            adj.get(dest).add(new Edge(source, weight));
        }
    }

    public void addEdge(int u, int v, boolean directed) {
        this.addEdge(u, v, 1, directed);
    }

    public void addEdge(int u, int v) {
        this.addEdge(u, v, 1, false);
    }

    public void draw() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + " : ");
            ArrayList<Edge> adjacent = adj.get(i);
            for (Edge v : adjacent) {
                System.out.print("(" + v.dest + ", " + v.weight + ") ");
            }
            System.out.println();
        }
    }

    private void clearVisit() {
        for (int i = 0; i < adj.size(); i++) {
            visited[i] = false;
            distance[i] = 1_000_000_000;
        }
    }

    private void dfs(int nodeIdx) {
        visited[nodeIdx] = true;
        ArrayList<Edge> adjacent = adj.get(nodeIdx);
        for (Edge e : adjacent) {
            int dest = e.getDest();
            if (!visited[dest]) {
                dfs(dest);
            }
        }
    }

    public int countCC() {
        clearVisit();
        int counter = 0;
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                counter++;
                dfs(i);
            }
        }
        return counter;
    }

    public int bfs(int start, int finish) {
        clearVisit();
        distance[start] = 0;
        queue.clear();
        queue.add(start);
        while (!queue.isEmpty()) {
            int nodeNow = queue.poll();
            visited[nodeNow] = true;
            if (nodeNow == finish) {
                return distance[nodeNow];
            }
            ArrayList<Edge> adjacent = adj.get(nodeNow);
            for (Edge e : adjacent) {
                int dest = e.getDest();
                if (!visited[dest]) {
                    distance[dest] = Math.min(distance[dest], distance[nodeNow] + 1);
                    queue.add(dest);
                }
            }
        }
        return -1; // tidak ditemukan
    }
}

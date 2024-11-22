import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static ArrayList<Node>[] A;
    static int INF = 999999999;

    public static class Node implements Comparable<Node> {
        public int vertex;
        public int cost;

        public Node (int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new ArrayList[N+1];
        for(int i = 0; i <= N; ++i) {
            A[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < N - 1; ++i) {
            int parent, child, cost;
            StringTokenizer st = new StringTokenizer(br.readLine());
            parent = Integer.parseInt(st.nextToken());
            child = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            A[parent].add(new Node(child, cost));
            A[child].add(new Node(parent, cost));
        }

        int[] distFromRoot = dijkstra(1);
        int farmostNode = 1;
        for(int i = 1; i <= N; ++i) {
            if(distFromRoot[i] > distFromRoot[farmostNode]) {
                farmostNode = i;
            }
        }

        int[] distFromFarmostNode = dijkstra(farmostNode);
        int maxLen = -1;
        for(int i = 1; i <= N; ++i) {
            maxLen = Math.max(maxLen, distFromFarmostNode[i]);
        }
        
        System.out.println(maxLen);
    }

    public static int[] dijkstra(int src) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(src, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.cost > dist[cur.vertex]) {continue;}
            dist[cur.vertex] = cur.cost;

            for(Node neighbor : A[cur.vertex]) {
                int nextCost = cur.cost + neighbor.cost;

                if(nextCost > dist[neighbor.vertex]) {continue;}
                pq.offer(new Node(neighbor.vertex, nextCost));
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}


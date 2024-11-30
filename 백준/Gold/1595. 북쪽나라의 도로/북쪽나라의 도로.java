import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Node>[] A;
    final static int MAX_CITY_CNT = 10000;
    final static int INF = 209999999;

    public static class Node implements Comparable<Node>{
        public int vertex;
        public int cost;
        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void solve() throws IOException {
        A = new ArrayList[MAX_CITY_CNT + 1];
        for(int i = 0; i <= MAX_CITY_CNT; ++i) {
            A[i] = new ArrayList<Node>();
        }

        int startNode = -1;
        while(true) {

            String input = br.readLine();
            if(input == null || input.isEmpty()) {
                break;
            }

            int a, b, cost;
            StringTokenizer st = new StringTokenizer(input);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            A[a].add(new Node(b, cost));
            A[b].add(new Node(a, cost));

            startNode = a;
        }

        if(startNode == -1) {
            System.out.println(0);
            return;
        }
        //임의의 노드 startNode 에서 가장 먼 노드(x) 찾음
        int[] x = dijkstra(startNode);

        //x에서 가장 먼 노드까지의 거리가 답
        int[] y = dijkstra(x[0]);
        System.out.println(y[1]);

    }

    public static int[] dijkstra(int startNode) {
        int farmostVertex = -1;
        int maxDist = -1;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] dist = new int[MAX_CITY_CNT + 1];
        Arrays.fill(dist, INF);

        pq.offer(new Node(startNode, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(dist[cur.vertex] > cur.cost) {
                dist[cur.vertex] = cur.cost;
                for(Node neighbor : A[cur.vertex]) {
                    if(dist[neighbor.vertex] > cur.cost + neighbor.cost) {
                        pq.offer(new Node(neighbor.vertex, cur.cost + neighbor.cost));
                    }
                }
            }
        }

        for(int i = 1; i <= MAX_CITY_CNT; ++i) {
            if(dist[i] == INF) {continue;}
            if(dist[i] > maxDist) {
                maxDist = dist[i];
                farmostVertex = i;
            }
        }

        return new int[]{farmostVertex, maxDist};
    }


    public static void main(String[] args) throws IOException {
        solve();
    }
}


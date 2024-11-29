import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static List<Node>[] A; //인접리스트

    static final int INF = 999999999;
    public static class Node implements Comparable<Node>{
        public int vertex;
        public int cost;
        public int connect;

        public Node(int vertex, int cost, int connect) {
            this.vertex = vertex;
            this.cost = cost;
            this.connect = connect;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }


    public static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        for(int i = 1; i <= N; ++i) {
            A[i] = new ArrayList<Node>();
        }


        for(int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int a, b, cost;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            A[a].add(new Node(b, cost, -1));
            A[b].add(new Node(a, cost, -1));
        }

        for(int i = 1; i <= N; ++i) {
            //dijkstra
            int dist[] = new int[N + 1];
            Arrays.fill(dist, INF);

            int connects[] = new int[N + 1];
            PriorityQueue<Node> pq = new PriorityQueue<>();

            pq.offer(new Node(i, 0, -1));
            while(!pq.isEmpty()) {
                Node cur = pq.poll();
                if(dist[cur.vertex] > cur.cost) {
                    dist[cur.vertex] = cur.cost;
                    connects[cur.vertex] = cur.connect;

                    for(Node neighbor : A[cur.vertex]) {
                        int cc = cur.connect;
                        if(cc == -1) {
                            cc = neighbor.vertex;
                        }

                        if(dist[neighbor.vertex] >= cur.cost + neighbor.cost) {
                            pq.offer(new Node(neighbor.vertex, cur.cost + neighbor.cost, cc));
                        }

                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= N; ++j) {
                if(i == j) {
                    sb.append("- ");
                    continue;
                }

                sb.append(String.valueOf(connects[j]));
                sb.append(" ");
            }

            System.out.println(sb.toString());
        }
    }


    public static void main(String[] args) throws IOException {
        solve();
    }
}


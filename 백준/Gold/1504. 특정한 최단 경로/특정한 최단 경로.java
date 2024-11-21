import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex, cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N, E;
    static List<Node>[] graph;
    static final int INF = Integer.MAX_VALUE / 10;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; ++i) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b ,c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(bf.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] distFrom1 = dijkstra(1);
        int[] distFromV1 = dijkstra(v1);
        int[] distFromV2 = dijkstra(v2);

        long path1 = (long) distFrom1[v1] + distFromV1[v2] + distFromV2[N];//1 -> v1 -> v2 -> N
        long path2 = (long) distFrom1[v2] + distFromV2[v1] + distFromV1[N];//1 -> v2 -> v1 -> N

        long result = Math.min(path1, path2);
        System.out.println(result >= INF ? -1 : result);
    }

    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.cost > dist[curr.vertex]) continue;

            for (Node neighbor : graph[curr.vertex]) {
                int newDist = dist[curr.vertex] + neighbor.cost;

                if (newDist < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = newDist;
                    pq.offer(new Node(neighbor.vertex, newDist));
                }
            }
        }

        return dist;
    }


    public static void main(String[] args) throws IOException {
        solve();
    }
}


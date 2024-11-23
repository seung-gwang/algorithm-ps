import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static class Edge implements Comparable<Edge> {
        public int a;
        public int b;
        public int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static List<Edge> edges;

    public static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<Edge>();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);

        int answer = mst();

        System.out.println(answer);

    }

    public static int getParent(int node, int[] parent) {
        if(node == parent[node]) {return node;}

        int ret = getParent(parent[node], parent);
        parent[node] = ret;

        return ret;
    }

    public static int mst() {
        List<Integer> route = new ArrayList<>();
        int[] parent = new int[N+1];
        for(int i = 1; i <= N; ++i) {
            parent[i] = i;
        }

        int sum = 0;
        int max = -1;

        for(Edge e : edges) {
            int a = e.a;
            int b = e.b;
            int cost = e.cost;

            int pa = getParent(a, parent);
            int pb = getParent(b, parent);

            if(pa != pb) {
                parent[pb] = pa;
                sum += cost;
                max = Math.max(max, cost);
            }
        }


        return sum - max;

    }


    public static void main(String[] args) throws IOException {
        solve();
    }
}


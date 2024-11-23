import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static List<Edge> edges;

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


    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edges = new ArrayList<Edge>();


        for (int i = 0; i < M; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
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
        int[] parent = new int[N+1];
        for(int i = 1; i <= N; ++i) {
            parent[i] = i;
        }

        int sum = 0;


        for(Edge e : edges) {
            int a = e.a;
            int b = e.b;
            int cost = e.cost;

            int pa = getParent(a, parent);
            int pb = getParent(b, parent);

            if(pa != pb) {
                parent[pb] = pa;
                sum += cost;
            }
        }


        return sum;

    }


    public static void main(String[] args) throws IOException {
        solve();
    }
}


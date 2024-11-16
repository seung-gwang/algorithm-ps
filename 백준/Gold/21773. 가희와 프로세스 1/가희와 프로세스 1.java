import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;


public class Main {
    static int T;
    static int n;

    public static class Process implements Comparable{
        public int pid;
        public int time;
        public int priority;

        public Process(int pid, int time, int priority) {
            this.pid = pid;
            this.time = time;
            this.priority = priority;
        }

        public int compareTo(Object o) {
            Process other = (Process)o;

            if(this.priority == other.priority) {
                return this.pid - other.pid;
            }

            return other.priority - this.priority;
        }
    }

    public static void solve() throws IOException {
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       String[] tn = bf.readLine().split(" ");
       T = Integer.valueOf(tn[0]);
       n = Integer.valueOf(tn[1]);

       PriorityQueue<Process> pq = new PriorityQueue<Process>();

       for(int i = 0; i < n; ++i) {
           String input[] = bf.readLine().split(" ");

           int pid = Integer.valueOf(input[0]); //pid
           int time = Integer.valueOf(input[1]); //time
           int priority = Integer.valueOf(input[2]); //초기 우선순위

           pq.add(new Process(pid, time, priority));
       }

       int t = 0;
        StringBuffer sb = new StringBuffer();
       while(!pq.isEmpty() && t < T) {
           ++t;

           Process cur = pq.poll();

           sb.append(String.valueOf(cur.pid));
           sb.append("\n");

           cur.time--;
           cur.priority--;

           if(cur.time == 0) {
               continue;
           }

           pq.add(cur);
       }

       System.out.print(sb.toString());
    }

    public static void main (String[] args) throws IOException {
        solve();
    }
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_Solution {
    static class Edge {
        int dest, wgt;
        Edge(int dt, int wt) {
            dest = dt;
            wgt = wt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int src[] = new int[m];
        int dest[] = new int[m];
        int wgt[] = new int[m];

        // Input
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            src[i] = Integer.parseInt(st2.nextToken());
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            dest[i] = Integer.parseInt(st3.nextToken());
        }
        StringTokenizer st4 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            wgt[i] = Integer.parseInt(st4.nextToken());
        }

        // Graph
        ArrayList<Edge> graph[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            graph[src[i]].add(new Edge(dest[i], wgt[i]));
        }

        // Output
        for (int i = 1; i <= n; i++)  {
            pw.print(i + ": ");
            for (Edge edge: graph[i]) {
                pw.print("(" + edge.dest + "," + edge.wgt + ") ");
            }
            pw.println();
        }
        pw.flush(); 
    }
}

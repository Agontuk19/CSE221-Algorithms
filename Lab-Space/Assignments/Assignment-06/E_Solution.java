import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class E_Solution {
    static ArrayList<Integer> graph[];
    static int[] dist;
    public static void bfs(int[] sources, int n) {
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        for (int source: sources) {
            q.add(source);
            dist[source] = 0;
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor: graph[node]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int s = Integer.parseInt(st1.nextToken());
        int q = Integer.parseInt(st1.nextToken());

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int src = Integer.parseInt(st2.nextToken());
            int des = Integer.parseInt(st2.nextToken());
            graph[src].add(des);
            graph[des].add(src);
        }

        int sources[] = new int[s];
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            sources[i] = Integer.parseInt(st3.nextToken());
        }

        bfs(sources, n);

        StringTokenizer st4 = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int des = Integer.parseInt(st4.nextToken());
            pw.print(dist[des] + " ");
        }
        pw.flush();
    }
}

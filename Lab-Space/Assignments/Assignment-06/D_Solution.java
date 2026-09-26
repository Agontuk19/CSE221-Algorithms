import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class D_Solution {
    static ArrayList<Integer> graph[];
    static PrintWriter pw = new PrintWriter(System.out); 
    public static int[] bfs(int start, int n) {
        int dist[] = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        int farthest = start;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor: graph[node]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }

                if (dist[neighbor] > dist[farthest]) {
                    farthest = neighbor;
                }
            }
        }
        return new int[]{farthest, dist[farthest]};
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] first = bfs(1, n);
        int[] second = bfs(first[0], n);

        pw.println(second[1]);
        pw.println(first[0] +  " " + second[0]);
        pw.flush(); 
    }
}

import java.io.*;
import java.util.*;

public class B_Solution {
    static PrintWriter pw = new PrintWriter(System.out);
    static StringBuilder dfsString = new StringBuilder();
    public static void dfs(int node, ArrayList<Integer> graph[], boolean visited[]) {
        visited[node] = true;
        dfsString.append(node).append(" ");

        for (int neighbor: graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        ArrayList<Integer> graph[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int src[] = new int[m];
        for (int i = 0; i < m; i++) {
            src[i] = Integer.parseInt(st2.nextToken());
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int des[] = new int[m];
        for (int i = 0; i < m; i++) {
            des[i] = Integer.parseInt(st3.nextToken());
        }

        for (int i = 0; i < m; i++) {
            graph[src[i]].add(des[i]);
            graph[des[i]].add(src[i]);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        boolean visited[] = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
            }
        }

        pw.println(dfsString.toString().trim());
        pw.flush(); 
    }
}
import java.io.*;
import java.util.*;

public class A_Solution {
    static PrintWriter pw = new PrintWriter(System.out);
    public static void bfs(int start, ArrayList<Integer> graph[], boolean visited[]) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            pw.print(node + " ");

            for (int neighbor: graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
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

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st2.nextToken());  
            int des = Integer.parseInt(st2.nextToken()); 
            graph[src].add(des); 
            graph[des].add(src); 
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        boolean visited[] = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i, graph, visited);
            }
        }
        pw.flush(); 
    }
}
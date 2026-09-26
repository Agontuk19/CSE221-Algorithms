import java.io.*;
import java.util.*;

public class C_Solution {
    static PrintWriter pw = new PrintWriter(System.out);
    public static void shortestPathLex(int start, int end, ArrayList<Integer> graph[], int n) {
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        parent[start] = -1;
        q.offer(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor: graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = node;
                    q.add(neighbor);
                } 
            }
        }

        if (!visited[end]) {
            pw.println(-1);
            return;
        }

        Stack<Integer> stack = new Stack<>();
        int curr = end;
        int count = -1;
        while (curr != -1) {
            stack.push(curr);
            curr = parent[curr];
            count++;
        }
        pw.println(count);
        while (!stack.isEmpty()) {
            pw.print(stack.pop() + " ");
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int s = Integer.parseInt(st1.nextToken()); 
        int d = Integer.parseInt(st1.nextToken());

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

        shortestPathLex(s, d, graph, n);
        pw.flush();
    }
}

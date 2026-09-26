import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class D_Solution {
    static PrintWriter pw = new PrintWriter(System.out);
    public static Stack<Integer> shortestPath(int start, int end, ArrayList<Integer> graph[], int n) {
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];

        Queue<Integer> q = new ArrayDeque<>();
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
            return null;
        }
        
        Stack<Integer> stack = new Stack<>();
        int curr = end;
        while (curr != -1) {
            stack.push(curr);
            curr = parent[curr];
        }
        return stack;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int s = Integer.parseInt(st1.nextToken());
        int d = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());

        ArrayList<Integer> graph[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st2.nextToken());
            int des = Integer.parseInt(st2.nextToken());
            graph[src].add(des);
        }

        Stack<Integer> dist1 = shortestPath(k, d, graph, n);
        Stack<Integer> dist2 = shortestPath(s, k, graph, n);

        if (dist1 == null || dist2 == null) {
            pw.println(-1);
        }
        else {
            pw.println((dist1.size() - 1) + dist2.size() - 1);

            while (!dist2.isEmpty()) {
                pw.print(dist2.pop() + " ");
            }
            dist1.pop();
            while (!dist1.isEmpty()) {
                pw.print(dist1.pop() + " ");
            }
            pw.println();
        }
        pw.flush();
    }
}

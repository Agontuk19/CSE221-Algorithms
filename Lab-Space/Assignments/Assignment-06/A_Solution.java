import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A_Solution {
    static ArrayList<Integer> graph[];
    static int indegree[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int k = Integer.parseInt(br.readLine());
        for (int x = 0; x < k; x++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            indegree = new int[n + 1];

            for (int i = 0; i < m; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());

                graph[a].add(b);
                indegree[b]++;
            }

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) q.add(i);
            }

            int answer[] = new int[n];
            int count = 0;
            while (!q.isEmpty()) {
                int node = q.poll();
                answer[count++] = node;
                for (int neighbor: graph[node]) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) q.add(neighbor);
                }
            }

            if (count != n) {
                pw.print(-1);
            }
            else {
                for (int i: answer) {
                    pw.print(i + " ");
                }
            }
            pw.println();
        }
        pw.flush();  
    }
}
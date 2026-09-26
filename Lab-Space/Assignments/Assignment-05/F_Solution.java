import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class F_Solution {
    static ArrayList<Integer> graph[];
    static int compArr[];
    static int comp;
    public static void dfs(int node) {
        compArr[node] = comp;
        for (int neighbor: graph[node]) {
            if (compArr[neighbor] == 0) {
                dfs(neighbor);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int q = Integer.parseInt(st1.nextToken());

        graph = new ArrayList[n + 1];
        compArr = new int[n + 1];
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
            if (compArr[i] == 0) {
                comp++;
                dfs(i);
            }
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st3.nextToken());
            int b = Integer.parseInt(st3.nextToken());

            if (compArr[a] == compArr[b]) {
                pw.println("YES");
            }
            else {
                pw.println("NO");
            }
        }
        pw.flush();
    }
}

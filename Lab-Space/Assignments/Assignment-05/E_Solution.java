import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class E_Solution {
    static ArrayList<Integer>[] graph;
    static int[] subtree;
    public static void dfs(int curr, int parent) {
        subtree[curr] = 1;
        for (int neighbor: graph[curr]) {
            if (neighbor == parent) continue;
            dfs(neighbor, curr);
            subtree[curr] += subtree[neighbor];
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int r = Integer.parseInt(st1.nextToken());

        graph = new ArrayList[n + 1];
        subtree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st2.nextToken());
            int des = Integer.parseInt(st2.nextToken());
            graph[src].add(des);
            graph[des].add(src);
        }

        dfs(r, 0);

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            int node = Integer.parseInt(br.readLine());
            pw.println(subtree[node]);
        }
        pw.flush();
    }
}

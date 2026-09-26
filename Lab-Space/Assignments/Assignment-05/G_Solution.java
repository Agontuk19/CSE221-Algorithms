import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_Solution {
    static ArrayList<Integer> graph[];
    static int[] state;

    public static boolean hasCycle(int node) {
        state[node] = 1;
        for (int neighbor: graph[node]) {
            if (state[neighbor] == 1) {
                return true;
            }
            if (state[neighbor] == 0 && hasCycle(neighbor)) {
                return true;
            }
        }
        state[node] = 2;
        return false;
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        graph = new ArrayList[n + 1];
        state = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st2.nextToken());
            int des = Integer.parseInt(st2.nextToken());
            graph[src].add(des);
        }

        for (int i = 1; i <= n; i++) {
            if (state[i] == 0 && hasCycle(i)) {
                pw.println("YES");
                pw.flush();
                return;
            }
        }
        pw.println("NO");
        pw.flush();
    }
}

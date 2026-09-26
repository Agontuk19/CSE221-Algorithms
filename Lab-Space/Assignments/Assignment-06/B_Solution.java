import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        ArrayList<Integer> graph[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int answer = 0;
        int color[] = new int[n + 1];
        Arrays.fill(color, -1);

        for (int i = 1; i <= n; i++) {
            if (color[i] != -1) continue;

            int count0 = 1;
            int count1 = 0;

            q.add(i);
            color[i] = 0;
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int neighbor: graph[node]) {
                    if (color[neighbor] == -1) {
                        color[neighbor] = 1 - color[node];

                        if (color[neighbor] == 0) count0++;
                        else count1++;
                        q.add(neighbor);
                    }
                }
            }
            answer += Math.max(count0, count1);
        }
        pw.println(answer);
        pw.flush();
    }
}

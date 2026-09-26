import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C_Solution {
    static int n;
    static int[] dx = {-2, -2, 2, 2, -1, -1, 1, 1};
    static int[] dy = {-1, 1, -1, 1, -2, 2, -2, 2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st1.nextToken()) - 1;
        int y1 = Integer.parseInt(st1.nextToken()) - 1;
        int x2 = Integer.parseInt(st1.nextToken()) - 1;
        int y2 = Integer.parseInt(st1.nextToken()) - 1;

        int dist[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[x1][y1] = 0;
        q.add(x1 * n + y1);

        while (!q.isEmpty()) {
            int curr = q.poll();

            int x = curr / n;
            int y = curr % n;

            if (x == x2 && y == y2) {
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.add(nx * n + ny);
                }
            }
        }
        pw.println(dist[x2][y2]);
        pw.flush();
    }
}

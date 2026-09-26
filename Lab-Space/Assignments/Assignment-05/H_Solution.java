import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_Solution {
    static char grid[][];
    static boolean visited[][];
    static int r, h;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static int bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        int diamonds = 0;
        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int cr = curr[0];
            int cc = curr[1];
            if (grid[cr][cc] == 'D') diamonds++;
 
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nr >= r || nc < 0 || nc >= h) {
                    continue;
                }
                if (grid[nr][nc] == '#') {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
        return diamonds;    
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st1.nextToken());
        h = Integer.parseInt(st1.nextToken());

        grid = new char[r][h];
        visited = new boolean[r][h];
        for (int i = 0; i < r; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < h; j++) {
                if (grid[i][j] != '#' && !visited[i][j]) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
        pw.println(answer);
        pw.flush();
    }
}

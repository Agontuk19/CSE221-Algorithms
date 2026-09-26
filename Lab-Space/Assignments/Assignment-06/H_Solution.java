import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_Solution {
    static ArrayList<Integer> graph[];
    static boolean visited[];
    static boolean usedLetter[] = new boolean[26];
    static String words[];
    public static boolean bfs(int start, int target) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == target) return true;

            int len = words[curr].length() - 1;
            char last = words[curr].charAt(len);
            if (!usedLetter[last - 'A']) {
                usedLetter[last - 'A'] = true;
                for (int next: graph[last - 'A']) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
        }
        return false; 
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        String A = st1.nextToken();
        String B = st1.nextToken();

        words = new String[n];
        visited = new boolean[n];
        graph = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }

        int start = -1, target = -1;
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();

            if (words[i].equals(A)) start = i;
            if (words[i].equals(B)) target = i;

            char first = words[i].charAt(0);
            graph[first - 'A'].add(i);
        }

        if (bfs(start, target)) {
            pw.println("YES");
        }
        else {
            pw.println("NO");
        }
        pw.flush();
    }
}

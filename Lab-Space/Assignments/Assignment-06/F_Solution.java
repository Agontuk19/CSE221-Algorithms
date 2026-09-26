import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class F_Solution {
    static HashSet<String> forbidden = new HashSet<>();
    public static int bfs(String start, String target) {
        if (forbidden.contains(target)) return -1;

        Queue<String> q = new ArrayDeque<>();
        HashMap<String, Integer> dist = new HashMap<>();

        q.add(start);
        dist.put(start, 0);

        while (!q.isEmpty()) {
            String curr = q.poll();
            char[] arr = curr.toCharArray();

            if (curr.equals(target)) {
                return dist.get(curr);
            }

            int currDist = dist.get(curr);
            for (int i = 0; i < 4; i++) {
                int digit = arr[i] - '0';

                arr[i] = (char) ('0' + (digit + 1) % 10);
                String next = new String(arr);
                if (!forbidden.contains(next) && !dist.containsKey(next)) {
                    dist.put(next, currDist + 1);
                    q.add(next);
                }

                arr[i] = (char) ('0' + (digit + 9) % 10);
                next = new String(arr);
                if (!forbidden.contains(next) && !dist.containsKey(next)) {
                    dist.put(next, currDist + 1);
                    q.add(next);
                }
                arr[i] = (char) ('0' + digit);
            }
        } 
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        String start = st1.nextToken();
        String target = st1.nextToken();
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            forbidden.add(br.readLine().trim());
        }

        pw.println(bfs(start, target));
        pw.flush();
    }
}

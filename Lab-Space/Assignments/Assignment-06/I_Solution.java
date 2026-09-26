import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class I_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        ArrayList<Integer> graph[] = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }
        int indegree[] = new int[26];
        boolean present[] = new boolean[26];

        int n = Integer.parseInt(br.readLine());
        String words[] = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            for (char c : words[i].toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String a = words[i];
            String b = words[i + 1];
            int len = Math.min(a.length(), b.length());
            boolean found = false;
            
            for (int j = 0; j < len; j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    int u = a.charAt(j) - 'a';
                    int v = b.charAt(j) - 'a';

                    if (!graph[u].contains(v)) {
                        graph[u].add(v);
                        indegree[v]++;
                    }
                    found = true;
                    break;
                }
            }
            if (!found && a.length() > b.length()) {
                pw.println(-1);
                pw.flush();
                return;
            }
        }

        int totalPresent = 0;
        for (int i = 0; i < 26; i++) {
            if(present[i]) {
                totalPresent++;
            }
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (present[i] && indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            answer.append((char) (node + 'a'));
            count++;
            for (int neighbor: graph[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        

        if (count != totalPresent) {
            pw.println(-1);
        }
        else {
            pw.println(answer);
        } 
        pw.flush();
    }
}
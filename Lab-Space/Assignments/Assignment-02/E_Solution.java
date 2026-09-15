import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        int freq[] = new int[n + 1];
        int left =  0;
        int dist = 0;
        int maxLen = 0;
        for (int right = 0; right < n; right++) {
            if (freq[arr[right]] == 0) {
                dist++;
            }
            freq[arr[right]]++;

            while (dist > k) {
                freq[arr[left]]--;
                if (freq[arr[left]] == 0) {
                    dist--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        pw.println(maxLen);
        pw.flush();
    }
}

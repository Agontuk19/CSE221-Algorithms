import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D_Solution {
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

        int left = 0;
        long sum = 0;
        int len = 0;
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            if (sum > k) {
                sum -= arr[left];
                left++;
            }
            len = Math.max(len, right - left + 1);
        }
        pw.println(len);
        pw.flush();
    }
}

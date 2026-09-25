import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E_Solution {
    static long mod;
    public static long[] multiply(long a, long n) {
        if (n == 0) return new long[]{1, 0};

        long half[] = multiply(a, n/2);
        long p = half[0];
        long s = half[1];

        long newP = (p * p) % mod;
        long newS = (s * (1 + p) % mod) % mod;

        if (n % 2 == 1) {
            newP = (newP * a) % mod;
            newS = (newS * a + a) % mod;
        }

        return new long[]{newP, newS};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int x = Integer.parseInt(br.readLine());
        for (int b = 0; b < x; b++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            mod = Long.parseLong(st.nextToken());

            pw.println(multiply(a, n)[1]);
        }
        pw.flush();
    }
}

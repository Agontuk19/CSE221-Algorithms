
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            long first = Long.parseLong(st.nextToken());
            String oper = st.nextToken();
            long second = Long.parseLong(st.nextToken());

            if (oper.equals("+")) {
                pw.println(first + second);
            }
            else if (oper.equals("-")) {
                pw.println(first - second);
            }
            else if (oper.equals("*")) {
                pw.println(first * second);
            }
            else if (oper.equals("/")) {
                pw.println((float)first / (float)second);
            }
            else if (oper.equals("%")) {
                pw.println(first % second);
            }
            else if (oper.equals("&")) {
                pw.println(first & second);
            }
            else if (oper.equals("|")) {
                pw.println(first | second);
            }
            else if (oper.equals("^")) {
                pw.println(first ^ second);
            }
            else if (oper.equals("<<")) {
                pw.println(first << second);
            }
            else if (oper.equals(">>")) {
                pw.println(first >> second);
            }
        }
        pw.flush();
    }
}

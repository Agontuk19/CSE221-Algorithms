import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class H_Solution {
    static int n;
    static int idx;
    static int preIdx;
    static int[] postOrder;
    static int[] inOrder;
    static int[] preOrder;

    public static void pre(int l, int r) {
        if (l > r) return;

        int root = postOrder[idx--];

        int pos = l;
        for (int i = l; i <= r; i++) {
            if (inOrder[i] == root) {
                pos = i;
                break;
            }
        }
        pre(pos + 1, r);
        pre(l, pos - 1);
        preOrder[preIdx++] = root;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        preOrder = new int[n];
        idx = n - 1;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st1.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st2.nextToken());
        }
        pre(0, n-1);

        for (int i = n-1; i >= 0;i--) {
            pw.print(preOrder[i] + " ");
        }
        pw.flush();
    }
}
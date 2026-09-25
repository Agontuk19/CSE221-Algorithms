import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_Solution {
    static int n;
    static int idx;
    static int[] preOrder;
    static int[] inOrder;

    public static void post(int l, int r) {
        if (l > r) return;

        int root = preOrder[idx++];

        int pos = l;
        for (int i = l; i <= r; i++) {
            if (inOrder[i] == root) {
                pos = i;
                break;
            }
        }
        post(l, pos - 1);
        post(pos + 1, r);
        System.out.print(root + " ");
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        preOrder = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st1.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            preOrder[i] = Integer.parseInt(st2.nextToken());
        }
        post(0, n-1);
    }
}
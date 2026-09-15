
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class G_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            int id[] = new int[a];
            int num[] = new int[a];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < a; j++) {
                id[j] = Integer.parseInt(st1.nextToken());
            }
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < a; j++) {
                num[j] = Integer.parseInt(st2.nextToken());
            }
            
            int swap = 0;
            for (int j = 0; j < a; j++) {
                int maxIdx = j;
                for (int k = j + 1; k < a; k++) {
                    if (num[k] > num[maxIdx]) {
                        maxIdx = k;
                    }
                    else if (num[k] == num[maxIdx] && id[k] < id[maxIdx]) {
                        maxIdx = k;
                    }
                }
                if (maxIdx != j) {
                    int temp = num[j];
                    num[j] = num[maxIdx];
                    num[maxIdx] = temp;

                    int temp2 = id[j];
                    id[j] = id[maxIdx];
                    id[maxIdx] = temp2;
                    swap++;
                }
            }
            pw.println("Minimum swaps: " + swap);
            for (int x = 0; x < a; x++) {
                pw.println("ID: " +  id[x] + " Mark: " + num[x]);
            }
            pw.flush();
        }
    }
}

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;

        for (int start = 0; start < n - 1; start++) {
            for (int end = start + 1; end < n; end++) {
                if (visited[start] && ((end - start) * (1 + Math.abs(arr[start] - arr[end]))) <= k) {
                    visited[end] = true;
                }
            }
        }

        if (visited[n - 1]) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
    }
}

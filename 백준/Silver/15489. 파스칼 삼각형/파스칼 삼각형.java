import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        
        long[][] pt = new long[r + w][r + w];
        
        for (int i = 0; i < r + w; i++) {
            Arrays.fill(pt[i], 1);
        }

        for (int i = 1; i < r + w - 1; i++) {
            for (int j = 1; j < i; j++) {
                pt[i][j] = pt[i - 1][j - 1] + pt[i - 1][j];
            }
        }
        
        long ans = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j <= i; j++) {
                ans += pt[r + i - 1][c + j - 1];
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}

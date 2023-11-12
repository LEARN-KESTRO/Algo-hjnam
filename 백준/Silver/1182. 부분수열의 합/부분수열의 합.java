import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, s, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 배열의 크기
        s = Integer.parseInt(st.nextToken()); // 찾고자 하는 부분집합의 합

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 배열 요소를 하나씩 입력 받음
        }

        ans = 0;
        choose(0, 0);
        if (s == 0){
            ans --;
        }
        bw.write(String.valueOf(ans));

        br.close();
        bw.flush();
        bw.close();
    }

    public static void choose(int cur, int value) {
        if (cur == n) {
            if (value == s) {
                ans ++;
            }
            return;
        }
        
        choose(cur + 1, value);
        choose(cur + 1, value + arr[cur]);
    }
}

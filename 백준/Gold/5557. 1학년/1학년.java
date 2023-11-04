import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int target = nums[n - 1];
        long[] dp = new long[21];

        // 첫 번째 숫자로 시작
        dp[nums[0]] = 1;

        // 다이나믹 프로그래밍으로 dp 테이블 채우기
        for (int i = 1; i < n - 1; i++) {
            long[] next = new long[21];
            for (int j = 0; j <= 20; j++) {
                if (dp[j] != 0) {
                    if (j + nums[i] <= 20) {
                        next[j + nums[i]] += dp[j];
                    }
                    if (j - nums[i] >= 0) {
                        next[j - nums[i]] += dp[j];
                    }
                }
            }
            dp = next;
        }

        // 결과 출력
        bw.write(String.valueOf(dp[target]));
        bw.newLine();

        // 리소스 해제
        br.close();
        bw.flush();
        bw.close();
    }
}

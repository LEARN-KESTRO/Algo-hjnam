import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int target = nums[n - 1];

        // dp[i][j] := i번째 숫자까지 사용해서 j 값을 만들 수 있는 경우의 수
        long[][] dp = new long[n][21];
        dp[0][nums[0]] = 1L;

        for (int i = 1; i < n - 1; i++) { 
            for (int j = 0; j <= 20; j++) { 
                if (j + nums[i] <= 20) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
                if (j - nums[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }

        System.out.println(dp[n - 2][target]);
        scanner.close();
    }
}

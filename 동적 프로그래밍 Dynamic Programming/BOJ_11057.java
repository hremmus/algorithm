import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  final static int MOD = 10007;
  static int N;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= N <= 1000. 자릿수
    dp = new int[N + 1][10]; // N번째 자리에 숫자 0 ~ 9가 오는 경우의 수

    Arrays.fill(dp[1], 1); // 0 ~ 9
    // dp[2][0] = dp[1] = 10 (0으로 시작하는 숫자도 포함)
    // dp[2][1] = dp[1][1] + dp[1][2] + dp[1][3] + ... + dp[1][9] = 9
    // dp[2][2] = dp[1][2] + dp[1][3] + ... + dp[1][8] + dp[1][9] = 8
    // .
    // .
    // dp[2][7] = dp[1][7] + dp[1][8] + dp[1][9] = 3
    // dp[2][8] = dp[1][8] + dp[1][9] = 2
    // dp[2][9] = dp[1][9] = 1
    for (int i = 2; i <= N; i++) {
      for (int j = 0; j <= 9; j++) {
        for (int k = j; k <= 9; k++) {
          dp[i][j] += dp[i - 1][k] % MOD;
        }
      }
    }

    int result = 0;
    for (int i : dp[N]) {
      result += i;
    }

    System.out.println(result % MOD);
    br.close();
  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static Integer[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= N <= 30

    dp = new Integer[N + 1];
    // 주어진 두 종류의 타일 크기가 2이므로, N이 짝수일 때만 3 * N 타일을 채울 수 있다.
    dp[0] = 1;
    if (N >= 2) dp[2] = 3; // 3 * 2 => dp[0] * 3 = 3
    // dp[4] = 3 * 2 * 2 => dp[2] * 3 + dp[0] * 2 = 11
    // dp[6] = 3 * 2 * 2 + 3 * 2 => dp[4] * 3 + dp[2] * 2 + dp[0] * 2 = 41
    for (int i = 4; i <= N; i += 2) {
      // dp[N] = dp[N - 2] * 3 + dp[N - 4] * 2 + dp[N - 6] * 2 + ... + dp[0] * 2
      dp[i] = dp[i - 2] * 3;

      for (int j = i - 4; j >= 0; j -= 2) {
        dp[i] += dp[j] * 2;
      }
    }

    System.out.println(N % 2 == 1 ? 0 : dp[N]);
    br.close();
  }
}

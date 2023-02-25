import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // BOJ_11726에 채울 수 있는 2x2 타일이 추가됨
  static int n;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine()); // 1 <= n <= 1000
    dp = new int[1001];
    dp[1] = 1; dp[2] = 3;
    // dp[3] = 5, dp[4] = 11
    // 즉, n의 경우의 수 = (n - 1)의 경우의 수 + (n - 2)의 경우의 수 * 2

    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
    }

    System.out.println(dp[n]);
    br.close();
  }
}

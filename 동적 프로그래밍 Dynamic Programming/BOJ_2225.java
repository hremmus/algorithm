import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  // 0부터 N까지의 숫자 K개를 합해 N을 만드는 경우의 수
  static int N, K;
  static long[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken()); // 1 <= N <= 200. 합해서 만들 수
    K = Integer.parseInt(st.nextToken()); // 1 <= K <= 200. 분해 개수

    dp = new long[K + 1][N + 1];
    Arrays.fill(dp[1], 1); // K = 1이면 N을 만들기 위한 경우의 수는 1 뿐이다.
    for (int i = 1; i <= K; i++) {
      dp[i][0] = 1; // 0을 K개만큼 반복해서 더하므로 모든 경우의 수가 1이다.
    }

    // N = 20, K = 2일 때 dp[2][20] = dp[1][0] + dp[1][1] + dp[1][2] + ... + dp[1][20]
    // N = 4, K = 3일 때 dp[3][4] = dp[2][0] + dp[2][1] + dp[2][2] + dp[2][3] + dp[2][4]
    // => 두 개를 합해 0이 되는 경우에 +4를, 1이 되는 경우에 +3을, 2가 되는 경우에 +2를,
    //    3이 되는 경우에 +1을, 4가 되는 경우에 +0을 하면 되기 때문이다.
    // => 즉, dp[K][N] = dp[K - 1][0] + dp[K - 1][1] + ... + dp[K - 1][N - 1] + dp[K - 1][N]

    // 그런데, 경우의 수를 구하다 보면 반복되는 합이 나타나는 것을 볼 수 있다.
    // dp[2][1] = dp[1][0] + dp[1][1] = dp[2][0] + dp[1][1] = 1 + 1 = 2
    // dp[2][2] = dp[1][0] + dp[1][1] + dp[1][2] = dp[2][1] + dp[1][2] = 2 + 1 = 3

    // K = 1, N = 0인 경우를 제하면 아래의 점화식이 성립한다.
    for (int i = 2; i <= K; i++) {
      for (int j = 1; j <= N; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        dp[i][j] %= 1_000_000_000;
      }
    }

    System.out.println(dp[K][N]);
    br.close();
  }
}

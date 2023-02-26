import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int T, n;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    dp = new int[10 + 1]; // 0 < n < 11
    // n의 합을 나타내는 데 1, 2, 3만이 이용되므로 먼저 1, 2, 3을 만드는 경우의 수를 설정한다.
    dp[1] = 1; // 1
    dp[2] = 2; // 1+1, 2
    dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

    // 위의 식을 이용해 4를 만들어 보면
    // 1+3 | 1+1+2, 2+2 | 1+1+1+1, 1+2+1, 2+1+1, 3+1
    // 각 경우의 수에 +3, +2, +1을 해주기만 하면 되기 때문에 이전 세 가지 경우의 수를 더하면 4를 만드는 경우의 수가 된다.
    // 즉 dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
    // cf) dp[5] = 7 + 4 + 2 = 13
    // 1+1+3, 2+3 | 1+1+1+2, 1+2+2, 2+1+2, 3+2 | 1+3+1, 1+1+2+1, 2+2+1, 1+1+1+1+1, 1+2+1+1, 2+1+1+1, 3+1+1
    for (int i = 4; i < dp.length; i++) {
      dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
    }
    
    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      n = Integer.parseInt(br.readLine());
      sb.append(dp[n]).append("\n");
    }
    
    System.out.println(sb);
    br.close();
  }
}

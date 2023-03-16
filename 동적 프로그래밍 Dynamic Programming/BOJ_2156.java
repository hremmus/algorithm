import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int n;
  static int[] input, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine()); // 1 <= n <= 10000
    input = new int[n + 1];
    for (int i = 1; i < input.length; i++) {
      input[i] = Integer.parseInt(br.readLine()); // 0 <= input[i] <= 1000
    }

    dp = new int[n + 1];
    dp[1] = input[1];
    if (n > 1) // n = 1일 때 에러 방지
      dp[2] = input[1] + input[2];
    
    // 6, 10, 13, 9, 8, 1 여섯 잔일 때, 6 + 10 + 9 + 8 = 33 이어야 함
    // dp[1] = 6 dp[2] = 10 dp[3] = 16 dp[4] = 25 dp[5] = 33 dp[6] = 33 
    
    for (int i = 3; i <= n; i++) {
      // 1) 앞의 두 잔까지의 최대값 (더할 수 없음)
      // 2) 앞앞 잔까지의 최대값과 (한 번 더할 수 있음) 자기 자신이 가진 양
      // 3) 앞앞앞 잔까지의 최대값과(두 번 연속 더할 수 있음) 앞+자기 자신이 가진 양 
      dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + input[i], dp[i - 3] + input[i - 1] + input[i]));
    }

    System.out.println(dp[n]);
    br.close();
  }
}

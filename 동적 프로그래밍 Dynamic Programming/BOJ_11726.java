import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // 세로는 고정된 값 2이기 때문에, 가로를 1 또는 2로 채우는 모든 경우의 수를 구하면 답이다.
  static int n;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine()); // 1 <= n <= 1000
    dp = new int[1001];
    dp[1] = 1; dp[2] = 2;
    // 그런데 3 = (1+1+1) or (1+2) or (2+1), 4 = (1+1+1+1) or (1+1+2) or (1+2+1) or (2+1+1) or (2+2)
    // 즉, n의 경우의 수 = (n - 1)의 경우의 수 + (n - 2)의 경우의 수
    
    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
    }
    
    System.out.println(dp[n]);
    br.close();
  }
}

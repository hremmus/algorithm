import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  final static int MOD = 9901; 
  static int N;
  static long[][] dp;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 1 <= N <= 100000
    N = Integer.parseInt(br.readLine());
    
    dp = new long[N + 1][3]; // N행에 사자를 0: 배치X, 1: 왼쪽 배치, 2: 오른쪽 배치
    dp[1][0] = 1; dp[1][1] = 1L; dp[1][2] = 1L; // Arrays.fill(dp[1], 1);
    /*
    dp[2][0] = 3; // = dp[1][0] + dp[1][1] + dp[1][2]
    dp[2][1] = 2; // = dp[1][0] + dp[1][2]
    dp[2][2] = 2; // = dp[1][0] + dp[1][1]
    dp[3][0] = 7; // = dp[2][0] + dp[2][1] + dp[2][2]
    dp[3][1] = 5; // = dp[2][0] + dp[2][2]
    dp[3][2] = 5; // = dp[2][0] + dp[2][1]
    dp[4][0] = 17; // = dp[3][0] + dp[3][1] + dp[3][2]
    dp[4][1] = 12; // = dp[3][0] + dp[3][2]
    dp[4][2] = 12; // = dp[3][0] + dp[3][1]
    */
    
    System.out.println((recursive(N, 0) + recursive(N, 1) + recursive(N, 2)) % MOD);
    br.close();
  }
  
  static long recursive(int N, int position) {
    if (dp[N][position] == 0) {
      if (position == 0) {
        dp[N][0] = (recursive(N - 1, 0) + recursive(N - 1, 1) + recursive(N - 1, 2)) % MOD;
      } else if (position == 1) {
        dp[N][1] = (recursive(N - 1, 0) + recursive(N - 1, 2)) % MOD;
      } else if (position == 2) {
        dp[N][2] = (recursive(N - 1, 0) + recursive(N - 1, 1)) % MOD;
      }
    }
    
    return dp[N][position];
  }
}

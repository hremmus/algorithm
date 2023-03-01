import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // BOJ_9095와 달리 1, 2, 3 세 숫자의 합으로 이루어진 수식에 같은 수를 두 번 이상 연속해서 사용하면 안 된다. 
  // => 2차원 배열 이용하여 메모이제이션
  static int T, n;
  static long[][] dp; // 출력 줄-배열 값의 총합에서 오버플로우 발생 가능 

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    dp = new long[100_000 + 1][3 + 1]; // 0 < n <= 100000, 수식의 맨 뒤에 오는 숫자 1, 2, 3
    // 1 = 1 ===> 1
    dp[1][1] = 1;
    // 2 = 2 ===> 1
    dp[2][2] = 1;
    // 3 = 3 = 2+1 = 1+2 ===> 3
    dp[3][1] = 1;
    dp[3][2] = 1;
    dp[3][3] = 1;
    // 4 = 3+1 = 1+3 = 1+2+1 ===> 3
    //  dp[4][1] = 2, dp[4][3] = 1
    // 5 = 3+2 = 2+3 = 2+1+2 = 1+3+1 ===> 4
    //  dp[5][1] = dp[4][3] = 1
    //  dp[5][2] = dp[3][1] + dp[3][2] = 2
    //  dp[5][3] = dp[2][1] = 1
    // 6 = 3+2+1 = 3+1+2 = 2+3+1 = 2+1+3 = 2+1+2+1 = 1+3+2 = 1+2+3 = 1+2+1+2 ===> 8
    //  dp[6][1] = dp[5][2] + dp[5][3] = 3
    //  dp[6][2] = dp[4][1] + dp[4][3] = 3
    //  dp[6][3] = dp[3][1] + dp[3][2] = 2
    // 7 = 3+1+3 = 3+1+2+1 = 2+3+2 = 2+1+3+1 = 1+3+2+1 = 1+3+1+2 = 1+2+3+1 = 1+2+1+3 = 1+2+1+2+1 ===> 9
    //  dp[7][1] = dp[6][2] + dp[6][3] = 5
    //  dp[7][2] = dp[5][1] + dp[5][3] = 2
    //  dp[7][3] = dp[4][1] + dp[4][2] = 2
    for (int i = 4; i < dp.length; i++) {
      dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1_000_000_009;
      dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1_000_000_009;
      dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1_000_000_009;
    }

    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      n = Integer.parseInt(br.readLine());
      sb.append((dp[n][1] + dp[n][2] + dp[n][3]) % 1_000_000_009).append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}

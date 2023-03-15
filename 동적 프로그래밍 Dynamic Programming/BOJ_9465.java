import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int T, n;
  static int[][] input, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      n = Integer.parseInt(br.readLine()); // 1 <= n <= 1000000
      input = new int[2][n + 1];
      for (int i = 0; i < 2; i++) {
        String[] line = br.readLine().split(" ");
        for (int j = 1; j <= n; j++) {
          input[i][j] = Integer.parseInt(line[j - 1]);
        }
      }

      dp = new int[2][n + 1];
      // 최대값을 구하기 위해 먼저 1열의 dp 값을 자기 자신으로 초기화
      dp[0][1] = input[0][1];
      dp[1][1] = input[1][1];
      // 인접한 두 칸을 제외하고, 다음 선택지는 대각선에 위치한 칸(a)과, 그 옆에 위치한 칸(b) 둘 중 하나가 된다.
      // 그런데 대각선에 위치한 칸을 선택하면 다음 대각선에 위치한 칸(a')을 포함할(뜯을) 수 있으므로,
      // dp 값을 이용해 두 칸을 더한 값(a+a')과 대각선 옆에 위치한 칸(b)의 최대값을 비교하게 된다.
      for (int i = 2; i <= n; i++) {
        // 기존 최대값에 다음 열의 점수를 더함
        dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + input[0][i];
        dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + input[1][i];
      }

      sb.append(Math.max(dp[0][n], dp[1][n])).append("\n"); // 최종 비교
    }

    System.out.print(sb);
    br.close();
  }
}

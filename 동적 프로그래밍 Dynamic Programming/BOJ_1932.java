import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int n;
  static int[][] input, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine()); // 1 <= n <= 500
    input = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 1; j <= i; j++) { // i를 넘지 않음 => 삼각형 모양
        input[i][j] = Integer.parseInt(line[j - 1]); // 0 <= input[i][j] <= 9999
      }
    }

    dp = new int[n + 1][n + 1];
    dp[1][1] = input[1][1];
    if (n > 1) {
      dp[2][1] = input[1][1] + input[2][1];
      dp[2][2] = input[1][1] + input[2][2];
    }

    for (int i = 3; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        // i - 1행의 j - 1열과 j열 둘 중 한 곳에서 출발
        // 이전 행까지의 최대 경로를 비교하여 더 큰 값을 선택하고, 현재 위치의 크기를 더함
        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + input[i][j];
      }
    }

    // 경로의 값이 최대인 원소를 따라가다 보면 index를 알지 못함 => 오름차순 정렬하여 값이 최대인 원소를 마지막에 두고 출력
    Arrays.sort(dp[n]);
    System.out.println(dp[n][n]);
    br.close();
  }
}

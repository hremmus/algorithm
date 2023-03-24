import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // BOJ_1149 참고, 첫번째 집과 마지막 집의 색이 같으면 안 된다는 조건이 추가됨 => line 29~39, 41~53
  final static int RED = 0;
  final static int GREEN = 1;
  final static int BLUE = 2;

  static int N;
  static int[][] cost, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 2 <= N <= 1000

    cost = new int[N][3];
    dp = new int[N][3];

    for (int i = 0; i < N; i++) {
      String line[] = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) { // line.length: 3
        cost[i][j] = Integer.parseInt(line[j]); // 1 <= cost[i][j] <= 1000
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < 3; i++) { // RED -> GREEN -> BLUE
      // 먼저 첫번째 집을 칠하는 최소값(비용)을 색을 나누어 각각의 위치에 저장
      // i = RED일 때 dp[0][RED], i = GREEN일 때 dp[0][GREEN], i = BLUE일 때 dp[0][BLUE]
      // 나머지는 범위 밖의 값으로 설정
      for (int j = 0; j < 3; j++) { // RED -> GREEN -> BLUE
        if (i == j) {
          dp[0][j] = cost[0][i];
        } else {
          dp[0][j] = 1000 * 1000 + 1; // 최대 집 개수와 최대 비용를 곱한 값에 +1
        }
      }

      // 인접한 집끼리 색깔이 같으면 안 된다는 조건을 반영, 두번쨰 집 ~ N - 1번째 집까지 칠해나가는 각각의 최소값을 구한다.
      for (int j = 1; j < N; j++) {
        dp[j][RED] = Math.min(dp[j - 1][GREEN], dp[j - 1][BLUE]) + cost[j][RED];
        dp[j][GREEN] = Math.min(dp[j - 1][RED], dp[j - 1][BLUE]) + cost[j][GREEN];
        dp[j][BLUE] = Math.min(dp[j - 1][RED], dp[j - 1][GREEN]) + cost[j][BLUE];
      }

      for (int j = 0; j < 3; j++) { // RED -> GREEN -> BLUE
        // 첫번째 집과 마지막 집이 같은 색이면 결과에 포함 x
        if (i == j) continue;
        // 같지 않다면, 마지막 집까지 칠하는 데 드는 최소 비용을 구함.
        min = Math.min(min, dp[N - 1][j]);
      }
    }

    System.out.println(min);
    br.close();
  }
}

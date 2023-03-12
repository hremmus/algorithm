import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // 2) 2차원 배열 두 개 + 재귀 함수 이용

  // 각 집의 비용의 최솟값을 찾아 누적합을 구하면 오답
  // 인접한 집의 색이 겹치지 않도록 하는 모든 경로의 경우의 수를 찾은 다음 최종적으로 최소인 누적합을 찾아야 한다.
  final static int RED = 0;
  final static int GREEN = 1;
  final static int BLUE = 2;
  static int N;
  static int[][] cost, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine()); // 1 <= N <= 1000 (입력 2 <= N <= 1000)
    cost = new int[N][3];
    dp = new int[N][3];

    for (int i = 0; i < cost.length; i++) {
      st = new StringTokenizer(br.readLine());
      cost[i][RED] = Integer.parseInt(st.nextToken());
      cost[i][GREEN] = Integer.parseInt(st.nextToken());
      cost[i][BLUE] = Integer.parseInt(st.nextToken());
    }

    //           red          blue          green
    // 1번 집 cost[1][0]   cost[1][1]   cost[1][2]
    // 2번 집 cost[2][0] += Math.min(cost[1][1], cost[1][2])
    //       cost[2][1] += Math.min(cost[1][0], cost[1][2])
    //       cost[2][2] += Math.min(cost[1][0], cost[1][1])
    // N번 집 cost[N][0] += Math.min(cost[N - 1][1], cost[N - 1][2])
    //       cost[N][1] += Math.min(cost[N - 1][0], cost[N - 1][2])
    //       cost[N][2] += Math.min(cost[N - 1][0], cost[N - 1][1])
    // 함수를 호출하기 전, dp[0]의 값을 첫번째 집의 색칠 비용으로 초기화
    dp[0][RED] = cost[0][RED];
    dp[0][GREEN] = cost[0][GREEN];
    dp[0][BLUE] = cost[0][BLUE];

    System.out.println(Math.min(recursive(N - 1, RED), Math.min(recursive(N - 1, GREEN), recursive(N - 1, BLUE))));
    br.close();
  }

  static int recursive(int N, int color) {
    if (dp[N][color] == 0) {
      // 이전 집의 최소 비용을 구한 값에 현재 집의 비용을 더함
      if (color == RED) {
        dp[N][RED] = Math.min(recursive(N - 1, GREEN), recursive(N - 1, BLUE)) + cost[N][RED];
      } else if (color == GREEN) {
        dp[N][GREEN] = Math.min(recursive(N - 1, RED), recursive(N - 1, BLUE)) + cost[N][GREEN];
      } else if (color == BLUE) {
        dp[N][BLUE] = Math.min(recursive(N - 1, RED), recursive(N - 1, GREEN)) + cost[N][BLUE];
      }
    }

    return dp[N][color];
  }
}

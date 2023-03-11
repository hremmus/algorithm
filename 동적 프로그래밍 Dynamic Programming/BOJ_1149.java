import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // 1) 2차원 배열 한 개 + 반복문 이용
  
  // 각 집의 비용의 최솟값을 찾아 누적합을 구하면 오답
  // 인접한 집의 색이 겹치지 않도록 하는 모든 경로의 경우의 수를 찾은 다음 최종적으로 최소인 누적합을 찾아야 한다.
  final static int RED = 0;
  final static int GREEN = 1;
  final static int BLUE = 2;
  static int N;
  static int[][] cost;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine()); // 1 <= N <= 1000 (입력 2 <= N <= 1000)
    cost = new int[N][3];

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
    for (int i = 1; i < cost.length; i++) {
      cost[i][RED] += Math.min(cost[i - 1][GREEN], cost[i - 1][BLUE]);
      cost[i][GREEN] += Math.min(cost[i - 1][RED], cost[i - 1][BLUE]);
      cost[i][BLUE] += Math.min(cost[i - 1][RED], cost[i - 1][GREEN]);
    }

    System.out.println(Math.min(Math.min(cost[N - 1][RED], cost[N - 1][GREEN]), cost[N - 1][BLUE]));
    br.close();
  }
}

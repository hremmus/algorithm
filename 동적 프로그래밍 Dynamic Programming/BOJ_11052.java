import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] p, cost;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= N <= 1000
    StringTokenizer st = new StringTokenizer(br.readLine());
    p = new int[N + 1]; cost = new int[N + 1];
    for (int i = 1; i < p.length; i++) {
      p[i] = Integer.parseInt(st.nextToken()); // 카드팩[개수] = 비용. 1 <= p[i] <= 10000
    }

    // N = 4, p[1] = 1, p[2] = 5, p[3] = 6, p[4] = 7일 때 최대비용 계산
    // cost[1] ? p[0] + p[1] = 1 ===> 1
    // cost[2] ? p[1] + p[1] = 2 | p[0] + p[2] = 5 ===> 5
    // cost[3] ? p[2] + p[1] = 6 | p[1] + p[2] = 6 | p[0] + p[3] = 6 ===> 6
    // cost[4] ? p[3] + p[1] = 7 | p[2] + p[2] = 10 | p[1] + p[3] = 7 | p[0] + p[4] = 7 ===> 10
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= i; j++) { // j <= i : N개보다 많이 든 카드팩은 계산하지 않음(살 수 없음)
        cost[i] = Math.max(cost[i], cost[i - j] + p[j]); // 첫번째 파라미터로 비교-최대값이 기록됨
      }
    }

    System.out.println(cost[N]);
    br.close();
  }
}

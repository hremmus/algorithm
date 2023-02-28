package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16194_230409 {
  // BOJ_11052 최대비용 구하는 문제 변형
  static int N;
  static int[] p, cost;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= N <= 1000
    StringTokenizer st = new StringTokenizer(br.readLine());
    p = new int[N + 1];
    cost = new int[N + 1];
    for (int i = 1; i < p.length; i++) {
      p[i] = Integer.parseInt(st.nextToken()); // 카드팩[개수] = 비용. 1 <= p[i] <= 10000
    }

    for (int i = 1; i <= N; i++) {
      cost[i] = p[i]; // min을 호출하기 위해 먼저 초기화
      for (int j = 1; j <= i; j++) { // j <= i : N개보다 많이 든 카드팩은 계산하지 않음(살 수 없음)
        cost[i] = Math.min(cost[i], cost[i - j] + p[j]); // 첫번째 파라미터에 최소값이 기록됨
      }
    }

    System.out.println(cost[N]);
    br.close();
  }
}

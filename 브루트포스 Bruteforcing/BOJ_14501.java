import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[] T, P, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= N <= 15

    T = new int[N];
    P = new int[N];

    for (int i = 0; i < N; i++) {
      String[] line = br.readLine().split(" ");
      T[i] = Integer.parseInt(line[0]); // 1 <= T[i] <= 5
      P[i] = Integer.parseInt(line[1]); // 1 <= P[i] <= 1000
    }

    // N일에 얻을 수 있는 최대 수익을 구하는 dp를 정의
    dp = new int[N + 1];
    for (int i = 0; i < N; i++) {
      if (T[i] + i <= N) {
        dp[T[i] + i] = Math.max(dp[T[i] + i], dp[i] + P[i]);
      }

      // 해당 날짜에 일할 수 없다면(dp 값이 0), 이전까지 일한 최대 수당을 넣어 주기 위해 max 이용
      dp[i + 1] = Math.max(dp[i + 1], dp[i]);
    }

    System.out.println(dp[N]);
    br.close();
  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // 2개 이상의 동일한 제곱수가 존재할 가능성 (ex) 753 = 625 + 64 + 64 => 배열에 메모이제이션 한 뒤 dp[N]으로 답을 구함
  static int N;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= N <= 100000
    dp = new int[N + 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = i; // 먼저, 1의 제곱수로 이루어져 제곱수 항의 '최대 개수'를 의미하는 i개로 초기화

      for (int j = 1; j * j <= i; j++) { // N 이하인 제곱수마다 반복
        dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1); // 제곱수를 항으로 빼주었기 때문에 개수 +1
        // 아래 코드와 같다.
        // if (dp[i] > dp[i - (j * j)] + 1) { dp[i] = dp[i - (j * j)] + 1; }
      }
    }

    System.out.println(dp[N]);
    br.close();
  }
}

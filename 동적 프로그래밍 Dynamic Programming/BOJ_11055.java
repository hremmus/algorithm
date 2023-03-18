import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[] input, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= n <= 1000
    input = new int[N];
    String[] line = br.readLine().split(" ");
    for (int i = 0; i < input.length; i++) {
      input[i] = Integer.parseInt(line[i]);
    }

    dp = new int[N];
    dp[0] = input[0];
    for (int i = 1; i < dp.length; i++) {
      dp[i] = input[i]; // 최댓값을 구하기 위해 먼저 자기 자신으로 초기화 = 자기 자신만을 원소로 가진 부분 수열의 최댓값
      for (int j = 0; j < i; j++) {
        if (input[i] > input[j]) { // 이전 원소보다 값이 크면(증가하는 부분 수열)
          // 기존의 dp 값과 비교하여 큰 값을 선택
          dp[i] = Math.max(dp[i], dp[j] + input[i]);
        }
      }
    }

    int result = dp[0];
    for (int i : dp) {
      if (result <= i) {
        result = i;
      }
    }

    System.out.println(result);
    br.close();
  }
}

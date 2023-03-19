import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N;
  static int[] input, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= n <= 1000
    input = new int[N];
    String[] line = br.readLine().split(" ");
    for (int i = 0; i < input.length; i++) {
      input[i] = Integer.parseInt(line[i]); // 1 <= input[i] <= 1000
    }

    dp = new int[N];
    Arrays.fill(dp, 1); // 감소하는 부분 수열의 length
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < i; j++) {
        if (input[i] < input[j]) { // 이전 원소보다 크기가 작으면(감소하는 부분 수열)
          // 기존의 dp 값과 비교하여 큰 값을 선택
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    Arrays.sort(dp);
    System.out.println(dp[N - 1]);
    br.close();
  }
}

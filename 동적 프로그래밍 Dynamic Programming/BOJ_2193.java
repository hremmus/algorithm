import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // 1차원 배열과 반복문으로 풀이
  static int N;
  static long dp[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= N <= 90 자릿수 => long
    // 1: 1 ==> 1
    // 2: 10 ==> 1
    // 3: 100, 101 ==> 2
    // 4: 1000, 1001, 1010 ==> 3
    // 5: 10000, 10001, 10010, 10100, 10101 ==> 5
    dp = new long[N + 1];
    dp[1] = 1;

    // 4자릿수 10'00', 10'01', 10'10' ==> 뒷자리가 3자릿수 2개와 겹침, 2자릿수 1개와 겹침
    // 5자릿수 10'000', 10'001', 10'010', 10'100', 10'101' ==> 뒷자리가 4자릿수 3개와 겹침, 3자릿수 2개와 겹침
    // => 아래의 점화식이 성립한다
    for (int i = 2; i < dp.length; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    System.out.println(dp[N]);
    br.close();
  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // 2차원 배열 + 재귀 함수로 풀이
  static int N;
  static Long dp[][];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= N <= 90 자릿수 ==> long
    // 1: 1 ==> 1
    // 2: 10 ==> 1
    // 3: 100, 101 ==> 2
    // 4: 1000, 1001, 1010 ==> 3
    // 5: 10000, 10001, 10010, 10100, 10101 ==> 5
    dp = new Long[N + 1][2];
    dp[1][0] = 0L; dp[1][1] = 1L; // digit == 1일 때 값을 초기화해놓아야 재귀 함수 호출이 가능
    
    int result = 0;
    for (int i = 0; i <= 1; i++) {
      result += recursive(N, i);
    }
    
    System.out.println(result);
    br.close();
  }
  
  static long recursive(int digit, int value) {
    if (digit == 1) return dp[digit][value];
    
    if (dp[digit][value] == null) {
      if (value == 1) dp[digit][value] = recursive(digit - 1, 0);
      if (value == 0) dp[digit][value] = recursive(digit - 1, 0) + recursive(digit - 1, 1);
    }
    
    return dp[digit][value];
  }
}

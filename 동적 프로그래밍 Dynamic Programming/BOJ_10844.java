import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // 2차원 배열로 '각 자리수'에 '0 ~ 9'가 오는 '경우의 수'를 저장
  static int N;
  static Long[][] dp; // 10억으로 나눈 나머지 값, 재귀 함수에서 null을 이용하기 위해 Wrapper 클래스 타입의 Long을 선언
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= N <= 100 자릿수
    // 1: 1, 2, 3, 4, 5, 6, 7, 8, 9
    // 2: 10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98 (9 다음은 10이므로 90 X)
    dp = new Long[N + 1][10]; // 10: 각 자리에 오는 수 0 ~ 9
    
    for (int i = 0; i < 10; i++) {
      dp[1][i] = 1L; // 한 자리 숫자에 올 수 있는 값은 자기 자신 단 하나 뿐임 (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    }
    
    long result = 0;
    for (int i = 1; i < 10; i++) {
      result += recursive(N, i);
      // N이 2면? 2(10,12)+2(21,23)+2(32,34)+2(43,45)+2(54,56)+2(65,67)+2(76,78)+2(87,89)+1(98)=17
    }

    System.out.println(result % 1_000_000_000);
    br.close();
  }
  
  // Top-Down 방식 재귀 함수 => 높은 자릿수(N)부터 낮은 자릿수(1)로 이동하며 탐색 => 낮은 자릿수부터 메모이제이션
  static long recursive(int digit, int value) {
    if (digit == 1) return dp[digit][value];
    
    if (dp[digit][value] == null) {
      if (value == 0) {
        dp[digit][value] = recursive(digit - 1, 1); // 값이 0이면 뒷자리 수는 무조건 1이 와야 함
      } else if (value == 9) {
        dp[digit][value] = recursive(digit - 1, 8); // 값이 9면 뒷자리 수는 무조건 8이 와야 함 (0 불가)
      } else { // 0, 9를 제외한 숫자는 뒷자리 수로 +-1인 경우의 수를 합산
        dp[digit][value] = recursive(digit - 1, value - 1) + recursive(digit - 1, value + 1);
      }
    }
        
    return dp[digit][value] % 1_000_000_000;
  }
}

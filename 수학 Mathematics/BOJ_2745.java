import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // B진수 -> 10진수? 각 자리의 숫자 또는 문자에 해당하는 진법의 거듭제곱을 곱한 다음 모두 더한다. (BOJ_11005와 반대)
  static String N;
  static int B;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = st.nextToken();
    B = Integer.parseInt(st.nextToken()); // 2 <= B <= 36

    int temp = 1; // 초기값 1 = B의 0승
    int result = 0; // 0 <= result < 1000000000
    for (int i = N.length() - 1; i >= 0; i--) { // 오른쪽부터
      char ch = N.charAt(i);
      if (ch >= 'A' && ch <= 'Z') {
        result += (ch + 10 - 'A') * temp; // 알파벳 대문자로 표시하던 것을 상응하는 숫자로 치환
      } else {
        result += (ch - '0') * temp; // char -> int형 치환
      }

      temp *= B; // 반복을 거치며 B가 N의 자릿수만큼 거듭제곱된다.
    }

    System.out.println(result);
    br.close();
  }
}

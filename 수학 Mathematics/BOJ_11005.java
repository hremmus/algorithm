import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // 10진수 -> B진수? 10진수 N을 몫이 0이 될 때까지 B로 나누고, 그 나머지 값들을 역순으로 읽으면 B진수가 된다.
  static int N, B;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 1 <= N < 1000000000
    B = Integer.parseInt(st.nextToken()); // 2 <= B <= 36

    if (N == 0) sb.append(0);

    while (N != 0) {
      if (N % B < 10) {
        sb.append(N % B);
      } else { // 나머지가 10 이상이면 숫자로 표시할 수 없는 자리가 있다. 이를 알파벳 대문자 A, B, C, ..., Z로 표현한다.
        sb.append((char) (N % B - 10 + 'A')); // 10 = 'A', 11 = 'B', 12 = 'C', ... 35= 'Z'
      }

      N /= B;
    }

    System.out.println(sb.reverse());
    br.close();
  }
}

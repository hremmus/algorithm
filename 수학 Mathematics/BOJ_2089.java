import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // 10진수 -> 2진수와 같은 방식
  //     -13  =>  110111
  // -13 / -2 = 6.5(-> 7) ... 1
  // 7 / -2 = -3.5(-> -3) ... 1
  // -3 / -2 = 1.5(-> 2) ... 1
  // 2 / -2 = -1 ... 0
  // -1 / -2 = 0.5(-> 1) ... 1
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    N = Integer.parseInt(br.readLine());
    if (N == 0) {
      System.out.println(0);
    } else {
      while (N != 1) { // 몫이 1이 될 때까지 -2로 나눔
        sb.append(Math.abs(N % -2)); // 나머지는 빌더에 추가
        N = (int) Math.ceil((double) N / -2); // 소수점 이하 높임
      }

      sb.append(N); // = 1
      sb.reverse(); // 문자열 뒤집기
      System.out.println(sb);
    }

    br.close();
  }
}

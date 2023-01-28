import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int A, B;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    sb.append(gcd(A, B)).append("\n");
    // 두 수를 소인수분해한 공통 부분이 최대공약수이므로,
    // 두 수를 곱한 값에 최대공약수를 나누면 최소공배수가 된다.
    sb.append(A * B / gcd(A, B)).append("\n");
    
    System.out.println(sb);
    br.close();
  }

  // Greatest Common Divisor
  // a >= b, r = a mod b(0 <= r < b)를 만족할 때
  // gcd(a, b) = gcd(b, r)이다.
  static int gcd(int a, int b) {
    // 나머지가 0이면, 두 수가 a로 나누어 떨어진다는 의미이므로 최대 공약수 gcd는 a가 된다. 재귀함수를 빠져 나옴
    if (b == 0) return a;

    // gcd(a, b) = gcd(b, r)이므로 재귀함수 호출
    // 위 식에 의해 r은 곧 a % b이다.
    return gcd(b, a % b);
  }
}

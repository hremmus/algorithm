import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int T, M, N, x, y;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st;
    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken()); // 1 <= M
      N = Integer.parseInt(st.nextToken()); // N <= 40000
      x = Integer.parseInt(st.nextToken()); // 1 <= x <= M
      y = Integer.parseInt(st.nextToken()); // 1 <= y <= N

      // 시간 복잡도를 줄이기 위해, x와 y의 값은 구하고자 하는 해에 M과 N을 나눈 나머지라는 점을 이용한다.
      int ix = 0; int iy = 0;
      int lcm = (M * N) / gcd(M, N);
      while (true) {
        // x, y를 M, N에 대한 등차수열 형태로 나열
        int tempX = M * ix + x;
        int tempY = N * iy + y;

        // 둘 중 하나라도 M과 N의 최소공배수를 넘기면 유효하지 않은 <x:y>
        if (tempX > lcm || tempY > lcm) {
          sb.append(-1).append("\n");
          break;
        }

        // 공통된 해를 발견하면 종료
        if (tempX == tempY) {
          sb.append(tempX).append("\n");
          break;
          
        } else {
          if (tempX < tempY) {
            ix++;
          } else if (tempX > tempY) {
            iy++;
          }
        }
      }
    }

    System.out.println(sb);
    br.close();
  }

  // 탐색 범위를 최소공배수로 지정하기 위해 최대공약수를 구함
  static int gcd(int a, int b) {
    if (b == 0)
      return a;

    return gcd(b, a % b);
  }
}

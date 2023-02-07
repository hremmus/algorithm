import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // nCm = n! / (n - m)!m!이므로 n!에 대한 2와 5의 승수는 더하고, (n - m)!과 m!에 대한 2와 5의 승수는 뺀다.
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    long count5 = divide5(n) - divide5(n - m) - divide5(m);
    long count2 = divide2(n) - divide2(n - m) - divide2(m);

    System.out.println(Math.min(count5, count2)); // 5와 2가 쌍을 이루어야 하므로 최소값이 쌍의 개수
    br.close();
  }

  static long divide5(long number) {
    long count = 0;

    while (number >= 5) {
      count += number / 5;
      number /= 5;
    }

    return count;
  }

  static long divide2(long number) {
    long count = 0;

    while (number >= 2) {
      count += number / 2;
      number /= 2;
    }

    return count;
  }
}

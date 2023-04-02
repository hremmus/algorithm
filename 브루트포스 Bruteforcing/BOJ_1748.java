import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= N <= 100000000

    int count = 0;
    // 1부터 시작, 10의 거듭제곱으로 증가. 숫자 N보다 커지면 종료(=N의 자릿수만큼 반복)
    for (int i = 1; i <= N; i *= 10) {
      count += (N - i) + 1; // 자릿수의 누적함
      // N + (N - 10) + 1 + (N - 100) + 1 + ... + (N - N의 자릿수) + 1
    }

    System.out.println(count);
    br.close();
  }
}

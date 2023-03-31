import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= N <= 100000000

    int count = 0;
    for (int start = 1, length = 1; start <= N; start *= 10, length++) {
      // start = 1이면 end = 9, start = 10이면 end = 99, start = 100이면, end = 999
      int end = (start * 10) - 1;
      // end가 N을 넘어서는 안 됨
      if (end > N) end = N;
      
      count += (end - start + 1) * length; // 범위에 속하는 개수에 자릿수를 곱한 다음 합산
    }

    System.out.println(count);
    br.close();
  }
}

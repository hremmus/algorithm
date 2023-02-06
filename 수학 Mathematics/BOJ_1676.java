import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static long N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 0 <= N <= 500. 팩토리얼 값을 다루기 어려움

    int count = 0;
    // 정수 N에 10(2*5)을 곱하면 뒷자리에 0이 더해진다.
    // 소인수분해하면 2의 지수의 개수가 5의 지수의 개수보다 많거나 같을 것이므로 약수 2는 고려하지 않는다.
    // N을 5로 나눌 때마다 카운트를 증가시킨다.
    // (실제로, N!에서 N이 5의 배수일 때마다 뒷자리 0의 개수가 1씩 증가되고 있음
    //  단, 24! -> 25! 2개 증가, 124! -> 125! 3개 증가)

    // 0! = 1, 1! = 1, 2! = 2 * 1 = 2, 3! = 3 * 2 * 1= 6, 4! = 4 * 3 * 2 * 1 = 24
    while (N >= 5) {
      count += N / 5;
      N /= 5;
    }

    System.out.println(count);
    br.close();
  }
}

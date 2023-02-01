import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // 1과 자기 자신을 제외한 어떤 수로 나누어 떨어진다면(=약수를 가진다면) 소수가 아님
  // => 숫자 N이 주어졌을 때 숫자를 2부터 N - 1까지 나누어 본다.
  // => 숫자는 좌우 대칭으로 곱이 일어나므로 N의 제곱근 '이하'까지 검사하면 시간을 단축할 수 있다.
  //    그 위는 이미 검사한 수가 약수에 해당하거나, N의 약수가 아니다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();

    int count = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) { // st.nextToken()과 함께 사용
      boolean isPrime = true;
      int number = Integer.parseInt(st.nextToken());
      if (number == 1) continue; // 카운트하지 않고 넘김
      
      for (int i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) {
          isPrime = false;
          break;
        }
      }

      if (isPrime) count++;
    }

    System.out.println(count);
    br.close();
  }
}


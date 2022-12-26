import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  /*
   *             Count
   *  N |   ZERO       ONE
   *  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
   *  0 |     1         0
   *  1 |     0         1
   *  2 |     1         1
   *  3 |     1         2
   *  4 |     2         3
   *  5 |     3         5
   *  6 |     5         8
   *  7 |     8         13
   *  N | fibo(N-1) + fibo(N-2)
   */

  // 조건으로 null을 다루기 위해 Integer형 배열을 생성
  // Integer: 참조형(내부에 클래스 O)으로, 값을 가리키는 주소를 저장
  // cf) int: 기본형(내부에 클래스 X)으로, 실제 값을 저장
  static Integer[][] arr = new Integer[41][2]; // 41: 0 <= N <= 40, 2: 0, 1

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    arr[0][0] = 1; arr[0][1] = 0;
    arr[1][0] = 0; arr[1][1] = 1;

    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    int N;
    while(T-- > 0){
      N = Integer.parseInt(br.readLine());
      fibonacci(N);
      sb.append(arr[N][0]).append(" ").append(arr[N][1]).append("\n");
    }
    System.out.print(sb);
  }

  static Integer[] fibonacci(int N) {
    // 탐색하지 않은 수일 때 = 이미 탐색한 수가 들어왔을 때 다시 탐색하지 않음
    if(arr[N][0] == null || arr[N][1] == null) {
      arr[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
      arr[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
    }

    return arr[N];
  }
}
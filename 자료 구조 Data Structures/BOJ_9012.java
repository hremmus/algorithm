import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  /* stack의 push/pop으로 구현이 가능 */
  static int T, count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      char arr[] = br.readLine().toCharArray();
      if (arr[0] == ')') {
        sb.append("NO\n");
        continue; // 다음 테스트 데이터로 넘어감
      }

      int i = 0;
      for (i = 0; i < arr.length; i++) {
        if (arr[i] == '(') count++;
        else if (arr[i] == ')') count--;

        if (count < 0) { // 닫는 괄호가 더 많아지면 count를 멈춤. i != arr.length
          sb.append("NO\n");
          break;
        }
      }

      if (i == arr.length) { // 입력 데이터 한 줄에 대해 count를 마치고
        if (count == 0) sb.append("YES\n");
        else sb.append("NO\n");
      }

      count = 0; // 초기화
    }

    System.out.println(sb);
    br.close();
  }
}

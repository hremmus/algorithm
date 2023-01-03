import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  /* 배열을 이용한 단어 뒤집기 */
  static int T;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String[] words = br.readLine().split(" "); // sentence를 공백 기준으로 잘라 배열에 담음

      for (String word : words) {
        for (int index = word.length() - 1; index >= 0; index--) { // 알파벳 맨 뒤부터 출력
          sb.append(word.charAt(index)); // String.charAt(int): 해당하는 인덱스의 character를 반환
        }
        sb.append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);

    br.close();
  }
}

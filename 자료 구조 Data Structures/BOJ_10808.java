import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static String S;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int[] count = new int[26]; // 영소문자 a ~ z, 총 26개

    S = br.readLine();
    for (int i = 0; i < S.length(); i++) {
      count[S.charAt(i) - 'a'] += 1; // count 배열의 인덱스 값으로 해당 알파벳 ASCII 코드에 'a'를 뺀 값을 사용
    }

    for (int i : count) {
      sb.append(i + " ");
    }

    System.out.println(sb);
  }
}

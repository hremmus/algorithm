import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static String S;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    S = br.readLine();

    String[] arr = new String[S.length()];
    for (int i = 0; i < S.length(); i++) {
      arr[i] = S.substring(i); // 인덱스로 시작하는 하위 문자열을 반환
    }

    Arrays.sort(arr); // 오름차순 정렬

    for (String suffix : arr) {
      sb.append(suffix).append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}

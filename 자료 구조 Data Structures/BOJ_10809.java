import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static String S;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    S = br.readLine();
    int[] location = new int[26]; // 영소문자 a ~ z, 총 26개
    for (int i = 0; i < location.length; i++) {
      location[i] = -1; // 위치 탐색 전 모든 원소를 -1로 초기화
    }

    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);

      if (location[ch - 'a'] == -1) // 알파벳이 두 번 이상 등장하는 경우 처음으로 등장하는 위치를 출력하기 위함
        location[ch - 'a'] = i;
    }

    for (int i : location) {
      sb.append(i + " ");
    }

    System.out.println(sb);
    br.close();
  }
}

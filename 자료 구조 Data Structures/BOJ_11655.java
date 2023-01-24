import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // 알파벳은 26개로 구성되어 있으므로, 반으로 나누어 앞 13개는 + 방향으로, 뒤 13개는 - 방향으로 미는 방법
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String sentence = br.readLine();
    for (int i = 0; i < sentence.length(); i++) {
      char ch = sentence.charAt(i);
      if ((ch >= 'a' && ch <= 'm') || (ch >= 'A' && ch <= 'M')) { // a ~ m 또는 A ~ M
        ch += 13;
      } else if ((ch >= 'n' && ch <= 'z') || (ch >= 'N' && ch <= 'Z')) { // n ~ z 또는 N ~ Z
        ch -= 13;
      }

      sb.append(ch); // 공백과 숫자는 암호화하지 않음
    }

    System.out.println(sb);
    br.close();
  }
}

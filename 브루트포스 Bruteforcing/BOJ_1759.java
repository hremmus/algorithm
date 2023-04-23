import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int L, C;
  static char[] input, password;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] line = br.readLine().split(" ");
    L = Integer.parseInt(line[0]); // 3 <= L <= 15
    C = Integer.parseInt(line[1]); // L <= C <= 15

    line = br.readLine().split(" ");
    input = new char[C];
    for (int i = 0; i < C; i++) {
      input[i] = line[i].charAt(0);
    }

    // 암호는 오름차순으로 배열
    Arrays.sort(input);

    password = new char[L];

    dfs(0, 0);

    br.close();
  }

  private static void dfs(int start, int depth) {
    if (depth == L) {
      if (isValid()) {
        System.out.println(password);
      }

      return;
    }

    for (int i = start; i < C; i++) {
      password[depth] = input[i];
      dfs(i + 1, depth + 1);
    }
  }

  private static boolean isValid() {
    int consonant = 0;
    int vowel = 0;
    for (char x : password) {
      if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') vowel++;
      else consonant++;
    }

    // 최소 두 개의 자음과 한 개의 모음으로 구성
    if (consonant >= 2 && vowel >= 1) return true;
    else return false;
  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    char[] arr = br.readLine().toCharArray();

    boolean tag = false;
    for (int i = 0; i < arr.length; i++) {
      // 태그 처리
      if (arr[i] == '<') {
        tag = true;
        sb.append('<');
      } else if (arr[i] == '>') {
        tag = false;
        sb.append('>');

        // 태그 내부 문자 혹은 공백 => 그대로
      } else if (tag || arr[i] == ' ') {
        sb.append(arr[i]);

        // 단어 => 뒤집기
      } else {
        int index = i;

        // 단어 끝으로 이동
        while (index < arr.length && arr[index] != ' ' && arr[index] != '<') {
          index++;
        }

        for (int j = index - 1; j >= i; j--) {
          sb.append(arr[j]);
        }

        i = index - 1; // 출력한 단어 다음부터 반복문 실행
      }
    }

    System.out.println(sb);
    br.close();
  }
}

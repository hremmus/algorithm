import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // 문제에서 입력 데이터의 개수가 정해지지 않을 때 => 반복문의 종료를 알리는 EOF(End Of File) 처리 필요
    String input = "";
    while ((input = br.readLine()) != null) { // IDE에서는 줄바꿈 또한 입력 데이터로 인식, Ctrl + Z 추가 입력
      int[] count = new int[4];
      for (int j = 0; j < input.length(); j++) {
        char ch = input.charAt(j);

        if (ch >= 'a' && ch <= 'z') {
          count[0] += 1;
        } else if (ch >= 'A' && ch <= 'Z') {
          count[1] += 1;
        } else if (ch >= '0' && ch <= '9') {
          count[2] += 1;
        } else if (ch == ' ') {
          count[3] += 1;
        }
      }

      for (int c : count) {
        sb.append(c + " ");
      }
      sb.append('\n');
    }

    System.out.print(sb);
    br.close();
  }
}

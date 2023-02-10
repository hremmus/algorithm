import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // 8은 2의 3승으로, 2진수 세 자리 => 8진수 한 자리로 표현이 가능
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String N = br.readLine();
    int remainder = N.length() % 3; // 입력 받은 수를 세 자리씩 나누고 남은 나머지 (0 또는 1 또는 2)
    // 뒤에서부터 세 자리씩 끊고 앞에 남는 한 자리 또는 두 자리의 2진수가 있다면 먼저 처리하여 출력
    if (remainder == 1) sb.append(N.charAt(0)); // '1' (X) N = 0이면 0
    if (remainder == 2) sb.append((N.charAt(0) -'0') * 2 + (N.charAt(1) -'0'));
    // 반복문에서 i로 나머지를 이용해야 초기값이 3을 넘지 않아 index 에러 발생 X
    for (int i = remainder; i < N.length(); i += 3) {
      sb.append((N.charAt(i) - '0') * 4 + (N.charAt(i + 1) - '0') * 2 + (N.charAt(i + 2) - '0'));
    }
    
    System.out.println(sb);
    br.close();
  }
}

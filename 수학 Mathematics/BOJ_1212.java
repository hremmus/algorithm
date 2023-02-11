import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static String[] eight = {"000", "001", "010", "011", "100", "101", "110", "111"};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String N = br.readLine();
    if (N.equals("0")) {
      System.out.println(0);
      return;

    } else {
      sb.append(Integer.parseInt(eight[N.charAt(0) - '0'])); // String -> int 변환하여 맨 앞 0 제거
      for (int i = 1; i < N.length(); i++) {
        sb.append(eight[N.charAt(i) - '0']);
      }
    }

    System.out.println(sb);
    br.close();
  }
}

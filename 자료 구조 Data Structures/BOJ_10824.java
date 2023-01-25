import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" "); // 입력되는 네 자연수는 1 ≤ A, B, C, D ≤ 1,000,000
    System.out.println(Long.valueOf(input[0] + input[1]) + Long.valueOf(input[2] + input[3]));
  }
}

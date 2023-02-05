import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine()); // 0 <= N <= 12
    
    System.out.println(factorial(N));
    br.close();
  }
  
  static int factorial(int n) {
    if (n == 0) return 1; // 1! = 1 * (1-1)! = 1 * 0! = 1, 0! = 1
    
    int result = 1;
    for (int i = n; i >= 1; i--) {
      result *= i;
    }
    
    return result;
  }
}

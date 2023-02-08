import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int t; // 1 <= t <= 100

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken()); // 1 <= n <= 100
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = Integer.parseInt(st.nextToken()); // 1 <= arr[i] <= 1000000
      }
      
      // n개의 수를 둘씩 짝지어 만드는 모든 경우의 수는 n(n-1)/2이므로, 100*99/2 = 4950이다.
      // 총합의 최대 범위 약 49억
      long sum = 0;
      // 이중 반복문으로 모든 쌍의 합을 구함
      for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
          sum += gcd(arr[i], arr[j]);
        }
      }
      
      sb.append(sum).append("\n");
    }
    
    System.out.println(sb);
    br.close();
  }
  
  // gcd(a, b) = gcd(b, a % b)
  static int gcd(int a, int b) {
    if (b == 0) return a;
    
    return gcd(b, a % b);
  }
}

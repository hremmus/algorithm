import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, S;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 1 <= N <= 10의 5승
    S = Integer.parseInt(st.nextToken()); // 1 <= S와 Ai <= 10의 9승

    st = new StringTokenizer(br.readLine());
    int[] distance = new int[N];
    for (int i = 0; i < distance.length; i++) {
      distance[i] = Math.abs(S - Integer.parseInt(st.nextToken()));
    }
    
    // 두 수 이상의 최대공약수 구하기
    int gcd = distance[0];
    for (int i = 1; i < distance.length; i++) {
      gcd = gcd(gcd, distance[i]);
    }
    
    System.out.println(gcd);
    br.close();
  }
  
  static int gcd(int a, int b) {
    if (b == 0) return a;
    
    return gcd(b, a % b);
  }
}

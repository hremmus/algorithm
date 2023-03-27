import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int E, S, M;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    E = Integer.parseInt(st.nextToken()); // 1 <= E <= 15
    S = Integer.parseInt(st.nextToken()); // 1 <= S <= 28
    M = Integer.parseInt(st.nextToken()); // 1 <= M <= 19
    
    int earth = 0, sun = 0, moon = 0;
    int year = 0;
    
    while (true) {
      if (E == earth && S == sun && M == moon) break;
      
      earth++; sun++; moon++;
      year++;
      if (earth == 16) earth = 1;
      if (sun == 29) sun = 1;
      if (moon == 20) moon = 1;
    }
    
    System.out.println(year);
    br.close();
  }
}

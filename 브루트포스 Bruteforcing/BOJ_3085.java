import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static char[][] board;
  static int max = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 3 <= N <= 50

    board = new char[N][N];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        board[i][j] = line.charAt(j);
      }
    }
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N - 1; j++) {
        // 같은 행에서 인접한 두 사탕 교환
        char temp = board[i][j];
        board[i][j] = board[i][j + 1];
        board[i][j + 1] = temp;
        
        // 최대값을 구하고
        search();
        
        // 원위치
        temp = board[i][j];
        board[i][j] = board[i][j + 1];
        board[i][j + 1] = temp;
      }
    }
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N - 1; j++) {
        // 같은 열에서 인접한 두 사탕 교환
        char temp = board[j][i];
        board[j][i] = board[j + 1][i];
        board[j + 1][i] = temp;
        
        // 최대값을 구하고
        search();
        
        // 원위치
        temp = board[j][i];
        board[j][i] = board[j + 1][i];
        board[j + 1][i] = temp;
      }
    }
    
    System.out.println(max);
    br.close();
  }
  
  // 가장 긴 연속 부분 구하기
  private static void search() {
    // 행 체크
    for (int i = 0; i < N; i++) {
      int count = 1;
      for (int j = 0; j < N - 1; j++) {
        if (board[i][j] == board[i][j + 1]) count++;
        else count = 1;
        
        max = Math.max(max, count);
      }
    }
    
    // 열 체크
    for (int i = 0; i < N; i++) {
      int count = 1;
      for (int j = 0; j < N - 1; j++) {
        if (board[j][i] == board[j + 1][i]) count++;
        else count = 1;
        
        max = Math.max(max, count);
      }
    }
  }
}

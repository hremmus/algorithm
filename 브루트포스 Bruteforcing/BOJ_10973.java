import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // 예제 7 / 7 4 5 1 2 3 6
  static int N;
  static int[] input;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    input = new int[N];
    String[] line = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(line[i]);
    }

    if (hasPreviousPermutation()) {
      for (int element : input) {
        sb.append(element).append(" ");
      }
    } else {
      sb.append("-1");
    }

    System.out.println(sb);
    br.close();
  }

  private static boolean hasPreviousPermutation() {
    int i = input.length - 1;
    // permutation[i - 1] > permutation[i]을 만족하는 가장 큰 index i를 찾는다.
    while (i > 0 && input[i - 1] <= input[i]) {
      i--;
    }
    // i = 0이면 조건을 만족하는 i를 찾지 못한 것 = 입력 받은 순열이 첫번째 순열(=오름차순 수열)
    if (i == 0) return false;
    
    // i를 구하면, permutation[i]부터 오름차순인 수열이 만들어 진다. 이 수열에는 더이상 이동할 수가 존재하지 않으므로
    // permutation[i - 1]을 감소시켜야 하는데, 이 때 뒷자리에 위치한 수 중에서
    // permutation[i - 1]보다 작은 수 중 가장 큰 수를 찾아 서로 바꿔 준다.

    int j = input.length - 1;
    // j >= i면서 permutation[i - 1] > permutation[j]을 만족하는 가장 큰 index j를 찾는다.
    while (input[i - 1] <= input[j]) {
      j--;
    }

    // permutation[i - 1]과 permutation[j]를 서로 바꾼다.
    swap(i - 1, j);

    j = input.length - 1;
    // permutation[i]부터 순열을 뒤집는다. (오름차순 -> 내림차순)
    while (i < j) {
      swap(i, j);
      i++; j--;
    }

    return true;
  }

  private static void swap(int index1, int index2) {
    int temp = input[index2];
    input[index2] = input[index1];
    input[index1] = temp;
  }
}

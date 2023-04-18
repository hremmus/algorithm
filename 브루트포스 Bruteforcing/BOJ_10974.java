import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[] array;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine()); // 1 <= N <= 8
    array = new int[N];
    for (int i = 0; i < N; i++) {
      array[i] = i + 1;
      sb.append(array[i]).append(" ");
    }
    sb.append("\n");

    int count = factorial(N) - 1;
    while (count-- > 0) {
      nextPermutation();
    }

    System.out.println(sb);
    br.close();
  }

  private static void nextPermutation() {
    int i = array.length - 1;
    // permutation[i - 1] < permutation[i]을 만족하는 가장 큰 index i를 찾는다.
    while (i > 0 && array[i - 1] >= array[i]) {
      i--;
    }
    // i = 0이면 조건을 만족하는 i를 찾지 못한 것 = 입력 받은 순열이 마지막 순열(=내림차순 수열)
    if (i == 0) return;
    
    // i를 구하면, permutation[i]부터 내림차순인 수열이 만들어 진다. 이 수열에는 더이상 이동할 수가 존재하지 않으므로
    // permutation[i - 1]을 증가시켜야 하는데, 이 때 뒷자리에 위치한 수 중에서
    // permutation[i - 1]보다 큰 수 중 가장 작은 수를 찾아 서로 바꿔 준다.

    int j = array.length - 1;
    // j >= i면서 permutation[i - 1] < permutation[j]을 만족하는 가장 큰 index j를 찾는다.
    while (array[i - 1] >= array[j]) {
      j--;
    }

    // permutation[i - 1]과 permutation[j]를 서로 바꾼다.
    swap(i - 1, j);

    j = array.length - 1;
    // permutation[i]부터 순열을 뒤집는다. (내림차순 -> 오름차순)
    while (i < j) {
      swap(i, j);
      i++; j--;
    }

    for (int element : array) {
      sb.append(element).append(" ");
    }
    sb.append("\n");
  }

  private static void swap(int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
  
  private static int factorial(int number) {
    if (number <= 1) return number;
    return factorial(number - 1) * number;
  }
}

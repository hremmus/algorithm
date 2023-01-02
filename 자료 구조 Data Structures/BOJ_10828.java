import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class myStack<Integer> {
  class Node {
    public Node(int data) {
      this.data = data;
    }

    int data;
    Node next;
  }

  Node top;
  int size;

  public void push(int item) {
    Node newNode = new Node(item);
    // 기존 top에 연결
    newNode.next = top;
    top = newNode;
    size++;
  }

  public int pop() {
    if (size == 0) {
      return -1;
    } else {
      int item = top.data; // LIFO(Last In First Out)
      top = top.next; // 꺼낸 노드의 연결을 끊음(= 맨 위 항목 제거)
      size--;
      return item;
    }
  }

  public int top() { // Stack.peek()
    if (top == null) {
      return -1;
    } else {
      return top.data;
    }
  }

  public int empty() {
    return top == null ? 1 : 0;
  }

  public int size() {
    return size;
  }
}

public class Main {
  static int N;

  public static void main(String[] args) throws IOException {
    /* 스택의 구조를 재현한 myStack */
    myStack<Integer> stack = new myStack<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());

    StringTokenizer st;
    while (N-- > 0) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      switch (command) {
        case "push":
          stack.push(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          bw.write(String.valueOf(stack.pop()));
          bw.newLine();
          break;
        case "size":
          bw.write(String.valueOf(stack.size()));;
          bw.newLine();
          break;
        case "empty":
          bw.write(String.valueOf(stack.empty()));
          bw.newLine();
          break;
        case "top":
          bw.write(String.valueOf(stack.top()));
          bw.newLine();
          break;
      }
    }

    bw.flush();
    br.close();
    bw.close();
  }
}

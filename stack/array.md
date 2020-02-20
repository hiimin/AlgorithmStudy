---
description: stack을 배열로 구현
---

# array

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int stack[] = new int[10000];
	static int top = -1;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int N = Integer.parseInt(br.readLine());
		String command;
		int num;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			
			if(command.equals("push")) {
				num = Integer.parseInt(st.nextToken());
				push(num);
			}else if(command.equals("pop")) {
				pop();
			}else if(command.equals("size")) {
				size();
			}else if(command.equals("empty")) {
				empty();
			}else if(command.equals("top")) {
				top();
			}
		}
		bw.flush();
		bw.close();
		
	}
	
	public static void push(int n) {
		top++;
		stack[top] = n;
	}
	
	public static void top() throws IOException {
		if(top==-1) {
			bw.write("-1");
			bw.write("\n");
			bw.flush();
		}else {
			bw.write(String.valueOf(stack[top]));
			bw.write("\n");
			bw.flush();
		}
	}
	
	public static void size() throws IOException {
		bw.write(String.valueOf(top+1));
		bw.write("\n");
		bw.flush();
	}
	
	public static void pop() throws IOException {
		if(top==-1) {
			bw.write("-1");
			bw.write("\n");
			bw.flush();
		}else {
			bw.write(String.valueOf(stack[top]));
			bw.write("\n");
			bw.flush();
			top--;
		}
	}
	public static void empty() throws IOException {
		if(top==-1) {
			bw.write("1");
			bw.write("\n");
			bw.flush();
		}else {
			bw.write("0");
			bw.write("\n");
			bw.flush();
		}
	}
	
}
```


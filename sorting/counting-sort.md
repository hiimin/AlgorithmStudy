# counting sort

![](../.gitbook/assets/image%20%2823%29.png)

![](../.gitbook/assets/image%20%2832%29.png)

![](../.gitbook/assets/image%20%282%29.png)

![](../.gitbook/assets/image%20%286%29.png)

![](../.gitbook/assets/image%20%2833%29.png)

### CODE

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int array[] = new int[10001];
		
		for(int i = 0; i < N; i++) {
			array[Integer.parseInt(br.readLine())]++;
		}
				
		for(int i = 0; i < 10001; i ++) {
			for(int j = 0; j < array[i]; j++) {
				bw.write(String.valueOf(i));
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
```


# insertion sort

![](../.gitbook/assets/image%20%2814%29.png)

![](../.gitbook/assets/image%20%2821%29.png)

![](../.gitbook/assets/image%20%2819%29.png)

### CODE

```java
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int array[];
		int N = scan.nextInt();
		array = new int[N];
		
		for(int i = 0; i < N; i++) {
			array[i] = scan.nextInt();
		}
		
		for(int i = 1; i < N ; i++) {
			int k = i-1;
			int tmp = array[i];
			while(k>=0&&array[k]>tmp) {
				array[k+1] = array[k];
				k--;
			}
			array[k+1] = tmp;
		}
		
		for(int i = 0; i < N ; i++) {
			System.out.println(array[i]);
		}
	}
}

```


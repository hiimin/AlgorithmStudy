# bubble sort

![](../.gitbook/assets/image%20%2878%29.png)

>

![](../.gitbook/assets/image%20%28105%29.png)

### CODE

```java
public static void bubbleSort(int array[]) {
	for(int i = array.length - 1; i > 0; i--) {
		for(int j = 0; j < i; j++) {
			if(array[j] > array[j+1]) {
				int tmp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = tmp;
			}
		}
	}
}
```


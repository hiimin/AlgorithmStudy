# quick sort

![](../.gitbook/assets/image%20%2851%29.png)

![](../.gitbook/assets/image%20%2858%29.png)

![](../.gitbook/assets/image%20%2870%29.png)

![](../.gitbook/assets/image%20%2892%29.png)

![](../.gitbook/assets/image%20%2865%29.png)

![](../.gitbook/assets/image%20%2814%29.png)

![](../.gitbook/assets/image%20%2899%29.png)

## CODE

```java
public static void quickSort(int array[], int start, int end) {
		if (start >= end)
			return;

		//피봇을 기준으로 나눔
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (array[j] <= array[end]) {
				i++;

				int tmp = array[j];
				array[j] = array[i];
				array[i] = tmp;
			}
		}

		int tmp = array[end];
		array[end] = array[i + 1];
		array[i + 1] = tmp;

		//왼쪽
		quickSort(array, start, i);
		
		//오른쪽
		quickSort(array, i + 1, end);
	}
```

## Quick sort VS Merge sort

{% embed url="https://medium.com/pocs/locality%EC%9D%98-%EA%B4%80%EC%A0%90%EC%97%90%EC%84%9C-quick-sort%EA%B0%80-merge-sort%EB%B3%B4%EB%8B%A4-%EB%B9%A0%EB%A5%B8-%EC%9D%B4%EC%9C%A0-824798181693" %}

 결론적으로 퀵소트가 캐쉬 효율이 좋기 때문에 quick sort가 더 좋다고 할 수 있다. merge sort는 배열을 나누고 합치는 과정에서 매 순간 배열의 전체적인 부분에 골고루 접근하고, quick sort는 피봇을 기준으로 나눈 후 나눈 부분에서 다시 피봇을 기준으로 나누는 정렬 방법을 사용하기 때문에 전체적인 부분을 모두 접근 하는 것이 아니고, 나눠진 부분에 집중적으로 접근하기 때문에 캐시 히트율이 높아진다.


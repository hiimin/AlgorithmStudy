# merge sort

![](../.gitbook/assets/image%20%2853%29.png)

![](../.gitbook/assets/image%20%28111%29.png)

![](../.gitbook/assets/image%20%28101%29.png)

### CODE

```java
public static void mergeSort(int a[], int p, int r) {
		if(p<r) {
			int q = (p+r)/2;
			mergeSort(a, p, q);
			mergeSort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	public static void merge(int a[], int p, int q, int r) {
		int n = r-p+1;
		int tmpArray[] = new int[n];
		
		int i = p;
		int j = q+1;
		
		for(int k = 0; k < n; k++) {
			if(i > q) {
				tmpArray[k] = a[j];
				j++;
			}else if(j > r) {
				tmpArray[k] = a[i];
				i++;
			}else if(a[i]<a[j]) {
				tmpArray[k] = a[i];
				i++;
			}else {
				tmpArray[k] = a[j];
				j++;
			}
				
		}
		
		for(int k = 0; k < n; k++) {
			a[p] = tmpArray[k];
			p++;
		}
	}
```


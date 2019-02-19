# is prime

### CODE

```java
public static boolean isPrime(int num) {
		if(num==1) {
			return false;
		}

		int sqrtN = (int)Math.sqrt(num);
		boolean isPrime = true;
		for(int i = 2; i <= sqrtN; i++) {
			if(num%i==0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
```

### COMMENT

위의 알고리즘은 시간복잡도가 sqrt\(n\)이기때문에 웬만한건 다 풀림


# is prime

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


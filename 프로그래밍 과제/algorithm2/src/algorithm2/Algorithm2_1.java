package algorithm2;

import java.util.Scanner;

public class Algorithm2_1 {

	public static void main(String[] args) {
		int N;
		int K;
		int data[];
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		data = new int[N];
		for(int i = 0;i<N;i++) {
			data[i] = sc.nextInt();
		}
		K = sc.nextInt();
		sc.close();
		
		System.out.println(numberOfPairs(data, 0, N-1, K));
		
		return;
	}
	
	public static int numberOfPairs(int data[],int start, int end, int k) {
		if(start>=end)
			return 0;
		else {
			int sum = data[start]+data[end];
			if(sum==k) 
				return 1+numberOfPairs(data, start+1,end-1,k);
			else if(sum>k)
				return numberOfPairs(data, start, end-1, k);
			else
				return numberOfPairs(data, start+1,end, k);
		}
	}
}

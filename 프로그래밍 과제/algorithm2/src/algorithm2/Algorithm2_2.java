package algorithm2;

import java.util.Scanner;

public class Algorithm2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		int K;
		int data[];
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		data = new int[N];
		for(int i = 0;i<N;i++)
			data[i] = sc.nextInt();
		
		K = sc.nextInt();
		
		System.out.println(floor(data, K, 0, N-1));
		System.out.println(ceiling(data, K, 0, N-1));
		
		return;
	}
	
	//K보다 작거나 같으면서 가장 큰 정수
	public static int floor(int data[], int k, int start, int end) {
		int middle = (start+end)/2;
		
		if(data[start]>k)								//k가 가장 작은 수 일경우
			return -1;
		else if(data[end]<=k)							//k가 가장 큰 수 일경우 배열의 마지막 값이 floor
			return data[end];
		else if(data[middle]<=k&&data[middle+1]>=k)		//middle값이 k보다 작고 middle다음 값이 k보다 클 경우
			return data[middle];
		else if(data[middle]>k)							//middle값이 k보다 클 경우
			return floor(data, k, start, middle-1);
		else											//middle값이 k보다 작을 경우
			return floor(data, k, middle+1, end);
	}
	
	//K보다 크거나 같으면서 가장 작은 정수
	public static int ceiling(int data[], int k, int start, int end) {
		int middle = (start+end)/2;
		if(data[end]<k)
			return -1;
		else if(data[start]>=k)
			return data[start];
		else if(data[middle]>=k&&data[middle-1]<=k)
			return data[middle];
		else if(data[middle]>k)
			return ceiling(data, k, start, middle-1);
		else
			return ceiling(data, k, middle+1, end);
	}

}
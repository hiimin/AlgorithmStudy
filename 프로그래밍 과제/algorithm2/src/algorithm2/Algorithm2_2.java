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
	
	//K���� �۰ų� �����鼭 ���� ū ����
	public static int floor(int data[], int k, int start, int end) {
		int middle = (start+end)/2;
		
		if(data[start]>k)								//k�� ���� ���� �� �ϰ��
			return -1;
		else if(data[end]<=k)							//k�� ���� ū �� �ϰ�� �迭�� ������ ���� floor
			return data[end];
		else if(data[middle]<=k&&data[middle+1]>=k)		//middle���� k���� �۰� middle���� ���� k���� Ŭ ���
			return data[middle];
		else if(data[middle]>k)							//middle���� k���� Ŭ ���
			return floor(data, k, start, middle-1);
		else											//middle���� k���� ���� ���
			return floor(data, k, middle+1, end);
	}
	
	//K���� ũ�ų� �����鼭 ���� ���� ����
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
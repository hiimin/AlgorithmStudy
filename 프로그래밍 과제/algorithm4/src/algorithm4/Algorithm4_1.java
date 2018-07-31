package algorithm4;

import java.util.Random;

public class Algorithm4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {9,3,6,7,1,2,4,5,8};
		for(int i = 0;i<data.length;i++)
			System.out.print(data[i]);
		
		System.out.println("");
		//insertionSort(data);
		quickSortRand(data, 0, 8);
		for(int i = 0;i<data.length;i++)
			System.out.print(data[i]);
		
	}
	
	static void bubbleSort(int data[]) {
		int n = data.length;
		for(int i = n-1;i>0;i--) {
			for(int j = 0;j<i;j++)
			{
				if(data[j]>data[j+1])
				{
					int tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
				}
			}
		}
	}
	
	static void selectionSort(int data[]) {
		int n = data.length;
		for(int i = n-1;i>0;i--) {
			int maxIndex = 0;
			for(int j = 0;j<=i;j++) {
				if(data[j]>data[maxIndex])
					maxIndex = j;
			}
			int tmp = data[maxIndex];
			data[maxIndex] = data[i];
			data[i] = tmp;
		}
	}
	
	static void insertionSort(int data[]) {
		int n = data.length;
		for(int k = 1;k<n;k++) {
			int tmp = data[k];
			int i = k-1;
			while(i>=0&&data[i]>tmp) {
				data[i+1] = data[i];
				i--;
			}
			data[i+1] = tmp;
		}
	}
	
	static void mergeSort(int data[], int p, int r) {
		if(p<r) {
			int q = (p+r)/2;
			mergeSort(data,p,q);
			mergeSort(data,q+1,r);
			merge(data,p,q,r);
		}
	}
	static void merge(int data[], int p, int q, int r) {
		int n = data.length;
		int copyData[] = new int[n];
		int i = p;
		int j = q+1;
		int k = 0;
		
		while(i<=q&&j<=r) {
			if(data[i]<data[j])
				copyData[k++] = data[i++];
			else
				copyData[k++] = data[j++];
		}
		while(i<=q)
			copyData[k++] = data[i++];
		while(j<=r)
			copyData[k++] = data[j++];
		
		for(int tmp = p;tmp<=r;tmp++)
			data[tmp] = copyData[tmp-p];
	}
	
	static void quickSort(int data[],int p, int r) {
		if(p<r) {
			int q = partition(data, p, r);
			quickSort(data, p, q-1);
			quickSort(data, q+1, r);
		}
	}
	static int partition(int data[], int p, int r) {
		int x = data[r];
		int i = p-1;
		for(int j = p;j<r;j++) {
			if(data[j]<=x) {
				i++;
				int tmp = data[i];
				data[i] = data[j];
				data[j] = tmp;
			}
		}
		int tmp = data[i+1];
		data[i+1] = data[r];
		data[r] = tmp;
		
		return i+1;
	}
	
	static void quickSortMiddle(int data[], int p, int r) {
		if(p<r) {
			int q = partitionMiddle(data, p, r);
			quickSortMiddle(data, p, q-1);
			quickSortMiddle(data, q+1, r);
		}
	}
	static int partitionMiddle(int data[], int p, int r) {
		//중간값 구하기
		int middleIndex;
		int minIndex;
		int maxIndex;
		if(data[p]>data[(p+r)/2]) {
			minIndex = (p+r)/2;
			maxIndex = p;
		}else {
			minIndex = p;
			maxIndex = (p+r)/2;
		}
		if(data[maxIndex]<data[r])
			middleIndex = maxIndex;
		else {
			if(data[r]>data[minIndex])
				middleIndex = r;
			else
				middleIndex = minIndex;
		}
		
		int tmp = data[r];
		data[r] = data[middleIndex];
		data[middleIndex] = tmp;
		
		int x = data[r];
		int i = p-1;
		for(int j = p;j<r;j++) {
			if(data[j]<=x) {
				i++;
				int tmp2 = data[i];
				data[i] = data[j];
				data[j] = tmp2;
			}
		}
		int tmp3 = data[i+1];
		data[i+1] = data[r];
		data[r] = tmp3;
		
		return i+1;
	}
	
	static void quickSortRand(int data[],int p, int r) {
		if(p<r) {
			int q = partitionRand(data, p, r);
			quickSortRand(data, p, q-1);
			quickSortRand(data, q+1, r);
		}
	}
	static int partitionRand(int data[], int p, int r) {
		Random rand = new Random();
		int randIndex = rand.nextInt(r-p+1)+p;
		
		int tmp = data[randIndex];
		data[randIndex] = data[r];
		data[r] = tmp;
		
		int x = data[r];
		int i = p-1;
		for(int j = p;j<r;j++) {
			if(data[j]<=x) {
				i++;
				int tmp2 = data[i];
				data[i] = data[j];
				data[j] = tmp2;
			}
		}
		int tmp3 = data[i+1];
		data[i+1] = data[r];
		data[r] = tmp3;
		
		return i+1;
	}

}

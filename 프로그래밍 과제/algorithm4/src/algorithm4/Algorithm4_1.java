package algorithm4;

import java.util.Random;

public class Algorithm4_1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Reverse1000[] = new int[1000];
		int Reverse10000[] = new int[10000];
		int Reverse100000[] = new int[100000];
		int Random1000[] = new int[1000];
		int Random10000[] = new int[10000];
		int Random100000[] = new int[100000];
		
		int Reverse1000_copy[] = new int[1000];
		int Reverse10000_copy[] = new int[10000];
		int Reverse100000_copy[] = new int[100000];
		int Random1000_copy[] = new int[1000];
		int Random10000_copy[] = new int[10000];
		int Random100000_copy[] = new int[100000];
		
		for(int i = 0;i<1000;i++) {
			Reverse1000_copy[i] = Reverse1000[i] = 999-i;
		}
		for(int i = 0;i<10000;i++) {
			Reverse10000_copy[i] = Reverse10000[i] = 9999-i;
		}
		for(int i = 0;i<100000;i++) {
			Reverse100000_copy[i] = Reverse100000[i] = 99999-i;
		}
		
		Random rand = new Random();
		for(int i = 0;i<1000;i++) {
			Random1000_copy[i] = Random1000[i] = rand.nextInt(1000);
		}
		for(int i = 0;i<10000;i++) {
			Random10000_copy[i] = Random10000[i] = rand.nextInt(10000);
		}
		for(int i = 0;i<100000;i++) {
			Random100000_copy[i] = Random100000[i] = rand.nextInt(100000);
		}
		
		//1행 - Bubble sort 실행 시간
		long startTime = System.currentTimeMillis();
		bubbleSort(Random1000_copy);
		long endTime = System.currentTimeMillis();
		long time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		bubbleSort(Reverse1000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		bubbleSort(Random10000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		bubbleSort(Reverse10000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		bubbleSort(Random100000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		bubbleSort(Reverse100000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		System.out.println("");
		
		//배열 초기화
		System.arraycopy(Random1000, 0, Random1000_copy, 0, Random1000.length);
		System.arraycopy(Random10000, 0, Random10000_copy, 0, Random10000.length);
		System.arraycopy(Random100000, 0, Random100000_copy, 0, Random100000.length);
		System.arraycopy(Reverse1000, 0, Reverse1000_copy, 0, Reverse1000.length);
		System.arraycopy(Reverse10000, 0, Reverse10000_copy, 0, Reverse10000.length);
		System.arraycopy(Reverse100000, 0, Reverse100000_copy, 0, Reverse100000.length);
		
		
		//2행 - Selection sort 실행 시간
		startTime = System.currentTimeMillis();
		selectionSort(Random1000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		selectionSort(Reverse1000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		selectionSort(Random10000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		selectionSort(Reverse10000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		selectionSort(Random100000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		selectionSort(Reverse100000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		System.out.println("");
		
		//배열 초기화
		System.arraycopy(Random1000, 0, Random1000_copy, 0, Random1000.length);
		System.arraycopy(Random10000, 0, Random10000_copy, 0, Random10000.length);
		System.arraycopy(Random100000, 0, Random100000_copy, 0, Random100000.length);
		System.arraycopy(Reverse1000, 0, Reverse1000_copy, 0, Reverse1000.length);
		System.arraycopy(Reverse10000, 0, Reverse10000_copy, 0, Reverse10000.length);
		System.arraycopy(Reverse100000, 0, Reverse100000_copy, 0, Reverse100000.length);
		
		
		//3행
		startTime = System.currentTimeMillis();
		insertionSort(Random1000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		insertionSort(Reverse1000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		insertionSort(Random10000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		insertionSort(Reverse10000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		insertionSort(Random100000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		insertionSort(Reverse100000_copy);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		System.out.println("");
		
		//배열 초기화
		System.arraycopy(Random1000, 0, Random1000_copy, 0, Random1000.length);
		System.arraycopy(Random10000, 0, Random10000_copy, 0, Random10000.length);
		System.arraycopy(Random100000, 0, Random100000_copy, 0, Random100000.length);
		System.arraycopy(Reverse1000, 0, Reverse1000_copy, 0, Reverse1000.length);
		System.arraycopy(Reverse10000, 0, Reverse10000_copy, 0, Reverse10000.length);
		System.arraycopy(Reverse100000, 0, Reverse100000_copy, 0, Reverse100000.length);
		
		
		//4행
		startTime = System.currentTimeMillis();
		mergeSort(Random1000_copy,0,999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		mergeSort(Reverse1000_copy,0,999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		mergeSort(Random10000_copy,0,9999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		mergeSort(Reverse10000_copy,0,9999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		mergeSort(Random100000_copy,0,99999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		mergeSort(Reverse100000_copy,0,99999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		System.out.println("");
		
		//배열 초기화
		System.arraycopy(Random1000, 0, Random1000_copy, 0, Random1000.length);
		System.arraycopy(Random10000, 0, Random10000_copy, 0, Random10000.length);
		System.arraycopy(Random100000, 0, Random100000_copy, 0, Random100000.length);
		System.arraycopy(Reverse1000, 0, Reverse1000_copy, 0, Reverse1000.length);
		System.arraycopy(Reverse10000, 0, Reverse10000_copy, 0, Reverse10000.length);
		System.arraycopy(Reverse100000, 0, Reverse100000_copy, 0, Reverse100000.length);
		
		
		
		//5행
		startTime = System.currentTimeMillis();
		quickSort(Random1000_copy,0,999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSort(Reverse1000_copy,0,999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSort(Random10000_copy,0,9999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSort(Reverse10000_copy,0,9999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSort(Random100000_copy,0,99999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		//error....
		/*startTime = System.currentTimeMillis();
		quickSort(Reverse100000_copy,0,99999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+" ");*/
		System.out.println("");
		
		//배열 초기화
		System.arraycopy(Random1000, 0, Random1000_copy, 0, Random1000.length);
		System.arraycopy(Random10000, 0, Random10000_copy, 0, Random10000.length);
		System.arraycopy(Random100000, 0, Random100000_copy, 0, Random100000.length);
		System.arraycopy(Reverse1000, 0, Reverse1000_copy, 0, Reverse1000.length);
		System.arraycopy(Reverse10000, 0, Reverse10000_copy, 0, Reverse10000.length);
		System.arraycopy(Reverse100000, 0, Reverse100000_copy, 0, Reverse100000.length);
		
		
		//6행
		startTime = System.currentTimeMillis();
		quickSortMiddle(Random1000_copy,0,999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSortMiddle(Reverse1000_copy,0,999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSortMiddle(Random10000_copy,0,9999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSortMiddle(Reverse10000_copy,0,9999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSortMiddle(Random100000_copy,0,99999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSortMiddle(Reverse100000_copy,0,99999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		System.out.println("");
		
		//배열 초기화
		System.arraycopy(Random1000, 0, Random1000_copy, 0, Random1000.length);
		System.arraycopy(Random10000, 0, Random10000_copy, 0, Random10000.length);
		System.arraycopy(Random100000, 0, Random100000_copy, 0, Random100000.length);
		System.arraycopy(Reverse1000, 0, Reverse1000_copy, 0, Reverse1000.length);
		System.arraycopy(Reverse10000, 0, Reverse10000_copy, 0, Reverse10000.length);
		System.arraycopy(Reverse100000, 0, Reverse100000_copy, 0, Reverse100000.length);
		
		
		//7행
		startTime = System.currentTimeMillis();
		quickSortRand(Random1000_copy,0,999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSortRand(Reverse1000_copy,0,999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSortRand(Random10000_copy,0,9999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSortRand(Reverse10000_copy,0,9999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSortRand(Random100000_copy,0,99999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		
		startTime = System.currentTimeMillis();
		quickSortRand(Reverse100000_copy,0,99999);
		endTime = System.currentTimeMillis();
		time = endTime-startTime;
		System.out.print(time/1000.0+"	");
		System.out.println("");
		
		//배열 초기화
		System.arraycopy(Random1000, 0, Random1000_copy, 0, Random1000.length);
		System.arraycopy(Random10000, 0, Random10000_copy, 0, Random10000.length);
		System.arraycopy(Random100000, 0, Random100000_copy, 0, Random100000.length);
		System.arraycopy(Reverse1000, 0, Reverse1000_copy, 0, Reverse1000.length);
		System.arraycopy(Reverse10000, 0, Reverse10000_copy, 0, Reverse10000.length);
		System.arraycopy(Reverse100000, 0, Reverse100000_copy, 0, Reverse100000.length);
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

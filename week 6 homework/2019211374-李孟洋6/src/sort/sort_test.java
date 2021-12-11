package sort;

import java.util.Scanner;
import java.math.*;

public class sort_test {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("please input n");
		int n = in.nextInt();
		//����N�������
		int[] arr=new int[n];
		for(int index=0;index<n;index++) {
			arr[index]=(int)(Math.random()*n);
		}
		for(int index=0;index<n;index++) {
			System.out.print(arr[index]+" ");;
		}
		System.out.println();
		System.out.println("�������򷽷���"
				+ "1.ð������; "
				+ "2.��������; "
				+ "3.��������; "
				+ "4.�ϲ�����; "
				+ "5.������;");
		int k = in.nextInt();
		if(k==1) {
			arr = propSort(arr);
			for(int index=0;index<n;index++) {
				System.out.print(arr[index]+" ");;
			}
			
		}else if(k==2) {
			arr = insertSort(arr);
			for(int index=0;index<n;index++) {
				System.out.print(arr[index]+" ");;
			}
		}else if(k==3) {
			arr = quickSort(arr,0,n-1);
			for(int index=0;index<n;index++) {
				System.out.print(arr[index]+" ");;
			}
		}else if(k==4) {
			getMergesort(arr);
			for(int index=0;index<n;index++) {
				System.out.print(arr[index]+" ");;
			}
		}else if(k==5) {
            heapSort(arr);
			for(int index=0;index<n;index++) {
				System.out.print(arr[index]+" ");;
			}
		}
		in.close();
	}

    //ð������
	public static int[] propSort(int[] arr) {
		int temp;
		for(int length=arr.length;length>0;length--) {
			for(int index=0;index<length-1;index++) {
				if(arr[index]>arr[index+1]) {
					temp=arr[index];
					arr[index]=arr[index+1];
					arr[index+1]=temp;
				}
			}
		}
		return arr;
	}
    //��������
    public static int[] insertSort(int[] arr) {
	    int i, j, insert;
	    for (i = 1; i < arr.length; i++) {
	        insert = arr[i];
	        j = i - 1;
	        while (j >= 0 && insert < arr[j]) {
	            arr[j + 1] = arr[j];
	            j--;
	        }
	        arr[j + 1] = insert;
	    }
	    return arr;
    }
    //��������
    public static int[] quickSort(int[] arr, int low, int high) {
        int left, right, key;
	    if (low > high) {
	            return null;
	    }
	    left = low;
	    right = high;
	    //key���ǻ�׼λ
	    key = arr[low];	 
	    while (left < right) {
	    //�ȿ��ұߣ���������ݼ�
	        while (key <= arr[right] && left < right) {
	            right--;
	        }
	        arr[left] = arr[right]; //����ָ���ֵ������ָ��
	        //�ٿ���ߣ��������ҵ���
	        while (key >= arr[left] && left < right) {
	            left++;
	        }
	        arr[right] = arr[left]; //����ָ���ֵ������ָ��
	    }
	    //��󽫻�׼ֵ��������ָ���غϵ�λ��
	    arr[right] = key;
	    //�ݹ�����������
	    quickSort(arr, low, right - 1);
	    //�ݹ�����Ұ�����
	    quickSort(arr, right + 1, high);
	    return arr;
    }

    //ʹ�úϲ����򣬻�ȡ����A�ķǽ�������
    public static void getMergesort(int[] A){
        int lenA = A.length;      //����A�ĳ���
        if(lenA > 1){
            int[] B = copyArray(A,0);   //��ȡ����A��ǰһ��Ԫ��
            int[] C = copyArray(A,1);   //��ȡ����A�к�һ��Ԫ��
            getMergesort(B);            //�ݹ�����B��Ԫ��
            getMergesort(C);            //�ݹ�����C��Ԫ��
            Merge(B,C,A);               //�ϲ�����B��C������A�ķǽ�������
        }
    }
    
    //��������Aǰһ����ߺ�һ���Ԫ��,����a�����ж�ǰһ����ߺ�һ��Ԫ��
    public static int[] copyArray(int[] A,int a){
        int[] result;
        int len = A.length;
        if(a == 0){         //��aΪ0ʱ����������A��ǰһ��Ԫ��
            result = new int[len/2];
            for(int i = 0;i < len/2;i++)
                result[i] = A[i];
        }
        else{              //a��Ϊ0ʱ����������A�ĺ�һ��Ԫ��
            result = new int[len-len/2];
            for(int i = 0;i < (len-len/2);i++)
                result[i] = A[len/2+i];
        }
        return result;
    }
    
    //�ϲ�����B��C���������ɷǽ������д�������A��
    public static void Merge(int[] B,int[] C,int[] A){
        int i = 0,j = 0,k = 0;
        int lenB = B.length;  //����B�ĳ���
        int lenC = C.length;  //����C�ĳ���
        while(i<lenB && j<lenC){
            if(B[i] < C[j]){       
                A[k] = B[i];    
                i++;
            }
            else{
                A[k] = C[j];
                j++;
            }
            k++;
        }
        if(i == lenB){ //��i����lenBʱ��˵��B���������Ѿ�ȫ������A�У��ٰ�C������ʣ�µ�Ԫ��ֱ�Ӵ�������A�м���
            while(j<lenC){
                A[k] = C[j];
                j++;
                k++;
            }
        }
        if(j == lenC){ //��j����lenCʱ��˵��C���������Ѿ�ȫ������A�У��ٰ�B������ʣ�µ�Ԫ��ֱ�Ӵ�������A�м���
            while(i<lenB){
                A[k] = B[i];
                i++;
                k++;
            }
        }
    }
    //������	
    public static void heapSort(int[] arr) {
        int temp = 0;
        //���������й�����һ���ѣ���������������ѡ��󶥶ѻ�С����
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //���Ѷ�Ԫ����ĩβԪ�ؽ�����������Ԫ�س�������ĩ��
        for (int j = arr.length-1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //���µ����ṹ��ʹ������Ѷ��壬Ȼ����������Ѷ�Ԫ���뵱ǰĩβԪ�أ�����ִ�е���+�������裬ֱ��������������
            adjustHeap(arr,0,j);
        }
    }
    public static void adjustHeap(int[] arr,int i, int length) {
        int temp = arr[i]; //ȡ����ǰԪ�ص�ֵ��������ʱ����
        //k = 2 * i + 1��i�ڵ�����ӽڵ�
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if(k + 1 < length && arr[k] < arr[k + 1]) { //˵�����ӽڵ��ֵС�����ӽڵ��ֵ
                k++; //kָ�����ӽڵ�
            }
            if(arr[k] > temp) { //����ӽڵ���ڸ��ڵ�
                arr[i] = arr[k]; //�ѽϴ��ֵ������ǰ�ڵ�
                i = k; //iָ��k�����Ƚ�
            } else {
                break;
            }
        }
        //��forѭ�������������Ѿ�����iΪ���ڵ���������ֵ������������ֲ���
        arr[i] = temp; //��temp��ֵ�ŵ��������λ��
    }

    
}

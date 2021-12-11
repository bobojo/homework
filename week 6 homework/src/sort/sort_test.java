package sort;

import java.util.Scanner;
import java.math.*;

public class sort_test {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("please input n");
		int n = in.nextInt();
		//生成N个随机数
		int[] arr=new int[n];
		for(int index=0;index<n;index++) {
			arr[index]=(int)(Math.random()*n);
		}
		for(int index=0;index<n;index++) {
			System.out.print(arr[index]+" ");;
		}
		System.out.println();
		System.out.println("输入排序方法："
				+ "1.冒泡排序; "
				+ "2.插入排序; "
				+ "3.快速排序; "
				+ "4.合并排序; "
				+ "5.堆排序;");
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

    //冒泡排序
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
    //插入排序
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
    //快速排序
    public static int[] quickSort(int[] arr, int low, int high) {
        int left, right, key;
	    if (low > high) {
	            return null;
	    }
	    left = low;
	    right = high;
	    //key就是基准位
	    key = arr[low];	 
	    while (left < right) {
	    //先看右边，依次往左递减
	        while (key <= arr[right] && left < right) {
	            right--;
	        }
	        arr[left] = arr[right]; //将右指针的值赋给左指针
	        //再看左边，依次往右递增
	        while (key >= arr[left] && left < right) {
	            left++;
	        }
	        arr[right] = arr[left]; //将左指针的值赋给右指针
	    }
	    //最后将基准值赋给左右指针重合的位置
	    arr[right] = key;
	    //递归调用左半数组
	    quickSort(arr, low, right - 1);
	    //递归调用右半数组
	    quickSort(arr, right + 1, high);
	    return arr;
    }

    //使用合并排序，获取数组A的非降序排列
    public static void getMergesort(int[] A){
        int lenA = A.length;      //数组A的长度
        if(lenA > 1){
            int[] B = copyArray(A,0);   //获取数组A中前一半元素
            int[] C = copyArray(A,1);   //获取数组A中后一半元素
            getMergesort(B);            //递归排序B中元素
            getMergesort(C);            //递归排序C中元素
            Merge(B,C,A);               //合并数组B和C，返回A的非降序序列
        }
    }
    
    //返回数组A前一半或者后一半的元素,参数a用于判定前一半或者后一半元素
    public static int[] copyArray(int[] A,int a){
        int[] result;
        int len = A.length;
        if(a == 0){         //当a为0时代表返回数组A的前一半元素
            result = new int[len/2];
            for(int i = 0;i < len/2;i++)
                result[i] = A[i];
        }
        else{              //a不为0时代表返回数组A的后一半元素
            result = new int[len-len/2];
            for(int i = 0;i < (len-len/2);i++)
                result[i] = A[len/2+i];
        }
        return result;
    }
    
    //合并数组B和C，并将其变成非降序序列存入数组A中
    public static void Merge(int[] B,int[] C,int[] A){
        int i = 0,j = 0,k = 0;
        int lenB = B.length;  //数组B的长度
        int lenC = C.length;  //数组C的长度
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
        if(i == lenB){ //当i等于lenB时，说明B数组中数已经全部存入A中，再把C数组中剩下的元素直接存入数组A中即可
            while(j<lenC){
                A[k] = C[j];
                j++;
                k++;
            }
        }
        if(j == lenC){ //当j等于lenC时，说明C数组中数已经全部存入A中，再把B数组中剩下的元素直接存入数组A中即可
            while(i<lenB){
                A[k] = B[i];
                i++;
                k++;
            }
        }
    }
    //堆排序	
    public static void heapSort(int[] arr) {
        int temp = 0;
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //将堆顶元素与末尾元素交换。将最大的元素沉到数组末端
        for (int j = arr.length-1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
            adjustHeap(arr,0,j);
        }
    }
    public static void adjustHeap(int[] arr,int i, int length) {
        int temp = arr[i]; //取出当前元素的值保存在临时变量
        //k = 2 * i + 1是i节点的左子节点
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if(k + 1 < length && arr[k] < arr[k + 1]) { //说明左子节点的值小于右子节点的值
                k++; //k指向右子节点
            }
            if(arr[k] > temp) { //如果子节点大于父节点
                arr[i] = arr[k]; //把较大的值赋给当前节点
                i = k; //i指向k继续比较
            } else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶（局部）
        arr[i] = temp; //将temp的值放到调整后的位置
    }

    
}

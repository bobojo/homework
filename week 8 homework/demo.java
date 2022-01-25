package homework;

import java.util.Random;
import java.util.*;


public class demo {
	static Random random=new Random();
	public static void test(){ 
		System.out.println(task1("abbc","dog cat cat fish")); 
		System.out.println(task2(new int[]{1,2,2,3,0})); 
		for(int i=0;i<5;i++){
			int target = random.nextInt(15) - 3; 
			System.out.println("target:"+target+"\tresult"+task3(new int[] {0,4,5,6,8},target)); 
		} 
	}
	public static void main(String[] args) {
		test();
	}
	
	public static boolean task1(String pattern, String s) { 
		//��һ����� 

        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        String[] strs = s.split(" "); // ����ַ���
        if (strs.length != pattern.length()) // �������еĳ��Ȳ����
            return false;
        for (int i = 0; i < pattern.length(); i++){ // ö�� ÿһ��
            String str = strs[i];
            char ch = pattern.charAt(i);
            if (str2ch.containsKey(str) && str2ch.get(str) != ch) 
                return false;
            if (ch2str.containsKey(ch) && !ch2str.get(ch).equals(str))
                return false;
            str2ch.put(str, ch);
            ch2str.put(ch, str);
        }
        return true;

	}
	
	public static int task2(int[] nums) { 
		//�ڶ������ 
        int[] arr = new int[nums.length];//������һ��������
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            arr[nums[i]]++;//���������Ը�Ԫ��Ϊ�±��Ԫ������
            if (arr[nums[i]] > 1) {
                return nums[i];
            }
        }
        return nums[i];
		
	}
	
	public static int task3(int []nums,int target){ 
		//��������� 
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }



}

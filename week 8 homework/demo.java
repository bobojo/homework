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
		//第一题代码 

        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        String[] strs = s.split(" "); // 拆分字符串
        if (strs.length != pattern.length()) // 两个序列的长度不相等
            return false;
        for (int i = 0; i < pattern.length(); i++){ // 枚举 每一对
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
		//第二题代码 
        int[] arr = new int[nums.length];//定义了一个新数组
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            arr[nums[i]]++;//新数组中以该元素为下标的元素自增
            if (arr[nums[i]] > 1) {
                return nums[i];
            }
        }
        return nums[i];
		
	}
	
	public static int task3(int []nums,int target){ 
		//第三题代码 
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

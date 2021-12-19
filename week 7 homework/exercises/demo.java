package exercises;

import java.util.*;

public class demo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("-------第一题--------");
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		
		int[] res = nextGreaterElement(nums1,nums2);
		for(int i=0;i<nums1.length;i++) {
			System.out.print(res[i]+" ");
		}
		System.out.println();
		System.out.println("-------第二题--------");
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,5,3,2,1};
		System.out.println(validateStackSequences(pushed,popped));
		System.out.println("-------第三题--------");
		int[] nums = {1,1,2,3,4,4};
		System.out.println(sumOfUnique(nums));
	}
	
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap();
        Stack<Integer> stack = new Stack();
        int[] res = new int[nums1.length]; 
        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()<nums2[i]){
                stack.pop();
            }
            if(!stack.isEmpty()&&stack.peek()!=null){
                map.put(nums2[i],stack.peek());
            }else{
                map.put(nums2[i],-1);
            }
            stack.push(nums2[i]);
        }
        for(int j=0;j<nums1.length;j++){
            res[j] = map.get(nums1[j]);
        }
        return res;
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) return true;
        if (pushed.length == 0 && popped.length != 0 || pushed.length != 0 && popped.length == 0 || pushed.length != popped.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int len = pushed.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && index < len && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return index == len;
    }
    
    public static int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        for(int j:map.keySet()){
            if(map.get(j) == 1){
                sum += j;
            }
        }
        return sum;
    }



}

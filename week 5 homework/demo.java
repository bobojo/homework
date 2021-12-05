package homework;

import java.util.Scanner;
import java.util.*;

class Solution{
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
	    //�߹�������·�������Ӽ���һ���֣����Զ�Ҫ���뵽������
	    list.add(new ArrayList<>(tempList));
	    for (int i = start; i < nums.length; i++) {
	        //����ѡ��
	        tempList.add(nums[i]);
	        //�ݹ�
	        backtrack(list, tempList, nums, i + 1);
	        //����ѡ��
	        tempList.remove(tempList.size() - 1);
	    }
	}

}

public class demo {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	System.out.println("-----------��һ��----------");
    	int x = in.nextInt();
    	System.out.println(reverse(x));
    	System.out.println("-----------�ڶ���----------");
    	int n = in.nextInt();
    	System.out.println(climbStairs(n));
    	System.out.println("-----------������----------");
    	System.out.println("������Ҫ��������������������10");
    	int m = in.nextInt();
    	int[] nums = new int[m];
    	System.out.println("����������");
    	for(int i=0;i<n;i++) {
    		nums[i]=in.nextInt();
    	}
        Solution s=new Solution();
        List<List<Integer>> l = new ArrayList<>();
        l = s.subsets(nums);
		for(int i=0;i<l.size();i++) {
			System.out.println(l.get(i));
		}
    	
    }
    public static int reverse(int x) {
        int r = 0;
        while (x != 0) {
            if (r < Integer.MIN_VALUE / 10 || r > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            r = r * 10 + digit;
        }
        return r;
    }
    
    public static int climbStairs(int n) {
        if(n==1) {
        	return 1;
        }
        if(n==2) {
        	return 2;
        }
        int[] f = new int[n+1];
        f[1]=1;
        f[2]=2;
        for(int i=3;i<=n;i++) {
        	f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}

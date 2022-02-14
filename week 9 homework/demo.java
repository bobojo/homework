package homework;
import java.util.*;
public class demo {
	public static void main(String[] args) {
		System.out.println("-----------��һ��----------");
		int[] nums = {1,4,7,8,9,5};
		int original = 4;
		System.out.println(findFinalValue(nums,original));
		
		System.out.println("-----------�ڶ���----------");
		int[] nums2 = {0,0,1,0};
		System.out.println(Arrays.toString(maxScoreIndices(nums2).toArray()));
		
		System.out.println("-----------������----------");
		System.out.println(subStrHash("leetcode",7,20,2,0));
		
		System.out.println("-----------������----------");
		String[] words = {"a","b","ab","cde"};
		Solution so = new Solution();
		int[] array = so.groupStrings(words);
		System.out.println(Arrays.toString(array));
		
	}
	

    
    public static int findFinalValue(int[] nums, int original) {
        
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == original){
                original = original*2;
            }
        }
        
        return original;
    }

    public static List<Integer> maxScoreIndices(int[] nums) {
    	
        int N = 100000;
        int[] sum = new int[N];
        int[] count = new int[N];
        
        List<Integer> list = new ArrayList<>();
        int max = 0;
        
        for(int i = 1; i <= nums.length; i ++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        
        for(int i = 1; i <= nums.length; i ++){
            if(nums[i - 1] == 0){
                count[i] = count[i - 1] + 1;
            }else{
                count[i] = count[i - 1];
            }
        }
        
        for(int i = 0; i <= nums.length; i ++){
            int num = count[i] + sum[nums.length] - sum[i];
            if(num > max){
                list = new ArrayList<>();
                list.add(i);
                max = num;
            }else if(num == max){
                list.add(i);
            }
        }
        
        return list;
    }
    
    public static String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int i = s.length() - k;
        long p = 1, h = 0;

        int ans = -1;
        for(int j = s.length() - 1; j >= i; j --){
            h = (h * power + s.charAt(j) - 'a' + 1) % modulo;
            p = p * power % modulo;
        }
        if(h == hashValue) ans = i;

        for(int j = i - 1; j >= 0; j --){
            h = (h * power + s.charAt(j) - 'a' + 1 - (s.charAt(j + k) - 'a' + 1) * p % modulo + modulo) % modulo;
            if(h == hashValue) ans = j;
        }
        return s.substring(ans,ans + k);
    }
    
}

class Solution{
    // ���鼯ģ�壨��ϣ��д����
    HashMap<Integer, Integer> fa = new HashMap<>(), size = new HashMap<>();
    int groups, maxSize;

    int find(int x) {
        if (fa.get(x) != x) {
            fa.put(x, find(fa.get(x)));
        }
        return fa.get(x);
    }

    void merge(int x, int y) {
        if (!fa.containsKey(y)) return;
        x = find(x);
        y = find(y);
        if (x == y) return;
        fa.put(x, y);
        size.put(y, size.get(y) + size.get(x));
        maxSize = Math.max(maxSize, size.get(y)); // ά����
        --groups;
    }

    public  int[] groupStrings(String[] words) {
        groups = words.length;
        for (var word : words) {
            var x = 0;
            for (var i = 0; i < word.length(); i++) {
                x |= 1 << (word.charAt(i) - 'a'); // ���� word �Ķ����Ʊ�ʾ
            }
            fa.put(x, x); // ��������鼯
            size.put(x, size.getOrDefault(x, 0) + 1);
            maxSize = Math.max(maxSize, size.get(x)); // ά����
            if (size.get(x) > 1) --groups;
        }

        fa.forEach((x, fx) -> {
            for (var i = 0; i < 26; i++) {
                merge(x, x ^ (1 << i)); // ��ӻ�ɾ���ַ� i
                if (((x >> i) & 1) == 1) {
                    for (var j = 0; j < 26; ++j) {
                        if (((x >> j) & 1) == 0) {
                            merge(x, x ^ (1 << i) | (1 << j)); // �滻�ַ� i Ϊ j
                        }
                    }
                }
            }
        });
        return new int[]{groups, maxSize};
    }

}

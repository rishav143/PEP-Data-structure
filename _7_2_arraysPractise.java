class palindrome {
    int count;
    boolean isPld;
    palindrome(int count, boolean isPld) {
        this.count = count;
        this.isPld = isPld;
    }
}

public class _7_2_arraysPractise {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while(j < nums.length) {
            if(nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                swap(nums, i, j);
                j++;
            }
        }
        return i+1;
    }

    public static palindrome checkPalindrome(int num) {
        int newNum = 0, originalNum = num;
        while(num > 0) {
            int last = num%10;
            newNum = newNum*10 + last;
            num = num/10;
        }
        return new palindrome(originalNum, originalNum == newNum);
    }

    public static void findLongestPalindrome(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            palindrome p = checkPalindrome(nums[i]);
            if(p.isPld) {
                max = Math.max(max, p.count);
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        //Question 1 - remove duplicates of array
        int arr[] = {10,20,20,30,30,50,50};
        int k = removeDuplicates(arr);
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }

        //Question 2 - finding longest palindrome in array
        int nums[] = {121, 234, 44544, 393, 50};
        findLongestPalindrome(nums);
    }
}

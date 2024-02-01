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

    public static void main(String[] args) {
        //Question 1 - remove duplicates of array
        int arr[] = {10,20,20,30,30,50,50};
        int k = removeDuplicates(arr);
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

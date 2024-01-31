public class _7_1_recursionPractise
{
    //Question 1 
    public static int findPower(int n, int exp) {
        if(exp <= 0) {
            return 1;
        }
        return n*findPower(n, exp-1);
    }
    
    //Question 2
    public static boolean isPrime(int n, int i) {
        if(n%i == 0) {
            return false;
        }
        if(i*i > n) {
            return true;
        }
        return isPrime(n, i+1);
    }
    
    //Quesiton 3
    public static int findLargest(int[] arr, int idx, int max) {
        //base case :
        if(idx == arr.length - 1) {
            return Math.max(max, arr[idx]);
        }
        max = Math.max(max, arr[idx]);
        return findLargest(arr, idx+1, max);
    }
    
	public static void main(String[] args) {
	    
	    //Question 1 - find the power of a number
		int n = 3;
		int exp = 4;
		System.out.println(findPower(n, exp));
		
		//Quesiton 2 - find the prime factor of a number
		System.out.println(isPrime(343, 2));
		
		//Question 3 - find largest element in a array
		int arr[] = {0,9,3,2,6,7,9};
		int element = findLargest(arr, 1, arr[0]);
		System.out.println(element);
	}
}
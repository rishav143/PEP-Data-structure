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
        if(n <= 2) {
            return false;
        }
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

    //Question 4
    public static int findSmallest(int[] arr, int idx, int min) {
        //base case
        if(idx == arr.length - 1) {
            return Math.min(min, arr[idx]);
        }
        min = Math.min(min, arr[idx]);
        return findSmallest(arr, idx+1, min);
    }

    //Quesiton 5 
    public static int reverseNumber(int n, int newNum) {
        if(n%10 <= 0) {
            return newNum;
        }
        int last = n%10;
        newNum = newNum * 10 + last;
        n = n/10;
        return reverseNumber(n, newNum);
    }

    public static int findHCF(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        if(a == b) return a;
        
        if(a > b) {
            return findHCF(a-b, b);
        } else {
            return findHCF(a, b-a);
        }
    }
    
    public static int findLCM(int a, int b) {
        //hcf * lcm = product of two numebr
        int hcf = findHCF(a, b);
        return (a*b)/hcf;
    }
    
	public static void main(String[] args) {
	    
	    //Question 1 - find the power of a number
		int n = 3;
		int exp = 4;
		System.out.println(findPower(n, exp));
		
		//Quesiton 2 - find the prime factor of a number
		System.out.println(isPrime(343, 2));
		
		//Question 3 - find largest element in a array
		int arr[] = {9,9,3,22,6,7,14}; 
		int maxElement = findLargest(arr, 1, arr[0]); // it work for the case for more than the one element
		System.out.println(maxElement);

        //Quesiton 4 - find smallest element in a array
        int minElement = findSmallest(arr, 1, arr[0]);
        System.out.println(minElement);

        //Question 5 - reversing a number 
        System.out.println(reverseNumber(332245, 0));

        //Question 6 - HCF of two Number
	    System.out.println(findHCF(20, 30));
	    
	    //Question 7 - lcm of two Number
	    System.out.print(findLCM(20, 30));
	}
}
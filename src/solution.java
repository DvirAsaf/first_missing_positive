public class solution {
    public int firstMissingPositive(int[] A) {
        // if the array is empty or null -> return 1 because 1 is the first missing positive integer.
        if(A == null || A.length == 0) {
            return 1;
        }
        //the length of the array is n
        int n = A.length;
        //we use this int for know if the array contain the value 1.
        int containsOne = 0;
        //step 1 - check if the array contains one.
        //change the values of negative and greater than n (length of A).
        for( int i = 0; i < n; i++) {
            if(A[i] == 1) {
                containsOne = 1;
            }
            else if(A[i] > n || A[i] <= 0) {
                A[i] = 1;
            }
        }
        //if the A doesn't contains the value 1 -> return 1.
        if(containsOne == 0) {
            return 1;
        }
        //step 2 - change values of the new array to negative value according to the index of the value.
        //for example : array length is 7 so i care about the values 1 to 8.
        //if the value in the array is 5 so i subtraction it by 1 and go to the index 4 (start  in 0) and change
        //the value of this index to be negative
        //if the index is already negative (previous) change, so we leave it to be negative.
        for(int i = 0; i < n; i++) {
            //the minus 1 is for the correct index in the array.
            int index = Math.abs(A[i]) - 1;
            if (A[index] > 0) {
                A[index] = A[index] * -1;
            }
        }
        //step 3 - find the first index that positive - this is the first missing positive integer.
        for(int i = 0; i < n; i++) {
            if(A[i] > 0) {
                return i+1;
            }
        }
        //edge case - if the given array is like [1,2,3,4] -> the return value is 5.
      return n+1;
    }
}

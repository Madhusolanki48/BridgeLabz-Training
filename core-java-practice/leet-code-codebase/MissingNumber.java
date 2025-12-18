//Find the Missing Number in an Array
class Main {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        //expected sum from 0-n
        int total = n * (n + 1) / 2;
        //sum of array elements
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //return missing number
        return total - sum;
    }
}
    

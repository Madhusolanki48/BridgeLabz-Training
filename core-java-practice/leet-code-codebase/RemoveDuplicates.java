// Remove Duplicates from Sorted Array
class Main {
    public int removeDuplicates(int[] nums) {
        int a = 1;
        for (int i = 1; i < nums.length; i++) {
            // if current element is different
            if (nums[i] != nums[i - 1]) {
            // place it at next unique position
                nums[a] = nums[i];
                a++;
            }
        }
        //count of unique elements
        return a;
    }
}
//Move All Zeros to the End of an Array
class Main {
     public void moveZeroes(int[] num) {
        int i = 0;
        // move non-zero elements to front
        for (int n : num)
        if (n != 0)
        num[i++] = n;
        // fill remaining positions with zeros
        while (i < num.length)
            num[i++] = 0;
    }
}
    


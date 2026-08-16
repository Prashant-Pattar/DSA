class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int pos=nums.length-1;
        int[] sorted= new int[nums.length];
        while(left<=right){
            int leftSquare=nums[left]*nums[left];
            int rightSquare=nums[right]*nums[right];

            if(leftSquare>rightSquare){
                sorted[pos]=leftSquare;
                left++;
            }else{
                sorted[pos]=rightSquare;
                right--;
            }
            pos--;
        }
        return sorted;
    }
}
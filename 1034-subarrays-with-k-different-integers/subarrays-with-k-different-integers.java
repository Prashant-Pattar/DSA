class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums, k-1);
    }

    private int atMost(int[] nums, int k){
        if(k==0){
            return 0;
        }

        int[] freq = new int[nums.length+1];
        int left=0;
        int distinctCount=0;
        int totalSubarrays=0;

        for(int right=0; right<nums.length;right++){
            if(freq[nums[right]]==0){
                distinctCount++;
            }
            freq[nums[right]]++;

            while(distinctCount>k){
                freq[nums[left]]--;
                if(freq[nums[left]]==0){
                    distinctCount--;
                }
                left++;
            }
            totalSubarrays+=(right-left+1);
        }
        return totalSubarrays;
    }
}
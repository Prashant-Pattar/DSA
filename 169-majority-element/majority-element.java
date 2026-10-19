class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> counts= new HashMap<>();
        for(int num:nums){
            int frequency=counts.getOrDefault(num,0)+1;

            if(frequency>n/2){
                return num; 
            }

            counts.put(num, frequency);
        }
        return -1;
    }
}
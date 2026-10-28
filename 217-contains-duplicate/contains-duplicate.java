class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num:nums){
            int count=countMap.getOrDefault(num, 0)+1;
            countMap.put(num, count);

            if(count>1){
                return true;
            }
        }
        return false;
    }
}
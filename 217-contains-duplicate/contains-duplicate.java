class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> seen = new HashSet<>();
        for(int num:nums){
            if(!seen.add(num)){
                return true;
            }
        }
        return false;

        // Map<Integer, Integer> countMap = new HashMap<>();
        // for(int num:nums){
        //     int count=countMap.getOrDefault(num, 0)+1;
        //     countMap.put(num, count);

        //     if(count>1){
        //         return true;
        //     }
        // }
        // return false;
    }
}
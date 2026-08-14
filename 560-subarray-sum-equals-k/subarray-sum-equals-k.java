class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int currentSum=0;

        HashMap<Integer, Integer> map= new HashMap<>();
        map.put(0,1);

        for(int i=0; i<nums.length; i++){
            currentSum+=nums[i];

            int pastMarker=currentSum-k;

            if(map.containsKey(pastMarker)){
                count=count+map.get(pastMarker);
            }

            map.put(currentSum, map.getOrDefault(currentSum, 0)+1);

        }
        return count;
    }
}
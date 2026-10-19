class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> countMap= new HashMap<>();
        List<Integer> result= new ArrayList<>();

        for(int num:nums){
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry:countMap.entrySet()){
            if(entry.getValue()> n/3){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
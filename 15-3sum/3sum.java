class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int anchor=0; anchor<nums.length-2;anchor++){


            if(anchor>0 && nums[anchor]==nums[anchor-1]) {
                continue;
            }   

            int left=anchor+1;
            int right=nums.length-1;

            while(left<right){
                int sum=nums[anchor]+nums[left]+nums[right];
                if(sum==0){
                    res.add(Arrays.asList(nums[anchor],nums[left],nums[right]));

                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }
}
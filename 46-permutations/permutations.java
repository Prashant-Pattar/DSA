class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] visited){
        if(tempList.size()==nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;

            visited[i]=true;
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, visited);
            tempList.remove(tempList.size()-1);
            visited[i]=false;
        }
    }
}
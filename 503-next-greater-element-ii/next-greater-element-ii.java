class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n=nums.length;
        int[] res=new int[n];

        Arrays.fill(res, -1);
        for(int i=0; i<n*2;i++){
            int currentIndex=i%n;
            int currentValue=nums[currentIndex];
            while(!stack.isEmpty() && currentValue>nums[stack.peek()]){
                int pastIndex=stack.pop();
                res[pastIndex]=currentValue;
            }
            if(i<n){
                stack.push(currentIndex);
            }
        }
        return res;
    }
}
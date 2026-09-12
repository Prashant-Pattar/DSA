class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> nextGreater= new HashMap<>();

        for(int num: nums2){
            while(!stack.isEmpty() && num>stack.peek()){
                int small=stack.pop();
                nextGreater.put(small, num);
            }
            stack.push(num);
        }

        int[] res= new int[nums1.length];
        for(int i=0; i<nums1.length;i++){
            res[i]=nextGreater.getOrDefault(nums1[i], -1);
        }
        return res;
    }
} 
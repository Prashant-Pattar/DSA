class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack= new ArrayDeque<>();
        int n=temperatures.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int pastIndex=stack.pop();
                res[pastIndex]=i-pastIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
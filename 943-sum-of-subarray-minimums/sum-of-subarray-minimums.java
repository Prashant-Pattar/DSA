class Solution {
    public int sumSubarrayMins(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n=arr.length;
        int MOD=1_000_000_007;

        int[] left=new int[n];
        int[] right=new int[n];

        for(int i=0; i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            left[i]=stack.isEmpty()?(i+1):(i-stack.peek());
            stack.push(i);
        }
        stack.clear();

        for(int i=n-1; i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            right[i]=stack.isEmpty()?(n-i):(stack.peek()-i);
            stack.push(i);
        }

        long totalSum=0;
        for(int i=0;i<n;i++){
            long helper=(long)arr[i]*left[i]*right[i];
            totalSum=(totalSum+helper)%MOD;
        }

        return (int)totalSum;
    }
}
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pair:prerequisites){
            int course=pair[0];
            int prerequisite=pair[1];
            adj.get(prerequisite).add(course);
        }

        int[] state = new int[numCourses];
        List<Integer> order = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(state[i]==0){
                if(!dfs(i,adj,state,order)){
                    return new int[0];
                }
            }
        }
        Collections.reverse(order);

        int[] result=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]=order.get(i);
        }
        return result;
    }
    private boolean dfs(int curr, List<List<Integer>> adj,int[] state, List<Integer> order){
        if(state[curr]==1){
            return false;
        }
        if(state[curr]==2){
            return true;
        }
        state[curr]=1;

        for(int neighbor: adj.get(curr)){
            if(!dfs(neighbor, adj, state, order)){
                return false;
            }
        }

        state[curr]=2;
        order.add(curr);

        return true;
    }
}
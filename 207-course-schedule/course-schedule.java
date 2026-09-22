class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for(int[] pair:prerequisites){
            int course = pair[0];
            int prerequisite=pair[1];

            adj.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        int completedCourses=0;

        while(!queue.isEmpty()){
            int curr=queue.poll();
            completedCourses++;

            for(int neighbor : adj.get(curr)){
                inDegree[neighbor]--;

                if(inDegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }

        return completedCourses == numCourses;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map=new HashMap<>();
        for(String word:words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        PriorityQueue<String> minHeap= new PriorityQueue<>((a,b)->{
            int freqA=map.get(a);
            int freqB=map.get(b);

            if(freqA==freqB){
                return b.compareTo(a);
            }else{
                return freqA-freqB;
            }
        });

        for(String key:map.keySet()){
            minHeap.offer(key);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        String[] res=new String[k];
        for(int i=k-1;i>=0;i--){
            res[i]=minHeap.poll();
        }

        return Arrays.asList(res);
    }
}
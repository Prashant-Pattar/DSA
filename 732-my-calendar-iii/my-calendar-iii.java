class MyCalendarThree {

    TreeMap<Integer, Integer> timeline;

    public MyCalendarThree() {
        timeline = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        timeline.put(startTime, timeline.getOrDefault(startTime, 0)+1);
        timeline.put(endTime, timeline.getOrDefault(endTime, 0)-1);

        int active=0;
        int max=0;
        for(int change: timeline.values()){
            active+=change;
            max=Math.max(max, active);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
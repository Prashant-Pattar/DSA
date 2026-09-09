class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right=0;
        for(int weight:weights){
            left=Math.max(weight,left);
            right=right+weight;
        }

        while(left<=right){
            int mid=left+(right-left)/2;
            if(canShip(weights,days,mid)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public static boolean canShip(int[] weights, int days, int capacity){
        int daysNeeded=1;
        int currentCapacity=0;
        for(int weight:weights){
            if(currentCapacity+weight>capacity){
                daysNeeded++;
                currentCapacity=weight;
            }else{
                currentCapacity+=weight;
            }
        }
        return daysNeeded<=days;
    }
}
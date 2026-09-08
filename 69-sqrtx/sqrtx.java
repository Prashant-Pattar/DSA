class Solution {
    public int mySqrt(int x) {
        int left=0;
        int right=x;
        int res=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if((long)mid*mid==x){
                return mid;
            }else if((long)mid*mid>x){
                right=mid-1;
            }else{
                res=mid;
                left=mid+1;
            }
        }
        return res;
    }
}
class Solution {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }

        int original=x;
        int temp=0;

        while(x>0){
            int lastDigit=x%10;
            temp=(temp*10)+lastDigit;
            x/=10;
        }
        return (temp==original);
    }
}
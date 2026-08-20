class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int left=0;
        int maxFreq=0;
        int maxLength=0;

        for(int right=0;right<s.length();right++){
            char rChar=s.charAt(right);
            freq[rChar-'A']++;

            maxFreq=Math.max(maxFreq,freq[rChar-'A']);

        while((right-left+1)-maxFreq>k){
            char lChar=s.charAt(left);
            freq[lChar - 'A']--;
            left++;
        }
        maxLength=Math.max(maxFreq, right-left+1 );
        }
        
        return maxLength;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int[] freq=new int[128];
        int i=0, j=0, size=0, n=s.length();
        while(j<n){
            char ch=s.charAt(j);
            while(freq[ch]>0){
                char c=s.charAt(i);
                freq[c]-=1;
                i+=1;
            }
            freq[ch]+=1;
            size=Math.max(size, j-i+1);
            j+=1;
        }
        return size;
    }
}
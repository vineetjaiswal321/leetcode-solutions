class Solution {
    public int maxOperations(String s) {
        int nO=0, cnt=0;
        int n=s.length();
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)=='1')    nO++;
            if(s.charAt(i)=='1' && s.charAt(i+1)=='0')  cnt+=nO;
        }
        return cnt;
    }
}
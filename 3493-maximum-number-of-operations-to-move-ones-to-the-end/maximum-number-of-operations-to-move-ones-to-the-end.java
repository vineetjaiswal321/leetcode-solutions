class Solution {
    public int maxOperations(String s) {
        int nO=0, cnt=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1')
            {
                nO++;//1
                if(i+1<n && s.charAt(i+1)=='0'){
                    while(i<n && s.charAt(i)==0){
                        i++;
                    }
                    cnt+=nO;
                } 
            } 
            
        }
        return cnt;
    }
}
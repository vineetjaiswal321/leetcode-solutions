class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length;
        int i=0;
        while(i<n){
            if(bits[i]==0){
                i+=1;
                continue;
            }
            if(i+2>=n)  return false;
            i+=2;
        }
        return true;
    }
}
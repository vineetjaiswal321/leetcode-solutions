class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        int f=-1, s=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==1 && f==-1){
                f=i;//0
            }
            else if(nums[i]==1){
                s=i;//4
                if(s-f-1<k) return false;
                f=s;
            }
        }
        return true;
    }
}
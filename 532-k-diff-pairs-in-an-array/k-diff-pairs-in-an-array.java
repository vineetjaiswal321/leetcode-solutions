class Solution {
    class Pair{
        int fir;
        int sec;
        Pair(int fir, int sec){
            this.fir=fir;
            this.sec=sec;
        }
    }
    public boolean bSearch(int tar, int[] nums, int st, int end){
        while(st<=end){
            int mid=st+(end-st)/2;
            if(nums[mid]==tar){
                return true;
            }
            else if(nums[mid]>tar){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return false;
    }   
    public int findPairs(int[] nums, int k) {
        // 1 1 3 4 5
        //mod(1, 3)=2
        int n=nums.length;
        Arrays.sort(nums);
        Set<String> set=new HashSet<>();
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!bSearch(k+nums[i], nums, i+1, n-1)) continue;
            int ad=k+nums[i];
            if(!set.contains(nums[i] + "" + ad + "")){
                cnt++;
                set.add(nums[i] + "" +  ad + "");
            }
        }
        return cnt;
    }
}
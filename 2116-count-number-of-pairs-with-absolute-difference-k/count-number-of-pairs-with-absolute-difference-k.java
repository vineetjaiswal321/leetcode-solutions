class Solution {
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
    public int countKDifference(int[] nums, int k) {
        //1 1 2 2
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i : nums){
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int n=nums.length;
        Arrays.sort(nums);
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!bSearch(k+nums[i], nums, i+1, n-1)) continue;
            cnt+=mp.get(k+nums[i]);
        }
        return cnt;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> arr=new HashSet<>();

        //Sorting : 
        Arrays.sort(nums);

        //Algo
        for(int i=0;i<nums.length;i++)
        {
        int left=i+1;
        int right=nums.length-1;
        int sum=nums[i];
        while(left<right)
        {
            sum=nums[i]+nums[left]+nums[right];
            if(sum==0)
            {
               // int res[]={};
                arr.add(Arrays.asList(nums[i],nums[left],nums[right]));   
                left++;
                right--;
            }
            else if(sum<0)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        }
        return new ArrayList<>(arr);
    }

}
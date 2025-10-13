class Solution {
    public static int fOccurence(int[] arr, int target)
    {
        int st=0;
        int end=arr.length-1;
        int fo=-1;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(arr[mid]==target)
            {
                fo=mid;
                end=mid-1;
            }
            else if(arr[mid]<target)
            {
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return fo;
    }
    public static int lOccurence(int[] arr, int target)
    {
        int st=0;
        int end=arr.length-1;
        int lo=-1;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(arr[mid]==target)
            {
                lo=mid;
                st=mid+1;
            }
            else if(arr[mid]<target)
            {
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return lo;
    }
    public int[] searchRange(int[] nums, int target) {
        int fo=fOccurence(nums, target);
        int lo=lOccurence(nums, target);

        int[] res={fo, lo};
        return res;
    }
}
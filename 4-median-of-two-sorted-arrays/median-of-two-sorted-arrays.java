class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int arr[]=new int[nums1.length+nums2.length];
        int i=0;
        for(i=0;i<nums1.length;i++)
        {
            arr[i]=nums1[i];
        }

        for(int j=0;j<nums2.length;j++)
        {
            arr[i+j]=nums2[j];
        }

        Arrays.sort(arr);
        int size=arr.length;
        double median=0;
        if(size%2==0)
        {
            median=(double)((arr[(size/2)-1]+arr[size/2]))/2;
        }
        else{
            median=arr[size/2];
        }

        return median;
    }
}
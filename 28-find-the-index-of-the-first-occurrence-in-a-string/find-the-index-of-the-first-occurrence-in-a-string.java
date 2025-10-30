class Solution {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle))  return -1;
        for(int i=0;i<haystack.length();i++)
        {
            boolean flag=true;
            for(int j=0;j<needle.length();j++)
            {
                if(needle.charAt(j)!=haystack.charAt(j+i))
                {
                    flag=false;
                    break;
                }
            }
            if(flag==true)  return i;
        }
        return -1;
    }
}
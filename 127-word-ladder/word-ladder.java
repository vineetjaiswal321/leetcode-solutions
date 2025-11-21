class Solution {
    class Pair{
        String str;
        int len;
        Pair(String str, int len){
            this.str=str;
            this.len=len;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        for(String str : wordList)  set.add(str);
        if(!set.contains(endWord))  return 0;

        //BFS
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        while(q.size()>0){
            Pair p=q.poll();
            String str=p.str;
            int len=p.len;

            for(int i=0;i<str.length();i++){
                for(char ch='a';ch<='z';ch++){
                    String newStr=str.substring(0, i) + ch + str.substring(i+1);
                    if(set.contains(newStr)){
                        q.add(new Pair(newStr, len+1));
                        set.remove(newStr);
                    }
                    if(newStr.equals(endWord))  return len+1;
                }
            }
        }
        return 0;
    }
}
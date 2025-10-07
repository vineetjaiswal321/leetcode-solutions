class Solution {
    public void bfs(int st, boolean[] visted, List<List<Integer>> rooms)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(st);
        while(q.size()>0)
        {
            int front=q.remove();
            for(int room : rooms.get(front)){
                if(!visted[room])
                {
                    q.add(room);
                    visted[room]=true;
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visted=new boolean[n];
        visted[0]=true;
        bfs(0, visted, rooms);
        for(boolean f : visted) if(!f)    return false;
        return true;
    }
}
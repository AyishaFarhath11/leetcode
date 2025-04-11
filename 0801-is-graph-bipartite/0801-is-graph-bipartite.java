class Solution {
    public boolean isBipartite(int[][] graph) {
         int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        //To visit all our nodes we are calling loop from 0 to n
        for(int i=0;i<n;i++){
//We will only call dfs, if our node is not visited, and if our graph is not bipartite we will return false
            if(color[i]==-1 && checkBipartite(graph,i,color,1)==false) return false;
        }
        return true;
    }
      public boolean checkBipartite(int[][] graph, int curr, int[] color, int currColor){
        //color array humare visited array ki tarah kaam krega
        //Pehle cuurent node ko color krdo, i.e., usse visited mark krdo
        color[curr]=currColor;
        //Now we will check our adjacent nodes
        for(int v:graph[curr]){
            //if humare current node aur adjacent node ka color same ho gya 
            //means graph bipartite nhi hai, so return false
            //kyuki Bipartite graph main adjacent nodes ka color same nhi hota hai
            if(color[curr]==color[v]) return false;
            //Now if our adjacent node is never visited, so we will visit it
            if(color[v]==-1){
                //agar humara current node Red color (1) hai toh adjacent node Green (0) hoga
                // agar humara current node Green (0) hai toh adjacent node Red (1) hoga
                // colorV = 1 - color[curr]
                //if color[curr]==0,(Green) -> 1-0 = 1(Red) hoga
                // if color[curr]==1, (Red) -> 1-1=0 (Green) hoga
                int colorV = 1 - color[curr];
                //agar humare v ka dfs agar Bipartite nhi hai toh hum directly false return krenge
                if(checkBipartite(graph,v,color,colorV)==false) return false;
            }
        }
        //agar humne kahi false return nhi kiya hai means humara graph Bipartite hai, so return true
        return true;
      }
}
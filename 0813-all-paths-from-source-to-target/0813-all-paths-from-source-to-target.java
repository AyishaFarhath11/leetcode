class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
    int n = graph.length-1;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        DFS(graph, ans, list, 0, n);
        return ans;
    }
    public static void DFS(int graph[][], List<List<Integer>> ans, List<Integer> list,  int src, int dest){
        if(src == dest){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int nbr : graph[src]){
            list.add(nbr);
            DFS(graph, ans, list, nbr, dest);
            list.remove(list.size()-1);
        }
    }

}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // Map to store original nodes and their cloned counterparts
        Map<Node, Node> visited = new HashMap<>();

        // Start DFS to clone the graph
        return dfs(node, visited);
    }
     private Node dfs(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node); // Return already cloned node
        }

        // Clone the current node
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // Recursively clone all neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, visited));
        }

        return clone;
    }

}
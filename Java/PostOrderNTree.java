//postorder iterative traversal
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<Node> myStack = new Stack<Node>();
        myStack.push(root);
        int i = 0;
        
        //iterate via stack
        while(!myStack.empty() && root != null) {
            root = myStack.pop(); result.add(root.val);
            //iterate over children to add to stack
            while(i < root.children.size()) {
                myStack.push(root.children.get(i));
                i++;
            }
            i=0;
        }
        Collections.reverse(result);
        return result;
    }
}

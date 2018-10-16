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


Shortest length to a Char given string**

    public int[] shortestToChar(String S, char C) {
        //local declarations
        int len = S.length(), prev = Integer.MIN_VALUE/2, i = 0;
        int[] result = new int[len];
        
        //left-to-right iterations
        while(i < len) {
            if(S.charAt(i) == C) {
                prev = i;
            }
            result[i] = i - prev;
            i++;
        }
        
        i = len-1; prev = Integer.MAX_VALUE/2;
        //right-to-left
        while(i > -1) {
            if(S.charAt(i) == C) {
                prev = i;   
            }    
            result[i] = Math.min(result[i], prev - i);
            
            i--;
        }
        
        return result;
    }



    Pre-order iterative traversal
        public List<Integer> preorder(Node root) {
        //local declarations
        List<Integer> result = new ArrayList<Integer>();
        Stack<Node> myS = new Stack<Node>();
        myS.push(root);
        int i = 0;
        
        //null
        if(root == null) {
            return result;
        }
        
        //dequeue items in queue
        while(!myS.isEmpty()) {
            root = myS.pop();
            result.add(root.val);
            i = root.children.size()-1;
            //get childrens
            while(i > -1) {
                myS.push(root.children.get(i));
                i--;
            }
        }
        return result;
    }

//max depth
    List<Integer> dList = new ArrayList<Integer>(); 
    
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        int result = driver(root, 1);
        return Collections.max(dList);
    }
    
    public int driver(Node root, int depth) {
        //local variable
        int tempD = 0, i = 0, isAdding = 0;
        
        if(root == null) {
            return 0;
        }
        else {
            //iterate over children
            while(i < root.children.size()) {
                if(isAdding == 0) {
                    depth++; isAdding++;
                }
                tempD = driver(root.children.get(i), depth);
                i++;
            }
            dList.add(depth);
        }
        return tempD;
    }
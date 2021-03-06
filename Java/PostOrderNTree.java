/*
Kevin Nguyen
Basic Java program that takes in a tree and outputs an iterative post-order-traversal.

How to run (linux):
	1.) open command line and cd into directory folder of where this code is
	2.) type in "javac *.java" to compile java files
	3.) type in "java PostOrderNTree"
*/

//imports
import java.io.*;
import java.util.*;

//class
class PostOrderNTree {
    //main driver
	public static void main(String[] args) {
		//local Declarations
	}
    
    //postorder iterative traversal
    public List<Integer> postorder(Node root) {
	//local declarations
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

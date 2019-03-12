/*
 * Watch - https://www.youtube.com/watch?v=Dte6EF1nHNo
 * https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/544/
 */
public class CreateDoublyLinkedListFromBinaryTree {

	public Node concatenate(Node a, Node b){
        if(a == null) return b;
        if(b == null) return a;
        
        Node aEnd = a.left;
        Node bEnd = b.left;
        
        a.left = bEnd;
        bEnd.right = a;
        b.left = aEnd;
        aEnd.right = b;
        return a;
    }
    
    public Node treeToDoublyList(Node root) {
        
        if(root == null){
            return root;
        }
        
        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);
        
        root.left = root;
        root.right = root;
        
        root = concatenate(left, root);
        root = concatenate(root, right);
        
        return root;
        
    }
}

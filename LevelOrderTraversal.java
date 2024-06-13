import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
@SuppressWarnings("unused")
public class LevelOrderTraversal {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
        public Node(Node root){
            this.val  = val;
            this.left = null;
            this.right = null;
        }
    } 
   public static void helper(Node root , List<Integer> list , List<List<Integer>> result){
    if (root == null) {
        return;
    }

    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    while (!q.isEmpty()) {
        Node curr = q.remove();

        if (curr == null) {
            System.out.println();
            if (q.isEmpty()) {
                break;
            }
            else{
                q.add(curr);
            }
        }
        else{
            list.add(curr.val);
            // result.add(list);
            if (curr.left != null) {
                q.add(curr.left);
            }
            
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

      result.add(list);
   }
   public static List<List<Integer>> levelorder(Node root){
    
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    helper(root, list, result); 

    return result;
   }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        // root.left.left  = new Node(null);
        // root.left.right = new Node(null);  
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        List<List<Integer>> result = levelorder(root);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i) + " ");
        }
    }
}

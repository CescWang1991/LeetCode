import java.util.ArrayList;
import java.util.List;

/**
 * 98. Validate Binary Search Tree
 */
public class IsValidTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        List<Integer> order = new ArrayList<Integer>();
        dfs(root, order);

        int len = order.size();
        if(len == 1) { return true; }

        for (int i = 0; i < len - 1; i++){
            if(order.get(i) >= order.get(i+1)){ return false; }
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> order) {
        if(root.left != null) { dfs(root.left, order); }
        order.add(root.val);
        if(root.right != null) { dfs(root.right, order); }
    }
}
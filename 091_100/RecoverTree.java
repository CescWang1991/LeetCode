import java.util.ArrayList;
import java.util.List;

/**
 * 99. Recover Binary Search Tree
 */
public class RecoverTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> order = new ArrayList<TreeNode>();
        dfs(root, order);
        int start, end;
        start = 0;
        end = order.size()-1;
        while(start < end){
            if(order.get(start).val < order.get(start+1).val) {
                start ++;
            }
            if(order.get(end-1).val < order.get(end).val) {
                end --;
            }
            if(order.get(start).val > order.get(start+1).val && order.get(end-1).val > order.get(end).val) {
                int temp = order.get(start).val;
                order.get(start).val = order.get(end).val;
                order.get(end).val = temp;
                break;
            }
        }
    }

    private void dfs(TreeNode root, List<TreeNode> order) {
        if(root.left != null) { dfs(root.left, order); }
        order.add(root);
        if(root.right != null) { dfs(root.right, order); }
    }
}

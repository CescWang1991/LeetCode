import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary TreeLevel Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {
    // 采用迭代的方法
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> element = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                element.add(curr.val);
                if(curr.left != null) { queue.add(curr.left); }
                if(curr.right != null) { queue.add(curr.right); }
            }
            res.add(element);
        }

        return res;
    }

    // 采用递归的方法，深度优先遍历，将遍历到的节点加入到对应层的列表中，然后访问其左右子节点。
    public List<List<Integer>> levelOrderRecur(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        levelRecur(root, res, 0);
        return res;
    }

    private void levelRecur(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if(res.size() < level+1) {    // 说明需要添加新的一行
            res.add(new LinkedList<Integer>());
        }
        res.get(level).add(root.val);   // 将节点值加入到对应层的列表中
        levelRecur(root.left, res, level+1);
        levelRecur(root.right, res, level+1);
    }
}

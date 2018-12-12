import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        levelRecursion(root, res, 0, false);

        return res;
    }
    // 递归调用方法，采用DFS，level记录当前节点的层数，如果flag为false，表示正序输出，使用add，否则使用addFirst，反向输出。
    private void levelRecursion(TreeNode root, List<List<Integer>> res, int level, boolean flag) {
        if (root == null) {
            return;
        }
        if (res.size() < level + 1) {// 说明还需要添加一行
            res.add(new LinkedList<Integer>());
        }
        if (flag) {
            ((LinkedList<Integer>) res.get(level)).addFirst(root.val);
        } else {
            res.get(level).add(root.val);
        }

        levelRecursion(root.left, res, level + 1, !flag);
        levelRecursion(root.right, res, level + 1, !flag);
    }
}

public class PopulatingNextPointer {
    /**
     * 116. Populating Next Right Pointers for Each Node(完美二叉树)
     * 对于当前节点root，如果不是叶节点，则左子节点的next为右子节点，右子节点的next为root.next节点的左子节点(如果存在next)
     * 然后分别递归调用左右子节点
     */
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }

        if(root.left != null && root.right != null){
            root.left.next = root.right;
            if(root.next != null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
    }

    /**
     * 117. Populating Next Right Pointers for Each Node II
     */
    public void connectRight(TreeLinkNode root) {
        if(root == null) {
            return;
        }

        TreeLinkNode curr = root;

        if(root.left != null && root.right != null) {
            linkRightNode(root, curr.right);
            linkRightNode(root, curr.left);
        } else if(root.left != null) {
            linkRightNode(root, curr.left);
        } else if(root.right != null) {
            linkRightNode(root, curr.right);
        }
        connect(curr.right);
        connect(curr.left);
    }

    private void linkRightNode(TreeLinkNode father, TreeLinkNode child) {
        if(child == father.left && father.right != null) {
            child.next = father.right;
        } else {
            while(father.next != null) {
                if(father.next.left != null) {
                    child.next = father.next.left;
                    break;
                } else if(father.next.right != null) {
                    child.next = father.next.right;
                } else {
                    father = father.next;
                }
            }
        }
    }
}

//Two elements of a binary search tree (BST) are swapped by mistake.
//
//    Recover the tree without changing its structure.
//
//    Example 1:
//
//    Input: [1,3,null,null,2]
//
//    1
//    /
//    3
//    \
//    2
//
//    Output: [3,1,null,null,2]
//
//    3
//    /
//    1
//    \
//    2
//    Example 2:
//
//    Input: [3,1,4,null,null,2]
//
//    3
//    / \
//    1   4
//    /
//    2
//
//    Output: [2,1,4,null,null,3]
//
//    2
//    / \
//    1   4
//    /
//    3
//    Follow up:
//
//    A solution using O(n) space is pretty straight forward.
//    Could you devise a constant space solution?

public class P99 {
    TreeNode node1, node2, pre;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int v = node1.val;
        node1.val = node2.val;
        node2.val = v;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (node1 == null) {
                node1 = pre;
            }
            node2 = root;
        }
        pre = root;
        inorder(root.right);
    }
}

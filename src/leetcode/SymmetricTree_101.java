package leetcode;



/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class SymmetricTree_101 {

    public boolean isSymmetric(TreeNode root) {
        if(null == root){
            return false;
        }
        return compare(root.left,root.right);
    }

    private boolean compare(TreeNode left,TreeNode right){
        if(null == left && null == right){
            return true;
        }
        if(null == left || null == right){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return compare(left.left,right.right) && compare(left.right,right.left);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

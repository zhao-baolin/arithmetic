package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class BinaryTreePreorderTraversal_144 {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList(){};
        LinkedList<TreeNode> store =  new LinkedList(){};
        if(null == root){
            return list;
        }
        store.add(root);
        while(!store.isEmpty()){
            TreeNode node = store.pollLast();
            list.add(node.val);
            if(null != node.right){
                store.add(node.right);
            }
            if(null != node.left){
                store.add(node.left);
            }

        }
        return list;
    }

}

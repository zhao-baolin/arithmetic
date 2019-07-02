package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class BinaryTreeInorderTraversal_94 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //递归版
    List<Integer> list = new ArrayList(){};
    public List<Integer> inorderTraversal(TreeNode root) {
        if(null == root){
            return list;
        }
        each(root);
        return list;
    }
    public void each(TreeNode node){
        if(null == node){
            return;
        }
        if(null != node.left){
            each(node.left);
        }
        list.add(node.val);
        each(node.right);
    }



    //基于栈的遍历
    public List < Integer > inorderTraversa2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                //遍历把左子树全部压入栈中
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }


}

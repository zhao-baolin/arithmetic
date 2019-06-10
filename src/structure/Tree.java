package structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/5/18
 */
public class Tree {
    private Node tree;

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }


    public void delete(int data) {
        Node deleteNode = tree; //目标删除节点 首先默认根节点
        boolean is_find = false;//是否找到节点标记
        Node deleteNodeParent = null; //目标删除节点的父节点
        while (null != deleteNode) {
            if(deleteNode.data == data){
                //找到了要删除的节点
                is_find = true;
                break;
            }
            deleteNodeParent = deleteNode;
            if (data > deleteNode.data) {
                deleteNode = deleteNode.right;//如果要删除的数据比当前节点大，则往后边走。
            } else {
                deleteNode = deleteNode.left;//如果要删除的数据比当前节点大，则往后边走。
            }
        }

        //没有该节点
        if (!is_find) {
            return;
        }

        // 要删除的节点有两个子节点
        if (null != deleteNode.left && null != deleteNode.right) {
            // 查找右子树中最小节点
            Node nodeMin = deleteNode.right;//右子树中最小节点
            Node nodeMinParent = deleteNode; // 右子树中最小节点的父节点
            while (null != nodeMin.left) {
                //只往左边找，最小的数据永远都在最左边
                nodeMinParent = nodeMin;
                nodeMin = nodeMin.left;
            }
            deleteNode.data = nodeMin.data; // 将目标删除节点中的数据替换成右子树最小节点的数据，由于是引用传递，所以树（tree）中要删除的节点内容已经替换成了右子树中最小节点内容
            deleteNode = nodeMin; //更新要删除的节点 转移删除目标 现在需要删除右子树中的最小节点 （程序走到这里 此时deleteNode是一定没有子节点的 因为它本身就是一个叶子节点）
            deleteNodeParent = nodeMinParent;//更新删除目标的父节点
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node childNode = null; // 接管被删除节点下面的子节点

        //如果你有子节点 那么将子树拿出来
        if(null != deleteNode.left){
            childNode = deleteNode.left;
        }else if(null != deleteNode.right){
            childNode = deleteNode.right;
        }

        //如果你要删的是根节点
        if(null == deleteNodeParent){
            tree = childNode;
        }else{
            //处理被删除节点的父节点 将父节点的的指针指向下面的子节点
            if(deleteNodeParent.left == deleteNode){
                deleteNodeParent.left = childNode;//如果是在父节点的左子节点 则把子节点对接给父节点的left
            }else{
                deleteNodeParent.right = childNode;//如果是在父节点的右子节点 则把子节点对接给父节点的right
            }
        }
    }



    public Node minNode(){
        return minNode(tree);
    }
    private Node minNode(Node node)
    {
        if(null == node.left){
            return node;
        }
        return minNode(node.left);
    }


    public Node maxNode(){
        return maxNode(tree);
    }
    private Node maxNode(Node node)
    {
        if(null == node.right){
            return node;
        }
        return maxNode(node.right);
    }

    /**
     * 二叉树前序遍历
     * @param node   二叉树节点
     */
    public void preTraversal(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        preTraversal(node.left);
        preTraversal(node.right);
    }


    /**
     * 二叉树后序遍历
     * @param node   二叉树节点
     */
    public void postTraversal(Node node){
        if(node == null){
            return;
        }
        postTraversal(node.left);
        postTraversal(node.right);
        System.out.println(node.data);
    }

 /*   public void levelTraversal(Node node)
    {
        if(null == node){
            return;
        }

        levelTraversal(node.left);
        levelTraversal(node.right);
    }*/
    private void ddd(Node node)
    {
        if(null != node.left){
            System.out.println(node.left.data);
        }
        if(null != node.right){
            System.out.println(node.right.data);
        }
    }

    /**
     * 二叉树层序遍历
     * @param root   二叉树根节点
     */
    public static void levelTraversal(Node root){
        if(null == root){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);//初始化
        while(!queue.isEmpty()){
            Node node = queue.poll();//弹出节点
            System.out.println(node.data);//打印
            if(node.left != null){
                queue.offer(node.left);//左子节点入队
            }
            if(node.right != null){
                queue.offer(node.right);//右子节点入队
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(8);
        tree.insert(15);
        tree.insert(7);
        tree.insert(14);
        tree.insert(17);
        tree.insert(5);
        tree.insert(13);
        tree.insert(16);
        tree.insert(19);
        tree.insert(1);
        tree.insert(6);

        //tree.delete(6);
        //tree.delete(14);
        //tree.delete(15);
        //tree.delete(150);

        //System.out.println(tree.minNode().data);
        //System.out.println(tree.maxNode().data);

        //tree.preTraversal(tree.tree);
        tree.levelTraversal(tree.tree);
    }

}

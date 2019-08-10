package coding.test;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static List<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode right = new TreeNode(2);
//        TreeNode left = new TreeNode(3);
//        root.right = right;
//        right.left = left;
//        Solution solution = new Solution();
//        solution.inorderTraversal(root);
//        System.out.println(Arrays.asList(result).toString());
////        Queue<Integer> queue = new LinkedList<>();
////        ((LinkedList<Integer>) queue).add(1);
////        ((LinkedList<Integer>) queue).pollLast();
//        List<Integer> list = new LinkedList<>();
//        ((LinkedList<Integer>) list).addFirst(1);
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        System.out.println(queue.poll());






    }
    public List<Integer> inorderTraversal(TreeNode root) {
//        inorderTraversalRecursive(root);
        inorderTraversalNoRecursive(root);
        return result;
    }
    
    // 递归
    public void inorderTraversalRecursive(TreeNode root){
        if(root == null)
            return;
        if(root.left != null)
            inorderTraversalRecursive(root.left);
        result.add(root.val);
        if(root.right != null)
            inorderTraversalRecursive(root.right);
    }
    
    // 非递归
    public void inorderTraversalNoRecursive(TreeNode root){
        if(root == null)
            return ;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        while(stack.size() > 0){
            while(cur != null && cur.left != null){
                stack.push(cur.left);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
            if(cur != null)
                stack.push(cur);
        }
    }


    public void preorderTraversalNoRecursive(TreeNode root){
        if(root == null)
            return ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = root;
        while(queue.size() > 0){
            cur = ((LinkedList<TreeNode>)queue).pollLast();
            result.add(cur.val);
            if(cur.right != null)
                queue.add(cur.right);
            if(cur.left != null)
                queue.add(cur.left);
        }
    }
    
}
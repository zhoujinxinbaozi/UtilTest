package coding.BinaryTree;

import java.util.*;

public class Traverse {
    static final List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Node root = createTree();
//        dfsTraverse(root);
        bfsTraverse(root);
        System.out.println(Arrays.asList(result));
    }

    // 广度优先遍历
    private static void bfsTraverse(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.offer(root);
        Node preNode = root;
        Node curNode = root;
        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            result.add(tmp.data);
            if(tmp.leftChild != null) {
                queue.offer(tmp.leftChild);
                curNode = tmp.leftChild;
            }

            if(tmp.rightChild != null) {
                queue.offer(tmp.rightChild);
                curNode = tmp.rightChild;
            }
            if(preNode == tmp){
                preNode = curNode;
                result.add(-1);// 代表换行
            }
        }
    }


    // 深度优先遍历
    private static void dfsTraverse(Node root) {
        Stack<Node> stack = new Stack<>();
        if (root == null)
            return;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            result.add(tmp.data);
            if (tmp.rightChild != null)
                stack.push(tmp.rightChild);
            if (tmp.leftChild != null)
                stack.push(tmp.leftChild);
        }
    }

    // 创建二叉树
    private static Node createTree() {
        Node root = new Node(1);
        Node l = new Node(2);
        Node r = new Node(5);
        Node ll = new Node(3);
        Node lr = new Node(4);
        Node rl = new Node(6);
        Node rr = new Node(7);
        root.leftChild = l;
        root.rightChild = r;
        r.leftChild = rl;
        r.rightChild = rr;
        l.leftChild = ll;
        l.rightChild = lr;
        return root;
        /**
         *            1
         *       2       5
         *    3   4   6   7
         */
    }
}

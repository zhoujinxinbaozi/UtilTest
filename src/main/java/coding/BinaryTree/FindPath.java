package coding.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindPath {
    private static List<Node> nodeList;
//    private static int[] array = { 4, 2, 6, 1, 4, 4, 1, 2, 3 };
    private static int[] array = {7, 4, 10, 3, 5, 8, 12};
    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        createBinTree();
//        inOrderTraverse(nodeList.get(0));
//        print(findPathByFoot(nodeList.get(0), 10));
//        print(findPathByRoot(nodeList.get(0), 10));
//        inorderTraverseByFoot(nodeList.get(0), 10);
//        inorderTraverseByEvery(nodeList.get(0), 10);
//        sequenceTraver(nodeList.get(0));
        System.out.println(judgeSortTree(nodeList.get(0)));
    }

    private static void createBinTree() {
        nodeList = new LinkedList<Node>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).leftChild = nodeList
                .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).rightChild = nodeList
                .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList
            .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList
                .get(lastParentIndex * 2 + 2);
        }
    }

//    public static void inOrderTraverse(Node node) {
//        if (node == null)
//            return;
//        inOrderTraverse(node.leftChild);
//        System.out.print(node.data + " ");
//        inOrderTraverse(node.rightChild);
//    }

    //从根路径开始寻找路径加和为target
    private static ArrayList<ArrayList<Integer>> findPathByRoot(Node root,int target) {
        if(root == null) {
            return result;
        }
        target = target - root.data;
        list.add(root.data);
        if(target == 0){
            result.add(new ArrayList<>(list));
        }else{
            if(root.leftChild != null){
                findPathByRoot(root.leftChild, target);
            }
            if(root.rightChild != null){
                findPathByRoot(root.rightChild, target);
            }
        }
        list.remove(list.size() - 1);
        return result;
    }

    // 以叶节点结束
    private static ArrayList<ArrayList<Integer>> findPathByFoot(Node root,int target) {
        if(root == null) {
            return result;
        }
        target = target - root.data;
        list.add(root.data);
        if(target == 0 && root.leftChild == null && root.rightChild == null){
            result.add(new ArrayList<>(list));
        }else{
            findPathByFoot(root.leftChild, target);
            findPathByFoot(root.rightChild, target);
        }
        list.remove(list.size() - 1);
        return result;
    }

    //中序遍历所有的节点找出所有的以叶节点为终点的指定路径和为target
    private static void inorderTraverseByFoot(Node root, int target) {
        if(root == null){
            return ;
        }
        print(findPathByFoot(root, target));
        if(root.leftChild != null){
            print(findPathByFoot(root.leftChild, target));

        }
        if(root.rightChild != null){
            print(findPathByFoot(root.rightChild, target));
        }

    }

    //中序遍历所有的节点找出所有的任意节点开始任意节点种植的路径和为target
    private static void inorderTraverseByEvery(Node root, int target) {
        if(root == null){
            return ;
        }
        print(findPathByRoot(root, target));
        if(root.leftChild != null){
            print(findPathByRoot(root.leftChild, target));

        }
        if(root.rightChild != null){
            print(findPathByRoot(root.rightChild, target));
        }

    }

    //对结果的打印
    private static void print(ArrayList<ArrayList<Integer>> path) {
        for(ArrayList<Integer> list : path){
            System.out.println(list.toString());
        }
        result = new ArrayList<>();
    }

    // 层序遍历
    private static void sequenceTraver(Node root){
        Queue<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).add(root);
        int start = 0;
        int end = 1;
        while(!queue.isEmpty()){
            Node pop = ((LinkedList<Node>) queue).pop();
            start ++;
            if(pop.leftChild != null){
                ((LinkedList<Node>) queue).add(pop.leftChild);
            }
            if(pop.rightChild != null){
                ((LinkedList<Node>) queue).add(pop.rightChild);
            }
            if(end == start){
                System.out.println(pop.data);
                start = 0;
                end = queue.size();
            }else{
                System.out.print(pop.data + "\t");
            }
        }
    }

    private static boolean judgeSortTree(Node root){
        if(root == null){
            return true;
        }else{
            int count = 0;
            if(root.leftChild != null){
                if(judgeSortTree(root.leftChild) && root.data > root.leftChild.data){
                    count ++;
                }
            }else{
                count ++;
            }
            if(root.rightChild != null && root.data < root.rightChild.data){
                if(judgeSortTree(root.rightChild)){
                    count ++;
                }
            }else{
                count ++;
            }
            return count == 2;
        }
    }
}

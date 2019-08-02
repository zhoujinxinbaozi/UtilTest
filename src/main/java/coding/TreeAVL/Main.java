package coding.TreeAVL;

/***
 * 判断一个树是否为搜索二叉树
 */
public class Main {
    // List<Integer> list = new ArrayList<Integer>();
    public static boolean b = true;
    public static int val = -1;

    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = new TreeNode(0);
        System.out.println(main.isValidBST(root));
    }


    public boolean isValidBST(TreeNode root) {
        preTraverse(root);
        // boolean b = true;
        // for(int i = 0; i < list.size() - 1; i ++){
        //     if(list.get(i) >= list.get(i+1)){
        //         b = false;
        //         break;
        //     }
        // }
        // return b;
        return b;
    }

    public void preTraverse(TreeNode root){
        if(root == null){
            return;
        }

        if(root.left != null){
            preTraverse(root.left);
        }
        if(val < 0){
            val = root.val;
        }else{
            if(val >= root.val){
                b = false;
            }
        }
        if(root.right != null){
            preTraverse(root.right);
        }
    }
}

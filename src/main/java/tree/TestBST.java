package tree;

/***
 *
 * 根据给定的数组，判定是否是搜索二叉树的后序遍历
 */
public class TestBST {
    public static void main(String[] args) {
        System.out.println(TestBST.VerifySquenceOfBST(new int[]{5, 3, 6}));
    }

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        return IsTreeBST(sequence, 0, sequence.length - 1);
    }

    public static boolean IsTreeBST(int[] sequence, int start, int end) {
        if (end <= start)
            return true;
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > sequence[end])
                break;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end])
                return false;
        }
        return IsTreeBST(sequence, start, i - 1) && IsTreeBST(sequence, i, end - 1);
    }

}

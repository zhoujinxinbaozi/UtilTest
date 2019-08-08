package union;

import java.util.Arrays;

public class UnionFind {
    static final int[] arr = new int[10];

    static {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i; // arr[i]存放的是自己的父节点的位置，自己是最上层节点则存放自身的值
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        uf.union(1, 3);
        uf.union(1, 5);
        uf.union(7, 3);
        System.out.println(uf.judgeSameRoot(1, 7));
        System.out.println(uf.judgeSameRoot(1, 3));
        System.out.println(uf.judgeSameRoot(1, 5));
        System.out.println(uf.judgeSameRoot(3, 5));
        System.out.println(uf.judgeSameRoot(7, 5));
        System.out.println(uf.judgeSameRoot(7, 0));
        System.out.println(Arrays.toString(arr));
    }

    // 找到根节点
    public int find(int target) {
        while (target != arr[target]) {
            target = arr[target];
        }
        return target;
    }

    // 合并两个分支
    public void union(int target1, int target2) {
        int root1 = find(target1);
        int root2 = find(target2);
        arr[root1] = root2;
    }

    // 判断两个节点是否是可以联通的
    public boolean judgeSameRoot(int target1, int target2) {
        int root1 = find(target1);
        int root2 = find(target2);
        return root1 == root2;
    }

}

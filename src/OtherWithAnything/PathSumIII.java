package OtherWithAnything;

import Tree.TreeNode;

//路径不一定以 root 开头，也不一定以 leaf 结尾，但是必须连续。
//root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//        10
//        /  \
//        5   -3
//        / \    \
//        3   2   11
//        / \   \
//        3  -2   1
//
//        Return 3. The paths that sum to 8 are:
//
//        1.  5 -> 3
//        2.  5 -> 2 -> 1
//        3. -3 -> 11
public class PathSumIII {
    public static void main(String[] args){}
    private int cnt=0;
    public int getnumpath(TreeNode root,int sum){
        PathWith_root(root,sum);
        getnumpath(root.left,sum);
        getnumpath(root.right,sum);
        return this.cnt;

    }
    private void PathWith_root(TreeNode root,int sum){
        if (root==null)
            return;
        if (sum==root.val){
            this.cnt++;
        }
        PathWith_root(root.left,sum-root.val);
        PathWith_root(root.right,sum-root.val);
    }

}

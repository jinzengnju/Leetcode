package OtherWithAnything;

import Tree.TreeNode;
//路径和定义为从 root 到 leaf 的所有节点的和。
public class PathSum {
    public static void main(String[] args){

    }
    private boolean result=false;
    public boolean getRes(TreeNode root,int sum){
        getResHelper(root,sum);
        return result;
    }
    private void getResHelper(TreeNode root,int sum){
        if (root.left==null&&root.right==null&&sum==root.val)
            this.result=true;
        getResHelper(root.left,sum-root.val);
        getResHelper(root.right,sum-root.val);
    }


    //method2
    public boolean method2(TreeNode root,int sum){
        if (root==null) return false;
        if (root.left==null&&root.right==null&&root.val==sum) return true;
        return method2(root.left,sum-root.val)||method2(root.right,sum-root.val);
    }
}

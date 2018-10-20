package Tree;

import java.util.ArrayList;
import java.util.List;

//输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
public class PathSum {
    public static void main(String[] args){}
    public List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> getRes(TreeNode root,int K){
        if (root==null)
            return res;
        backtracking(root,K,new ArrayList<Integer>());
        return res;
    }
    private void backtracking(TreeNode node,int sum,List<Integer> path){
        //停止条件：到达叶子节点停止,到达叶子节点且sum为0需要做一定处理
        //划分子问题：将sum-节点的val值作为新的sum递归调用左右子树
        //合并结果：
        if (node==null)
            return;
        path.add(node.val);
        if (node.left==null&&node.right==null&&node.val==sum){
            res.add(new ArrayList<>(path));
        }else {
            backtracking(node.left,sum-node.val,path);
            backtracking(node.right,sum-node.val,path);
        }
        path.remove(path.size()-1);
    }
}

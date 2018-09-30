package Tree;

import java.util.ArrayList;
import java.util.List;

//路径必须从根节点到叶子节点
public class PathSum {
    public static void main(String[] args){}
    private List<List<Integer>> res=new ArrayList<>();


    public List<List<Integer>> getPath(TreeNode root,int sum){
        List<Integer> path=new ArrayList<>();
        backtracking(root,sum,path);
        return  res;

    }

    private void backtracking(TreeNode node,int sum,List<Integer> path){
        //停止条件：到达叶子节点停止,到达叶子节点且sum为0需要做一定处理
        //划分子问题：将sum-节点的val值作为新的sum递归调用左右子树
        //合并结果：
        if(node==null){
            return;
        }
        path.add(node.val);
        sum-=node.val;

        if(node.left==null&&node.right==null&&sum==0){
            res.add(new ArrayList<>(path));
        }else {
            backtracking(node.left,sum,path);
            backtracking(node.right,sum,path);
        }
        path.remove(path.size()-1);

    }
}

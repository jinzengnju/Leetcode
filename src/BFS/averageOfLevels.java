package BFS;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//637. Average of Levels in Binary Tree (Easy)
public class averageOfLevels {
    public static void main(String[] args){}
    private List<Double> getRes(TreeNode root){
        List<Double> ret=new ArrayList<>();
        if (root==null)
            return ret;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) queue).add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            int sum=0;
            while(size-->1){
                TreeNode temp=queue.poll();
                sum=+temp.val;
                if (temp.left!=null)
                    ((LinkedList<TreeNode>) queue).add(temp.left);
                if (temp.right!=null)
                    ((LinkedList<TreeNode>) queue).add(temp.right);
            }
            ret.add(1.0*sum/size);
        }
        return ret;

    }
}

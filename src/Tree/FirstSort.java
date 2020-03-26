package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jin
 * datetime: 2020/1/6 上午10:55
 */
//实现二叉树的前序便利

public class FirstSort {
    private List<Integer> res=new ArrayList<>();
    public static void main(String[] args){


    }
    private void sort(TreeNode root){
        if (root==null)
            return;
        res.add(root.val);
        sort(root.left);
        sort(root.right);
    }
    //法二
    private void sort_stack(TreeNode root){
        if (root==null)
            return;
        Stack<TreeNode> mysatck=new Stack<>();
        mysatck.add(root);
        while(!mysatck.isEmpty()){
            TreeNode temp=mysatck.peek();
            res.add(temp.val);
            if (root.right!=null){
                mysatck.add(root.right);
            }
            if (root.left!=null){
                mysatck.add(root.left);
            }
        }
    }
}

package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jin
 * datetime: 2020/1/6 下午4:51
 */
public class InorderSort {
    private List<Integer> res=new ArrayList<>();
    public static void main(String[] args){}
    private void sort1(TreeNode root){
        if (root==null)
            return;
        sort1(root.left);
        res.add(root.val);
        sort1(root.right);
    }

    private void sort2(TreeNode root){
        Stack<TreeNode> mystack=new Stack<>();
        if (root==null)
            return;
        TreeNode cur=root;
        if (!mystack.isEmpty()||cur!=null){
            if (cur!=null){
                mystack.add(cur);
                cur=cur.left;
            }else {
                cur=mystack.pop();
                res.add(cur.val);
                mystack.add(cur.right);
            }
        }
    }

}

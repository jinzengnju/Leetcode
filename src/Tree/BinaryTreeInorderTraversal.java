package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//非递归方法,栈
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ret=new ArrayList<>();
        if(root==null)
            return ret;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode node=stack.pop();
            ret.add(node.val);
            cur=node.right;
        }
        return ret;
    }
}

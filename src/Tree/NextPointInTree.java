package Tree;
//给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

//① 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
//        ② 否则，向上找第一个左链接指向的树包含该节点的祖先节点。


public class NextPointInTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode next;
        public TreeNode(int x){
            val=x;
            left=null;
            right=null;
            next=null;
        }
    }
    public TreeNode getNext(TreeNode node){
        if(node.right!=null){
            TreeNode res=node.right;
            while(res.left!=null)
                res=res.left;
            return res;
        }
        else{
            while(node.next!=null){//搜索不能超过根节点
                TreeNode next=node.next;
                while(next.left==node){
                    return next;
                }
                node=node.next;
            }
        }
        return null;
    }
}

package Tree;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class ConvertTreeToList {

    private TreeNode pre=null;
    private TreeNode head=null;
    public TreeNode Convert(TreeNode root){
        if (root==null)
            return null;
        ConvertHelper(root);
        return head;

    }
    private void ConvertHelper(TreeNode node){
        //这里是中需遍历:遍历到每个节点,访问的操作是将该节点指针赋值给pre.所以左子树遍历完后pre指向左子树最大的节点
        if(node==null){
            return;
        }
        ConvertHelper(node.left);//左子树遍历完后pre指向左子树最大的节点
        node.left=pre;
        if(pre!=null)
            pre.right=node;
        pre=node;
        if(head==null){
            head=node;
        }
        ConvertHelper(node.right);//遍历右子树,开始的时候,pre指向根节点,而右子树最先访问的是右子树最小的节点
    }
}

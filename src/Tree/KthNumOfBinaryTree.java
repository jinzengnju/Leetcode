package Tree;
//利用二叉查找树中序遍历有序的特点。
public class KthNumOfBinaryTree {
    public static void main(String[] args){

    }
    private int retK=0;
    private int cnt=0;
    public int findKthNum(TreeNode root,int K){
        inorder(root,K);
        return retK;
    }
    private void inorder(TreeNode root,int k){
        if(root==null||cnt>=k)
            return;
        inorder(root.left,k);
        cnt++;
        if (cnt==k)
            retK=root.val;
        inorder(root.right,k);
    }
}

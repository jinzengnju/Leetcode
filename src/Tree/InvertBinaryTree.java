package Tree;
//递归调用子树的翻转
//必须要保存left的指针,以为后面会赋值新的值给left
public class InvertBinaryTree {
    public static void main(String[] args){

    }
    public TreeNode inversionTree(TreeNode root){
        if(root==null)
            return null;
        TreeNode left=root.left;
        root.left=inversionTree(root.right);
        root.right=inversionTree(left);
        return root;
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){val=x;}
    public static TreeNode mkTree(int[] arr){
        TreeNode[] nodes=new TreeNode[arr.length+1];
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]!=Integer.MAX_VALUE){
                nodes[i]=new TreeNode(arr[i-1]);

            }
            else
                nodes[i]=null;
        }
        TreeNode node=null;
        for(int i=1;i<arr.length/2;i++){
            node=nodes[i];
            if(node==null) continue;
            node.left=nodes[2*i];
            node.right=nodes[2*i+1];
        }
        return nodes[1];
    }

}

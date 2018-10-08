package Tree;

public class BalancedBinaryTree {
    private boolean result=true;
    public static void main(String[] args){
        int[] arr={3,9,20,Integer.MAX_VALUE, Integer.MAX_VALUE,15,7};
        TreeNode root=BalancedBinaryTree.TreeNode.mkTree(arr);

    }

    public static class TreeNode{
     int val;
     TreeNode left;
     TreeNode right;
     public TreeNode(int x){
       val=x;
     }
     private static TreeNode mkTree(int[] arr){
         TreeNode[] nodes=new TreeNode[arr.length+1];
         for(int i=1;i<arr.length;i++){
             if(arr[i-1]!=Integer.MAX_VALUE){
                 nodes[i]=new TreeNode(arr[i-1]);
             }else
                 nodes[i]=null;
         }
         TreeNode node=null;
         for(int i=1;i<nodes.length/2;i++){
             node=nodes[i];
             if(node==null) continue;
             node.left=nodes[2*1];
             node.right=nodes[2*i+1];
         }
         return nodes[1];
     }
    }

    public boolean isBalancedTree(TreeNode root){
        Depth(root);
        return result;
    }
    private int Depth(TreeNode root){
        if (root==null||!result)//这里的递归停止条件需要注意以下
            return 0;
        int left=Depth(root.left);
        int right=Depth(root.right);
        if (Math.abs(left-right)>1)
            result=false;
        return 1+ Math.max(left,right);
    }


}

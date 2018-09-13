package Tree;

//Input:
//
//        1
//        / \
//        2  3
//        / \
//        4   5
//
//        Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//最大距离为左子树的深度+右子树的深度的最大值,该值定义为成员变量max
//同时递归函数应该返回当前树的最大深度(左右子树深度的最大值加一)
public class DiameterofBinaryTree {
    public static void main(String[] args){
        int[] arr={3,9,20,Integer.MAX_VALUE, Integer.MAX_VALUE,15,7};
        TreeNode root=DiameterofBinaryTree.TreeNode.mkTree(arr);
        System.out.println(new DiameterofBinaryTree().diameterOfBinaryTree(root));

    }
    private int max=0;
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val=x;
        }
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
            for (int i=1;i<arr.length/2;i++){
                node=nodes[i];
                if (node==null) continue;
                node.left=nodes[2*i];
                node.right=nodes[2*i+1];
            }
            return nodes[1];
        }
    }
    public int diameterOfBinaryTree(TreeNode root){
        depth(root);
        return max;

    }
    public int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        int ldepth=depth(node.left);
        int rdepth=depth(node.right);
        max=Math.max(max,ldepth+rdepth);
        return Math.max(ldepth,rdepth)+1;

    }

}

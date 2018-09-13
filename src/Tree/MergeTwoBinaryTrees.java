package Tree;
//Input:
//        Tree 1                     Tree 2
//        1                         2
//        / \                       / \
//        3   2                     1   3
//        /                           \   \
//        5                             4   7
//
//        Output:
//        3
//        / \
//        4   5
//        / \   \
//        5   4   7

//思路:递归调用,将合并树拆分为root节点的数相加以及左右子树的分别合并
//指针都为空,直接返回空,否则返回其中一个非空节点
public class MergeTwoBinaryTrees {
    public static void main(String[] args){
        int[] arr={3,9,20,Integer.MAX_VALUE, Integer.MAX_VALUE,15,7};
        TreeNode root=MergeTwoBinaryTrees.TreeNode.mkTree(arr);

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
            for(int i=1;i<nodes.length;i++){
                if(arr[i-1]!=Integer.MAX_VALUE)
                    nodes[i]=new TreeNode(arr[i-1]);
                else
                    nodes[i]=null;
            }
            TreeNode node=null;
            for(int i=1;i<nodes.length/2;i++){
                node=nodes[i];
                if(node==null) continue;
                node.left=nodes[2*i];
                node.right=nodes[2*i+1];
            }
            return nodes[1];
        }
    }

    public TreeNode mergeTree(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null) return null;
        if(t1==null) return t2;
        if(t2==null) return t1;
        TreeNode root=new TreeNode(t1.val+t2.val);
        root.left=mergeTree(t1.left,t2.left);
        root.right=mergeTree(t1.right,t2.right);
        return root;
    }
}

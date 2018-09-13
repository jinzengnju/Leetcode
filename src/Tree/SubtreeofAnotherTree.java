package Tree;

public class SubtreeofAnotherTree {
    public static void main(String[] args){

    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val=x;
        }
        public static TreeNode mkTree(int[] arr){
            TreeNode[] nodes=new TreeNode[arr.length+1];
            for(int i=1;i<nodes.length;i++){
                if(arr[i-1]!=Integer.MAX_VALUE){
                    nodes[i]=new TreeNode(arr[i-1]);
                }
                else
                    nodes[i]=null;
            }
            TreeNode node=null;
            for (int i=1;i<nodes.length/2;i++){
                node=nodes[i];
                if(node==null) continue;
                node.left=nodes[2*i];
                node.right=nodes[2*i+1];
            }
            return nodes[1];
        }

    }

    public boolean isSubTree(TreeNode s,TreeNode t){
        if(s==null) return false;
        return isSubTree(s,t)||isSubTree(s.left,t)||isSubTree(s.right,t);

    }

    public boolean isSubtreeWithRoot(TreeNode s,TreeNode t){
        if(s==null&&t==null) return true;
        if(s==null||t==null) return false;
        if(s.val!=t.val) return false;
        return isSubTree(s.left,t.left)&&isSubTree(s.right,t.right);

    }

}

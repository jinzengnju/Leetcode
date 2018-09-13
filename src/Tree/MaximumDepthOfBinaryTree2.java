package Tree;


public class MaximumDepthOfBinaryTree2 {
    public static void main(String[] args){
        //TreeNode node=new TreeNode(3);//这里如果去掉static class中的TreeNode中的static,会报错(非静态变量类型不能在静态上下文中引用)
        //因为main方法是静态的,想要在买你方法中引用内部类,需要将TreeNode声明为静态的
        int[] arr={3,9,20,Integer.MAX_VALUE, Integer.MAX_VALUE,15,7};
        TreeNode node=MaximumDepthOfBinaryTree2.TreeNode.mkTree(arr);
        System.out.println(new MaximumDepthOfBinaryTree2().maxDepth(node));

    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            val=k;
        }
        public static TreeNode mkTree(int[] arr){
            TreeNode[] nodes=new TreeNode[arr.length+1];
            for(int i=1;i< nodes.length;i++){
                if(arr[i-1]!=Integer.MAX_VALUE){
                    nodes[i]=new TreeNode(arr[i-1]);
                }
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

    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}

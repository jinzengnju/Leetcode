package LiuLiShuo;

import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            Main model=new Main();
            int N=scan.nextInt();
            int[] preorder=new int[N];
            int[] inorder=new int[N];
            for (int i=0;i<N;i++){
                preorder[i]=scan.nextInt();
                inorder[i]=preorder[i];
            }
            Arrays.sort(inorder);
            TreeNode root=model.reConstructBinaryTree(preorder,inorder);
            ArrayList<Integer> res=model.PrintFromTopToBottom(root);
            for (int i=0;i<res.size();i++){
                if(i!=res.size()-1){
                    System.out.print(res.get(i)+" ");
                }else
                    System.out.print(res.get(i));

            }

        }

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode t = queue.poll();
                if (t == null)
                    continue;
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return ret;
    }

    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int x){
            val=x;
        }
    }

    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

}

package Tree;

public class PathSumIII {
    public int pathSum(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        int ret=pathSumStartWithRoot(root,sum)+pathSumStartWithRoot(root.left,sum)+pathSum(root.right,sum);
        return ret;
    }
    private int pathSumStartWithRoot(TreeNode root, int sum){
        if(root==null){
            return 0;
        }
        int ret=0;
        //这里为哈每次进来都要讲ret置0？
        //对于某个路径，如果已经找到了，以该路径为基础，再往下延申肯定不是待求的路径，所以继续往深层递归的时候需要讲ret变为0.
        if(root.val==sum) ret++;
        ret+=pathSumStartWithRoot(root.left,sum-root.val)+pathSumStartWithRoot(root.right,sum-root.val);
        return ret;
    }
}

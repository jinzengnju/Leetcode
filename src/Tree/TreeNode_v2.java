package Tree;


//在Tree的题目中，常会给出一些测试用例，用一些特定的格式来表示一棵树，如[3,9,20,null,null,15,7]就表示如下的一棵树：
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        因此，我扩展了一下这个TreeNode的一些实现，使其可以通过官方给出的格式方便的构建出一棵树，从而使得我们在自己写玩代码后能很方便地调试。
//https://blog.csdn.net/styshoo/article/details/52865386
public class TreeNode_v2 {
    public int val;
    public TreeNode_v2 left;
    public TreeNode_v2 right;
    TreeNode_v2(int x){val =x;}
    public String toString(){
        return Integer.toString(val);
    }
    //这里的意思是TreeNode_v2.toString()的时候,会返回node节点的val的值


    //    int []arr = {3, 9, 20, Integer.MAX_VALUE, Integer.MAX_VALUE, 15, 7};
    private static int[] StrToIntArray(String str){
        str=str.substring(1,str.length()-1);//去掉左右两边的[]
        String[] strs=str.split(",");
        int[] arr=new int[strs.length];
        for(int i=0;i<strs.length;i++){
            if(strs[i].equals("null")){
                arr[i]=Integer.MAX_VALUE;
            }
            else{
                arr[i]=Integer.parseInt(strs[i]);//将字符串形式的数字转化为Integer
            }
        }
        return arr;

    }

    //    String str = "[3,9,20,null,null,15,7]";
    public static TreeNode_v2 mkTree(String str){
        //这里声明了mkTree为静态方法,所以StrToIntArray必须也是静态方法,因为在static方法内部不能调用非静态方法
        //static方法的主要作用是方便在没有创建对象的情况下来使用
        int[] arr=StrToIntArray(str);
        TreeNode_v2[] nodes=new TreeNode_v2[arr.length+1];
        for(int i=1;i<nodes.length;i++){//这里为什么要从下标1开始,原因是后面建立树的时候方便索引的运算2*i与2*i+1.可以自己画图试试
            if(arr[i-1]!=Integer.MAX_VALUE){
                nodes[i]=new TreeNode_v2(arr[i-1]);
            }
            else{
                nodes[i]=null;
            }
        }
        TreeNode_v2 node=null;
        for(int i=1;i<nodes.length/2;i++){
            node=nodes[i];
            if(node==null){
                continue;
            }
            node.left=nodes[2*i];
            node.right=nodes[2*i+1];
        }
        return nodes[1];
    }

//    使用以上代码时，只需要使用该代码建立一个项目，再将其链接到你的工作代码中即可。调用静态函数mkTree即可把官方给出的Tree的格式转换为一棵树，非常简单，如下：
//
//    String str = "[3,9,20,null,null,15,7]";
//    TreeNode node = TreeNode.mkTree(str);

}

package Graph;

public class GraphImpl {
    //在邻域数组中写数据
    private GraphType type;
    private int[][] a;
    private int n;//n表示节点的个数
    private int e;//e表示边的个数
    private static final int MaxValue=Integer.MAX_VALUE;
    public void creatGraph(EdgeElement[] d) {
        int i;
        for(i=0;i<d.length;i++){
            if(d[i]==null) break;
            int v1,v2;
            v1=d[i].fromvex;
            v2=d[i].endvex;
            if(v1<0 || v1>n-1 || v2<0 || v2>n-1 || v1==v2){
                System.out.println("边的顶点序号无效，退出运行");
                System.exit(0);
            }
            if(type==GraphType.NoDirectionNoWeight){
                a[v1][v2]=a[v2][v1]=1;
            }else if(type==GraphType.NoDirectionWeight){
                a[v1][v2]=a[v2][v1]=d[i].weight;
            }else if(type==GraphType.DirectionNoWeight){
                a[v1][v2]=1;
            }else{
                a[v1][v2]=d[i].weight;
            }
        }
        e=i;			//边的数目
    }

    public void putEdge(EdgeElement theEdge) {
        int v1,v2;
        v1=theEdge.fromvex;
        v2=theEdge.endvex;
        if(v1<0 || v1>n-1 || v2<0 || v2>n-1 || v1==v2){
            System.out.println("边的顶点序号无效，退出运行！");
            System.exit(0);
        }
        if(a[v1][v2]==0 || a[v1][v2]==MaxValue) e++;		//边数e的值加一
        if(type==GraphType.NoDirectionNoWeight || type==GraphType.NoDirectionWeight){
            if(type==GraphType.NoDirectionNoWeight){
                a[v1][v2]=a[v2][v1]=1;
            }else{
                a[v1][v2]=a[v2][v1]=theEdge.weight;
            }
        }else{
            if(type==GraphType.DirectionNoWeight) a[v1][v2]=1;
            else{
                a[v1][v2]=theEdge.weight;
            }
        }
    }

    public void removeEdge(int i, int j) {
        if(i<0 || i>n-1 || j<0 || j>n-1 || i==j){
            System.out.println("边的顶点序号无效，退出运行！");
            System.exit(0);
        }
        if(a[i][j]==0 || a[i][j]==MaxValue){
            System.out.println("要删除的边不存在，退出运行！");
            System.exit(0);
        }
        if(type==GraphType.NoDirectionNoWeight){
            a[i][j]=a[j][i]=0;
        }else if(type==GraphType.NoDirectionWeight){
            a[i][j]=a[j][i]=MaxValue;
        }else if(type==GraphType.DirectionNoWeight){
            a[i][j]=0;
        }else a[i][j]=MaxValue;
        e--;
    }

    //得到该结点的度
    public int degree(int i) {
        if(i<0 || i> n-1){
            System.out.println("参数的顶点序号值无效，退出运行");
            System.exit(0);
        }
        int k=0;
        if(type==GraphType.NoDirectionNoWeight || type==GraphType.NoDirectionWeight){
            for(int j=0;j<n;j++){
                if(a[i][j]!=0 && a[j][i]!=MaxValue) k++;

            }
        }else{
            k = inDegree(i)+outDegree(i);
        }
        return k;
    }

    //入度
    public int inDegree(int i) {
        if(i<0 || i> n-1){
            System.out.println("参数的顶点序号值无效，退出运行");
            System.exit(0);
        }
        if(type==GraphType.NoDirectionNoWeight || type==GraphType.NoDirectionWeight){
            return -1;
        }
        int k=0;
        for(int j=0;j<n;i++){
            if(a[j][i]!=0 && a[j][i]!=MaxValue) k++;
        }
        return k;
    }
    //出度
    public int outDegree(int i) {
        if(i<0 || i> n-1){
            System.out.println("参数的顶点序号值无效，退出运行");
            System.exit(0);
        }
        if(type==GraphType.NoDirectionNoWeight || type==GraphType.NoDirectionWeight){
            return -1;
        }
        int k=0;
        for(int j=0;j<n;i++){
            if(a[i][j]!=0 && a[i][j]!=MaxValue) k++;
        }
        return k;
    }

    //输出
    public void output() {
        int i,j;
        System.out.print("V={");//输出顶点集合
        for(i=0;i<n-1;i++){
            System.out.print(i+",");
        }
        System.out.print(n-1+"}");//输出顶点集合
        //输出边集合
        System.out.print("E={");
        if(type==GraphType.NoDirectionNoWeight || type==GraphType.DirectionNoWeight){
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    if(a[i][j]!=0 && a[i][j]!=MaxValue){
                        if(type==GraphType.NoDirectionNoWeight){
                            if(i<j)System.out.print("("+i+","+j+"),");
                        }else{
                            System.out.print("<"+i+","+j+">");
                        }
                    }
                }
            }
        }else{
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    if(a[i][j]!=0 && a[i][j]!=MaxValue){
                        if(type==GraphType.NoDirectionWeight){
                            if(i<j)System.out.print("("+i+","+j+")"+a[i][j]+",");
                        }else System.out.print("<"+i+","+j+">"+a[i][j]+",");
                    }
                }
            }
        }
        System.out.print("}");
    }

    //深度优先进行搜索   是从哪个顶点开始遍历，这里可以用顶点序号表示顶点
    public void depthFirstSearch(int v) {		//驱动函数
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            visited[i]=false;
        }
        dfs(v,visited);							//把每个结点遍历一次。
        System.out.println();
    }
    //进行深度优先搜索的内部递归方法使用
    private void dfs(int i,boolean visited[]){	//工作函数
        System.out.print(i+" ");
        visited[i]=true;
        for(int j=0;j<n;j++){
            if(a[i][j]!=0 && a[i][j]!=MaxValue && !visited[j]){
                dfs(j,visited);
            }
        }
    }



}

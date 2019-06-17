package Graph;

public class EdgeElement {
    int fromvex;
    int endvex;
    int weight;

    public EdgeElement(int v1,int v2){
        //对于无权重图的初始化
        fromvex=v1;
        endvex=v2;
        weight=1;
    }
    public EdgeElement(int v1,int v2,int wgt){
        //对于有权重图的初始化
        fromvex=v1;
        endvex=v2;
        weight=wgt;
    }
}

package Sort;

public class HeapSort {

    private int[] buildMaxHeap(int[] array){
        //从最后一个结点array.length-1的父节点（array.length-1-1）/2开始,直到根节点,反复调整堆
        for(int i=(array.length-2)/2;i>=0;i--){
            adjustDownToUp(array,i,array.length);
        }
        return array;
    }
    private void adjustDownToUp(int[] array,int k,int length){
        int temp=array[k];
        for(int i=2*k+1;i<array.length;i=2*i+1){//i初始化为节点l的左孩子
            if(i<length&&array[i]<array[i+1]){
                i++;
            }
            if(array[i]<=temp){
                break;
            }else {
                array[k]=array[i];//将左右子节点中较大值array[i]调整到父节点上
                k=i;//更新k值,以便继续向下调整
            }
        }
        array[k]=temp;
    }

    //堆排序
    public int[] heapsort(int[] array){
        array=buildMaxHeap(array);//初始建堆，array[0]为第一趟值最大的元素
        for(int i=array.length-1;i>1;i--){
            int temp=array[0];
            array[0]=array[i];
            array[i]=temp;
            adjustDownToUp(array,0,i);
        }
        return array;
    }

    //删除堆顶元素
    public int[] deleteMax(int[] array){
        array[0]=array[array.length-1];
        array[array.length-1]=-9999;
        adjustDownToUp(array,0,array.length);
        return array;
    }

    //堆的插入操作
    public int[] insertData(int[] array,int data){
        array[array.length-1]=data;
        int k=array.length-1;
        int parent=(k-1)/2;
        while(parent>=0&&data>array[parent]){
            array[k]=array[parent];
            k=parent;
            if(parent!=0){
                parent=(parent-1)/2;
            }else{
                break;
            }
        }
        array[k]=data;
        return array;
    }

}

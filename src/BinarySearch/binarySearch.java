package BinarySearch;

public class binarySearch {
    //1.1二分查找原始版–查找某个数的下标（任意一个）
    //在有序数组中查找某个数，找到返回数的下标，存在多个返回任意一个即可，没有返回-1。所有程序采用左右均为闭区间，
    // 即函数中n为最后一个元素下标，而不是元素个数
    public int binarySearch(int[] arr,int n,int key){
        int left=0;
        int right=n;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(arr[mid]==key)
                return mid;
            else if(arr[mid]>key)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }
    //1.2查找第一个大于等于某个数的下标,
    // 查找数组中某个数的位置的最小下标，没有返回-1(即数组允许包含多条数据,函数返回最左侧的下标)
    //int[] a = {1,2,2,2,4,8,10}，查找2，返回第一个2的下标1；查找3，返回4的下标4；查找4，返回4的下标4。
    // 如果没有大于等于key的元素，返回-1,直接用上面1.2，但需要处理一下，即当返回的low位置不等于key时，也返回-1。
    public int firstGreatOrEqual(int[] arr,int n,int key){
        int left=0;
        int right=n;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(arr[mid]>=key){
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return left<=n?left:-1;
    }
    //查找数组中某个数的位置的最小下标，没有返回-1
    public int firstIndex(int[] a, int n, int key){
        int left=0;
        int right=0;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(a[mid]>=key)
                right=mid-1;
            else
                left=mid+1;
        }
        return (left<=n)&&(a[left]==key)?left:-1;
    }

    //1.3查找第一个大于某个数的下标
    //int[] a = {1,2,2,2,4,8,10}，查找2，返回4的下标4；查找3，返回4的下标4；查找4，返回8的下标5。如果没有大于key的元素，返回-1。
    //查找数组中某个数的位置的最大下标，没有返回-1
    //直接用上面1.3，得到的下标 - 1即可，但也需要处理一下，即不用判断low <= n，而是判断low-1>=0，且返回的low-1位置等于key时，才返回位置low - 1
    public int firstGreat(int[] arr,int n,int key){
        int left=0;
        int right=0;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(arr[mid]>key)
                right=mid-1;
            else
                left=mid+1;
        }
        return left<=n?left:-1;
    }
    //查找数组中某个数的位置的最大下标，没有返回-1
    public int lastIndex(int[] arr,int n,int key){
        int left=0;
        int right=0;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(arr[mid]>key)
                right=mid-1;
            else
                left=mid+1;
        }
        return (left-1>=0&&(arr[left-1]==key))?left-1:-1;
    }

    //查找数组中小于某个数的最大下标，没有返回-1.可以根据1.2修改
    //假如数据为1,2,3,3,3,4,5,查找小于3的最大下标.第一次mid指向3,而目标在左侧,应该移动right指针
    public int firstLess(int[] arr,int n,int key){
        int left=0;
        int right=0;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(arr[mid]>=key)
                right=mid-1;
            else
                left=mid+1;
        }
        return right;
    }
}

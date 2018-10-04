package HashMap;

public class MapSort {
}
//o1.compareTo(o2);
//就是返回正数的话，当前对象（调用compareTo方法的对象o1）要排在比较对象（compareTo传参对象o2）后面，返回负数的话，放在前面
//那么：
//Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
//表示的是(s1 + s2)比(s2 + s1)小的话，传入的s1放在前面，s2放在后面
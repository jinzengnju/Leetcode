package ComparatorAndComparable;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args){
        Student[] persons = new Student[5];
        persons[0] =new Student("tom",1,88,45);
        persons[1] =new Student("jack",6,80,12);
        persons[2] =new Student("bill",4,68,21);
        persons[3] =new Student("kandy",2,98,34);
        persons[4] =new Student("lily",5,94,20);
        System.out.println("排序前的数据：");
        for (Student student:persons) {
            System.out.println(student);
        }
        //创建SortByNumber对象，将其作为参数传入Arrays.sort(persons,sortByNumber)方法中
        SortByNumber sortbynumber=new SortByNumber();
        Arrays.sort(persons,sortbynumber);
        System.out.println("根据学生编号由低到高排序：");
        for (Student student:persons) {
            System.out.println(student);
        }
        SortByScore sortByScore = new SortByScore();
        Arrays.sort(persons,sortByScore);
        System.out.println("根据学生成绩由高到低排序：");
        for (Student student:persons) {
            System.out.println(student);
        }

    }
}
class Student{
    private String name;
    private int number;
    private int score;
    private int age;
    public Student(String name,int number,int score,int age){
        this.name = name;
        this.number = number;
        this.score = score;
        this.age = age;
    }
    //重写Student类的toString()方法，在输入对象时按照以下方式输出
    @Override
    public String toString() {
        return "Student[name:"+name+",age:"+age+",number:"+number+",score:"+score+"]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class SortByNumber implements Comparator<Student>{
    public int compare(Student o1,Student o2){
        return o1.getNumber()-o2.getNumber();
    }
}

class SortByScore implements Comparator<Student>{
    public int compare(Student o1,Student o2){
        return o1.getScore()-o2.getScore();
    }
}
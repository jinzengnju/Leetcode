package ComparatorAndComparable;

//一种是使用Comparable接口：让待排序对象所在的类实现Comparable接口，并重写Comparable接口中的compareTo()方法,
//        缺点是只能按照一种规则排序。
//只要相关的类实现了comparable接口，调用sort即可自然排序

import java.util.Arrays;

public class ComparableTest {
    public static void main(String[] args){
        Person[] persons=new Person[5];
        persons[0] =new Person("tom",45);
        persons[1] =new Person("jack",12);
        persons[2] =new Person("bill",21);
        persons[3] =new Person("kandy",34);
        persons[4] =new Person();

        Arrays.sort(persons);
        for (Person person:persons){
            System.out.println(person);
        }

    }

}
class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public Person(){
        this("unknown", 0);
    }
    //重写该类的compareTo()方法，使其按照从小到大顺序排序
    public int compareTo(Person o){
        return this.age-o.age;
    }
    public String toString() {
        return "Person[name:"+name+",age:"+age+"]";
    }

}
//在测试类中通过Colletions.sort即可实现排序
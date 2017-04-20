/**
 * Created by zoypong on 2017/4/20.
 */
public class Animals implements Talking{
    String name;
    int age;

    Animals(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public void say() {
        System.out.println(name + " Talking " + " and its age is " + age);
    }
}

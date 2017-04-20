/**
 * Created by zoypong on 2017/4/20.
 */
public class Human extends Animals {
    private String country;

    public Human(String name, int age, String country) {
        super(name, age);
        this.country = country;
    }

    @Override
    public void say() {
        // 多态。看起来像是重写方法
        System.out.println("I am Human from " + country);
    }
}

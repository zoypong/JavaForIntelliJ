import javax.xml.crypto.Data;
import java.awt.datatransfer.SystemFlavorMap;
import java.text.*;
import java.util.*;

/**
 *
 */
public class HelloWorld {

    private static void print(int idx, Object obj){
        System.out.println(String.format("{%d} , %s", idx, obj));
    }

    private static void demoString(){
        String str = "Hello world";
        print(1,str.indexOf('e'));
        print(2,str.charAt(6));
        print(3,str.codePointAt(0));
        print(4,str.compareToIgnoreCase("Hello Wrld"));
        print(5,str.compareTo("Hel wor"));

        print(6,str.contains("hel"));
        print(7,str.concat("!!!"));

        print(8,str.toUpperCase());
        print(9,str.toLowerCase());

        print(10,str.startsWith("Heo"));
        print(11,str.endsWith("world"));

        print(12,str.replace('o', 'x'));
        print(13,str.replaceAll("Hello", "Hi"));
        print(14,str.replaceAll("l|r", "k"));

        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(false);
        sb.append('x');
        sb.append("Helloo");
        print(15,sb.toString());
    }

    private static void demoList() {
        List<String> strList = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            strList.add(String.valueOf(i));
        }
        print(1,strList);

        List<String> strListB = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            strListB.add(String.valueOf(i*i));
        }

        strList.addAll(strListB);
        print(2,strList);

        strList.remove(0);
        print(3,strList);

        strList.remove(String.valueOf(16));
        print(4,strList);

        // 正规排序
        Collections.sort(strList);
        print(5,strList);

        // 自定义排序。为什么 o2 与 o1 交换一下位置，排序结果就不一样了呢？
        Collections.sort(strList, new Comparator<String>(){

            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        print(6,strList);

        // 遍历
        for(String obj : strList) {
            print(7, obj);
        }

        for(int i = 0; i < strList.size(); i++) {
            print(8, strList.get(i));
        }
    }

    /**
     *  之所以用 hashMap 和 hashTable ，是因为在List在查找的时候是O(n)而不是O(1)，在数据量大的时候效率会比较
     * 慢。 Map 中只要给定 key 就可以得到 value ，查找效率为O(1)。
     */
    private static void demoMapAndTable() {
        Map<String, String> map = new HashMap<String, String>();
        // 放入键值对
        for (int i = 0; i < 5; i++) {
            map.put(String.valueOf(i), String.valueOf(i*i));
        }
        // 打印出来
        print(1, map);


        for (Map.Entry<String, String> entry : map.entrySet()) {
            print(2, entry.getKey() + "|" + entry.getValue());
        }

        print(3,map.values());
        print(4,map.keySet());
        print(5,map.get("4"));
        print(6,map.containsValue("9"));

    }

    private static void demoSet() {
        Set<String> set =  new HashSet<String>();

        for (int i = 0; i < 5; i++) {
            set.add(String.valueOf(i));
        }
        print(1, set);

        set.addAll(Arrays.asList(new String[] {"A", "B", "C"}));
        print(2, set);

        for (String val : set) {
            print(3, val);
        }

    }

    private static void demoException() {
        try{
            int a = 1;
            //a = a/0;
            if (a == 1) {
                throw new Exception("我故意的");
            }
        } catch (Exception e) {
            print(1, e.getMessage());
        } finally {
            // 一般情况下 finally 都是做一些数据清理、句柄处理、文件关闭等收尾工作
            print(2, "finally");
        }
    }


    private static void AnimalsOOP() {
        Animals ams = new Animals("jay", 2);
        ams.say();

        Animals human = new Human("HAHA", 11, "China");
        human.say();
    }

    private static void Function() {
        Random random = new Random();
        random.setSeed(2);
        /*
            nextInt = 2;
            nextInt = nextInt << xx && 100101。
            这是一个伪随机过程，只要一开始指定一个数，那么后面的伪随机链条就是一定的。假如指定
            了种子，那么每次运行的结果都是一样的，因为种子与时间相关，指定种子后随机数不与时间
            直接相关了。若没指定种子，那么种子其实与时间相关，时间不同种子不同，而种子不同随机数
            就不同了
          */
        for (int i = 0; i < 4; i++) {
            print(i, random.nextInt(1000));
        }


        List<Integer> arr = Arrays.asList(new Integer[] {1,2,3,4,5});
        Collections.shuffle(arr);
        print(5,arr);


        Date date = new Date();
        print(6,date);
        print(7,date.getTime());

        // 自定义时间格式 dFormat ，y/M/d 代表年月日， H/m/s 代表时分秒，个数代表占位符
        DateFormat dFormat = new SimpleDateFormat("MM.dd/yyyy HH:mm:ss");
        print(8,dFormat.format(date));

        print(9,UUID.randomUUID());

        print(10,Math.log(8));
        print(11,Math.max(1,3));
        print(12,Math.min(10,5));
        print(13,Math.ceil(2.2));
        print(14,Math.floor(3.5));


    }

    public static void main(String[] args){
        Function();
        //AnimalsOOP();
        //demoException();
        //demoString();
        //demoList();
        //demoMapAndTable();
        //demoSet();
    }
}

import java.util.HashMap;

/**
 * Created by liusifan on 2017/3/6.
 */
public class Test {
    public static void main(String[] args) {
        HashMap<TestHashMap,String>  hashMap= new HashMap<>();
        hashMap.put(new TestHashMap(1),"a1");
        TestHashMap x=new TestHashMap(2);
        hashMap.put(x,"ax");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.put(new TestHashMap(3),"c1");
        hashMap.get(x);
    }
}

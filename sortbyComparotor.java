import java.security.KeyStore.Entry;
import java.util.*;
class Main{
public static void main(String[] args) {
    System.out.println("Hello");
    HashMap<Integer,String> uMap = new HashMap<>();
    uMap.put(1, "dabc");
    uMap.put(2, "cabc");
    uMap.put(3, "babc");
    uMap.put(4, "aabc");

    System.out.println(uMap);
    Set<Entry<Integer,String>> mSet = uMap.entrySet();
    List<Entry<Integer,String>> list = new ArrayList<>(mSet);
    Collections.sort(list, (o1,o2)->o1.getValue().compareTo(o2.getValue()));
    System.out.println(list);
}
}
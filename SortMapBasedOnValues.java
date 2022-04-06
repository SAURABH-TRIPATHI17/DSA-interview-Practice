import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class SortMapBasedOnValues {
 
	public static void main(String[] args) {
		
		Map<Integer,String> employeeIdandNameMap = new HashMap<>();
		
		employeeIdandNameMap.put(10234, "Sean");
		employeeIdandNameMap.put(10033, "KK");
		employeeIdandNameMap.put(11004, "MARK");
		employeeIdandNameMap.put(11724, "ANTONY");
		employeeIdandNameMap.put(12004, "WEST");
		employeeIdandNameMap.put(13234, "BEAN");
		employeeIdandNameMap.put(10004, "AK");
		
		System.out.println("Original Map::::");
		employeeIdandNameMap.forEach((k,v)->System.out.println(k+"\t"+v));
		
		Set<Entry<Integer, String>> entrySet = employeeIdandNameMap.entrySet();
		
		List<Entry<Integer, String>> list = new ArrayList<>(entrySet);
		
		Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
		
		System.out.println("Map sorted based on Values::::");
		
		/*list.forEach(s->{
			System.out.println(s.getKey()+"\t"+s.getValue());
		});
        */
        list.stream().filter(x -> x.getKey()>11000).map(x -> x.getKey()+20000).forEach(System.out::println);
	}
}
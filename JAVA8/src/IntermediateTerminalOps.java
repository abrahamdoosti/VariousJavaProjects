import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IntermediateTerminalOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Stream without terminal operation");

		Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
			System.out.println("doubling " + i);
			return i * 2;
		});
		System.out.println("Stream with terminal operation");

		int result = Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
			System.out.println("doubling " + i);
			return i * 2;
		}).sum();
		System.out.println("result = " + result);
		
		
		Map<String, List<String>> cities=new HashMap<>();
		cities.put("NC",Arrays.asList("Charlotte","Raleigh","Winston Salem"));
		cities.put("MN",Arrays.asList("St. Paul","Minniapolis"));
		cities.put("CA",Arrays.asList("Los Angeles","San Farncisco","San Jose"));
						
		cities.get("NC").add("Durham");
		
		List<String> flattendCities=cities.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
		flattendCities.forEach(System.out::println);
		
		//Optional(Student)
		
	}

}

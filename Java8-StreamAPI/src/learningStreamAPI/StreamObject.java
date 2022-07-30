package learningStreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObject {
	
	public static void main(String[] args) {
		
		//Stream API - used to process Collections/Group of objects(such as arrays)
		
		//ways to create Stream Objects
		
		//1. blank stream:
		Stream<Object> emptyStream = Stream.empty();
		
		//2. Array,object, ollection to -> stream
		String[] names = {"abcd", "pqrs", "prateek", "dur"};
		Stream<String> stream1 = Stream.of(names);
		//to print elements from streams
		stream1.forEach(e -> {
			System.out.println(e);
		});
		
		//3. Stream.builder
		Stream<Object> streamBuilder = Stream.builder().build();
		
		//4. Arrays
		IntStream streamArrays = Arrays.stream(new int[] {2,3,4,5});
		streamArrays.forEach(e -> {
			System.out.println(e);
		});
		
		
		
		//5. Collection object such as List, Set
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(4);
		list2.add(41);
		list2.add(54);
		list2.add(32);
		
		Stream<Integer> listStream = list2.stream();
		listStream.forEach(e -> {
			System.out.println(e);
		});
		
	}
	
}

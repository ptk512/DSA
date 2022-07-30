package learningStreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain1 {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create a list and filter all even numbers from the list
		
		//list.of creates a immuatable String means we can not modify the list once its created
		//means we cannot add or delete or update elements in the List later
		
		List<Integer> list1 = List.of(2, 4, 5, 65, 12, 32, 78, 67);
		
		//list1.add(5); //this will throw run time error
		
		//Another way of creating list by Arraylist method
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(4);
		list2.add(41);
		list2.add(54);
		list2.add(32);
		
		//3rd way of creating list --> this ne also creates immutable list
		List<Integer> list3 = Arrays.asList(34, 12, 21, 54, 77, 4, 56);
		
		
		//list1 --> filter even numbers
		
		//without StreamAPI method
		List<Integer> listEven = new ArrayList<Integer>();
		for(Integer i: list1) {
			if(i%2 == 0) {
				listEven.add(i);
			}
		}
		
		System.out.println(list1);
		
		
		
		//with StreamAPI
		Stream<Integer> stream= list1.stream();
		//filter("yaha par ham boolean predicate ya function return krenge") jo boolean true hone pr filter krega
		// niche hamne filter me lambda expression likha hai jo even numbers ko filter karega
		List<Integer> evenList= stream.filter(i -> i%2 == 0).collect(Collectors.toList());
		System.out.println(evenList);
		
		
		// above can also be written in singel line
		List<Integer> newList= list1.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
		
		//to get numbers greater than 20 inn list
		System.out.println("list1 with elements > 20 = "+list1.stream().filter(i -> i>20).collect(Collectors.toList()));
		
		
	
		
		
		
		
	}

}

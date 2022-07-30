package learningStreamAPI;

import java.util.List;
import java.util.stream.Collectors;

public class Methods {

	public static void main(String[] args) {

		
		//filter(Predicate)
		  	//predicate means = boolean valued function
			//most common way to write predicate = lambda expression
				//lambda => e -> e>10
		
		
		//map(Function)
		  /*
		   * Map me har ek element pr each element par operation perform kar sakte hai
		   * 		   
		   * */
		
		//	printing elements in a list that startswith A
		
		List<String> list = List.of("Aman", "Abhinav", "Atul", "Prateek", "Nitish");
		//now we know that we have to print name that starts with A so we can think that we need predicate(return true when condition satisfy)
		list.stream().filter(e -> e.startsWith("A")).forEach(e-> {
			System.out.println(e);
		});
		
		
		//return square of each element in a List
		// ab yaha koi condition nahi aayi true ya false vali jese phle aayi thi
		//to yaha par use krenge map
		
		List<Integer> numbers = List.of(23, 4, 5, 12, 35);
		List<Integer> newNumbers = numbers.stream().map(i -> i*i).collect(Collectors.toList());
		System.out.println("Square of elements : "+newNumbers);
		
		
		
		
		//sorted
		numbers.stream().sorted().forEach(System.out::println);
		
		
	}

}

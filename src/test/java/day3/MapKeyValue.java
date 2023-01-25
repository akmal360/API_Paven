package day3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapKeyValue {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();

		map.put(1, "v1");
		map.put(2, "v2");
		map.put(3, "v3");

		// using foreach with lambda funcion or arrow sign;

		map.forEach((k, v) -> {
			System.out.println("keys : " + k + " values : " + v);

		});

		// using map.entrySet() method

		List<Integer> number = Arrays.asList(1, 2, 3);
		List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(square);

		List<String> name = Arrays.asList("ab", "bc");
		Object result = name.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
		System.out.println(result);

		List<String> names2 = Arrays.asList("G", "C", "D", "A");
		List<String> result2 = names2.stream().sorted().collect(Collectors.toList());
		System.out.println(result2);

		List<Integer> numbers = Arrays.asList(3, 4, 6);
		Set<Integer> squarer = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
		System.out.println(squarer);

		List<Integer> num = Arrays.asList(2, 3, 5, 9);
		num.stream().map(x -> x * x).forEach(t -> System.out.println(t));

		List<Integer> num2 = Arrays.asList(3, 45, 6, 7,4,2);
		int evenNum= num2.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) ->ans+ i);
		System.out.println("*******"+evenNum);
		
//		List<Integer> num21 = Arrays.asList(3, 45, 6, 7,4,2);
//		int evenNumq= num2.stream().filter(x -> x % 2 == 0).filter(x>10).forEach()
					  
					  
					  
		System.out.println("*******"+evenNum);

	}

}

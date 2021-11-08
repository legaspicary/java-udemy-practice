package com.practice.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class LambdaMain {
	public static void main(String[] args) {
//		functionalInterfaceDemo();
//		anotherFunctionalDemo();
//		chainingFunctionsDemo();
//		bifunctionDemo();
//		IntUnaryOperator intUnaryOperator = (int i) -> i + 5;
//		System.out.println(intUnaryOperator.applyAsInt(89));
//		streamDemo();
	}

	public static void flatMapDemo() {

	}

	public static void streamDemo() {
		List<String> list = Arrays.asList("Hello", "World", "Helloo", "Henloo", "Again", "And", "Again");

		list.stream().map(String::toLowerCase).filter(s -> s.startsWith("h")).sorted().forEach(System.out::println);

		Stream<String> ioNumbers = Stream.of("123", "321", "12345");
//		ioNumbers.forEach(System.out::println);

		Stream<String> concat = Stream.concat(list.stream(), ioNumbers);
		concat.distinct().peek(System.out::println).count();
	}

	public static void bifunctionDemo() {
		BiFunction<Integer, Integer, String> bifc = (Integer i, Integer j) -> i + j + "HEHE BOI";
		System.out.println(bifc.apply(123, 123));
	}

	public static void chainingFunctionsDemo() {
		Function<Integer, String> fc1 = (Integer i) -> i + "";
		Function<String, Integer> fc2 = (String str) -> Integer.parseInt(str) + 10;
		Function<Integer, Integer> chainedFunction = fc1.andThen(fc2);
		System.out.println(chainedFunction.apply(123));
	}

	public static void anotherFunctionalDemo() {
		Function<String, Integer> fc = (String intStr) -> Integer.parseInt(intStr);
		System.out.println(fc.apply("123"));
	}

	public static void functionalInterfaceDemo() {
		new Thread(() -> System.out.println("Printed from a lambda!")).start();
		new Thread(() -> {
			System.out.println("Printed from a lambda again!");
			System.out.println("Printed from a lambda again again!");
		}).start();
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Cary", 12));
		employees.add(new Employee("Cary2", 13));
		employees.add(new Employee("Cary3", 14));
		employees.add(new Employee("Cary4", 15));
		employees.add(new Employee("Cary5", 16));
		Collections.sort(employees, (employee1, employee2) -> employee2.getName().compareTo(employee1.getName()));

		for (Employee employee : employees) {
			System.out.println(employee.getName() + " " + employee.getAge());
		}

		UpperConcat uc = (s1, s2) -> {
//			employees accessible here
			return (s1 + s2).toUpperCase();
		};
		System.out.println(useUpperConcat(uc, employees.get(0).getName(), employees.get(1).getName()));
	}

	public static String useUpperConcat(UpperConcat uc, String s1, String s2) {
		return uc.upperAndCat(s1, s2);
	}
}

@FunctionalInterface
interface UpperConcat {
	String upperAndCat(String s1, String s2);
}
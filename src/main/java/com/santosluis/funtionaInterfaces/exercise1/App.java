package com.santosluis.funtionaInterfaces.exercise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String... args) {
//Basic
/*
1. Function<T, R>
Exercise: Create a list of integers. Use the Function interface to define a function that multiplies each integer by 3.
Apply this function to all elements in the list and print the results.
 */
        List<Integer> integerList = new ArrayList<>(List.of(1, 3, 5, 7, 9));
        Function<Integer, Integer> multiplier = x -> x * 3;
        List<Integer> result1 = integerList.stream().map(multiplier).toList();
        System.out.println(result1);
/*
2. Predicate<T>
Exercise: Create a list of strings. Use the Predicate interface to define a condition that checks if a string has more
than 5 characters. Filter the list to include only strings that meet this condition and print the resulting list.
 */
        List<String> stringList = new ArrayList<>(List.of("Hello", "World","Practice","Always","Never Give up"));
        Predicate<String> filterCondition = text -> text.length() > 6;
        List<String> result2 = stringList.stream().filter(filterCondition).toList();
        System.out.println(result2);

        /*
3. Consumer<T>
Exercise: Create a list of integers. Use the Consumer interface to define an action that prints each integer doubled.
 Apply this consumer to all elements in the list.
 */
        List<Integer> integerList2 = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
        Consumer<Integer> consumer = x -> System.out.println(x * 2);
        integerList2.forEach(consumer);
/*
4. Supplier<T>
Exercise: Use the Supplier interface to provide a default value of type String. Print the value returned by the supplier.
 */
        Supplier<String> getText = () -> "Hello World!!!";
        System.out.println(getText.get());

/*
5. BiFunction<T, U, R>
Exercise: Create a list of integers and another list of strings. Use the BiFunction interface to concatenate each
integer (converted to string) with each string from the two lists. Print the resulting concatenated strings.
 */
        List<Integer> integerList3 = new ArrayList<>(List.of(1,3,5));
        List<String> textList2 = new ArrayList<>(List.of("uno", "tres", "cinco"));
        BiFunction<Integer, String, String> converter = (number, text) -> number + " " + text;
        List<String> concatenatedResults = integerList3.stream()
                .flatMap(num -> textList2.stream().map(word -> converter.apply(num, word)))
                .toList();
        System.out.println(getText.get());        // Print the resulting concatenated strings
        concatenatedResults.forEach(System.out::println);

/*
6. BiPredicate<T, U>
Exercise: Create two lists: one of integers and other of Strings. Use BiPredicate interface to define a
condition that checks if an integer is greater than 10 and if a string starts with "A".
Use este predicado para filtrar pares de elementos que cumplan ambas condiciones y muestra los resultados.
filter the elements that meet both conditions.
*/
        List<Integer> integerList4 = new ArrayList<>(List.of(1,30,8,20));
        List<String> textList3 = new ArrayList<>(List.of("ABC", "CBC", "AEF","AEG"));
        BiPredicate<Integer, String> validator2 = (number, text) -> number>10 && text.startsWith("A");
        List<String> results = integerList4.stream()
                .flatMap(num -> textList3.stream()
                        .filter(str -> validator2.test(num, str))
                        .map(str -> num + " - " + str))
                .toList();
        System.out.println(getText.get());
        results.forEach(System.out::println);

        // todo: More to come




    }

}

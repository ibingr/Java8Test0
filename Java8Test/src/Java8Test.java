import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class Java8Test {

	List<String> mylist = new ArrayList<String>();
	
	public Java8Test(){
		mylist.add("One");
		mylist.add("Two");
		mylist.add("Three");
		mylist.add("Four");
		mylist.add("Five");
		mylist.add("Six");

        mylist.add("Seven");
		
	}
	
	public static void main(String args[]){
		
		new Thread(() -> System.out.println("Hell World")).start();
		
		List<String> mylist0 = new Java8Test().mylist;
		
		
		Collections.sort(mylist0, ((String s1, String s2) -> s1.compareTo(s2)));
	    System.out.println(mylist0);
	    
	    mylist0.forEach(u -> System.out.println(u.substring(0, 2)));
	    
	    mylist0.forEach(System.out::print);
	    System.out.println("\n");
	    
	    long c = mylist0.stream().filter(u -> u.startsWith("T")).count();
	    System.out.println(c);
	    
	    String s = mylist0.stream().filter(u -> u.startsWith("T")).collect(Collectors.toList()).toString();
	    System.out.println(s);

	    new Java8Test().java8format(Java8Test::format0);
	    new Java8Test().java8format(Java8Test::format1);
	    new Java8Test().java8format(Java8Test::format2);
	    
	    double average = new Java8Test().mylist.parallelStream().mapToInt(u -> u.length()).average().getAsDouble();
	    System.out.println(average);
	    
	    
	}
	
	void java8format(Consumer<String> func){
		this.mylist.forEach(u -> func.accept(u));
	}
	static void format0(String str){
	   System.out.println(str.charAt(0));
	}	
	static void format1(String str){
		System.out.println(str.charAt(1));
	}	
	static void format2(String str){
		System.out.println(str.charAt(2));
	}	
}

package src.main;

import src.main.functionality.CodingQuestionsSolution;
import src.main.prepTests.ContractInterface;
import src.main.prepTests.ContractInterfaceImpl;
import src.main.prepTests.SquaringFunctionalInterface;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    //private final static SquaringFunctionalInterface squaring = num -> num * num;

    public static void main(String[] args) throws ExecutionException, InterruptedException {



































        /*
        int number = 11;
        int result = squaring.square(number);
        System.out.println("Square of " + number + " is: " + result);

        // 1️⃣ Using Thread subclass
        MyThread t1 = new MyThread();
        t1.start();

        // 2️⃣ Using Runnable implementation
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        // 3️⃣ Using Runnable with Lambda
        Thread t3 = new Thread(() -> {
            System.out.println("[Lambda Runnable] Running on: " + Thread.currentThread().getName());
        });
        t3.start();

        // 4️⃣ Using Callable (lambda) with Future
            Callable<String> task = () -> {
                return "Result from " + Thread.currentThread().getName();
            };

            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<String> future = executor.submit(task);
            System.out.println(future.get()); // blocks until done
            executor.shutdown();

        // 5️⃣ Using ExecutorService with Fixed Thread Pool
        ExecutorService poolExecutor = Executors.newFixedThreadPool(3);
        for (int i = 10; i <= 15; i++) {
            int taskId = i;
            poolExecutor.execute(() -> {
                System.out.println("[ExecutorService] Task " + taskId + " running on: " + Thread.currentThread().getName());
            });
        }
        poolExecutor.shutdown();



        List<Person> people = new ArrayList<>();

        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 40));
        people.add(new Person("Zeta", 35));
        people.add(new Person("Charlie", 32));
        people.add(new Person("Britney", 54));
        people.add(new Person("Joseph", 26));
        people.add(new Person("Joseph", 28));

        System.out.println("Using collections.sort() OR the Comparable interface with age");
        Collections.sort(people);

        for (Person p : people){
            System.out.print(p.toString() + ", ");
        }
        System.out.println();

        //Ordering using the Comparator interface
        //1. Lambda expression with name ordering
        people.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        System.out.println("Using Comparator lambda expression with natural name ordering:");
        for (Person p : people){
            System.out.print(p.toString() + ", ");
        }
        System.out.println();

        //1.2 Lambda expression with age ordering
        people.sort((p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println("Using Comparator lambda expression with natural age ordering:");
        for (Person p : people){
            System.out.print(p.toString() + ", ");
        }
        System.out.println();

        //2. Method reference with reverse name ordering
        people.sort(Comparator.comparing(Person::getName).reversed()
                .thenComparing((p1,p2) -> p2.getAge() - p1.getAge()));
        System.out.println("Using Comparator.comparing & Method reference with reverse name ordering:");
        for (Person p : people){
            System.out.print(p.toString() + ", ");
        }
        System.out.println();

        //3. Anonymous class with reverse age ordering
        System.out.println("Using Comparator Anonymous class with reverse age ordering:");
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p2.getAge() - p1.getAge();
            }
        });
        for (Person p : people){
            System.out.print(p.toString() + ", ");
        }
        System.out.println(".......................................................");
        System.out.println();

        Map<String, Integer> result = persons.stream()
                .filter(person -> person.getName().startsWith("A"))
                .collect(Collectors.toMap(Person::getName, Person::getAge));

        System.out.println(result);

        Optional<String> name = Optional.of("Java");
        name.ifPresent(System.out::println);

        String json = """
            {
                "name": "Alice",
                "age": 30,
                "Sex": "Female"
            }
            """;
        System.out.println(json);

        
        record Employee (int empId, String name) {}
        Employee e1 = new Employee(1, "Aadil");
        Employee e2 = new Employee(2, "John");
        System.out.println(e1.empId());
        System.out.println(e2);


        String a = new String("test");
        String b = new String("test");
        String c = "test";
        String d = "copy";
        String e = "copy";
        String f = new String("copy").intern();

        System.out.println(a == b);        // false (reference)
        System.out.println(a.equals(b));    //true
        System.out.println(a == c);         //false
        System.out.println(b == c);         //false
        System.out.println(d == e);         //true
        System.out.println(f == e && f == d); // true as f is created in the String-pool and reuses "copy"

        System.out.println("The int division by zero: " + 5.0/0);
        List<String> myList = Arrays.asList("John", "bob", "tresa");
        Map<String, Integer> myMap= myList.stream().collect(Collectors.toMap(s->s, String::length));

        record Book (String title, String author, double price){
            String getAuthor() {
                return author;
            }
        }
        Book book = new Book("Corporate Life", "Aadil", 230.77D);


        Predicate<String> isLongWord = word -> word.length() > 5;
        Map<String, String> cache = new LinkedHashMap<>(128, 0.75F, true);
        //searchSuggestionOnTyping
        String[] products =  {"mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchKey = "mouse";
        CodingQuestionsSolution sol = new CodingQuestionsSolution();
        List<List<String>> res = CodingQuestionsSolution.searchSuggestionOnTyping(products, searchKey);
        for (List<String> ls : res)
            System.out.println(ls);

        //amazonFreshPrizeWinner
        //Fail case
        String[] g1 = {"apple", "apple"};
        String[] g2 = {"apple", "apple", "banana"};
        List<List<String>> codeList = new ArrayList<>();
        codeList.add(Arrays.asList(g1));
        codeList.add(Arrays.asList(g2));
        String[] sc = {"apple", "apple", "apple", "banana"};
        System.out.println("amazonFreshPrizeWinner:" + CodingQuestionsSolution.amazonFreshPrizeWinner(codeList, Arrays.asList(sc)));
        //Pass case
        String[] g3 = {"apple", "apple"};
        String[] g4 = {"banana", "anything", "banana"};
        List<List<String>> codeList2 = new ArrayList<>();
        codeList.add(Arrays.asList(g3));
        codeList.add(Arrays.asList(g4));
        String[] sc2 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        System.out.println("amazonFreshPrizeWinner:" + CodingQuestionsSolution.amazonFreshPrizeWinner(codeList2, Arrays.asList(sc2)));

        //Amazon Logistics getTotalImbalance()
        System.out.println("Total weight Imbalance:" + CodingQuestionsSolution.getTotalImbalance(new int[]{1,2,3}));

        //Sum of available Good Ranges
        System.out.println("Sum of left&right values of good ranges:" + CodingQuestionsSolution.calculateGoodRanges(10, new int[]{2,7,5,9,6,1,8,10,3,4}));
*/
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable running: " + Thread.currentThread().getName());
    }
}


class Person implements Comparable<Person> {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    //Only one type of ordering; need to override this method if the class implements Comparable
    @Override
    public int compareTo(Person other) {
        return this.age - other.age;
    }
}

import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MacIntosh {

    public static void main(String[] args) {

        //la Method run of Runnable does not take any argument
        //that's why the first parenthesis is empty

/*

        Thread myLambdaThread = new Thread ( () -> System.out.println("Print my first thread using lambda expression"));
        myLambdaThread.run();
*/
        List<Person> people;
        people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carrol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

/*

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getLastName().compareTo(p2.getLastName());
            }
        });
*/

        //Step 2: Create a method that prints all elements in the list
//       printAll(people);



        //Step3: Create a method that prints all people that have last name beginning with C
        //printLastNameBeginningWithC(people);


    /**
     *   printConditionally(people, new Condition() {
     *       @Override
     *       public boolean test(Person p) {
     *           return p.getLastName().startsWith("C");
     *       }
     *   });
     */
        printConditionally(people, (p) ->  p.getLastName().startsWith("C")  );


/*
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getFirstName().startsWith("C");
            }
        });
*/
        printConditionally(people, p -> p.getLastName().startsWith("C") );

    }  //end Main()


/*

    public static void printAll(List<Person> people) {
        for(Person p : people) {
            System.out.println(p);
        }
    }
*/

    public static void printConditionally(List<Person>people, Condition condition) {
        for(Person p : people) {
            if (condition.test(p)) {
                System.out.println(p);
            }
        }
    }

/*

    public static void printLastNameBeginningWithC(List<Person> people) {
        for(Person p : people) {
            if (p.getLastName().startsWith("C"))
                System.out.println(p);
        }
    }
*/


}

@FunctionalInterface
interface Condition {
    boolean test(Person p);
}
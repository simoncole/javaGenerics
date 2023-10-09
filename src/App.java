import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        testArrayStack();

        removeDuplicatesDriver();

        assertNumberInRange();
    }

    public static void assertNumberInRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 0 and 10: ");

        try {
            int num = scanner.nextInt();
            assert num >= 0 && num <= 10: "Value should be in the range of 0 and 10";
            System.out.println("The number you entered was: " + num);
        }
        catch(InputMismatchException e) {
            System.out.println("The input provided was not an integer");
        }
        catch (AssertionError e) {
            System.out.println(e);
        }
        scanner.close();
    }

    public static void removeDuplicatesDriver() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(24);
        list.add(14);
        list.add(42);
        list.add(25);

        ArrayList<Integer> newList = removeDuplicates(list);

        System.out.println(newList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        HashSet<E> previousElemnts = new HashSet<E>();

        for(int i = 0; i < list.size(); i++) {
            if(previousElemnts.contains(list.get(i))) {
                list.remove(i);
            }
            else {
                previousElemnts.add(list.get(i));
            }
        }

        return list;
    }

    public static void testArrayStack() {
    GenericStack<Integer> stack = new GenericStack<>(3);
    
    // test pushing and popping integers
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assert stack.pop() == 3;
    assert stack.pop() == 2;
    assert stack.pop() == 1;
    assert stack.isEmpty();
    
    // test pushing and popping null values
    stack.push(null);
    assert stack.pop() == null;
    assert stack.isEmpty();
    
    // test pushing and popping strings
    GenericStack<String> stringStack = new GenericStack<>();
    stringStack.push("hello");
    stringStack.push("world");
    assert stringStack.pop().equals("world");
    assert stringStack.pop().equals("hello");
    assert stringStack.isEmpty();
    
    // test pushing and popping doubles
    GenericStack<Double> doubleStack = new GenericStack<>();
    doubleStack.push(3.14);
    doubleStack.push(2.71);
    assert doubleStack.pop() == 2.71;
    assert doubleStack.pop() == 3.14;
    assert doubleStack.isEmpty();
    
    // test pushing more elements than the initial capacity
    for (int i = 0; i < 10; i++) {
        stack.push(i);
    }
    for(int i = 9; i >= 0; i--) {
        assert stack.pop() == i;
    }
    assert stack.isEmpty();
    
    // test popping from an empty stack
    try {
        stack.pop();
        assert false;
    } catch (EmptyStackException e) {
        assert true;
    }
    
    // test checking if an empty stack is empty
    assert stack.isEmpty();
    
    // test checking if a non-empty stack is empty
    stack.push(1);
    assert !stack.isEmpty();
    
    System.out.println("All tests passed!");
}
}

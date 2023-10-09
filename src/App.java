import java.util.EmptyStackException;

public class App {
    public static void main(String[] args) {
        testArrayStack();

        
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
    assert stack.pop() == 9;
    assert stack.pop() == 8;
    assert stack.pop() == 7;
    assert stack.pop() == 6;
    assert stack.pop() == 5;
    assert stack.pop() == 4;
    assert stack.pop() == 3;
    assert stack.pop() == 2;
    assert stack.pop() == 1;
    assert stack.pop() == 0;
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

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Stack<Integer> stack=new Stack<>();
        stack.push(32);
        stack.push(4);
        stack.push(7);
        stack.push(82);
        stack.push(13);
        stack.push(55);

        System.out.println(stack.pop());

        System.out.println(stack.pop());
        System.out.println(stack.pop());

  //Queue
        Queue<Integer>queue=new LinkedList<>();
        queue.add(3);
        queue.add(6);
        queue.add(34);
        queue.add(98);
        queue.add(67);
        queue.add(41);
        queue.add(56);

        System.out.println(queue.remove());
        System.out.println(queue.remove());


        Deque<Integer>deque=new ArrayDeque<>();
        deque.add(89);
        deque.add(32);
        deque.removeFirst();

    }
}
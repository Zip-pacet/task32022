import ourqueue.SimpleLinkedList;
import ourqueue.SimpleLinkedListQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Mamapopa {

    public static int stepToEmpty(Queue<Integer> x, Queue<Integer> y){
        int count = 0;
        boolean isNotEmpty = true;
        int sum = 0;

        while (isNotEmpty){
            if (x.isEmpty() || y.isEmpty()){
                isNotEmpty = false;
                break;
            }

            if(x.peek() < y.peek()){
                sum = x.peek() + y.peek();
                x.add(sum);
                x.remove(x.peek());
                y.remove(y.peek());
                sum = 0;
                count += 1;
            }

            if (x.isEmpty() || y.isEmpty()){
                isNotEmpty = false;
                break;
            }

            if (x.peek() > y.peek()){
                sum = x.peek() - y.peek();
                y.add(sum);
                x.remove(x.peek());
                y.remove(y.peek());
                sum = 0;
                count += 1;
            }

            if(x.peek() == y.peek()){
                x.remove(x.peek());
                y.remove(y.peek());
                count += 1;
            }





        }

        return count;
    }

    public static int stepToEmpty(SimpleLinkedListQueue x, SimpleLinkedListQueue y) {
        int count = 0;
        boolean isNotEmpty = true;
        int sum = 0;
        try {


        while (isNotEmpty) {
            if (x.empty() || y.empty()) {
                isNotEmpty = false;
                break;
            }

            if (x.element() < y.element()) {
                sum = x.element() + y.element();
                x.add(sum);
                x.removeFirst();
                y.removeFirst();
                sum = 0;
                count += 1;
            }

            if (x.empty() || y.empty()) {
                isNotEmpty = false;
                break;
            }

            if (x.element() > y.element()) {
                sum = x.element() - y.element();
                y.add(sum);
                x.removeFirst();
                y.removeFirst();
                sum = 0;
                count += 1;
            }

            if (x.element() == y.element()) {
                x.removeFirst();
                y.removeFirst();
                count += 1;
            }

        }

        } catch (SimpleLinkedList.SimpleLinkedListException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }


}

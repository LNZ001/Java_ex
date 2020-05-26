import java.util.ArrayDeque;

public class Solution {

    public static void main(String[] args){
        String[] str = {"4","13","5","/","+"};
        System.out.println(evalRPN(str));
    }

    public static int evalRPN(String[] tokens) {
        ArrayDeque<Integer> deque = new ArrayDeque<>(); // 双端队列

        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int v1 = deque.pollLast();
                    int v2 = deque.pollLast();
                    int value = v2 + v1;
                    deque.add(value);
                    break;
                }
                case "-" -> {
                    int v1 = deque.pollLast();
                    int v2 = deque.pollLast();
                    int value = v2 - v1;
                    deque.add(value);
                    break;
                }
                case "*" -> {
                    int v1 = deque.pollLast();
                    int v2 = deque.pollLast();
                    int value = v2 * v1;
                    deque.add(value);
                    break;
                }
                case "/" -> {
                    int v1 = deque.pollLast();
                    int v2 = deque.pollLast();
                    int value = v2 / v1;
                    deque.add(value);
                    break;
                }
                default -> {
                    int value = Integer.parseInt(token);
                    deque.add(value);
                }
            }
        }
        return deque.pop();
    }
}


package cs.vsu.ru.lyashenko_e_v;

import java.util.Scanner;

public class Main {

    private static class Node {
        int num;
        Node next;

        public Node(int i) {
            num = i; next = null;
        }
    }

    private static class Circle {
        Node first = null;

        public void addAfter(int n) {
            Node newNode = new Node(n);
            if (first == null) {
                first = newNode.next = newNode;
            } else {
                newNode.next = first.next;
                first.next = newNode;
            }
            first = newNode;
        }

        public void shift() {
            if (first != null) {
                first = first.next;
            }
        }

        public boolean isEmpty() { return first == null; }
        public boolean isSingle() { return first != null && first.next == first; }

        public void countKids() {
            if (first != null && first.next != first) {
                first.next = first.next.next;
                first = first.next;
            }
        }
    }

    public static int Counter(int n) {
        assert n > 0;
        Circle people = new Circle();
        for (int i = 1; i <= n; ++i) {
            people.addAfter(i);
        }
        people.shift();
        while (!people.isSingle()) {
            people.countKids();
        }
        return people.first.num;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число: ");
        double s = input.nextInt();
        System.out.println("Номер последнего оставшегося в круге: " + Counter((int) s));
    }
}

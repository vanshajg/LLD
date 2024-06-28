package javaCollectionsFramework.queue_examples;

import java.util.Comparator;
import java.util.PriorityQueue;

record Node(int val) {
}

public class PriorityQueueExample {
    public static void main(String[] args) {
        final PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::val));
        pq.add(new Node(1));
        pq.add(new Node(2));
        pq.add(new Node(-1));
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().val());
        }

    }
}

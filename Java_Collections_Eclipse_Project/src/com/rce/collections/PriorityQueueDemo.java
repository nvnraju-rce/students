package com.rce.collections;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(50);
        queue.add(10);
        queue.add(30);
        queue.add(20);

        System.out.println("Priority order:");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

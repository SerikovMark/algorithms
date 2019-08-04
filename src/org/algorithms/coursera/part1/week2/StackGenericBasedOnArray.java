package org.algorithms.coursera.part1.week2;

import java.util.Arrays;

public class StackGenericBasedOnArray<T> implements StackGeneric<T> {

    private final static int DEFAULT_STACK_SIZE = 2;
    private final static int SIZE_MULTIPLIER = 2;

    private T[] stack;
    private int currentIndex = -1;

    public StackGenericBasedOnArray() {
        this.stack = (T[])new Object[DEFAULT_STACK_SIZE];
    }

    @Override
    public void push(T item) {
        if (currentIndex >= stack.length - 1) {
            stack = Arrays.copyOf(stack, stack.length * SIZE_MULTIPLIER);
        }
        currentIndex++;
        stack[currentIndex] = item;
    }

    @Override
    public T pop() {
        if (currentIndex == -1) return null;
        T item = stack[currentIndex];
        stack[currentIndex] = null;
        currentIndex--;
        if (currentIndex > DEFAULT_STACK_SIZE && currentIndex <= stack.length / 4) {
            stack = Arrays.copyOf(stack, stack.length / SIZE_MULTIPLIER);
        }
        return item;
    }

    @Override
    public T peek() {
        return stack[currentIndex];
    }

    @Override
    public boolean isEmpty() {
        return currentIndex == -1;
    }

    @Override
    public int size() {
        return currentIndex + 1;
    }
}

package com.vanshajgirotra.multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class SearchTask extends RecursiveTask<Integer> {

    private final int[] arr;
    private final int start;
    private final int end;
    private final int searchElement;
    private final int base_threshold = 3;

    @Override
    protected Integer compute() {
        int size = end - start + 1;
        if (size <= base_threshold) {
            return processSearch();
        }
        int mid = (end + start) / 2;
        SearchTask task1 = new SearchTask(arr, start, mid, searchElement);
        SearchTask task2 = new SearchTask(arr, mid + 1, end, searchElement);
        task1.fork();
        task2.fork();
        return task1.join() + task2.join();
    }

    private Integer processSearch() {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] == searchElement) {
                count++;
            }
        }
        return count;
    }
}

public class ForkJoinTaskExample {

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 6};
        int start = 0;
        int end = arr.length - 1;
        int searchElement = 6;

        ForkJoinPool pool = ForkJoinPool.commonPool();
        SearchTask searchTask = new SearchTask(arr, start, end, searchElement);
        int result = pool.invoke(searchTask);
        System.out.println(result);
    }
}

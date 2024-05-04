package com.vanshajgirotra.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
class SumCalculatorTask implements Callable<Integer> {

    private final int[] arr;
    private final int startIdx;
    private final int endIdx;

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            sum += arr[i];
        }
        return sum;
    }
}

@Slf4j
public class ParallelSum {

    public static void main(String[] args) {
        final int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        final int blockSize = 3;
        final int numberOfBlocks = (int) Math.ceil((double) arr.length / blockSize);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        int startIdx = 0;
        int endIdx;
        List<Future<Integer>> intSumFutures = new ArrayList<>();
        for (int i = 0; i < numberOfBlocks; i++) {
            endIdx = startIdx + blockSize - 1;
            if (endIdx >= arr.length) {
                endIdx = arr.length - 1;
            }
            var future = executorService.submit(new SumCalculatorTask(
                    arr,
                    startIdx,
                    endIdx
            ));
            intSumFutures.add(future);
            startIdx += blockSize;
        }

        int totalSum = 0;
        for (Future<Integer> future : intSumFutures) {
            totalSum += getComputedValue(future);
        }
        log.info("sum: {}", totalSum);

        executorService.shutdown();

    }

    private static int getComputedValue(Future<Integer> future) {
        while (!future.isDone()) {
            Thread.yield();
        }
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            log.error("exception: {}", e.getMessage());
            return 0;
        }
    }
}

package com.vanshajgirotra.multithreading;

import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.Data;

@Data
class ScheduledTask implements Comparable<ScheduledTask> {

    private Runnable task;
    private TaskType taskType;
    private Long period;
    private Long delay;
    private Long scheduledTime;

    @Override
    public int compareTo(ScheduledTask o) {
        return Long.compare(scheduledTime, o.scheduledTime);
    }
}

enum TaskType {
    ONCE,
    FIXED_DELAY,
    FIXED_RATE
}

public class CustomExecutorService {

    private final PriorityQueue<ScheduledTask> tasks = new PriorityQueue<>();
    private ExecutorService executorService;

    public CustomExecutorService(int threadCount) {
        executorService = Executors.newFixedThreadPool(threadCount);
    }

    public void start() {
        var queue = new PriorityQueue<Integer>();
        queue.poll();
    }

    /**
     * Creates and executes a one-shot action that becomes enabled after the given delay.
     */
    public void schedule(Runnable command, long delay, TimeUnit unit) {
    }

    /**
     * Creates and executes a periodic action that becomes enabled first after the given initial delay, and
     * subsequently with the given period; that is executions will commence after initialDelay then
     * initialDelay+period, then initialDelay + 2 * period, and so on.
     */
    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
    }

    /*
     * Creates and executes a periodic action that becomes enabled first after the given initial delay, and
     * subsequently with the given delay between the termination of one execution and the commencement of the next.
     */
    public void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
    }
}

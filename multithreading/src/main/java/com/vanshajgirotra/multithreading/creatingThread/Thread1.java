package com.vanshajgirotra.multithreading.creatingThread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Thread1 extends Thread {

    // this is the method that will be called when the thread is started.
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            log.info("from thead:{} ctr={}", Thread.currentThread(), i);
        }
    }
}

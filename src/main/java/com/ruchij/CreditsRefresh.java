package com.ruchij;

import java.util.Timer;
import java.util.TimerTask;

public class CreditsRefresh {
    public void solve() throws InterruptedException {
        Timer timer = new Timer();

        TimerTask timerTask =
                new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Hello World");
                    }
                };

        timer.scheduleAtFixedRate(timerTask, 0, 1000);
        Thread.sleep(10000);
        timer.cancel();
    }
}

package Tests;

import java.util.Random;

public class UtilMethods {
    public static void log(String s) {
        System.out.println("[" + Thread.currentThread().getName() + "] " + s);
    }

    public static void simulateHardWork() {
        try {
            int waitTime = 1000 + new Random().nextInt(10) * 1000;
            Thread.sleep(waitTime);
        } catch (InterruptedException ignored) {
        }
    }
}

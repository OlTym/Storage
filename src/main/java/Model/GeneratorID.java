package Model;

import java.util.concurrent.TimeUnit;

class GeneratorID {

    private static final long MICRO_IN_MILL = 1000;
    private static final long NANO_IN_MICRO = 1000;
    private static long baseNanoTime;
    private static long baseTimeInMicro;
    private static long lastGuid;

    static {
        baseNanoTime = System.nanoTime();
        baseTimeInMicro = System.currentTimeMillis() * MICRO_IN_MILL;
        lastGuid = baseTimeInMicro;
    }

    static int newGuid() {
        long newGuid;
        while ((newGuid = calNewTimeInMicro()) <= lastGuid) {

            try {
                TimeUnit.MICROSECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lastGuid = newGuid;
        return (int) newGuid;
    }

    private static long calNewTimeInMicro() {
        return baseTimeInMicro + ((System.nanoTime() - baseNanoTime) / NANO_IN_MICRO);
    }

}






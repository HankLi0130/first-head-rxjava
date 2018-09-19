package tw.hankli.ch4_4;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        int result = 0;

        for (int i = 0; i < 99; i++) {
            result += i;
        }

        return result;
    }
}

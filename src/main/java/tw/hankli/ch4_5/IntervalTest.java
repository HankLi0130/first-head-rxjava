package tw.hankli.ch4_5;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class IntervalTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        fromInterval()
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println("onNext " + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.err.println("onError " + e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                        latch.countDown();
                    }
                });

        latch.await();
    }

    private static Observable<Long> fromInterval() {
        return Observable.interval(1L, TimeUnit.SECONDS);
    }

    private static Observable<Long> fromIntervalRange() {
        return Observable.intervalRange(10L, 10L, 3L, 1L, TimeUnit.SECONDS);
    }
}

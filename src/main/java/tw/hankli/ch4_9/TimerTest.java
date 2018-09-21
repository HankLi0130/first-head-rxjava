package tw.hankli.ch4_9;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TimerTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        fromTimer().subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("onNext " + aLong);
            }

            @Override
            public void onError(Throwable e) {
                System.err.println("Error " + e);
            }

            @Override
            public void onComplete() {
                latch.countDown();
                System.out.println("onComplete");
            }
        });

        latch.await();
    }

    private static Observable<Long> fromTimer() {
        return Observable.timer(3, TimeUnit.SECONDS, Schedulers.io());
    }
}

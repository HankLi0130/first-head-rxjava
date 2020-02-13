package tw.hankli.ch4_8;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Function;
import tw.hankli.ch4_6.JustTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RepeatTest {

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        fromRepeat().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                System.err.println("Error " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
                latch.countDown();
            }
        });
        latch.await();
    }

    private static Observable<Integer> fromRepeat() {
        return JustTest.fromJust()
                .repeat(3);
    }

    private static Observable<Integer> fromRepeatUntil() {

        return JustTest.fromJust()
                .repeatUntil(new BooleanSupplier() {
                    @Override
                    public boolean getAsBoolean() throws Exception {
                        return true;
                    }
                });
    }

    private static Observable<Integer> fromRepeatWhen() {

        return JustTest.fromJust().repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Object> objectObservable) throws Exception {

                return objectObservable.delay(3, TimeUnit.SECONDS);
            }
        });
    }
}

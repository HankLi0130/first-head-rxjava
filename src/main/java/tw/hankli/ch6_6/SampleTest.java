package tw.hankli.ch6_6;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class SampleTest {

    public static void main(String[] args) {

        fromSample().subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.err.println("Error " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    private static Observable<String> fromSample() {

        Observable<String> o1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("A");
                Thread.sleep(70);

                emitter.onNext("B");
                Thread.sleep(50);

                emitter.onNext("C");
                Thread.sleep(20);

                emitter.onNext("D");
                Thread.sleep(65);

                emitter.onNext("E");
                Thread.sleep(20);

                emitter.onComplete();
            }
        });

        return o1.sample(100, TimeUnit.MILLISECONDS, true);
    }
}

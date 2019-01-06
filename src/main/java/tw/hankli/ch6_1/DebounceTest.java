package tw.hankli.ch6_1;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class DebounceTest {

    public static void main(String[] args) throws InterruptedException {

        fromDebounce().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer i) {
                System.out.println("onNext " + i);
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

    private static Observable<Integer> fromDebounce() {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                Thread.sleep(505);
                emitter.onNext(2);
                Thread.sleep(405);
                emitter.onNext(3);
                Thread.sleep(100);
                emitter.onNext(4);
                Thread.sleep(605);
                emitter.onNext(5);
                Thread.sleep(510);
                emitter.onComplete();
            }
        })
                /** Debounce Operator */
                .debounce(500, TimeUnit.MILLISECONDS);
    }
}

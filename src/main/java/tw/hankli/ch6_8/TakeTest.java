package tw.hankli.ch6_8;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TakeTest {
    public static void main(String[] args) {

        fromTakeLast().subscribe(new Observer<Integer>() {
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

    private static Observable<Integer> getObservable() {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(0);
                Thread.sleep(1000);
                emitter.onNext(1);
                Thread.sleep(1000);
                emitter.onNext(2);
                Thread.sleep(1000);
                emitter.onNext(3);
                Thread.sleep(1000);
                emitter.onNext(4);
                Thread.sleep(1000);
                emitter.onComplete();
            }
        });
    }

    private static Observable<Integer> fromTake() {
        return getObservable()
                .take(2);
//                .take(1500, TimeUnit.MILLISECONDS);
    }

    private static Observable<Integer> fromTakeLast() {
        return getObservable()
                .takeLast(2);
//                .takeLast(1500, TimeUnit.MILLISECONDS);
    }
}

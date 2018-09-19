package tw.hankli.ch4_3;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class EmptyNeverThrowTest {

    public static void main(String[] args) {
        fromThrow().subscribe(new Observer<Long>() {
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
            }
        });
    }

    public static Observable<Long> fromEmpty() {
        return Observable.empty();
    }

    public static Observable<Long> fromNever() {
        return Observable.never();
    }

    public static Observable<Long> fromThrow() {
        return Observable.error(new Exception("exception!!"));
    }
}

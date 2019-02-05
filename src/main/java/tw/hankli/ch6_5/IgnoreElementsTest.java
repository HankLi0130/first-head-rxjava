package tw.hankli.ch6_5;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class IgnoreElementsTest {

    public static void main(String[] args) {

        fromIgnoreElements().subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }

            @Override
            public void onError(Throwable e) {
                System.err.println("Error " + e);
            }
        });
    }

    private static Completable fromIgnoreElements() {
        return Observable.range(0, 10)
                .ignoreElements();
    }
}

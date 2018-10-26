package tw.hankli.ch5_6;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class WindowTest {

    public static void main(String[] args) {

        fromWindow().subscribe(new Observer<Observable<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Observable<Integer> observable) {
                System.out.println("onNext ");

                observable.subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("Window onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(observable.hashCode() + " Window onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.err.println("Window onError " + e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Window onComplete");
                    }
                });
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

    private static Observable<Observable<Integer>> fromWindow() {
        return Observable.range(0, 10)
                .window(2, 1);
    }
}

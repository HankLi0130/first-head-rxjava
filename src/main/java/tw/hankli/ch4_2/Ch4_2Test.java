package tw.hankli.ch4_2;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import tw.hankli.ch4_1.Ch4_1Test;

import java.util.concurrent.Callable;

public class Ch4_2Test {

    public static void main(String[] args) {

        fromDefer().subscribe(new Observer<Long>() {
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
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    public static Observable<Long> fromDefer() {
        return Observable.defer(new Callable<ObservableSource<? extends Long>>() {
            @Override
            public ObservableSource<? extends Long> call() throws Exception {
                return Ch4_1Test.fromCreate();
            }
        });
    }
}

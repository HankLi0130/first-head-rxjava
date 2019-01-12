package tw.hankli.ch6_2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;


public class DistinctTest {

    public static void main(String[] args) {

        fromDistinct().subscribe(new Observer<Integer>() {
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

    private static Observable<Integer> fromDistinct() {
        return Observable.just(1, 2, 1, 1, 2, 3)
                .distinct(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer % 2;
                    }
                });
    }

    private static Observable<Integer> fromDistinctUntilChanged() {

        return Observable.just(6, 8, 6, 6, 8, 8)
                .distinctUntilChanged();
    }
}

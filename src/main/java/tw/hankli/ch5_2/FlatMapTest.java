package tw.hankli.ch5_2;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class FlatMapTest {

    public static void main(String[] args) {

        fromFlatMap().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integers) {
                System.out.println("onNext " + integers.toString());
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

    private static Observable<Integer> fromFlatMap() {
        return Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .flatMap(new Function<Integer, ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> apply(Integer integer) throws Exception {
                        return Observable.just(integer * 10, integer * 100, integer * 1000);
                    }
                });
    }
}

package tw.hankli.ch5_4;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class MapTest {

    public static void main(String[] args) {

        fromMap().subscribe(new Observer<Integer>() {
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

    private static Observable<Integer> fromMap() {
        return Observable.range(0, 10)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer * 100;
                    }
                });
    }
}

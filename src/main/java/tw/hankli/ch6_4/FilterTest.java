package tw.hankli.ch6_4;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;

public class FilterTest {

    public static void main(String[] args) {

        fromFilter().subscribe(new Observer<Integer>() {
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

    private static Observable<Integer> fromFilter() {

        return Observable.range(1, 10)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer % 2 == 1;
                    }
                });
    }
}

package tw.hankli.ch6_3;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class ElementAtTest {

    public static void main(String[] args) {

        fromElementAt1().subscribe(new MaybeObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onSuccess(Integer i) {
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

//        fromElementAt2().subscribe(new SingleObserver<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                System.out.println("onSubscribe");
//            }
//
//            @Override
//            public void onSuccess(Integer i) {
//                System.out.println("onNext " + i);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                System.err.println("Error " + e);
//            }
//        });
    }

    private static Maybe<Integer> fromElementAt1() {
        return Observable.just(88, 77, 66)
                .elementAt(3);
    }

    private static Single<Integer> fromElementAt2() {
        return Observable.just(88, 77, 66)
                .elementAt(3, 101);
    }

    private static Single<Integer> fromElementAtOrError() {
        return Observable.just(88, 77, 66)
                .elementAtOrError(3);
    }
}

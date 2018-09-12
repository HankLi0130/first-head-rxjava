package tw.hankli.ch3_3;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Ch3_3Test {

    public static void main(String[] args) {

        Observable.just(2, 3, 4, 5, 6, 7, 8, 9)
                .filter(integer -> integer > 5)
                .map(integer -> integer * 10)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError " + e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }
}

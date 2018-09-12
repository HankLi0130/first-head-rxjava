package tw.hankli.ch3_2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Ch3_2Test {

    public static void main(String[] args) {

        Observable.just("10", "World")
                .map(s -> Integer.valueOf(s))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer s) {
                        System.out.println("onNext " + s);
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

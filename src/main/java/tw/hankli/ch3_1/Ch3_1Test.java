package tw.hankli.ch3_1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Ch3_1Test {

    public static void main(String[] args) {

        Observable.just("Hello", "World")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
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

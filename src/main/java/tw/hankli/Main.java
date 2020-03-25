package tw.hankli;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        // https://proandroiddev.com/exploring-rxjava-in-android-operators-for-combining-observables-25734080f4be
        Observable<Integer> a = Observable.just(1, 2, 3, 4, 5);
        Observable<Character> b = Observable.just('A', 'B', 'C', 'D', 'E');

        a.join(
                b,
                o -> Observable.timer(20, TimeUnit.SECONDS),
                o -> Observable.timer(10, TimeUnit.SECONDS),
                (num, chr) -> {
                    System.out.println("number: " + num + ", character: " + chr);
                    return num.toString() + chr;
                }
        ).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        Thread.sleep(1000);
    }
}

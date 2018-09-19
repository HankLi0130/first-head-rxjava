package tw.hankli.ch4_2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DeferTest {

    public static void main(String[] args) {

        MyClass myObject = new MyClass();

        Observable<String> observable = myObject.valueObservable();

        myObject.setValue("Hank");

        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String name) {
                System.out.println("onNext " + name);
            }

            @Override
            public void onError(Throwable e) {
                System.err.println("onError " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}

package tw.hankli.ch4_1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Ch4_1Test {

    public static void main(String[] args) {

        fromCreate().subscribe(new Observer<Integer>() {
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
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    private static Observable<Integer> fromCreate() {

        return Observable.create(emitter -> {

            try {
                for (int i = 0; i < 5; i++) {
                    if (!emitter.isDisposed()) {
                        emitter.onNext(i);
                    }
                }

                emitter.onComplete();

            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }
}

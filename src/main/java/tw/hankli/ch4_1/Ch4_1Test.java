package tw.hankli.ch4_1;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.Calendar;

public class Ch4_1Test {

    public static void main(String[] args) {

        fromCreate().subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Long along) {
                System.out.println("onNext " + along);
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

    public static Observable<Long> fromCreate() {
        return Observable.create(
                new ObservableOnSubscribe<Long>() {
                    @Override
                    public void subscribe(ObservableEmitter<Long> emitter) throws Exception {

                        for (int i = 0; i < 3; i++) {

                            if (!emitter.isDisposed()) {
                                emitter.onNext(Calendar.getInstance().getTimeInMillis());
                            }
                        }

                        emitter.onComplete();
                    }
                });
    }
}

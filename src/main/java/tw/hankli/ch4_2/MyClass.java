package tw.hankli.ch4_2;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

import java.util.concurrent.Callable;

public class MyClass {

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public Observable<String> valueObservable() {
        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                return Observable.just(MyClass.this.value);
            }
        });
    }
}

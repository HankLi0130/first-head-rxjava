package tw.hankli.ch5_5;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

import java.util.concurrent.Callable;

public class ScanTest {

    public static void main(String[] args) {

        fromScan().subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String str) {
                System.out.println("onNext " + str);
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

    private static Observable<String> fromScan() {
        return Observable.just("How", "are", "you")
                .scan("Hi,", new BiFunction<String, String, String>() {
                    @Override
                    public String apply(String str1, String str2) throws Exception {
                        return str1 + " " + str2;
                    }
                });
    }

    private static Observable<String> fromScanWith() {
        return Observable.just("How", "are", "you")
                .scanWith(new Callable<String>() {
                              @Override
                              public String call() throws Exception {
                                  return "Hi,";
                              }
                          },
                        new BiFunction<String, String, String>() {
                            @Override
                            public String apply(String s, String s2) throws Exception {
                                return s + " " + s2;
                            }
                        });
    }
}

package tw.hankli.ch5_1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class BufferTest {

    public static void main(String[] args) {

        fromBufferCount().subscribe(new Observer<List<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(List<Integer> integers) {
                System.out.println("onNext " + integers.toString());
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

    private static Observable<List<Integer>> fromBufferCount() {
        return Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .buffer(3, 2, new Callable<List<Integer>>() {
                    @Override
                    public List<Integer> call() throws Exception {

                        List<Integer> list = new ArrayList<>();

                        list.add(99);
                        list.add(98);

                        return list;
                    }
                });
    }
}



package tw.hankli.ch4_4;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FromTest {

    public static void main(String[] args) {

        fromFuture().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext " + Thread.currentThread().getName());
                System.out.println("onNext " + integer);
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

        System.out.println("Main " + Thread.currentThread().getName());
    }

    private static Observable<Integer> fromArray() {

        Integer[] intArr = new Integer[]{1, 2, 3, 4, 5};

        return Observable.fromArray(intArr);
    }

    private static Observable<Integer> fromCallable() {

        return Observable.fromCallable(new MyCallable());
    }

    private static Observable<Integer> fromFuture() {

        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<Integer> future = service.submit(new MyCallable());

        service.shutdown();

        return Observable.fromFuture(future, Schedulers.io());
    }

    private static Observable<Integer> fromIterable() {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        return Observable.fromIterable(list);
    }
}

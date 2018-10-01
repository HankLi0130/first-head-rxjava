package tw.hankli.ch5_3;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

public class GroupByTest {

    public static void main(String[] args) {

        fromGroupBy().subscribe(new Observer<GroupedObservable<Boolean, Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(GroupedObservable<Boolean, Integer> booleanIntegerGroupedObservable) {

                if (booleanIntegerGroupedObservable.getKey()) {
                    booleanIntegerGroupedObservable.subscribe(new Observer<Integer>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            System.out.println("Group onSubscribe");
                        }

                        @Override
                        public void onNext(Integer integer) {
                            System.out.println("Group onNext " + integer);
                        }

                        @Override
                        public void onError(Throwable e) {
                            System.err.println("Group onError " + e);
                        }

                        @Override
                        public void onComplete() {
                            System.out.println("Group onComplete");
                        }
                    });
                }

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

    private static Observable<GroupedObservable<Boolean, Integer>> fromGroupBy() {

        return Observable.range(1, 10)
                .groupBy(new Function<Integer, Boolean>() {
                    @Override
                    public Boolean apply(Integer integer) throws Exception {
                        return integer % 2 == 0;
                    }
                }, new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer * 10;
                    }
                });
    }
}

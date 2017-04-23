package com.rafakob.androidutils.rx;

import org.reactivestreams.Publisher;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;


public class RxSchedulers {
    public static <T> ObservableTransformer<T, T> io() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> ObservableTransformer<T, T> computation() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> SingleTransformer<T, T> ioSingle() {
        return new SingleTransformer<T, T>() {
            @Override
            public SingleSource<T> apply(Single<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> SingleTransformer<T, T> computationSingle() {
        return new SingleTransformer<T, T>() {
            @Override
            public SingleSource<T> apply(Single<T> observable) {
                return observable
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> CompletableTransformer ioCompletable() {
        return new CompletableTransformer() {
            @Override
            public CompletableSource apply(Completable observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> CompletableTransformer computationCompletable() {
        return new CompletableTransformer() {
            @Override
            public CompletableSource apply(Completable observable) {
                return observable
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> FlowableTransformer<T, T> ioFlowable() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> FlowableTransformer<T, T> computationFlowable() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
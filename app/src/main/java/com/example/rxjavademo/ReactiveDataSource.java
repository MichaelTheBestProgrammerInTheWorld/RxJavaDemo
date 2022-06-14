package com.example.rxjavademo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public class ReactiveDataSource {

    public Observable<String> getObservableList() {
        List<String> createdList = new ArrayList<>();
        createdList.add("D");
        createdList.add("E");
        createdList.add("F");
        return Observable.fromIterable(createdList);
    }

    public Single<List<String>> getSingleList() {
        List<String> createdList = new ArrayList<>();
        createdList.add("G");
        createdList.add("H");
        createdList.add("I");
        return Single.just(createdList);
    }

    public Maybe<String> getMaybeString() {
        return Maybe.just("s");
    }

    public Maybe<String> getMaybeEmpty() {
        return Maybe.empty();
    }

    public Completable getCompletable(){
        return Completable.complete();
    }
}

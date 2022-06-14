package com.example.rxjavademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.CompletableObserver
import io.reactivex.MaybeObserver
import io.reactivex.SingleObserver
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create an object from reactive data source
        val reactiveDataSource = ReactiveDataSource()

        //implement observable
        reactiveDataSource.observableList.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<String> {

                override fun onComplete() {
                    Log.d(TAG,"observable list - onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG,"observable list - onSubscribe")

                }

                override fun onNext(t: String) {
                    Log.d(TAG,"observable list - onNext $t")

                }

                override fun onError(e: Throwable) {
                    Log.d(TAG,"observable list - onError ${e.message}")

                }
            })

        //implement single
        reactiveDataSource.singleList.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :SingleObserver<List<String>>{

                override fun onSuccess(t: List<String>) {
//                    for(oneString in t){
//
//                    }
                    Log.d(TAG,"single list - onSuccess ${t}")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG,"single list - onSubscribe")

                }

                override fun onError(e: Throwable) {
                    Log.d(TAG,"single list - onError ${e.message}")

                }
            })

        //implement maybe empty
        reactiveDataSource.maybeEmpty.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MaybeObserver<String> {
                override fun onSuccess(t: String) {
                    Log.d(TAG,"maybe empty - onSucces $t")

                }

                override fun onComplete() {
                    Log.d(TAG,"maybe empty - onComplete")

                }

                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG,"maybe empty - onSubscribe")

                }

                override fun onError(e: Throwable) {
                    Log.d(TAG,"maybe empty - onError ${e.message}")

                }
            })

        //implement maybe string
        reactiveDataSource.maybeString.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MaybeObserver<String> {
                override fun onSuccess(t: String) {
                    Log.d(TAG,"maybe list - onSucces $t")

                }

                override fun onComplete() {
                    Log.d(TAG,"maybe list - onComplete")

                }

                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG,"maybe list - onSubscribe")

                }

                override fun onError(e: Throwable) {
                    Log.d(TAG,"maybe list - onError ${e.message}")

                }
            })

        //implement completable
        reactiveDataSource.completable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : CompletableObserver {

                override fun onComplete() {
                    Log.d(TAG,"completable - onComplete")

                }

                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG,"completable - onSubscribe")

                }

                override fun onError(e: Throwable) {
                    Log.d(TAG,"completable  - onError ${e.message}")

                }
            })
    }
}
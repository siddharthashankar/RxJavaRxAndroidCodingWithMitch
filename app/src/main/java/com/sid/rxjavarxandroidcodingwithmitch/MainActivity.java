package com.sid.rxjavarxandroidcodingwithmitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    final Task task = new Task("Dog the walk", true, 3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-----1 Observable using fromIterable

       /* Observable<Task> taskObservable = Observable // create a new Observable object
                .fromIterable(DataSource.createTasksList()) // apply 'fromIterable' operator
                .subscribeOn(Schedulers.io()) // designate worker thread (background)
                .filter(new Predicate<Task>() {
                    @Override
                    public boolean test(Task task) throws Exception {
                        Log.d(TAG,"BG Thread..."+Thread.currentThread().getName());
                        Thread.sleep(1000);
                        return task.isCompleted();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()); // designate observer thread (main thread)*/

        //-----2 Observable using create() operator: Creating an Observable from a single object

       /* Observable<Task> singleTaskObservable = Observable
                .create(new ObservableOnSubscribe<Task>() {
                    @Override
                    public void subscribe(ObservableEmitter<Task> emitter) throws Exception {
                        if(!emitter.isDisposed()){
                            emitter.onNext(task);
                            emitter.onComplete();
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());*/

        //-----3 Observable using create() operator: Creating an Observable from a list of objects

       /* Observable<Task> taskListObservable = Observable
                .create(new ObservableOnSubscribe<Task>() {
                    @Override
                    public void subscribe(ObservableEmitter<Task> emitter) throws Exception {
                        for(Task tasks: DataSource.createTasksList()){
                            if(!emitter.isDisposed()){
                                emitter.onNext(tasks);
                            }
                        }
                        if(!emitter.isDisposed()){
                            emitter.onComplete();
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());*/

        //-----4 Observable using just() operator

/*        Observable<String> justObservable = Observable
                .just("first", "second", "third", "four", "five", "six", "seven", "eight", "nine", "ten")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        justObservable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG,"onNext..."+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/
    //---End--4 Observable using just() operator

        //-----5 Observable using range() operator

/*        Observable<Integer> rangeObservable = Observable
                .range(0,21)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        rangeObservable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG,"onNext..."+integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/
        //---End--5 Observable using range() operator


        // Observer
      /*  taskListObservable.subscribe(new Observer<Task>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
               // Log.i(TAG, "onSubscribe called");
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(@NonNull Task task) {
              //  Log.i(TAG, "on Next...currentThread: "+Thread.currentThread().getName());
                Log.i(TAG, "onNext: "+task.getDescription());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
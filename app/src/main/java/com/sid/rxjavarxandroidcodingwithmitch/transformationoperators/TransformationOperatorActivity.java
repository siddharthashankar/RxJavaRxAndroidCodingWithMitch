package com.sid.rxjavarxandroidcodingwithmitch.transformationoperators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.sid.rxjavarxandroidcodingwithmitch.DataSource;
import com.sid.rxjavarxandroidcodingwithmitch.R;
import com.sid.rxjavarxandroidcodingwithmitch.Task;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class TransformationOperatorActivity extends AppCompatActivity {
private String TAG = TransformationOperatorActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transformation_operator);

    // 1...Mapping (Task -> String)
        Observable<String> extractDescriptionObservable = Observable
                .fromIterable(DataSource.createTasksList())
                .subscribeOn(Schedulers.io())
                .map(mapDescription)
                .observeOn(AndroidSchedulers.mainThread());

        extractDescriptionObservable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: extracted description: " + s);
            }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onComplete() {
            }
        });
        // 1. End......Mapping (Task -> String)

        // 2...Mapping (Task -> Updated Task)
        Observable<Task> mapDescriptionUpdatedTaskObservable = Observable
                .fromIterable(DataSource.createTasksList())
                .subscribeOn(Schedulers.io())
                .map(mapDescriptionUpdatedTask)
                .observeOn(AndroidSchedulers.mainThread());
        mapDescriptionUpdatedTaskObservable.subscribe(new Observer<Task>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Task task) {
                Log.d(TAG, "onNext: is this task complete? " + task.isCompleted());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        // 2. End..Mapping (Task -> Updated Task)

       // 3...Mapping  Order of Emitted Objects
        Observable<Task> mapDescriptionUpdatedTaskObservable2 = Observable
                .fromIterable(DataSource.createTasksList())
                .subscribeOn(Schedulers.io())
                .map(mapDescriptionUpdatedTask)
                .observeOn(AndroidSchedulers.mainThread());
        mapDescriptionUpdatedTaskObservable2.subscribe(new Observer<Task>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Task task) {
                Log.d(TAG, "onNext: is this task complete? " + task.getDescription());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    //1
    Function<Task, String> mapDescription = new Function<Task, String>(){
        @Override
        public String apply(Task task) throws Exception {
            Log.d(TAG, "apply: doing work on thread: " + Thread.currentThread().getName());
            return task.getDescription();
        }
    };

    //2
    Function<Task, Task> mapDescriptionUpdatedTask = new Function<Task, Task>() {
        @Override
        public Task apply(Task task) throws Exception {
            Log.d(TAG, "apply: doing work on thread: " + Thread.currentThread().getName());
            task.setCompleted(true);
            return task;
        }
    };

}
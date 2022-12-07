package com.example.rxjava;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.example.rxjava.model.List_Users;
import com.example.rxjava.model.Users;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class OperatorActivity extends AppCompatActivity {

    CompositeDisposable  compositeDisposable;
    SearchView  searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        compositeDisposable = new CompositeDisposable();
        searchView = findViewById(R.id.shearchView);



        /*
        //Create

        //Users users = new Users("Tom Hardy" , "Tom@yahoo.com" , 1);
        Observable<Users> usersObservable = Observable.create(new ObservableOnSubscribe<Users>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Users> emitter) throws Throwable {

                for (Users users : List_Users.getListUsers()){

                    if (!emitter.isDisposed())
                        emitter.onNext(users);
                }

                if (!emitter.isDisposed())
                    emitter.onComplete();
            }
        })
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io());

        usersObservable.subscribe(new Observer<Users>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Users users) {

                Log.d("On_Next_Thread : " , Thread.currentThread().getName());
                Log.d("On_Next_Create : "  , users.getName() + " " + users.getEmail());

            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d("On_Error : "  , e.getMessage()+"");

            }

            @Override
            public void onComplete() {

                Log.d("On_Complete : " , "Complete");

            }
        });

         */

        /*
        //Just
         Observable<String> stringObservable = Observable.just( "MVVM" , "Rx Java" )
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io());

        stringObservable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {


            }

            @Override
            public void onNext(@NonNull String s) {

                Log.d("On_Next_Thread : " , Thread.currentThread().getName());
                Log.d("On_Next_Just : "  , s);

            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d("On_Error : "  , e.getMessage()+"");

            }

            @Override
            public void onComplete() {

                Log.d("On_Complete : " , "Complete");

            }
        });

         */

        /*
        //fromIterable
        Observable<Users> usersObservable = Observable.fromIterable(List_Users.getListUsers())
                .filter(new Predicate<Users>() {
                    @Override
                    public boolean test(Users users) throws Throwable {

                        Log.d("On_Next_Thread_Other : " , Thread.currentThread().getName());

                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        return true;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());

        usersObservable.subscribe(new Observer<Users>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {


            }

            @Override
            public void onNext(@NonNull Users users) {

                Log.d("On_Next_Thread : " , Thread.currentThread().getName());
                Log.d("On_Next_formIterable : "  , users.getName() + " " + users.getEmail());

            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d("On_Error" , e.getMessage()+"");
            }

            @Override
            public void onComplete() {

                Log.d("On_Complete : " , "Complete");

            }
        });
        */

        /*
       // Range && Repeat/*

        Observable<Integer> rangObservable=Observable.range(1,14)
                .repeat(5)
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

       rangObservable.subscribe(new Observer<Integer>() {
           @Override
           public void onSubscribe(@NonNull Disposable d) {

           }

           @Override
           public void onNext(@NonNull Integer integer) {


               Log.d("On_Next_Thread : " , Thread.currentThread().getName());
               Log.d("On_Next_Rang :", integer.toString());

           }

           @Override
           public void onError(@NonNull Throwable e) {

           Log.d("On_Error" , e.getMessage()+"");

           }

           @Override
           public void onComplete() {

               Log.d("On_Complete : " , "Complete");

           }
       });
      */

        /*
        // compositeDisposab???????????

        Observable<Users> usersObservable = Observable.fromIterable(List_Users.getListUsers())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        usersObservable.subscribe(new Observer<Users>() {


            @Override
            public void onSubscribe(@NonNull Disposable d) {

                compositeDisposable.add(d);
                Log.d("On_Subscribe", "Disposable");

            }

            @Override
            public void onNext(@NonNull Users users) {

                Log.d("On_Next_Thread : ", Thread.currentThread().getName());
                Log.d("On_Next :", users.getName());
            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d("On_Error", e.getMessage() + "");
            }

            @Override
            public void onComplete() {
                Log.d("On_Complete", "Complete ");

            }
        });

        compositeDisposable.add(usersObservable.subscribe(new Consumer<Users>() {
            @Override
            public void accept(Users users) throws Throwable {

            }
        }));

         */

        /*
        //Handler
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("On_Handler" , "Ok");
            }
        },40000);
       */

        /*
            //Interval
        Observable<Long>   intervalObservable= Observable.interval(5, TimeUnit.SECONDS)

         .takeWhile(new Predicate<Long>() {
             @Override
             public boolean test(Long aLong) throws Throwable {
                 return aLong<15;
             }
         })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());


                intervalObservable.subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {

                        Log.d("On_Next_Thread : ", Thread.currentThread().getName());
                        Log.d("On_Next :", aLong+"");

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                        Log.d("On_Error", e.getMessage() + "");

                    }

                    @Override
                    public void onComplete() {


                        Log.d("On_Complete", "Complete ");
                    }
                });

             */

        /*
        //Timer
        Observable<Long> timerObservable = Observable.timer(15 , TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());

        timerObservable.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Long aLong) {

                Log.d("On_Next_Thread : " , Thread.currentThread().getName());
                Log.d("On_Next : "  , aLong+"");

            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d("On_Error" , e.getMessage()+"");

            }

            @Override
            public void onComplete() {

                Log.d("On_Complete : " , "Complete");


            }
        });
         */

        /*
        //Take
        Observable<Users> usersObservable = Observable.fromIterable(List_Users.getListUsers())
                .take(3)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());

        usersObservable.subscribe(new Observer<Users>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Users users) {

                Log.d("On_Next_Thread : " , Thread.currentThread().getName());
                Log.d("On_Next_Take : "  , users.getName()+" " + users.getEmail());

            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d("On_Error" , e.getMessage()+"");

            }

            @Override
            public void onComplete() {

                Log.d("On_Complete : " , "Complete");

            }
        });
        */

        /*
        //TakeWhile
        Observable<Users> usersObservable = Observable.fromIterable(List_Users.getListUsers())
                .takeWhile(new Predicate<Users>() {
                    @Override
                    public boolean test(Users users) throws Throwable {
                        return users.isShow_item();
                    }
                })
         .observeOn(AndroidSchedulers.mainThread())
         .subscribeOn(Schedulers.io());

        usersObservable.subscribe(new Observer<Users>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Users users) {

                Log.d("On_Next_Thread : " , Thread.currentThread().getName());
                Log.d("On_Next_Take : "  , users.getName()+" " + users.getEmail());


            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("On_Error" , e.getMessage()+"");

            }

            @Override
            public void onComplete() {
                Log.d("On_Complete : " , "Complete");

            }
        });
        */

        /*
        //Distinct
        Observable<Users> usersObservable = Observable.fromIterable(List_Users.getListUsers())
                .distinct(new Function<Users, String>() {
                    @Override
                    public String apply(Users users) throws Throwable {
                        return users.getName()+" " + users.getEmail();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());

        usersObservable.subscribe(new Observer<Users>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Users users) {

                Log.d("On_Next_Thread : " , Thread.currentThread().getName());
                Log.d("On_Next_Take : "  , users.getName()+" " + users.getEmail());

            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d("On_Error" , e.getMessage()+"");

            }

            @Override
            public void onComplete() {
                Log.d("On_Complete : " , "Complete");

            }
        });
         */

        /*
        //Buffer
        @NonNull Observable<List<Users>> usersObservable = Observable.fromIterable(List_Users.getListUsers())
                .buffer(4)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        usersObservable.subscribe(new Observer<List<Users>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<Users> list) {

                Log.d("On_Next_Buffer" , "........................");
                for (Users users : list) {
                    Log.d("On_Next_Buffer : ", users.getName() + " " + users.getEmail());
                }

            }

            @Override
            public void onError(@NonNull Throwable e) {

               Log.d("On_Error" , e.getMessage()+"");

            }

            @Override
            public void onComplete() {

                Log.d("On_Complete : " , "Complete");

            }
        });

         */


        /*
        //Debounce
        Observable<String> searchObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {

                        //set Method

                        if (!emitter.isDisposed())
                            emitter.onNext(newText);

                        return false;
                    }
                });

            }
        })
        .debounce(1, TimeUnit.SECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io());

        searchObservable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String query_search) {

                Log.d("On_Next_Debounce : ", query_search);

            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d("On_Error" , e.getMessage()+"");

            }

            @Override
            public void onComplete() {

            }
        });

         */
        /*
        //fromCallable
        Observable<Users> usersObservable = Observable.fromCallable(new Callable<Users>() {
            @Override
            public Users call() throws Exception {

                //Database
                return null;
            }
        })
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io());

        usersObservable.subscribe(new Observer<Users>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Users users) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


         */
        /*
        //fromArray
        Users[] users = new Users[2];
        users [0] = new Users("Rx Java" , "" , 1);
        users [1] = new Users("Tom Hardy" , "" , 2);

        Observable<Users> usersObservable = Observable.fromArray(users)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());

        usersObservable.subscribe(new Observer<Users>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Users users) {

                Log.d("On_Next_FromArray : " , users.getName() );

            }

            @Override
            public void onError(@NonNull Throwable e) {



            }

            @Override
            public void onComplete() {

            }
        });

         */

        /*
        //Debounce
        Observable<String> searchobservable =Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
               searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                   @Override
                   public boolean onQueryTextSubmit(String query) {
                       return false;
                   }

                   @Override
                   public boolean onQueryTextChange(String newText) {
                       if(!emitter.isDisposed())
                           emitter.onNext(newText);

                       return  false;
                   }
               });
            }
        })
        .debounce(1, TimeUnit.SECONDS)
        .observeOn(AndroidSchedulers.mainThread())
         .observeOn(Schedulers.io());


        searchobservable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String query_searche) {
                Log.d("On_Next_Debounce ",query_searche);

            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d("On_Error" , e.getMessage()+"");

            }

            @Override
            public void onComplete() {
                Log.d("On_Complete : " , "Complete");

            }
        });

         */

    }


        @Override
        protected void onDestroy () {
            super.onDestroy();
            compositeDisposable.clear();
            //compositeDisposable.dispose();
        }
    }
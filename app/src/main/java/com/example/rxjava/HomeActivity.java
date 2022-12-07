package com.example.rxjava;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjava.adapter.PostAdapter;
import com.example.rxjava.api.ApiClient;
import com.example.rxjava.api.ApiInterface;
import com.example.rxjava.model.Post;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    String url = "http://androidmohammad.ir/rxjava/";
    ApiInterface request;

    PostAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        request = ApiClient.getApiClient(url).create(ApiInterface.class);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*
        compositeDisposable.add(request.getPost()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<Post>>() {
                    @Override
                    public void accept(List<Post> posts) throws Throwable {

                        adapter = new PostAdapter(getApplicationContext() , posts );
                        recyclerView.setAdapter(adapter);

                    }
                }));

         */

                  compositeDisposable.add(request.getPost()

                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribeOn(Schedulers.io())
                  .subscribeWith(new DisposableSingleObserver<List<Post>>() {
                      @Override
                      public void onSuccess(@NonNull List<Post> posts) {

                          adapter = new PostAdapter(getApplicationContext(), posts);
                          recyclerView.setAdapter(adapter);

                      }

                      @Override
                      public void onError(@NonNull Throwable e) {
                        Log.d("Error" ,e.getMessage()+"");
                      }
                  }));


        }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
package com.example.rxjava.api;


import com.example.rxjava.model.Post;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiInterface {


  //  @GET("getPosts.php")
   // Observable<List<Post>> getPost();

    // @GET("getPosts.php")
     //Flowable<List<Post>> getPost();

     @GET("getPosts.php")
     Single<List<Post>> getPost();



}

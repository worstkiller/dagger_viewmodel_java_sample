package com.vikas.dagger.di.module;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vikas.dagger.BuildConfig;
import com.vikas.dagger.data.remote.WebService;
import com.vikas.dagger.data.remote.WebServiceImpl;

import java.io.IOException;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * module for managing the dependencies related to local DB and rest api
 */
@Module
public abstract class RepositoryModule {

    @Provides
    @Singleton
    static Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    static Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient(Cache cache, Interceptor interceptor) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(interceptor);
        client.cache(cache);
        return client.build();
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit(@Named("apiEndPoint") String endPoint, Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(endPoint)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @Named("apiEndPoint")
    static String provideApiEndpoint() {
        return BuildConfig.API_ENDPOINT;
    }

    @Provides
    @Named("apiToken")
    static String provideApiToken() {
        return String.format("Bearer\u202f%1s", BuildConfig.API_TOKEN);
    }

    @Provides
    @Singleton
    static WebService provideWebService(Retrofit retrofit) {
        return retrofit.create(WebService.class);
    }

    @Provides
    @Singleton
    static Interceptor provideInterceptor(@Named("apiToken") final String apiToken) {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder newBuilder = request.newBuilder()
                        .addHeader("Authorization", apiToken)
                        .addHeader("Accept", "application/json");
                request = newBuilder.build();
                return chain.proceed(request);
            }
        };
    }

    @Provides
    @Singleton
    static WebServiceImpl provideWebServiceImpl(WebService webService) {
        return new WebServiceImpl(webService);
    }

}

package com.notash.mysampledagger.di;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.notash.mysampledagger.ApiInterface;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module(includes = ContextModule.class)
public class NetworkModule {

    public static final String BASE_URL = "http://edi-yooz.com/api/v1/";

    @Provides
    @ApplicationScope
    public ApiInterface provideApiInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

    @Provides
    @ApplicationScope
    public Retrofit provideRetrofit(CallAdapter.Factory callAdapterFactory,
                                    Converter.Factory convertorFactory,
                                    OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(callAdapterFactory)
                .addConverterFactory(convertorFactory)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @ApplicationScope
    public Converter.Factory provideConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @ApplicationScope
    public CallAdapter.Factory provideAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor provideHttpLoginInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
    }

    @Provides
    @ApplicationScope
    public Cache provideCache(File cacheFile) {
        return new Cache(cacheFile, 5 * 1000 * 1000);
    }

    @Provides
    @ApplicationScope
    public File provideFile(Context context) {
        File cacheFile = new File(context.getCacheDir(), "okhttp_cache");
        cacheFile.mkdirs();
        return cacheFile;
    }


}

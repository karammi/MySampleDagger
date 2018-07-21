package com.notash.mysampledagger.di;

import android.app.Application;

import com.notash.mysampledagger.ApiInterface;
import com.notash.mysampledagger.App;

import dagger.Component;

//@Singleton
@ApplicationScope
@Component(modules = NetworkModule.class)
public interface ApplicationComponent {

//    void inject(App app);

    @ApplicationScope
    ApiInterface getApiInterface();
}

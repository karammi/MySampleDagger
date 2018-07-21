package com.notash.mysampledagger;

import android.app.Activity;
import android.app.Application;

import com.notash.mysampledagger.di.ApplicationComponent;
import com.notash.mysampledagger.di.ContextModule;
import com.notash.mysampledagger.di.DaggerApplicationComponent;

import javax.inject.Inject;

import timber.log.Timber;

public class App extends Application {

    ApplicationComponent component;

//    @Inject
//    ApiInterface apiInterface;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        component = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
//        component.inject(this);

//        DaggerApplicationComponent.builder()
//                .contextModule(new ContextModule(this))
//                .build();
    }


    public ApplicationComponent getComponent() {
        return this.component;
    }

    public static App get(Activity activity) {
        return (App) activity.getApplication();
    }
}

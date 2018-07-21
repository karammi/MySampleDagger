package com.notash.mysampledagger.di;

import android.app.Activity;

import com.notash.mysampledagger.SecondActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private SecondActivity secondActivity;

    public ActivityModule(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;
    }

    @Provides
    @ActivityScope
    public SecondActivity provideSecondActivity() {
        return this.secondActivity;
    }
}

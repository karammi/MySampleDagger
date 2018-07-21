package com.notash.mysampledagger.di;


import android.app.Activity;

import com.notash.mysampledagger.SecondActivity;

import dagger.Component;


@Component(modules = {ActivityModule.class}, dependencies = {ApplicationComponent.class})
@ActivityScope
public interface ActivityComponent {

    void inject(SecondActivity activity);

}


package com.notash.mysampledagger.di;

import com.notash.mysampledagger.models.User;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = UserModule.class)
public interface UserComponent {

    User provideUser();
}

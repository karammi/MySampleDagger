package com.notash.mysampledagger.di;

import com.notash.mysampledagger.models.Contact;
import com.notash.mysampledagger.models.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Provides
    @Singleton
    Contact provideContact() {
        return new Contact();
    }

    @Provides
    @Singleton
    User provideUser() {
        return new User(new Contact());
    }
}

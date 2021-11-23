package com.lyecdevelopers.ekibanda.di.Component;

import android.app.Application;


import com.lyecdevelopers.ekibanda.Ekibanda;
import com.lyecdevelopers.ekibanda.di.BuildersModule.ActivityBuildersModule;
import com.lyecdevelopers.ekibanda.di.ViewModelModule.ViewModelFactoryModule;
import com.lyecdevelopers.ekibanda.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * created by jaba
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuildersModule.class,
        AppModule.class,
        ViewModelFactoryModule.class,
})
public interface AppComponent extends AndroidInjector<Ekibanda> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}

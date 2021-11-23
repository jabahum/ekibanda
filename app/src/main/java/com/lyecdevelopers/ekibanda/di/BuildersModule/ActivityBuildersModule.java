package com.lyecdevelopers.ekibanda.di.BuildersModule;




import com.lyecdevelopers.ekibanda.di.modules.account.AccountBuildersModule;
import com.lyecdevelopers.ekibanda.di.modules.account.AccountModule;
import com.lyecdevelopers.ekibanda.di.modules.account.AccountScope;
import com.lyecdevelopers.ekibanda.di.modules.account.AccountViewModelsModule;
import com.lyecdevelopers.ekibanda.di.modules.main.MainBuildersModule;
import com.lyecdevelopers.ekibanda.di.modules.main.MainModule;
import com.lyecdevelopers.ekibanda.di.modules.main.MainScope;
import com.lyecdevelopers.ekibanda.di.modules.main.MainViewModelsModule;
import com.lyecdevelopers.ekibanda.di.modules.splash.SplashBuildersModule;
import com.lyecdevelopers.ekibanda.di.modules.splash.SplashModule;
import com.lyecdevelopers.ekibanda.di.modules.splash.SplashScope;
import com.lyecdevelopers.ekibanda.di.modules.splash.SplashViewModelsModule;
import com.lyecdevelopers.ekibanda.di.modules.walkthrough.WalkThroughBuildersModule;
import com.lyecdevelopers.ekibanda.di.modules.walkthrough.WalkThroughModule;
import com.lyecdevelopers.ekibanda.di.modules.walkthrough.WalkThroughScope;
import com.lyecdevelopers.ekibanda.di.modules.walkthrough.WalkThroughViewModelsModule;
import com.lyecdevelopers.ekibanda.ui.account.AccountActivity;
import com.lyecdevelopers.ekibanda.ui.main.MainActivity;
import com.lyecdevelopers.ekibanda.ui.splash.SplashActivity;
import com.lyecdevelopers.ekibanda.ui.walkthrough.WalkThroughActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * created by jaba
 */
@Module
public abstract class ActivityBuildersModule {

    @MainScope
    @ContributesAndroidInjector(modules = {
            MainBuildersModule.class,
            MainModule.class,
            MainViewModelsModule.class,
    })
    abstract MainActivity contributeMainActivity();


    @AccountScope
    @ContributesAndroidInjector(modules = {
            AccountBuildersModule.class,
            AccountModule.class,
            AccountViewModelsModule.class,

    })

    abstract AccountActivity contributeAccountActivity();

    @SplashScope
    @ContributesAndroidInjector(modules = {

            SplashBuildersModule.class,
            SplashModule.class,
            SplashViewModelsModule.class,

    })

    abstract SplashActivity contributeSplashActivity();

    @WalkThroughScope
    @ContributesAndroidInjector(modules = {
            WalkThroughBuildersModule.class,
            WalkThroughModule.class,
            WalkThroughViewModelsModule.class,
    })

    abstract WalkThroughActivity contributeWalkThroughActivity();
}

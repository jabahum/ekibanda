package com.lyecdevelopers.ekibanda.di.modules.main

import com.lyecdevelopers.ekibanda.ui.main.MainFragment
import com.lyecdevelopers.ekibanda.ui.main.discover.DiscoverFragment
import com.lyecdevelopers.ekibanda.ui.main.home.HomeFragment
import com.lyecdevelopers.ekibanda.ui.main.home.MovieDetailFragment
import com.lyecdevelopers.ekibanda.ui.main.home.movie.CastFragment
import com.lyecdevelopers.ekibanda.ui.main.home.movie.PhotosFragment
import com.lyecdevelopers.ekibanda.ui.main.home.movie.ReviewsFragment
import com.lyecdevelopers.ekibanda.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * created by jaba
 */
@Module
abstract class MainBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment?

    @ContributesAndroidInjector
    abstract fun contributeDiscoverFragment(): DiscoverFragment?

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment?

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment?

    @ContributesAndroidInjector
    abstract fun contributeMovieDetailFragment(): MovieDetailFragment?

    @ContributesAndroidInjector
    abstract fun contributeCastFragment(): CastFragment?

    @ContributesAndroidInjector
    abstract fun contributePhotosFragment(): PhotosFragment?

    @ContributesAndroidInjector
    abstract fun contributeReviewsFragment(): ReviewsFragment?

}
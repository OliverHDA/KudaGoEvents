package ru.oliverhd.kudagoevents.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.oliverhd.kudagoevents.categorieslist.CategoriesListFragment
import ru.oliverhd.kudagoevents.di.modules.ContributesAndroidInjectorModule
import ru.oliverhd.kudagoevents.di.modules.RepositoryModule
import ru.oliverhd.kudagoevents.main.App
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ContributesAndroidInjectorModule::class,
        RepositoryModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {

    fun inject(categoriesListFragment : CategoriesListFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        fun build(): ApplicationComponent
    }
}
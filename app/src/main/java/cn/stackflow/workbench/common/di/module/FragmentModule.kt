package cn.stackflow.workbench.di.module

import com.king.frame.mvvmframe.di.component.BaseFragmentSubcomponent
import cn.stackflow.workbench.app.home.MenuFragment
import cn.stackflow.workbench.app.me.MeFragment
import cn.stackflow.workbench.app.base.TabFragment
import cn.stackflow.workbench.app.home.HomeFragment
import cn.stackflow.workbench.temp.TempFragment
import cn.stackflow.workbench.temp.TempListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module(subcomponents = [BaseFragmentSubcomponent::class])
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeTempFragment(): TempFragment

    @ContributesAndroidInjector
    abstract fun contributeTempListFragment(): TempListFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeMenuFragment(): MenuFragment

    @ContributesAndroidInjector
    abstract fun contributeMeFragment(): MeFragment

    @ContributesAndroidInjector
    abstract fun contributeTabFragment(): TabFragment


}
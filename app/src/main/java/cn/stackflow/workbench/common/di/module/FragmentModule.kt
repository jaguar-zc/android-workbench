package cn.stackflow.workbench.common.di.module

import cn.stackflow.workbench.common.base.TabFragment
import cn.stackflow.workbench.ui.layout.MenuFragment
import cn.stackflow.workbench.ui.layout.WorkbenchFragment
import cn.stackflow.workbench.ui.layout.calendar.CalendarFragment
import cn.stackflow.workbench.ui.layout.msg.MsgFragment
import cn.stackflow.workbench.ui.layout.st.MeFragment
import com.king.frame.mvvmframe.di.component.BaseFragmentSubcomponent
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module(subcomponents = [BaseFragmentSubcomponent::class])
abstract class FragmentModule {

//    @ContributesAndroidInjector
//    abstract fun contributeTempFragment(): TempFragment
//
//    @ContributesAndroidInjector
//    abstract fun contributeTempListFragment(): TempListFragment

    @ContributesAndroidInjector
    abstract fun contributeMsgFragment(): MsgFragment

    @ContributesAndroidInjector
    abstract fun contributeCalendarFragment(): CalendarFragment

    @ContributesAndroidInjector
    abstract fun contributeWorkbenchFragment(): WorkbenchFragment

    @ContributesAndroidInjector
    abstract fun contributeMenuFragment(): MenuFragment

    @ContributesAndroidInjector
    abstract fun contributeTabFragment(): TabFragment

    @ContributesAndroidInjector
    abstract fun contributeMeFragment(): MeFragment


}
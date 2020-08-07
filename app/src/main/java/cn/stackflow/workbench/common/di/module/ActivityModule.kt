package cn.stackflow.workbench.di.module

import com.king.frame.mvvmframe.di.component.BaseActivitySubcomponent
import cn.stackflow.workbench.app.about.AboutActivity
import cn.stackflow.workbench.app.account.*
import cn.stackflow.workbench.app.base.WebActivity
import cn.stackflow.workbench.app.home.HomeActivity
import cn.stackflow.workbench.app.splash.SplashActivity
import cn.stackflow.workbench.temp.TempActivity
import cn.stackflow.workbench.temp.TempListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module(subcomponents = [BaseActivitySubcomponent::class])
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeTempActivity(): TempActivity

    @ContributesAndroidInjector
    abstract fun contributeTempListActivity(): TempListActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun contributeAboutActivity(): AboutActivity

    @ContributesAndroidInjector
    abstract fun contributeWebActivity(): WebActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    abstract fun contributeCodeLoginActivity(): CodeLoginActivity

    @ContributesAndroidInjector
    abstract fun contributeRegisterActivity(): RegisterActivity

    @ContributesAndroidInjector
    abstract fun contributeResetPwdActivity(): ResetPwdActivity

    @ContributesAndroidInjector
    abstract fun contributeChangePwdActivity(): ChangePwdActivity

}
package cn.stackflow.workbench.common.di.module

import cn.stackflow.workbench.common.base.WebActivity
import cn.stackflow.workbench.ui.MainActivity
import cn.stackflow.workbench.ui.about.AboutActivity
import cn.stackflow.workbench.ui.account.LoginActivity
import cn.stackflow.workbench.ui.setting.dept.DeptActivity
import cn.stackflow.workbench.ui.setting.dept.DeptEditActivity
import cn.stackflow.workbench.ui.setting.role.RoleActivity
import cn.stackflow.workbench.ui.setting.user.UserActivity
import cn.stackflow.workbench.ui.splash.SplashActivity
import com.king.frame.mvvmframe.di.component.BaseActivitySubcomponent
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module(subcomponents = [BaseActivitySubcomponent::class])
abstract class ActivityModule {

//    @ContributesAndroidInjector
//    abstract fun contributeTempActivity(): TempActivity
//
//    @ContributesAndroidInjector
//    abstract fun contributeTempListActivity(): TempListActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
//
    @ContributesAndroidInjector
    abstract fun contributeAboutActivity(): AboutActivity

    @ContributesAndroidInjector
    abstract fun contributeWebActivity(): WebActivity
//
    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity


    @ContributesAndroidInjector
    abstract fun contributeDeptActivity(): DeptActivity

    @ContributesAndroidInjector
    abstract fun contributeDeptEditActivity(): DeptEditActivity

    @ContributesAndroidInjector
    abstract fun contributeRoleActivity(): RoleActivity

    @ContributesAndroidInjector
    abstract fun contributeUserActivity(): UserActivity

//
//    @ContributesAndroidInjector
//    abstract fun contributeCodeLoginActivity(): CodeLoginActivity
//
//    @ContributesAndroidInjector
//    abstract fun contributeRegisterActivity(): RegisterActivity
//
//    @ContributesAndroidInjector
//    abstract fun contributeResetPwdActivity(): ResetPwdActivity
//
//    @ContributesAndroidInjector
//    abstract fun contributeChangePwdActivity(): ChangePwdActivity

}
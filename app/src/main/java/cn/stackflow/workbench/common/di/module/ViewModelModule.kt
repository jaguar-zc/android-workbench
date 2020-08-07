package cn.stackflow.workbench.di.module

import androidx.lifecycle.ViewModel
import com.king.frame.mvvmframe.di.scope.ViewModelKey
import cn.stackflow.workbench.app.about.AboutViewModel
import cn.stackflow.workbench.app.account.LoginViewModel
import cn.stackflow.workbench.app.account.PasswordViewModel
import cn.stackflow.workbench.app.account.RegisterViewModel
import cn.stackflow.workbench.app.base.BaseViewModel
import cn.stackflow.workbench.app.home.HomeViewModel
import cn.stackflow.workbench.app.home.MenuViewModel
import cn.stackflow.workbench.app.me.MeViewModel
import cn.stackflow.workbench.app.splash.SplashViewModel
import cn.stackflow.workbench.temp.TempListViewModel
import cn.stackflow.workbench.temp.TempViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(BaseViewModel::class)
    abstract fun bindBaseViewModel(viewModel: BaseViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TempViewModel::class)
    abstract fun bindTempViewModel(viewModel: TempViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TempListViewModel::class)
    abstract fun bindTempListViewModel(viewModel: TempListViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun bindMenuViewModel(viewModel: MenuViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AboutViewModel::class)
    abstract fun bindAboutViewModel(viewModel: AboutViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MeViewModel::class)
    abstract fun bindMeViewModel(viewModel: MeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindRegisterViewModel(viewModel: RegisterViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PasswordViewModel::class)
    abstract fun bindPasswordViewModel(viewModel: PasswordViewModel) : ViewModel

}
package cn.stackflow.workbench.common.di.module

import androidx.lifecycle.ViewModel
import cn.stackflow.workbench.common.base.BaseViewModel
import cn.stackflow.workbench.ui.MainViewModel
import cn.stackflow.workbench.ui.about.AboutViewModel
import cn.stackflow.workbench.ui.account.LoginViewModel
import cn.stackflow.workbench.ui.layout.audit.AuditViewModel
import cn.stackflow.workbench.ui.layout.doc.DocViewModel
import cn.stackflow.workbench.ui.layout.msg.MsgViewModel
import cn.stackflow.workbench.ui.layout.st.MeViewModel
import cn.stackflow.workbench.ui.setting.dept.DeptEditViewModel
import cn.stackflow.workbench.ui.setting.dept.DeptViewModel
import cn.stackflow.workbench.ui.setting.resource.ResourceViewModel
import cn.stackflow.workbench.ui.setting.role.RoleViewModel
import cn.stackflow.workbench.ui.setting.user.UserViewModel
import cn.stackflow.workbench.ui.splash.SplashViewModel
import com.king.frame.mvvmframe.di.scope.ViewModelKey
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
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(TempViewModel::class)
//    abstract fun bindTempViewModel(viewModel: TempViewModel) : ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(TempListViewModel::class)
//    abstract fun bindTempListViewModel(viewModel: TempListViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AuditViewModel::class)
    abstract fun bindAuditViewModel(viewModel: AuditViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AboutViewModel::class)
    abstract fun bindAboutViewModel(viewModel: AboutViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MeViewModel::class)
    abstract fun bindMeViewModel(viewModel: MeViewModel) : ViewModel
//
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DeptViewModel::class)
    abstract fun bindDeptViewModel(viewModel: DeptViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DeptEditViewModel::class)
    abstract fun bindDeptEditViewModel(viewModel: DeptEditViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MsgViewModel::class)
    abstract fun bindMsgViewModel(viewModel: MsgViewModel) : ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(DocViewModel::class)
    abstract fun bindDocViewModel(viewModel: DocViewModel) : ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(RoleViewModel::class)
    abstract fun bindRoleViewModel(viewModel: RoleViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(viewModel: UserViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ResourceViewModel::class)
    abstract fun bindResourceViewModel(viewModel: ResourceViewModel) : ViewModel


//
//    @Binds
//    @IntoMap
//    @ViewModelKey(RegisterViewModel::class)
//    abstract fun bindRegisterViewModel(viewModel: RegisterViewModel) : ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(PasswordViewModel::class)
//    abstract fun bindPasswordViewModel(viewModel: PasswordViewModel) : ViewModel

}
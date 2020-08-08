package cn.stackflow.workbench.common.di.compoent

import com.king.frame.mvvmframe.di.component.AppComponent
import com.king.frame.mvvmframe.di.scope.ApplicationScope
import cn.stackflow.workbench.App
import cn.stackflow.workbench.common.di.module.ApplicationModule
import dagger.Component

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@ApplicationScope
@Component(dependencies = [AppComponent::class], modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: App)
}
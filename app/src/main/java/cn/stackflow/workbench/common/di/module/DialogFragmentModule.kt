package cn.stackflow.workbench.di.module

import com.king.frame.mvvmframe.di.component.BaseDialogFragmentSubcomponent
import cn.stackflow.workbench.temp.TempDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module(subcomponents = [BaseDialogFragmentSubcomponent::class])
abstract class DialogFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeTempDialogFragment(): TempDialogFragment

}
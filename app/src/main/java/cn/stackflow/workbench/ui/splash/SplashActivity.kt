package cn.stackflow.workbench.ui.splash

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import cn.stackflow.workbench.R
import cn.stackflow.workbench.common.base.BaseActivity
import cn.stackflow.workbench.databinding.SplashActivityBinding
import kotlinx.android.synthetic.main.splash_activity.*

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class SplashActivity : BaseActivity<SplashViewModel, SplashActivityBinding>(){


    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)

        startAnimation(rootView)
    }

    override fun getLayoutId(): Int {
        return R.layout.splash_activity
    }

    private fun startAnimation(view: View) {
        val anim = AnimationUtils.loadAnimation(context, R.anim.splash_anim)
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                startActivity()
            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })
        view.startAnimation(anim)
    }

    private fun startActivity(){
        startHomeActivity()
        finish()
    }


}
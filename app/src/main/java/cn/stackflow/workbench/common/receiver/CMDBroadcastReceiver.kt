package cn.stackflow.workbench.common.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import cn.stackflow.workbench.ui.account.LoginActivity
import com.orhanobut.logger.Logger

open class CMDBroadcastReceiver : BroadcastReceiver() {
    companion object {
        var ACTION = "cn.stackflow.workbench.action.CMD"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Logger.d("CMDBroadcastReceiver")
        val cmd = intent?.getStringExtra("cmd")

        Toast.makeText(context, "CMD:$cmd", Toast.LENGTH_LONG).show();
        var intentLogin = Intent(context, LoginActivity::class.java)
        intentLogin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(intentLogin)
    }





}
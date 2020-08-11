package cn.stackflow.workbench.common.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import cn.stackflow.workbench.ui.account.LoginActivity

open class CMDBroadcastReceiver : BroadcastReceiver() {
    companion object {
        var ACTION = "android.intent.action.CMD_BROADCAST_RECEIVER"
    }


    override fun onReceive(context: Context?, intent: Intent?) {
        TODO("Not yet implemented")
        Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();
        context?.startActivity(Intent(context,LoginActivity::class.java))
    }
}
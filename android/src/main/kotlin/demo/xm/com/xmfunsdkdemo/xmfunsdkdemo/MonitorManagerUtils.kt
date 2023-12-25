package demo.xm.com.xmfunsdkdemo.xmfunsdkdemo

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Message
import android.util.Log
import com.lib.MsgContent
import com.manager.account.BaseAccountManager
import com.manager.account.XMAccountManager
import com.manager.db.Define.LOGIN_BY_INTERNET
import com.manager.db.DevDataCenter
import com.manager.device.DeviceManager
import com.manager.device.config.PwdErrorManager.OnRepeatSendMsgListener
import com.manager.device.media.monitor.MonitorManager
import com.xm.ui.dialog.XMPromptDlg

object MonitorManagerUtils {

    @SuppressLint("StaticFieldLeak")
    var monitorManager: MonitorManager? = null

    fun start(): Boolean {
        if (monitorManager == null) return false
        return try {
            monitorManager?.startMonitor()
            true
        } catch (ex: Exception) {
            ex.printStackTrace()
            false
        }
    }

    fun test() {
        XMAccountManager.getInstance().login("18502922792", "Ch3.1415926", LOGIN_BY_INTERNET, object : BaseAccountManager.OnAccountManagerListener {
            override fun onSuccess(msgId: Int) {
                Log.i("xxxxxxxxxxxxxxxxxxxx", "onSuccess: ")

            }

            override fun onFailed(msgId: Int, errorId: Int) {
                Log.i("xxxxxxxxxxxxxxxxxxxx", "onFailed: ")

            }

            override fun onFunSDKResult(msg: Message?, ex: MsgContent?) {
                Log.i("xxxxxxxxxxxxxxxxxxxx", "onFunSDKResult: ")
            }
        })


    }

    fun test1(activityContext: Activity) {
        val devInfo = DevDataCenter.getInstance().getDevInfo("192.168.1.60:34567")
        XMPromptDlg.onShowPasswordErrorDialog(activityContext, devInfo.sdbDevInfo,
                0, OnRepeatSendMsgListener {
        }, false)
    }

    fun test2() {
        XMAccountManager.getInstance().devList
        DeviceManager.getInstance().loginDev("192.168.1.60:34567", object : DeviceManager.OnDevManagerListener<Any> {
            override fun onSuccess(devId: String?, operationType: Int, result: Any?) {
                Log.i("xxxxxxxxxxxxxxxxxxxx", "loginDev onSuccess: ")
            }

            override fun onFailed(devId: String?, msgId: Int, jsonName: String?, errorId: Int) {
                Log.i("xxxxxxxxxxxxxxxxxxxx", "loginDev onFailed: ")
            }
        });
    }

    fun test3() {

    }
}
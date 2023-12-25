package demo.xm.com.xmfunsdkdemo.xmfunsdkdemo

import android.app.Activity
import com.lib.EFUN_ATTR
import com.lib.FunSDK
import com.lib.SDKCONST
import com.manager.XMFunSDKManager
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** XmfunsdkdemoPlugin */
class XmfunsdkdemoPlugin: FlutterPlugin, MethodCallHandler, ActivityAware {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel
  private lateinit var flutterPluginBinding: FlutterPlugin.FlutterPluginBinding
 lateinit var activityContext: Activity;

  override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    this.flutterPluginBinding = flutterPluginBinding;
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "xmfunsdkdemo")
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(call: MethodCall, result: Result) {
    if (call.method == "getPlatformVersion") {
      result.success("Android ${android.os.Build.VERSION.RELEASE}")
    } else if (call.method == "initSdk") {
      try {
        XMFunSDKManager.getInstance().initXMCloudPlatform(flutterPluginBinding.applicationContext,
                call.argument("appUuid"), call.argument("appKey"), call.argument("appSecret"),
                call.argument<Int>("appMovecard")!!, true);
        XMFunSDKManager.getInstance().initLog();
        // 如果是低功耗设备（门铃、门锁等）还需要调用以下方法：
        FunSDK.SetFunIntAttr(EFUN_ATTR.SUP_RPS_VIDEO_DEFAULT, SDKCONST.Switch.Open);
//        // 初始化打印：
//        XMFunSDKManager.getInstance().initLog();
        result.success(true)
      } catch (ex: Exception) {
        ex.printStackTrace()
        result.success(false)
      }
    } else if (call.method == "startMonitor") {
      result.success(MonitorManagerUtils.start())
    } else if (call.method == "test") {
      MonitorManagerUtils.test()
      result.success(true)
    }  else if (call.method == "test1") {
      MonitorManagerUtils.test1(activityContext)
      result.success(true)
    }  else if (call.method == "test2") {
      MonitorManagerUtils.test2()
      result.success(true)
    }  else if (call.method == "test3") {
      MonitorManagerUtils.test3()
      result.success(true)
    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }

  override fun onAttachedToActivity(binding: ActivityPluginBinding) {
    activityContext = binding.activity;
    flutterPluginBinding
            .platformViewRegistry
            .registerViewFactory("MonitorView", MonitorFactory(binding.activity))
  }

  override fun onDetachedFromActivityForConfigChanges() {
  }

  override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
  }

  override fun onDetachedFromActivity() {
  }
}

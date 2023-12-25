package demo.xm.com.xmfunsdkdemo.xmfunsdkdemo

import android.content.Context
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class MonitorFactory(private val activityContext: Context) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
        val creationParams = args as Map<String?, Any?>?
        return MonitorView(activityContext, viewId, creationParams)
    }
}
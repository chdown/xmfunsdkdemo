package demo.xm.com.xmfunsdkdemo.xmfunsdkdemo

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.manager.device.DeviceManager
import demo.xm.com.xmfunsdkdemo.xmfunsdkdemo.MonitorManagerUtils
import demo.xm.com.xmfunsdkdemo.xmfunsdkdemo.MonitorManagerUtils.monitorManager
import io.flutter.plugin.platform.PlatformView

class MonitorView(private val context: Context, id: Int, creationParams: Map<String?, Any?>?) : PlatformView {

    private lateinit var frameLayout: FrameLayout

    override fun getView(): View {
//        val frameLayout = FrameLayout(context as Activity)
//        var textView = TextView(context)
//        textView.textSize = 24f
//        textView.setBackgroundColor(Color.rgb(255, 255, 255))
//        textView.text = "Rendered on a native Android view (id: $)"
//        frameLayout.addView(textView)
        return frameLayout
    }

    override fun dispose() {}

    init {
        frameLayout = FrameLayout(context)
        frameLayout.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400);
        MonitorManagerUtils.monitorManager = DeviceManager.getInstance().createMonitorPlayer(frameLayout, "192.168.1.60:34567")
        monitorManager?.startMonitor();
//        val monitorManager = DeviceManager.getInstance().createMonitorPlayer(frameLayout, "d3044046e2e8f403")
//        monitorManager.startMonitor();
//        val  textView = TextView(context)
//        textView.textSize = 24f
//        textView.setBackgroundColor(Color.rgb(255, 255, 255))
//        textView.text = "Rendered on a native Android view (id: $id)"
//        frameLayout.addView(textView);
    }
}
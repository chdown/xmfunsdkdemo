
import 'xmfunsdkdemo_platform_interface.dart';

class Xmfunsdkdemo {
  Future<String?> getPlatformVersion() {
    return XmfunsdkdemoPlatform.instance.getPlatformVersion();
  }

  Future<bool?> initSdk(String appUuid, String appKey, String appSecret, int appMovecard) {
    return XmfunsdkdemoPlatform.instance.initSdk(appUuid, appKey, appSecret, appMovecard);
  }

  Future<bool?> startMonitor() {
    return XmfunsdkdemoPlatform.instance.startMonitor();
  }

  Future<bool?> test() {
    return XmfunsdkdemoPlatform.instance.test();
  }

  Future<bool?> test1() {
    return XmfunsdkdemoPlatform.instance.test1();
  }

  Future<bool?> test2() {
    return XmfunsdkdemoPlatform.instance.test2();
  }

  Future<bool?> test3() {
    return XmfunsdkdemoPlatform.instance.test3();
  }

}

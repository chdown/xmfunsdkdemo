import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'xmfunsdkdemo_method_channel.dart';

abstract class XmfunsdkdemoPlatform extends PlatformInterface {
  /// Constructs a XmfunsdkdemoPlatform.
  XmfunsdkdemoPlatform() : super(token: _token);

  static final Object _token = Object();

  static XmfunsdkdemoPlatform _instance = MethodChannelXmfunsdkdemo();

  /// The default instance of [XmfunsdkdemoPlatform] to use.
  ///
  /// Defaults to [MethodChannelXmfunsdkdemo].
  static XmfunsdkdemoPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [XmfunsdkdemoPlatform] when
  /// they register themselves.
  static set instance(XmfunsdkdemoPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }


  Future<bool?> initSdk(String appUuid, String appKey, String appSecret, int appMovecard) {
    throw UnimplementedError('initSdk() has not been implemented.');
  }

  Future<bool?> startMonitor() {
    throw UnimplementedError('startMonitor() has not been implemented.');
  }

  Future<bool?> test() {
    throw UnimplementedError('startMonitor() has not been implemented.');
  }

  Future<bool?> test1() {
    throw UnimplementedError('startMonitor() has not been implemented.');
  }

  Future<bool?> test2() {
    throw UnimplementedError('startMonitor() has not been implemented.');
  }

  Future<bool?> test3() {
    throw UnimplementedError('startMonitor() has not been implemented.');
  }
}

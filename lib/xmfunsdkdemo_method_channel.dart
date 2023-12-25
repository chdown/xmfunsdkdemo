import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'xmfunsdkdemo_platform_interface.dart';

/// An implementation of [XmfunsdkdemoPlatform] that uses method channels.
class MethodChannelXmfunsdkdemo extends XmfunsdkdemoPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('xmfunsdkdemo');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }


  @override
  Future<bool?> initSdk(String appUuid, String appKey, String appSecret, int appMovecard) async {
    final isSuccess = await methodChannel.invokeMethod<bool>('initSdk', {
      "appUuid": appUuid,
      "appKey": appKey,
      "appSecret": appSecret,
      "appMovecard": appMovecard,
    });
    return isSuccess;
  }


  @override
  Future<bool?> startMonitor() async {
    final isSuccess = await methodChannel.invokeMethod<bool>('startMonitor');
    return isSuccess;
  }

  @override
  Future<bool?> test() async{
    final isSuccess = await methodChannel.invokeMethod<bool>('test');
    return isSuccess;
  }

  @override
  Future<bool?> test1() async{
    final isSuccess = await methodChannel.invokeMethod<bool>('test1');
    return isSuccess;
  }

  @override
  Future<bool?> test2() async{
    final isSuccess = await methodChannel.invokeMethod<bool>('test2');
    return isSuccess;
  }

  @override
  Future<bool?> test3() async{
    final isSuccess = await methodChannel.invokeMethod<bool>('test3');
    return isSuccess;
  }
}

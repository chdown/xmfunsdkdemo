import 'package:flutter_test/flutter_test.dart';
import 'package:xmfunsdkdemo/xmfunsdkdemo.dart';
import 'package:xmfunsdkdemo/xmfunsdkdemo_platform_interface.dart';
import 'package:xmfunsdkdemo/xmfunsdkdemo_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockXmfunsdkdemoPlatform
    with MockPlatformInterfaceMixin
    implements XmfunsdkdemoPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final XmfunsdkdemoPlatform initialPlatform = XmfunsdkdemoPlatform.instance;

  test('$MethodChannelXmfunsdkdemo is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelXmfunsdkdemo>());
  });

  test('getPlatformVersion', () async {
    Xmfunsdkdemo xmfunsdkdemoPlugin = Xmfunsdkdemo();
    MockXmfunsdkdemoPlatform fakePlatform = MockXmfunsdkdemoPlatform();
    XmfunsdkdemoPlatform.instance = fakePlatform;

    expect(await xmfunsdkdemoPlugin.getPlatformVersion(), '42');
  });
}

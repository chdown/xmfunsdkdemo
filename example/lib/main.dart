import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:xmfunsdkdemo/xmfunsdkdemo.dart';
import 'package:xmfunsdkdemo/monitor_view.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';
  final _xmfunsdkdemoPlugin = Xmfunsdkdemo();

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    await _xmfunsdkdemoPlugin.initSdk("657ac7052d362a5de6180337", "3db8cc79108bc7c6040b8e1b31f8fe6f", "67cb6a3cc0eb43f68c90542f8b8c3a11", 2);
    String platformVersion;
    // Platform messages may fail, so we use a try/catch PlatformException.
    // We also handle the message potentially returning null.
    try {
      platformVersion =
          await _xmfunsdkdemoPlugin.getPlatformVersion() ?? 'Unknown platform version';
    } on PlatformException {
      platformVersion = 'Failed to get platform version.';
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _platformVersion = platformVersion;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Column(
          children: [
            Text('Running on: $_platformVersion\n'),
            ElevatedButton(
                onPressed: () {
                  _xmfunsdkdemoPlugin.test();
                },
                child: Text("登录")),
            ElevatedButton(
                onPressed: () {
                  _xmfunsdkdemoPlugin.test1();
                },
                child: Text("密码输入")),
            ElevatedButton(
                onPressed: () {
                  _xmfunsdkdemoPlugin.test2();
                },
                child: Text("设备登录")),
            ElevatedButton(
                onPressed: () {
                  _xmfunsdkdemoPlugin.test3();
                },
                child: Text("test3")),
            ElevatedButton(
                onPressed: () {
                  _xmfunsdkdemoPlugin.startMonitor();
                },
                child: Text("启动")),
            Container(height: 300, child: MonitorView()),
          ],
        ),
      ),
    );
  }
}

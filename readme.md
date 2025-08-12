# traceroute-for-android [ ![Download](https://api.bintray.com/packages/angelwangjing/maven/traceroute-for-android/images/download.svg) ](https://bintray.com/angelwangjing/maven/traceroute-for-android/_latestVersion)
Easy way to use traceroute on Android.

## Description

Traceroute tracks the route packets taken from an IP network on their way to a given host. It utilizes the IP protocol's time to live (TTL) field and attempts to elicit an ICMP TIME_EXCEEDED response from each gateway along the path to the host.

## Rendering Image

![images/1.png](images/1.png)

## Adding to project

```groovy
dependencies {
    implementation 'com.wandroid:traceroute:<latest-version>'
}
```

## Simple usage

synchronous way

```kotlin
val traceResult = TraceRoute.traceRoute("www.google.com")
```

asynchronous way

```kotlin
TraceRoute.setCallback {
    success { Log.d("tag", "\ntraceroute finish") }
    update { text -> Log.d("tag", text) }
    failed { code, reason -> Log.d("tag", """\ntraceroute failed.code:$code, reason:$reason""") }
}
TraceRoute.traceRoute("www.google.com", true)
```

## Proguard

```proguard
-keepclassmembers com.wandroid.traceroute.TraceRoute {
    void clearResult();
    void appendResult(***);
    int execute(***);
}
```

get executable file from [traceroute-android-executable](https://github.com/wangjing53406/traceroute-android-executable)

## 适配16KB
1. 新增Android 16KB模式的适配
参考文档：[Android 支持 16 KB 的页面大小](https://developer.android.google.cn/guide/practices/page-sizes?hl=zh-cn#check-code)
2. 升级Traceroute for Linux版本为2.1.6，[官网链接](https://sourceforge.net/projects/traceroute/files/traceroute/)
package com.wandroid.traceroute.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatEditText
import android.support.v7.widget.AppCompatTextView
import com.traceroute.TraceRoute
import com.traceroute.TraceRouteResult
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var text: AppCompatEditText

    lateinit var result: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val traceRoute = TraceRoute.traceRoute(arrayOf("traceroute", "--help"))

        text = findViewById(R.id.sample_text)
        result = findViewById(R.id.result)

        findViewById<AppCompatButton>(R.id.sample_button).setOnClickListener {
            doTraceRoute()
        }

    }

    private fun doTraceRoute() {
        result.text = ""
//        TraceRoute.setCallback(object : TraceRouteCallback {
//            override fun onSuccess(traceRouteResult: TraceRouteResult) {
//                result.append("\ntraceroute finish")
//            }
//
//            override fun onUpdate(text: String) {
//                result.append(text)
//            }
//
//            override fun onFailed(code: Int, reason: String) {
//                result.append("\ntraceroute failed")
//            }
//        })
        TraceRoute.setCallback {
            success { result.append(getTraceRouteDetail(it)) }
            update { text -> result.append(text) }
            failed { code, reason -> result.append("""\ntraceroute failed.code:$code, reason:$reason""") }
        }
        TraceRoute.traceRoute(text.text.toString(), true)
    }

    private fun getTraceRouteDetail(traceRouteResult: TraceRouteResult): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        val traceProd = StringBuilder()
        traceProd.append("\n{")
            .append("moduleVer='").append(traceRouteResult.moduleVer).append("'")
            .append(", protocol='").append(traceRouteResult.protocol).append("'")
            .append(", toHost='").append(traceRouteResult.toHost).append("'")
            .append(", startTime='").append(formatter.format(traceRouteResult.startTime)).append("'")
            .append(", domainTime='").append(traceRouteResult.domainTime).append("'")
            .append(", targetIP='").append(traceRouteResult.targetIP).append("'")
            .append(", detail=").append(traceRouteResult.detail)
            .append('}')
        return traceProd.toString()
    }

}

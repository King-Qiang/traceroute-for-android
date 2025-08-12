package com.traceroute

data class TraceRouteResult(
    var moduleVer: String = "",           // 模块版本
    var protocol: String = "",            // 使用协议
    var code: Int = 0,                    // 状态码
    var startTime: Long = 0L,             // 开始时间戳
    var targetIP: String = "",            // 目标IP地址
    var toHost: String = "",              // 目标主机名
    var domainTime: Long = 0L,            // 域名解析时间
    var detail: String = ""               // 详细结果信息
) {
    companion object {
        /**
         * 获取 TraceRouteResult 实例
         */
        fun instance(): TraceRouteResult {
            return TraceRouteResult()
        }
    }

    /**
     * 重置所有字段为默认值
     */
    fun reset() {
        moduleVer = ""
        protocol = ""
        code = 0
        startTime = 0L
        targetIP = ""
        toHost = ""
        domainTime = 0L
        detail = ""
    }
}

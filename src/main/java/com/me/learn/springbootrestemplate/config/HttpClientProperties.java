/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.learn.springbootrestemplate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/11/17
 **/

@ConfigurationProperties(prefix = "httpclient")
public class HttpClientProperties {
    private int maxTotalConnections;
    private int defaultMaxPerRoute;
    private long defaultKeepAliveTimeMillis;
    private int requestTimeout;
    private int connectTimeout;
    private int socketTimeout;
    private long closeIdleConnectionWaitTimeSecs;

    public int getMaxTotalConnections() {
        return maxTotalConnections;
    }

    public void setMaxTotalConnections(int maxTotalConnections) {
        this.maxTotalConnections = maxTotalConnections;
    }

    public int getDefaultMaxPerRoute() {
        return defaultMaxPerRoute;
    }

    public void setDefaultMaxPerRoute(int defaultMaxPerRoute) {
        this.defaultMaxPerRoute = defaultMaxPerRoute;
    }

    public long getDefaultKeepAliveTimeMillis() {
        return defaultKeepAliveTimeMillis;
    }

    public void setDefaultKeepAliveTimeMillis(long defaultKeepAliveTimeMillis) {
        this.defaultKeepAliveTimeMillis = defaultKeepAliveTimeMillis;
    }


    public int getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(int requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public long getCloseIdleConnectionWaitTimeSecs() {
        return closeIdleConnectionWaitTimeSecs;
    }

    public void setCloseIdleConnectionWaitTimeSecs(long closeIdleConnectionWaitTimeSecs) {
        this.closeIdleConnectionWaitTimeSecs = closeIdleConnectionWaitTimeSecs;
    }
}

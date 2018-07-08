package com.jiayang.middleware.exceptions;

public class PluginSize0Exception extends RuntimeException {
    public PluginSize0Exception() {
        super("未加载任何插件");
    }
}

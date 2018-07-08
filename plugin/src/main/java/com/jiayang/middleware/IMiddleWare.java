package com.jiayang.middleware;

import com.jiayang.middleware.IPlugin.IPlugin;

public interface IMiddleWare {
 AbstactMiddleWare use(IPlugin plugin);
 AbstactMiddleWare apply();
}
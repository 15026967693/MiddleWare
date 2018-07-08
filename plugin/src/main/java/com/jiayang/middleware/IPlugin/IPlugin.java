package com.jiayang.middleware.IPlugin;

import com.jiayang.middleware.Functions.Function0;

public interface IPlugin {
void applyPlugin(Object[] args, Function0<Void> next);
}

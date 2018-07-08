package com.jiayang.middleware.exceptions;

public class PluginHasBeenAddedException extends RuntimeException{
    public PluginHasBeenAddedException(){
        super("插件已经加载目前插件为单例模式不能重复加载。" +
                "\n请检查编程与spring配置文件是否重复加载插件");

    }
}

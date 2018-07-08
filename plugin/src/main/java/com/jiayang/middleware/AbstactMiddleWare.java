package com.jiayang.middleware;
import com.jiayang.middleware.Functions.Function0;
import com.jiayang.middleware.IPlugin.IPlugin;
import com.jiayang.middleware.exceptions.PluginHasBeenAddedException;
import com.jiayang.middleware.exceptions.PluginSize0Exception;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstactMiddleWare implements IMiddleWare {
private List<IPlugin> plugins=new ArrayList<IPlugin>();
private IPlugin curPlugin=null;
private Object[] args=null;
private int curPluginIndex=0;
    /**
     * 运行下一个中间件的方法
     */
    private Function0<Void> next=new Function0<Void>() {
    public Void apply() {
        if(curPluginIndex!=plugins.size()) {
            curPlugin = plugins.get(curPluginIndex++);
            curPlugin.applyPlugin(args, next);
        }
        else
            curPluginIndex=0;

        return null;
    }
};

    public AbstactMiddleWare(){}

    public AbstactMiddleWare(Object[] args)
    {
        this.args=args;
    }
    /**
     * 添加插件的方法，
     * 当插件已经存在时抛出错误出于性能考虑目前只支持单个插件，
     * 但是可以通过plugin的equals方法将两个相同的插件强行识别为不同的插件但不建议使用
     * @param plugin 添加的插件
     * @return
     *
     */
    public AbstactMiddleWare use(IPlugin plugin)
{
    if(!plugins.contains(plugin))
    plugins.add(plugin);
    else
        throw new PluginHasBeenAddedException();
    return this;
}
@Override
public AbstactMiddleWare apply(){
        if(plugins.size()==0)
            throw new PluginSize0Exception();
        curPlugin=plugins.get(curPluginIndex++);
        curPlugin.applyPlugin(args,next);
       return this;

}

}

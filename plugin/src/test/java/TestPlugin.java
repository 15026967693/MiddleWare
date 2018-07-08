import com.jiayang.middleware.Functions.Function0;
import com.jiayang.middleware.IPlugin.IPlugin;
import org.junit.Test;

public class TestPlugin implements IPlugin {
    private static  volatile TestPlugin plugin;
    public static   TestPlugin createTestPlugin(){
        if(plugin==null) {
            synchronized (TestPlugin.class) {
                if (plugin == null)
                    return new TestPlugin();
            }
        }
        return plugin;
    }
        private TestPlugin(){}
    @Override
    public void applyPlugin(Object[] args, Function0<Void> next) {
        System.out.println(args[0]);
        System.out.println("applyplugin1");
        next.apply();
    }
}

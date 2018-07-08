import com.jiayang.middleware.Functions.Function0;
import com.jiayang.middleware.IPlugin.IPlugin;

public class TestPlugin2 implements IPlugin {

    @Override
    public void applyPlugin(Object[] args, Function0<Void> next) {
        System.out.println(args[1]);
        next.apply();
    }
}

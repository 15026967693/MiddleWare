import org.junit.Test;

public class  Test1{
    @Test
    public void test(){

        TestMiddleWare tmw=new TestMiddleWare(new Object[]{"hello","world"});
        tmw.use(TestPlugin.createTestPlugin()).use(new TestPlugin2()).use(new TestPlugin2()).apply().apply();
        new TestMiddleWare().apply();
    }


}
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MainPageInvocationHandler implements InvocationHandler {
    private MainPage mainPage;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.getAnnotation(Selector.class).xpath();
    }
}

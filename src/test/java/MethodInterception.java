import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MethodInterception {

    @Test
    public void annotationValue() {
        MainPage mainPage = createPage(MainPage.class);
        assertNotNull(mainPage);
        assertEquals(mainPage.buttonSearch(), ".//*[@test-attr='button_search']");
        assertEquals(mainPage.textInputSearch(), ".//*[@test-attr='input_search']");
    }

    private MainPage createPage(Class clazz) {

        MainPage mainPage = (MainPage) Proxy.newProxyInstance(MainPageInvocationHandler.class.getClassLoader(), new Class[] { clazz }, new MainPageInvocationHandler());
        return mainPage;
    }
}

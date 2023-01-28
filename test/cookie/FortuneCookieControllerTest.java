package cookie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class FortuneCookieControllerTest {

    private static FortuneCookieController goodFactoryController;
    private static FortuneCookieController badFactoryController;
    private static FortuneCookieFactory goodFactory;
    private static FortuneCookieFactory badFactory;
    private static FortuneConfig goodConfig;
    private static FortuneConfig badConfig;

    @BeforeAll
    public static void beforeEach() {
        goodConfig = new FortuneConfig(true);
        goodFactory = new FortuneCookieFactory(goodConfig,
                Collections.singletonList("positive"),
                Collections.singletonList("negative"));
        goodFactoryController = new FortuneCookieController(goodFactory);

        badConfig = new FortuneConfig(false);
        badFactory = new FortuneCookieFactory(badConfig,
                Collections.singletonList("positive"),
                Collections.singletonList("negative"));
        badFactoryController = new FortuneCookieController(badFactory);
    }

    @Test
    public void shouldReturnPositiveFortune(){
        Assertions.assertEquals("positive", goodFactoryController.tellFortune().getFortuneText());
    }

    @Test
    public void shouldReturnNegativeFortune(){
        Assertions.assertEquals("negative", badFactoryController.tellFortune().getFortuneText());
    }

}

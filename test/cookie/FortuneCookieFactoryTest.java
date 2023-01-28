package cookie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class FortuneCookieFactoryTest {
    private static FortuneCookieFactory fabrica;

    @BeforeEach
    public void beforeEach() {
        fabrica = new FortuneCookieFactory(new FortuneConfig(true),
                Collections.singletonList("positive"),
                Collections.singletonList("negative"));
    }

    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked(){
        fabrica.bakeFortuneCookie();
        Assertions.assertEquals(1, fabrica.getCookiesBaked());
    }

    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked (){
        fabrica.bakeFortuneCookie();
        fabrica.bakeFortuneCookie();
        Assertions.assertEquals(2, fabrica.getCookiesBaked());
    }

    @Test
    public void shouldSetCounterToZeroAfterResetCookieCreatedCall (){
        fabrica.bakeFortuneCookie();
        Assertions.assertEquals(1, fabrica.getCookiesBaked());
        fabrica.resetCookiesCreated();
        Assertions.assertEquals(0, fabrica.getCookiesBaked());
    }
}
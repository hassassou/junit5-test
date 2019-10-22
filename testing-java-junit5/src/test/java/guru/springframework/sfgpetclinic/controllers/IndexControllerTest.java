package guru.springframework.sfgpetclinic.controllers;

import org.assertj.core.api.Java6Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Wrong View Returned");
        Java6Assertions.assertThat(indexController.index()).isEqualTo("index");
    }

    @Test
    void oupsHandler() {
        assertTrue("notimplemented".equals(indexController.oupsHandler()), () -> "This is some message expensive to build for my test");
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here");
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeoutPreempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here 234157962/89");
        });
    }

    @Test
    void testAssumptionTrue() {
        Assumptions.assumeTrue("Hassa".equalsIgnoreCase("HASSA"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOs(){

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindowsOs() {

    }

    @EnabledOnOs(OS.LINUX)
    @Test
    void testMeOnMLinuxOs() {

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "mhassa")
    @Test
    void testIfUserMH() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    void testIfUserFred() {

    }
}
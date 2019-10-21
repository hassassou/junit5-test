package guru.springframework;

import org.junit.jupiter.api.*;

class GreetingTest {

    private Greeting greeting;

    @BeforeAll
    static void beforeClass() {
        System.out.println("Before - I am only called one");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each ............");
        greeting = new Greeting();
    }

    @Test
    void helloWorld() {
        System.out.println(greeting.helloWorld());

    }

    @Test
    void helloWorld1() {
        System.out.println(greeting.helloWorld("Mohamed"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("In After Each ............");
    }

    @AfterAll
    static void afterClass() {
        System.out.println("After - I am only called one");
    }
}
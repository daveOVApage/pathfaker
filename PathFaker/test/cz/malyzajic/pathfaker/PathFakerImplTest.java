package cz.malyzajic.pathfaker;

import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author daop
 */
public class PathFakerImplTest {

    public PathFakerImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of preparePathContext method, of class PathFakerImpl.
     */
    @Test
    public void testPreparePathContextNullInput() {
        System.out.println("preparePathContext :: null input");
        PathRequest request = null;
        PathFakerProviderEnum provider = null;
        PathFakerImpl instance = new PathFakerImpl();
        PathContext expResult = null;
        Properties properties = null;
        PathContext result = instance.preparePathContext(request, provider, properties);
        assertEquals(expResult, result);
    }

    @Test
    public void testPreparePathContextGoogleInput() {
        System.out.println("preparePathContext :: google input");
        PathRequest request = null;
        PathFakerProviderEnum provider = PathFakerProviderEnum.GOOGLE;
        PathFakerImpl instance = new PathFakerImpl();
        Properties properties = null;

        boolean thrown = false;
        try {
            instance.preparePathContext(request, provider, properties);
        } catch (IllegalStateException e) {
            thrown = true;
        }

        assertTrue(thrown);

    }

    @Test
    public void testPreparePathContextGoogleFullInput() {
        System.out.println("preparePathContext :: google full input");
        PathRequest request = new PathRequest();
        request.setStartPlaceName("Ostrava, Nádražní 140");
        request.setEndPlaceName("Opava, Nákladní 20");

        PathFakerProviderEnum provider = PathFakerProviderEnum.GOOGLE;
        PathFakerImpl instance = new PathFakerImpl();
        Properties properties = new Properties();
        properties.put("key", "");
        properties.put("language", "cs");
        PathContext result = instance.preparePathContext(request, provider, properties);
        boolean google = result instanceof GooglePathContext;
        assertEquals(google, true);
    }

}

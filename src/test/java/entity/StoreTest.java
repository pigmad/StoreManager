package entity;

import junit.framework.TestCase; 
import org.junit.Test;

/**
 *
 * @author laste
 */
public class StoreTest extends TestCase { 
    private Store stubStore; 
    
    @Override
    protected void setUp() throws Exception {
        stubStore = new Store();
    } 
    
    @Test
    public void testSetAndGetIdStore() {
        int testId = 1;
        assertEquals(0, 0, 0);    
        stubStore.setIdStore(testId);
        assertEquals(testId, stubStore.getIdStore());
    }
    
    @Test
    public void testSetAndGetCity() {
        String testCity = "cityTest";
        assertNull(stubStore.getCity());
        stubStore.setCity(testCity);
        assertEquals(testCity, stubStore.getCity());
    } 
    
    
    @Test
    public void testConstructor(){
        int testId = 5;
        String testCity = "cityTest";
        stubStore = new Store(testId, testCity);
        assertEquals(testId, stubStore.getIdStore());
        assertEquals(testCity, stubStore.getCity());
    }
}

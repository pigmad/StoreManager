package entity;

import junit.framework.TestCase; 
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author laste
 */
public class ItemTest extends TestCase { 
    private Item stubItem; 
    
    @Override
    protected void setUp() throws Exception {
        stubItem = new Item();
    } 
    
    @Test
    public void testSetAndGetIdItem() {
        int testId = 1;
        assertEquals(0, 0, 0);    
        stubItem.setIdItem(testId);
        assertEquals(testId, stubItem.getIdItem());
    }
    
    @Test
    public void testSetAndGetName() {
        String testName = "NameTest";
        assertNull(stubItem.getName());
        stubItem.setName(testName);
        assertEquals(testName, stubItem.getName());
    } 
    
    @Test
    public void testSetAndGetPrice() {
        double testPrice = 100.00;
        assertEquals(0, 0, 0);    
        stubItem.setPrice(testPrice);
        assertEquals(testPrice, stubItem.getPrice(), 0);
    }  
    
    @Test
    public void testSetAndGetQuantity() {
        int testQuantity = 10;
        assertEquals(0, 0, 0);    
        stubItem.setQuantity(testQuantity);
        assertEquals(testQuantity, stubItem.getQuantity(), 0);
    } 
    
    @Test
    public void testConstructor(){
        String testName = "NameTest";
        int testId = 2;
        double testPrice = 100.00;
        int testQuantity = 89;
        stubItem = new Item(testId, testName, testPrice, testQuantity);
        assertEquals(testName,stubItem.getName());
        assertEquals(testId, stubItem.getIdItem());
        assertEquals(testPrice, stubItem.getPrice(), 0);
        assertEquals(testQuantity, stubItem.getQuantity());
    }
}

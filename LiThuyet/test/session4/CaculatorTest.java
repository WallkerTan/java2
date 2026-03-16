package LiThuyet.test.session4;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import LiThuyet.main.session4.Cacullator;

public class CaculatorTest {
    
    @Test
    @DisplayName("test add a+b")
    public void testAdd(){
        int a = 2;
        int b = 3;
        int expected = 5;
        
        int actual = Cacullator.add(a, b);
        assertEquals(expected, actual);
    }

}

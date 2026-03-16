package src.test.session4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import src.main.session4.s4_ex1;

public class test_s1_login {

    
    @DisplayName("test_login_s1")
    @ParameterizedTest
    @CsvSource({
            "'Nguyen Van', true",
            "'NguyenVan', false",
            "'Hello World', true",
            "'HelloWorld', false"
    })
    public void tests1(String name, boolean expected) {
        assertEquals(expected, s4_ex1.s1_login(name));
    }
}

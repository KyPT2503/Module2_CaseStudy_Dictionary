package dictionary.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RequestCreatorTest {
    private String input;
    private String result;

    public RequestCreatorTest(String input, String result) {
        this.input = input;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"define --adjective summer", "Request: kind_define, keyword_summer, kindOfDefine_ADJECTIVE"},
                {"define --noun summer","Request: kind_define, keyword_summer, kindOfDefine_NOUN"},
                {"define --pronoun summer","Request: kind_define, keyword_summer, kindOfDefine_PRONOUN"},
                {"lookup summer","Request: kind_lookup, keyword_summer"},
                {"drop summer","Request: kind_drop, keyword_summer"},
                {"","Invalid request."},
                {"define","Invalid request."},
                {"  lookup summer","Invalid request."},
        });
    }

    @Test
    public void createRequest() {
        RequestCreator requestCreator = RequestCreator.getInstance();
        assertEquals(requestCreator.createRequest(input).toString(), result);
    }
}
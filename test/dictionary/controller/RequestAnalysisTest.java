package dictionary.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RequestAnalysisTest {
    private String input;
    private String result;

    public RequestAnalysisTest(String input, String result) {
        this.input = input;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {" define  summer --adjective", "define summer --adjective"},
                {"define   summer --noun", "define summer --noun"},
                {"define summer --pronoun", "define summer --pronoun"},
                {"     lookup summer", "lookup summer"},
                {"  lookup summer   ", "lookup summer"},
                {"lookup summer", "lookup summer"},
                {"drop summer", "drop summer"},
                {"  drop    summer ", "drop summer"},
                {"drop summer", "drop summer"},
        });
    }

    @Test
    public void test() {
        RequestAnalysis requestAnalysis = RequestAnalysis.getInstance();
        assertEquals(requestAnalysis.analysis(input), result);
    }
}
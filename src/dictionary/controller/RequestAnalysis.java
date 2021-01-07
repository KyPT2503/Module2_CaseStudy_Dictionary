package dictionary.controller;

import java.util.regex.Pattern;

public class RequestAnalysis {
    private static RequestAnalysis instance;

    private RequestAnalysis() {
    }

    public static RequestAnalysis getInstance() {
        if (instance == null) {
            synchronized (RequestAnalysis.class) {
                if (instance == null)
                    instance = new RequestAnalysis();
            }
        }
        return instance;
    }

    public String analysis(String request) {
        request = request.trim();
        request = request.replaceAll("\\s+", " ");
        return request;
    }
}

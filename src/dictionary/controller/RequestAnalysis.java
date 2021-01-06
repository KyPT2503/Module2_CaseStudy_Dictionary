package dictionary.controller;

import java.util.regex.Pattern;

public class RequestAnalysis {

    static final Pattern lookupPattern = Pattern.compile("lookup\\s(.*?)");
    static final Pattern definePattern = Pattern.compile("define\\s--(.*?)\\s+(.*?)");
    static final Pattern dropPattern = Pattern.compile("drop\\s(.*?)");

    public Request analysis(String request) {
        request = request.trim();
        request = request.replaceAll("\\s+", "\\s");
        return null;
    }
}

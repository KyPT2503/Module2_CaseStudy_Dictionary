package dictionary.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestCreator {
    static final Pattern lookupPattern = Pattern.compile("lookup\\s(.*?)");
    static final Pattern definePattern = Pattern.compile("define\\s--(pronoun|noun|adjective|verb|synonymous)\\s+(.*?)");
    static final Pattern dropPattern = Pattern.compile("drop\\s(.*?)");

    private static RequestCreator instance;

    private RequestCreator() {
    }

    public static RequestCreator getInstance() {
        if (instance == null) {
            synchronized (RequestCreator.class) {
                if (instance == null) {
                    instance = new RequestCreator();
                }
            }
        }
        return instance;
    }

    public Request createRequest(String request) {
        Matcher matcherLookup = lookupPattern.matcher(request);
        Matcher matcherDefine = definePattern.matcher(request);
        Matcher matcherDrop = dropPattern.matcher(request);

        if (matcherLookup.matches()) {
            return new LookupRequest(matcherLookup.group(1));
        } else if (matcherDefine.matches()) {
            return new DefineRequest(matcherDefine.group(1), matcherDefine.group(2));
        } else if (matcherDrop.matches()) {
            return new DropRequest(matcherDrop.group(1));
        } else {
            return new InvalidRequest();
        }
    }
}
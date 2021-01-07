package dictionary.controller;

public class DefineRequest extends Request {
    public static final String PRONOUN = "pronoun";
    public static final String ADJECTIVE = "adjective";
    public static final String NOUN = "noun";
    public static final String VERB = "verb";
    public static final String SYNONYMOUS = "synonymous";

    private kindOfDefine kind;
    private String keyWord;

    private enum kindOfDefine {PRONOUN, ADJECTIVE, NOUN, VERB, SYNONYMOUS}

    public DefineRequest(String kind, String keyWord) {
        if (kind.equals(PRONOUN)) {
            this.kind = kindOfDefine.PRONOUN;
        } else if (kind.equals(ADJECTIVE)) {
            this.kind = kindOfDefine.ADJECTIVE;
        } else if (kind.equals(NOUN)) {
            this.kind = kindOfDefine.NOUN;
        } else if (kind.equals(VERB)) {
            this.kind = kindOfDefine.VERB;
        } else if (kind.equals(SYNONYMOUS)) {
            this.kind = kindOfDefine.SYNONYMOUS;
        }
        this.keyWord = keyWord;
    }

    @Override
    public String toString() {
        return "Request: kind_define, keyword_" + this.keyWord + ", kindOfDefine_" + this.kind;
    }
}
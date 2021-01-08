package dictionary.controller;

public class DefineRequest extends Request {
    public static final String PRONOUN = "pronoun";
    public static final String ADJECTIVE = "adjective";
    public static final String NOUN = "noun";
    public static final String VERB = "verb";
    public static final String SYNONYMOUS = "synonymous";
    public static final String KIND_OF_DEFINE_IS_INVALID = "kind of define is invalid.";

    private kindOfDefine kind;

    public enum kindOfDefine {PRONOUN, ADJECTIVE, NOUN, VERB, SYNONYMOUS}

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
        } else {
            UserInterfaceController.getInstance().display(KIND_OF_DEFINE_IS_INVALID);
        }
        this.keyWord = keyWord;
    }

    public kindOfDefine getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return "Request: kind_define, keyword_" + this.keyWord + ", kindOfDefine_" + this.kind;
    }
}
package dictionary.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
    public static final String CONTENT_IN_FILE_IS_NOT_VALID = "Content in file is not valid.";
    private String name;
    private String pronoun;
    private String noun;
    private String verb;
    private String adjective;
    private String synonymous;

    public Word(String content) throws IllegalArgumentException {
        Pattern wordPattern = Pattern.compile("^@(.*?) ((.|\n)*?)\n\\* Adjective\n((.|\n)*?)\n\\* Noun\n((.|\n)*?)\n\\* Verb\n((.|\n)*?)\n\\* Synonymous\n((.|\n)*?)");
        Matcher matcher = wordPattern.matcher(content);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(CONTENT_IN_FILE_IS_NOT_VALID);
        }
        this.name = matcher.group(1);
        this.pronoun = matcher.group(2);
        this.adjective = matcher.group(3);
        this.noun = matcher.group(4);
        this.verb = matcher.group(5);
        this.synonymous = matcher.group(6);
    }

    public Word(String name, String pronoun, String noun, String verb, String adjective, String synonymous) {
        this.name = name;
        this.pronoun = pronoun;
        this.noun = noun;
        this.verb = verb;
        this.adjective = adjective;
        this.synonymous = synonymous;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "@" + this.name + " " + this.pronoun + "\n" +
                "* " + "Adjective\n" + this.adjective + "\n" +
                "* " + "Noun\n" + this.noun + "\n" +
                "* " + "Verb\n" + this.verb + "\n" +
                "* " + "Synonymous\n" + this.synonymous;
    }
}

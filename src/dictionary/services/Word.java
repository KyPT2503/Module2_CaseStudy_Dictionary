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

        reStructureContent(content);
        content += "*";

        this.name = matcher.group(1);
        this.pronoun = matcher.group(2);
        this.adjective = getMeaning("Adjective", content);
        this.noun = getMeaning("Noun", content);
        this.verb = getMeaning("Verb", content);
        this.synonymous = getMeaning("Synonymous", content);
    }

    public Word(String name, String pronoun, String noun, String verb, String adjective, String synonymous) {
        this.name = name;
        this.pronoun = pronoun;
        this.noun = noun;
        this.verb = verb;
        this.adjective = adjective;
        this.synonymous = synonymous;
    }

    private void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    private void setNoun(String noun) {
        this.noun = noun;
    }

    private void setVerb(String verb) {
        this.verb = verb;
    }

    private void setAdjective(String adjective) {
        this.adjective = adjective;
    }

    private void setSynonymous(String synonymous) {
        this.synonymous = synonymous;
    }

    public void addDefinePronoun(String pronoun) {
        this.setPronoun(pronoun);
    }

    public void addDefineNoun(String noun) {
        this.setNoun(this.noun + (this.noun.equals("") ? "" : "\n") + noun);
    }

    public void addDefineAdjective(String adjective) {
        this.setAdjective(this.adjective + (this.adjective.equals("") ? "" : "\n") + adjective);
    }

    public void addDefineVerb(String verb) {
        this.setVerb(this.verb + (this.verb.equals("") ? "" : "\n") + verb);
    }

    public void addDefineSynonymous(String synonymous) {
        this.setSynonymous(this.synonymous + (this.synonymous.equals("") ? "" : "\n") + synonymous);
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

    private static void reStructureContent(String content) {
        content = content.replaceAll("\\*", "\\*\\*");
        content = content.replaceFirst("\\*", "");
    }

    private static String getMeaning(String kindOfMeaning, String content) {
        Pattern pattern = Pattern.compile("\\* " + kindOfMeaning + "((.|\\n)*?)\\*");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return null;
    }
}
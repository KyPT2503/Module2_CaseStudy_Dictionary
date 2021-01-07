import dictionary.controller.*;
import dictionary.services.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        /*Pattern downPattern = Pattern.compile("^((.|\n)*?)");
        String string = "summer\nsummer\nsummer'";
        System.out.println(downPattern.matcher(string).matches());*/
        /*String content = "@abc /xxy-z/\n* Adjective\nsummer\n* Noun\nsummer\n* Verb\n\n* Synonymous\nsummer";
        System.out.println(content);
        System.out.println(wordPattern.matcher(content).matches());*/
        Pattern wordPattern = Pattern.compile("^@(.*?) (.*?)\\n\\* Adjective\\n((.|\\n)*?)\\n\\* Noun\\n((\\n|.)*?)\n\\* Verb\n((.|\n)*?)\n\\* Synonymous\n((.|\n)*?)");
        File file = new File("words/summer.txt");
        String content = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                content += line.trim() + "\n";
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Matcher matcher = wordPattern.matcher(content);
        System.out.println(matcher.matches());
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
        System.out.println(matcher.group(4));
    }
}

package dictionary.services;

import java.io.*;

/*read and write from/to files*/
public class FileController {
    private static FileController instance;

    public static FileController getInstance() {
        if (instance == null) {
            synchronized (FileController.class) {
                if (instance == null) {
                    instance = new FileController();
                }
            }
        }
        return instance;
    }

    public Word getWord(String name) {
        File file = new File("words/" + name + ".txt");
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
        return new Word(content);
    }

    public static void main(String[] args) {
        System.out.println(getInstance().getWord("summer"));
    }

    public String getContent(String name){
        File file = new File("words/" + name + ".txt");
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
        return content;
    }

    public void defineWord(Word word) {
        File file = new File("words/" + word.getName() + ".txt");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(word.toString());
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteWord(String name) {
        File file = new File("words/" + name + ".txt");
        boolean result = file.delete();
    }
}

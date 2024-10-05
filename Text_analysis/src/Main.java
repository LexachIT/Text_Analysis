import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Укажите путь к вашему файлу здесь
        String filePath = "D:/Текст.svc";

        try {
            StringBuilder text = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            reader.close();

            // Определение расширения файла
            String extension = getFileExtension(filePath);
            String[] words;

            if (extension.equals("svс")) {
                words = text.toString().split("[\\s,]+");  // Разделение по пробелам и запятым для SVC
            } else {
                words = text.toString().split("\\s+");     // Разделение по пробелам для TXT
            }

            int totalChars = text.length();
            int totalCharsWithoutSpaces = text.toString().replace(" ", "").length();
            int wordCount = words.length;

            // Вывод статистики в консоль
            System.out.println("Количество символов: " + totalChars);
            System.out.println("Количество символов без пробелов: " + totalCharsWithoutSpaces);
            System.out.println("Количество слов: " + wordCount);

            // Запись статистики в файл
            FileWriter writer = new FileWriter(new File("statistics.txt"));
            writer.write("Количество символов: " + totalChars + "\n");
            writer.write("Количество символов без пробелов: " + totalCharsWithoutSpaces + "\n");
            writer.write("Количество слов: " + wordCount + "\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для получения расширения файла
    private static String getFileExtension(String filePath) {
        String fileName = new File(filePath).getName();
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // пустая строка если нет расширения
        }
        return fileName.substring(lastIndexOf + 1);
    }
}


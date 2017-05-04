package Main;

import java.io.File;

public class Main {

    //TODO: доделать поиск по поддиректориям
    //TODO: доделать слачаи с остав. аргументами
    static public boolean SearchInfolder(String dir, String filename) {
        return false;
    }

    static public boolean Find(String[] args) {
        boolean found = false;
        System.out.println("Lab 2 started!");
        if (args.length == 4) {
            if (args[0] == "-r" && args[1] == "-d") {
                String dir = args[2], filename = args[3];
                File folder = new File(dir);
                if (folder != null && folder.listFiles() != null) {
                    for (int i = 0; i < folder.listFiles().length; i++) {
                        System.out.println(folder.listFiles()[i]);
                    }
                }
            }


        } else if (args.length == 3) {
            if (args[0] == "-d") {
                String dir = args[1], filename = args[2];
                File folder = new File(dir);
                if (folder != null && folder.listFiles() != null) {
                    for (int i = 0; i < folder.listFiles().length; i++) {
                        if (folder.listFiles()[i].getName().equals(filename)) {
                            found = true;
                            break;
                        }
                    }

                }
            }

        } else if (args.length == 1) {

        } else {
            System.out.println("Неверное указаны параметры!");
        }

        return found;
    }

    //Вызов cmd
    //C:\Users\Александр\IdeaProjects\Lab2\out\artifacts\Lab2_jar>java -jar Lab2.jar
    public static void main(String[] args) {

        if (Find(new String[]{"-r", "-d", "C:\\Users\\Александр\\Desktop", "target.txt"})) {
            System.out.print("Файл найден");
        } else
            System.out.print("Файл  не найден");
        //Find(args);
    }
}

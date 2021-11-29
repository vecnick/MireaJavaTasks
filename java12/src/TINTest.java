import java.util.Scanner;
import java.util.HashMap;


public class TINTest
{
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        var database = new HashMap<String, String>(5);
        database.put("1", "никита");
        database.put("2", "женя");
        database.put("3", "боря");
        database.put("4", "гоша");
        database.put("5", "влад");
        System.out.print("Введите Ф.И.О.: ");
        String name = in.nextLine();
        System.out.print("Введите ИНН: ");
        String tin = in.next();
        try
        {
            String dbName = database.get(tin);
            if (!name.equals(dbName))
            {
                throw new InvalidTINException("[ОШИБКА]: ИНН \"" + tin + "\" не действителен для \"" + name + "\".");
            }
            System.out.println("ИНН \"" + tin + "\" действителен для \"" + name + "\".");
        }
        catch (InvalidTINException exception)
        {
            System.err.println(exception.getMessage());
        }
    }
}
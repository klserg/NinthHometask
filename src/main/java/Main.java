import org.example.services.*;
import org.example.ui.menu.ExitMenuItem;
import org.example.ui.menu.Menu;
import org.example.ui.menu.MenuItem;
import org.example.ui.menu.contacts.*;
import org.example.ui.views.ConsoleContactsView;
import org.example.ui.views.ContactsView;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // ContactsService contactsService = new CsvContactsService(Path.of("1.csv"));
       // ContactsService contactsService = new ByteContactsService();
       //ContactsService contactsService = new InMemoryContactsService();
        ContactsService contactsService = new XMLContactService(new File("list.xml"));
      // ContactsService contactsService = new JSONContactService(new File("list.json"));
       ContactsView contactsView = new ConsoleContactsView(scanner);

        List<MenuItem> menuItemList = List.of(
                new ShowAllMenuItem(contactsService, contactsView),
                new AddContactsMenuItem(contactsService, contactsView),
                new DeleteContactsMenuItem(contactsService, contactsView),
                new FindContactsByNameMenuItem(contactsService, contactsView),
                new FindContactsByValueMenuItem(contactsService, contactsView),
                new ExitMenuItem("Выход"));

        Menu menu = new Menu(scanner, menuItemList);
        menu.run();

//        File file = new File("./");
//        searchJavaFile(file);
    }

    public static void searchJavaFile(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.getName().contains(".java")) {
                    System.out.println(f.getName());
                }
                    searchJavaFile(f);
                }
            }
        }
    }


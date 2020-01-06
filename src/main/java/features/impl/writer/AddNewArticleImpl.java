package features.impl.writer;

import config.crud.CrudArticle;
import config.crud.CrudCategory;
import entities.Article;
import entities.Category;
import entities.User;
import features.usecase.writer.AddNewArticleUseCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AddNewArticleImpl implements AddNewArticleUseCase {
    private User user;

    public AddNewArticleImpl(User user) {
        this.user = user;
    }

    @Override
    public void addNewArticle() {
        Scanner scanner = new Scanner(System.in);
        outer:
        while (true) {
            System.out.println("Categories:");
            List<Category> categories = CrudCategory.getInstance().findAll();
            if (categories.size() == 0) {
                System.out.println("There are no category.");
                break;
            } else categories.forEach(System.out::println);
            System.out.println("select category id to add:");
            long categoryId = scanner.nextLong();
            Category category = CrudCategory.getInstance().findById(categoryId);
            System.out.println("title:");
            String title = scanner.next();
            System.out.println("Brief:");
            String brief = scanner.next();
            System.out.println("Content:");
            String content = scanner.next();

            System.out.println("Publish Date (Enter in  following format : yyyy.MM.dd)");
            String date = scanner.next();
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
            Date publishDate = null;

            try {
                publishDate = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            CrudArticle.getInstance().
                    save(new Article(
                            title,
                            brief,
                            content,
                            new Date(),
                            new Date(),
                            publishDate,
                            false,
                            category,
                            user,
                            null)
                    );
            System.out.println("Woul you like to add new article again?\n" +
                    "1: Yes\n" +
                    "2: No");
            while(true) {
                String str = scanner.next();
                if (str.equals("1")) continue outer;
                else if (str.equals("2")) break outer;
                else System.out.println("invalid number!\nPlease try again...");
            }

        }

    }
}

package features.impl;

import entities.Article;
import entities.Category;
import entities.User;
import features.usecase.AddNewArticleUseCase;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AddNewArticleUseCaseImpl implements AddNewArticleUseCase {
    User user;
    Session session;

    public AddNewArticleUseCaseImpl(User user, Session session) {
        this.user = user;
        this.session = session;
    }

    @Override
    public void addNewArticle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Categories:");
        // Show all categories
        session.beginTransaction();
        List<Category> categories = findAllCategories(session);
        if (categories.size() == 0) System.out.println("There are no category.");
        else categories.forEach(System.out::println);
        System.out.println("What would you like to do?\n" +
                "1: add new Category\n" +
                "2: add new article");
        String dec = scanner.next();
        if (dec.equals("1")) {
            System.out.println("add new Category.");
            System.out.println("title:");
            String title = scanner.next();
            System.out.println("description");
            String description = scanner.next();
            Category category = new Category(null, title, description, null);
            session.save(category);
        } else if (dec.equals("2")) {
            System.out.println("add new article\n" +
                    "Article Category:");
            categories.forEach(System.out::println);
            System.out.println("select category id to add:");
            long categoryId = scanner.nextLong();
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
            System.out.println("Would you like to publish the article?\n" +
                    "1: Yes\n" +
                    "2: No");
            boolean isPublished;
            while (true) {
                String ans = scanner.nextLine();
                if (ans.equals("1")) {
                    isPublished = true;
                    break ;
                } else if (ans.equals("2")) {
                    isPublished = false;
                    break;
                }
//                else if(!ans.equals("1") || !ans.equals("2")){
//                    System.out.println("Invalid Number!");
//                    System.out.println("Please Enter again");
//                }
            }
//            Article newArticle = new Article(null,
//                    title,
//                    brief,
//                    content,
//                    new Date(),
//                    new Date(),
//                    publishDate,
//                    isPublished,
//                    null,
//                    user);

//                Category selectedCategory = session.load(Category.class, categoryId);
//                newArticle.setCategory(selectedCategory);
//                session.save(newArticle);

        }
        session.getTransaction().commit();
    }

    private List<Category> findAllCategories(Session session) {
        Query<Category> query = session
                .createQuery("from Category ", Category.class);
        return query.list();
    }

}

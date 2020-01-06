package features;

import config.crud.CrudArticle;
import config.crud.CrudCategory;
import config.crud.CrudTag;
import config.crud.CrudUser;
import entities.Article;
import entities.Category;
import entities.Tag;
import entities.User;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public abstract class GetNewEntity {

    private static Scanner input = new Scanner(System.in);

    public static User getNewUser(String massage) {
        long userId;
        String id;
        boolean status = true;
        User user = null;
        while (status) {
            try {
                CrudUser.getInstance().findAll().forEach(System.out::println);
                System.out.println(massage);
                id = input.next();
                userId = Long.parseLong(id);
                user = CrudUser.getInstance().findById(userId);
                if (user == null) {
                    throw new NullPointerException();
                }
                status = false;
            } catch (Exception e) {
                System.out.println("Wrong number ID!\n" +
                        "Please try again.");
            }
        }

        return user;
    }

    public static Article getNewArticle(String massage) {
        long articleId;
        String id;
        boolean status = true;
        Article article = null;
        while (status) {
            try {
                CrudArticle.getInstance().findAll().forEach(System.out::println);
                System.out.println(massage);
                id = input.next();
                articleId = Long.parseLong(id);
                article = CrudArticle.getInstance().findById(articleId);
                if (article == null) {
                    throw new NullPointerException();
                }
                status = false;
            } catch (Exception e) {
                System.out.println("Wrong number ID!\n" +
                        "Please try again.");
            }
        }

        return article;
    }

    public static Article getNewArticle(String massage, List<Article> list) {
        long articleId;
        String id;
        boolean status = true;
        Article article = null;
        while (status) {
            try {
                list.forEach(System.out::println);
                System.out.println(massage);
                id = input.next();
                articleId = Long.parseLong(id);

                for (Article a : list) {
                    if (a.getId() == articleId) {
                        article = CrudArticle.getInstance().findById(articleId);
                        break;
                    }
                }
                if (article == null) {
                    throw new NullPointerException();
                }
                status = false;
            } catch (Exception e) {
                System.out.println("Wrong number ID!\n" +
                        "Please try again.");
            }
        }

        return article;
    }


    public static Tag getNewTag(String massage) {
        long tagId;
        String id;
        boolean status = true;
        Tag tag = null;
        while (status) {
            try {
                CrudTag.getInstance().findAll().forEach(System.out::println);

                System.out.println(massage);
                id = input.next();
                tagId = Long.parseLong(id);
                tag = CrudTag.getInstance().findById(tagId);
                if (tag == null) {
                    throw new NullPointerException();
                }
                status = false;
            } catch (Exception e) {
                System.out.println("Wrong number ID!\n" +
                        "Please try again.");
            }
        }

        return tag;
    }

    public static Category getNewCategory(String massage) {
        long categoryId;
        String id;
        boolean status = true;
        Category category = null;
        while (status) {
            try {
                CrudCategory.getInstance().findAll().forEach(System.out::println);
                System.out.println(massage);
                id = input.next();
                categoryId = Long.parseLong(id);
                category = CrudCategory.getInstance().findById(categoryId);
                if (category == null) {
                    throw new NullPointerException();
                }
                status = false;
            } catch (Exception e) {
                System.out.println("Wrong number ID!\n" +
                        "Please try again.");
            }
        }

        return category;
    }


}

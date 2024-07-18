import model.Blog;
import model.User;
import model.enums.BlogStatus;
import model.enums.StatusType;
import repository.BlogRepository;
import repository.UserRepository;
import service.BlogService;
import service.UserService;
import util.GenerateHashPassword;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        UserService userService = new UserService(new UserRepository());

        BlogService blogService = new BlogService(new BlogRepository(), userService);

        userService.saveUser("cem@gmail.com", "password");
        userService.saveUser("mehmet@gmail.com", "123456");
        userService.saveUser("toygun@gmail.com", "123456");
        userService.saveUser("emreirgoren@outlook.com","password123");

        userService.changeStatus("cem@gmail.com", StatusType.APPROVED);
        userService.changeStatus("mehmet@gmail.com", StatusType.APPROVED);
        userService.changeStatus("toygun@gmail.com", StatusType.APPROVED);
        userService.changeStatus("emreirgoren@outlook.com",StatusType.APPROVED);

        userService.changeStatus( List.of("cem@gmail.com","toygun@gmail.com"), StatusType.APPROVED);

        userService.getAllUsers().forEach(System.out::println);

        userService.getAllUsers()
                .stream()
                .peek(System.out::println)
                .filter(user -> user.getEmail().equals("cem@gmail.com"))
                .toList();



        List<String> emailList = userService.getAllUsers()
                .stream()
                .map(User::getEmail)
                .toList();

        /*List<Blog> allUsersBlogList = userService.getAllUsers()
                .stream()
                .flatMap(user -> user.getBlogList().stream())
                .toList();*/


        Map<String, User> emailUserMap = userService.getAllUsersMap();

        User cemUser = emailUserMap.get("cem@gmail.com");


        User foundUser = userService.getUserByEmail("cem@gmail.com");


        blogService.createBlog("başlık", "içerik", "cem@gmail.com");

        Blog foundBlog = blogService.getBlogByTitle("başlık");

        blogService.addComment("başlık", "çok kötü olmuş", foundUser);


        //-- for ile yapımı

        /*
        List<Blog> userBlogList = user.getBlogList();

        List<Blog> userDraftBlogList = new ArrayList<>();
        List<Blog> userPublishedBlogList = new ArrayList<>();

        for (Blog userBlog : userBlogList) {

            if (BlogStatus.DRAFT.equals(userBlog.getBlogStatus())) {
                userDraftBlogList.add(userBlog);
            } else if (BlogStatus.PUBLISHED.equals(userBlog.getBlogStatus())) {
                userPublishedBlogList.add((userBlog));
            }

        }
        */
        //ödev. kullanıcın takip ettiği tag'lere göre blog'lar gelmeli


        /*
        Optional<Blog> instacioBlog = blogList.stream()
                .filter(blog1 -> blog1.getTitle().equals("Instancio: A New Way to Create Test Data"))
                .findFirst();

        Blog blog1 = instacioBlog.orElseThrow(() -> new RuntimeException("bu isimde bir blog bulunamadı"));

        if (instacioBlog.isEmpty()) {
            System.out.println("bu isimde bir blog bulunamadı");
            throw new RuntimeException("bu isimde bir blog bulunamadı");
        }

        Optional<Blog> willBeDraftBlog = user.getBlogList()
                .stream()
                .filter(blog2 -> blog2.getTitle().equals("Instancio: A New Way to Create Test Data"))
                .findFirst();


        if (willBeDraftBlog.isEmpty()) {
            System.out.println("bu isimde bir blog bulunamadı");
            throw new RuntimeException("bu isimde bir blog bulunamadı");
        }

        if (BlogStatus.PUBLISHED.equals(willBeDraftBlog.get().getBlogStatus())) {
            System.out.println("published olan blog delete edilemez. önce draft yapın.");
            throw new RuntimeException("published olan blog delete edilemez. önce draft yapın.");
        }

        willBeDraftBlog.get().setBlogStatus(BlogStatus.DRAFT);

        */

        blogService.changeBlogStatus(BlogStatus.DELETED, "başlık");

        /**
         * Test
         */

        User emreUser = userService.getUserByEmail("emreirgoren@outlook.com");


        blogService.createBlog("Java", "Merhaba Dünya!", "emreirgoren@outlook.com");

        blogService.addComment("Java","Güzel olmuş",emreUser);
        blogService.addComment("Java","iyi olmuş",emreUser);

        blogService.createBlog("Java2", "Merhaba Dunya", "emreirgoren@outlook.com");
        blogService.createBlog("Java3", "Merhaba Dunya", "emreirgoren@outlook.com");

        blogService.addLike("Java");



        /**
         * cemUser kullanıcısının password hashlenmesi
         */

        GenerateHashPassword generateHashPassword = new GenerateHashPassword();
        generateHashPassword.hashPassword(Optional.ofNullable(cemUser));

        System.out.println(generateHashPassword.hashPassword(Optional.ofNullable(cemUser)));

        User foundUser1 =userService.getUserByEmail(cemUser.getEmail());
        System.out.println(foundUser1);

        /**
         * Blog İstatistikleri
         */

        /**
         * Blog Sayısı
         */
        System.out.println(blogService.getBlogCount());

        /**
         * Comment Sayısı
         */


        System.out.println(blogService.getCommentCount());

        /**
         * Like Sayısı
         */

        System.out.println(blogService.getLikeCount());
        blogService.getLikeCount();

        /**
         * Verilen User'a ait blog sayısı
         */
        blogService.getBlogCountByUser("emreirgoren@outlook.com");

        System.out.println(blogService.getBlogCountByUser("emreirgoren@outlook.com"));

        /**
         * Verilen User'a ait comment sayısı
         */

        System.out.println(blogService.getCommentCountByUser("emreirgoren@outlook.com"));

        /**
         * Verilen User'a ait like sayısı
         */

        System.out.println(blogService.getLikeCountByUser("emreirgoren@outlook.com"));
        System.out.println(blogService.getLikeCountByUser("cem@gmail.com"));

        /**
         * Verilen User'a ait like sayısı
         */

        System.out.println(blogService.getLikeCountByUser("emreirgoren@outlook.com"));
        System.out.println(blogService.getLikeCountByUser("cem@gmail.com"));
    }
}

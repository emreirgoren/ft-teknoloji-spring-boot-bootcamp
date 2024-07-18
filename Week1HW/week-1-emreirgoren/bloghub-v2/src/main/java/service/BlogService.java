package service;

import model.Blog;
import model.BlogComment;
import model.User;
import model.enums.BlogStatus;
import repository.BlogRepository;

import java.util.List;
import java.util.Optional;

public class BlogService {

    private BlogRepository blogRepository;
    private UserService userService;

    public BlogService(BlogRepository blogRepository, UserService userService) {
        this.blogRepository = blogRepository;
        this.userService = userService;
    }

    public Blog createBlog(String title, String text, String email) {

        User foundUser = userService.getUserByEmail(email);

        Blog blog = new Blog(title, text, foundUser);

        blogRepository.save(blog);

        return blog;
    }

    public Blog getBlogByTitle(String title) {

        return blogRepository.findByTitle(title).orElseThrow(() -> new RuntimeException("blog bulunamadı"));
    }

    public void addComment(String title, String comment, User user) {

        Blog foundBlog = getBlogByTitle(title);
        //TODO log ekle
        foundBlog.getBlogCommentList().add(new BlogComment(user, comment));

    }

    public List<Blog> getBlogsFilterByStatus(BlogStatus blogStatus, String email) {

        User foundUser = userService.getUserByEmail(email);

        return foundUser.getBlogList().stream()
                .filter(blog -> blogStatus.equals(blog.getBlogStatus()))
                .toList();
    }

    public void changeBlogStatus(BlogStatus blogStatus, String title) {

        Blog foundBlog = getBlogByTitle(title);

        if (foundBlog.getBlogStatus().equals(BlogStatus.PUBLISHED)) {
            throw new RuntimeException("statüsü PUBLISHED olan bir blog silinemez.");
        }

        //TODO log eklenecek
        foundBlog.setBlogStatus(blogStatus);

    }

    public void addLike(String blogTitle){

        Blog foundBlog = getBlogByTitle(blogTitle);

        foundBlog.setLikeCount(foundBlog.getLikeCount()+1);
    }

    /**
     * Blog İstatistikleri
     */

    /**
     * Blog Sayısı
     */
    public String getBlogCount() {

        int totalBlog = blogRepository.blogCount();

        return "Blog Sayısı: " + totalBlog;

    }

    /**
     * Comment Sayısı
     */

    public String getCommentCount() {

        int totalComment = (int) blogRepository.getAllBlog().stream()
                .flatMap(blog -> blog.getBlogCommentList().stream())
                .count();

        return "Comment Sayısı: " + totalComment;
    }

    /**
     * Like Sayısı
     */

    public String getLikeCount() {

        long totalLike = blogRepository.getAllBlog().stream()
                .mapToLong(Blog::getLikeCount).sum();

        return "Like Sayısı: " + totalLike;
    }

    /**
     * Girilen User'ın Blog Sayısı
     */

    public String getBlogCountByUser(String email) {

        User foundUser = userService.getUserByEmail(email);

        try {
                long blogCountByUser = blogRepository.getAllBlog().stream()
                        .filter(blog -> blog.getUser().equals(foundUser))
                        .count();
                return "Verilen email'e ait blog sayısı: " + blogCountByUser;

        }catch (NullPointerException e){
            return "Blog bulunamadı " +e.getMessage();
        }

    }

    /**
     * İstenilen User'ın comment sayısı
     */

    public String getCommentCountByUser(String email){
        User foundUser = userService.getUserByEmail(email);

        try {
            long commentCountByUser = blogRepository.getAllBlog().stream()
                    .filter(blog -> blog.getUser().equals(foundUser))
                    .flatMap(blog -> blog.getBlogCommentList().stream())
                    .count();

            return "Verilen User ait comment sayısı: " + commentCountByUser;
        }catch (NullPointerException e){
            return "User'ın comment bulunamadı " + e.getMessage();
        }

    }

    public String getLikeCountByUser(String email) {

        User foundUser = userService.getUserByEmail(email);

            long likeCountByUser = blogRepository.getAllBlog().stream()
                    .filter(blog -> blog.getUser().equals(foundUser))
                    .mapToLong(Blog::getLikeCount).sum();
            return "Verilen User ait like sayısı: " + likeCountByUser;

    }
}

package src.main.session3;

import java.util.Arrays;
import java.util.List;

class Post {

    private String title;
    private List<String> tags;

    public Post(String title, List<String> tags) {
        this.title = title;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTags() {
        return tags;
    }
}

public class S3_ex6 {
    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(
                new Post("Java", Arrays.asList("java", "backend")),
                new Post("Python", Arrays.asList("python", "data")));

        List<String> A = posts.stream().map(Post::getTags).flatMap(List::stream).toList();
        System.out.println(A);
    }
}

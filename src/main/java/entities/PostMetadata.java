package entities;

import lombok.Builder;
import services.PostsManager;

import java.util.List;


public class PostMetadata {
    String text;
    List<String> url;

    public PostMetadata (String text) {
        this.text = text;
    }
}

package entities;

import lombok.Data;

@Data

public class Posts {
    Long id;
    PostMetadata postMetadata;
    Long postedBy;
    Long postedOn;
    Boolean isDeleted = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PostMetadata getPostMetadata() {
        return postMetadata;
    }

    public void setPostMetadata(PostMetadata postMetadata) {
        this.postMetadata = postMetadata;
    }

    public Long getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Long postedBy) {
        this.postedBy = postedBy;
    }

    public Long getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Long postedOn) {
        this.postedOn = postedOn;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}

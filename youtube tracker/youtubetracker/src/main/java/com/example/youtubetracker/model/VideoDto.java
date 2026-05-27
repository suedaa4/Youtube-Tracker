package com.example.youtubetracker.model;

public class VideoDto {
    private String videoId;
    private String title;
    private String channelTitle;
    private String thumbnailUrl;
    private String viewCount;
    private String likeCount;
    private String publishedAt;
    private String categoryId;

    public String getVideoId() { return videoId; }
    public void setVideoId(String videoId) { this.videoId = videoId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getChannelTitle() { return channelTitle; }
    public void setChannelTitle(String channelTitle) { this.channelTitle = channelTitle; }

    public String getThumbnailUrl() { return thumbnailUrl; }
    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }

    public String getViewCount() { return viewCount; }
    public void setViewCount(String viewCount) { this.viewCount = viewCount; }

    public void setViewCount(long viewCount) { this.viewCount = String.valueOf(viewCount); }

    public String getLikeCount() { return likeCount; }
    public void setLikeCount(String likeCount) { this.likeCount = likeCount; }

    public String getPublishedAt() { return publishedAt; }
    public void setPublishedAt(String publishedAt) { this.publishedAt = publishedAt; }

    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
}
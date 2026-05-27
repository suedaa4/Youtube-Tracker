package com.example.youtubetracker.service;

import com.example.youtubetracker.model.VideoDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class YoutubeService {

    private final String API_KEY = "AIzaSyAftGgVPBkyjmfZqI572creOxykYQDqfBQ";
    private final String BASE_URL = "https://www.googleapis.com/youtube/v3/videos";

    public List<VideoDto> getTopVideos(String regionCode, int maxResults, String categoryId) {
        List<VideoDto> videoList = new ArrayList<>();

        String url = String.format(
            "%s?part=snippet,statistics&chart=mostPopular&regionCode=%s&maxResults=%d&videoCategoryId=%s&key=%s",
            BASE_URL, regionCode, maxResults, categoryId, API_KEY
        );

        try {
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            JsonNode items = root.path("items");

            for (JsonNode item : items) {
                VideoDto video = new VideoDto();
                video.setVideoId(item.path("id").asText());
                video.setTitle(item.path("snippet").path("title").asText());
                video.setChannelTitle(item.path("snippet").path("channelTitle").asText());
                video.setPublishedAt(item.path("snippet").path("publishedAt").asText());
                video.setThumbnailUrl(
                    item.path("snippet").path("thumbnails").path("high").path("url").asText()
                );
                video.setViewCount(
                    item.path("statistics").path("viewCount").asText("0")
                );
                video.setLikeCount(
                    item.path("statistics").path("likeCount").asText("0")
                );
                video.setCategoryId(categoryId);
                videoList.add(video);
            }
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }

        return videoList;
    }
}
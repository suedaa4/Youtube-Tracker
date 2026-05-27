package com.example.youtubetracker.service;

import com.example.youtubetracker.model.VideoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class YoutubeController {

    private final YoutubeService youtubeService;

    public YoutubeController(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }

    @GetMapping("/")
    public String index(
            @RequestParam(defaultValue = "0") String categoryId,
            @RequestParam(defaultValue = "TR") String regionCode,
            Model model) {

        List<VideoDto> globalVideos = youtubeService.getTopVideos("US", 50, categoryId);
        List<VideoDto> localVideos  = youtubeService.getTopVideos(regionCode, 10, categoryId);

        model.addAttribute("globalVideos", globalVideos);
        model.addAttribute("localVideos", localVideos);
        model.addAttribute("selectedCategory", categoryId);
        model.addAttribute("regionCode", regionCode);

        return "index";
    }
}
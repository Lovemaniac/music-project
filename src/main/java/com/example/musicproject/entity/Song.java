package com.example.musicproject.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Song {
    private String id;         // 歌曲ID
    private String name;       // 歌曲名称
    private String artist;     // 歌手
    private String album;      // 专辑
    private Integer duration;  // 时长（秒）
    private Date releaseDate;  // 发布日期
}


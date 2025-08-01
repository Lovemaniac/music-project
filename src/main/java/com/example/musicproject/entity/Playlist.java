package com.example.musicproject.entity;

import lombok.Data;

import java.util.List;

@Data
public class Playlist {
    private Long id;
    private String name;
    private String creator;
    private List<String> songs;
}

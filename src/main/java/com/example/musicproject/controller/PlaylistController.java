package com.example.musicproject.controller;

import com.example.musicproject.entity.Playlist;
import com.example.musicproject.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    // 查询歌单
    @GetMapping("/{id}")
    public Playlist getPlaylist(@PathVariable Long id) {
        return playlistService.getPlaylistById(id);
    }

    // 更新歌单
    @PutMapping("/{id}")
    public void updatePlaylist(@PathVariable Long id, @RequestBody Playlist playlist) {
        playlist.setId(id);
        playlistService.updatePlaylist(playlist);
    }
}

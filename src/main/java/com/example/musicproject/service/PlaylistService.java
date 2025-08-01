package com.example.musicproject.service;

import com.example.musicproject.mapper.PlaylistMapper;
import com.example.musicproject.entity.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class PlaylistService {

    @Autowired
    private PlaylistMapper playlistMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private static final String PLAYLIST_CACHE_KEY = "playlist:";  // Redis 键前缀

    public Playlist getPlaylistById(Long id) {
        String redisKey = PLAYLIST_CACHE_KEY + id;
     // 1. 查询 Redis 缓存
        Playlist playlist = (Playlist) redisTemplate.opsForValue().get(redisKey);
        if (playlist != null) {
            return playlist;
        } else {
            // 2. 查询数据库
            playlist = playlistMapper.getPlaylistWithSongs(id);
            if (playlist != null) {
                // 3. 将查询结果存入 Redis 缓存
                redisTemplate.opsForValue().set(redisKey, playlist,1, TimeUnit.HOURS);
            }
            return playlist;
        }

    }

    //修改歌单歌曲列表
    public void updatePlaylist(Playlist playlist) {
        playlistMapper.deletePlaylistSongs(playlist.getId());
        playlistMapper.insertPlaylistSongs(playlist.getId(), playlist.getSongs());
        String redisKey = PLAYLIST_CACHE_KEY + playlist.getId();
        redisTemplate.delete(redisKey);
    }
}

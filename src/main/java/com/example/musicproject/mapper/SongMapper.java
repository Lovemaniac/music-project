package com.example.musicproject.mapper;

import com.example.musicproject.entity.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SongMapper {
    Song getSongById(@Param("id") String id);
   List<Song> getSongsByPlaylistId(@Param("playlistId") String playlistId);
    void insertSong(Song song);
}

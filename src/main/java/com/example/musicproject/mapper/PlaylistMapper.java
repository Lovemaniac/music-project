package com.example.musicproject.mapper;

import com.example.musicproject.entity.Playlist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlaylistMapper {

    Playlist getPlaylistWithSongs(@Param("id") Long id);

    void insertPlaylist(Playlist playlist);

    void deletePlaylistSongs(@Param("playlistId") Long playlistId);

    void insertPlaylistSongs(@Param("playlistId") Long playlistId, @Param("songIds") List<String> songIds);


}

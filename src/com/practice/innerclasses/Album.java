package com.practice.innerclasses;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private SongList songs;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new SongList();
	}

	// public static for the sake of the auto-checker of the challenge
	public static class SongList {
		private ArrayList<Song> songs;

		private SongList() {
			this.songs = new ArrayList<Song>();
		}

		private boolean add(Song song) {
			if (findSong(song.getTitle()) != null)
				return false;
			this.songs.add(song);
			return true;
		}

		private Song findSong(int trackNumber) {
			Song foundSong = null;
			int index = trackNumber - 1;
			if (index >= 0 && index < this.songs.size()) {
				foundSong = this.songs.get(index);
			}
			return foundSong;
		}

		private Song findSong(String title) {
			Song foundSong = null;
			for (Song song : this.songs) {
				if (song.getTitle().equals(title)) {
					foundSong = song;
					break;
				}
			}
			return foundSong;
		}

	}

	public boolean addSong(String title, double duration) {
		Song foundSong = this.songs.findSong(title);
		if (foundSong != null)
			return false;
		this.songs.add(new Song(title, duration));
		return true;
	}

	public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
		Song foundSong = this.songs.findSong(trackNumber);
		if (foundSong == null)
			return false;
		playlist.add(foundSong);
		return true;
	}

	public boolean addToPlayList(String title, LinkedList<Song> playlist) {
		Song foundSong = this.songs.findSong(title);
		if (foundSong == null)
			return false;
		playlist.add(foundSong);
		return true;
	}
}

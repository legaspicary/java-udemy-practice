package com.practice.arrays;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}

	public boolean addSong(String title, double duration) {
		Song song = this.findSong(title);
		if (song != null)
			return false;
		this.songs.add(new Song(title, duration));
		return true;
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

	public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
		int index = trackNumber - 1;
		if (index < 0 || index >= this.songs.size()) {
			return false;
		}
		Song song = this.songs.get(index);
		playlist.add(song);
		return true;
	}

	public boolean addToPlayList(String title, LinkedList<Song> playlist) {
		Song song = this.findSong(title);
		if (song == null)
			return false;
		playlist.add(song);
		return true;
	}
}

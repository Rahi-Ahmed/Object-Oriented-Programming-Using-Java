import java.util.LinkedList;
import java.util.Scanner;

// Class representing a song
class Song {
    private String title;
    private String artist;
    private int duration;

    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String toString() {
        return title + " by " + artist + " (" + duration + "s)";
    }
}

// Class representing the playlist
class Playlist {
    private LinkedList<Song> songs;

    public Playlist() {
        songs = new LinkedList<>();
    }

    // Add a song to the playlist
    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Song added: " + song);
    }

    // Delete a song from the playlist
    public void deleteSong(String title) {
        boolean found = false;
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                songs.remove(song);
                System.out.println("Song deleted: " + song);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Song not found: " + title);
        }
    }

    // Display all the songs in the playlist
    public void displayPlaylist() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            System.out.println("Playlist:");
            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }

    // Play the next song in the playlist
    public void playNext() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            Song currentSong = songs.removeFirst();
            System.out.println("Playing: " + currentSong);
            songs.addLast(currentSong);
        }
    }

    // Play the previous song in the playlist
    public void playPrevious() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            Song currentSong = songs.removeLast();
            System.out.println("Playing: " + currentSong);
            songs.addFirst(currentSong);
        }
    }

    // Shuffle the songs in the playlist
    public void shuffle() {
        if (songs.size() <= 1) {
            System.out.println("Not enough songs to shuffle.");
        } else {
            LinkedList<Song> shuffledSongs = new LinkedList<>();
            while (!songs.isEmpty()) {
                int index = (int) (Math.random() * songs.size());
                shuffledSongs.add(songs.remove(index));
            }
            songs = shuffledSongs;
            System.out.println("Playlist shuffled.");
        }
    }
}

// Main class
public class MusicPlaylist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();

        // Menu-driven program
        while (true) {
            System.out.println("=== Music Playlist Menu ===");
            System.out.println("1. Add a song");
            System.out.println("2. Delete a song");
            System.out.println("3. Display playlist");
            System.out.println("4. Play next song");
            System.out.println("5. Play previous song");
            System.out.println("6. Shuffle playlist");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter song duration in seconds: ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Song song = new Song(title, artist, duration);
                    playlist.addSong(song);
                    break;
                case 2:
                    System.out.print("Enter the song title to delete: ");
                    String deleteTitle = scanner.nextLine();
                    playlist.deleteSong(deleteTitle);
                    break;
                case 3:
                    playlist.displayPlaylist();
                    break;
                case 4:
                    playlist.playNext();
                    break;
                case 5:
                    playlist.playPrevious();
                    break;
                case 6:
                    playlist.shuffle();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
}

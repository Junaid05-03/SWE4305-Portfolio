import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlaylistManager manager = new PlaylistManager();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("========================================");
        System.out.println("   Welcome to Junaid's Music Playlist   ");
        System.out.println("========================================");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. View all songs");
            System.out.println("2. Add a song");
            System.out.println("3. Remove a song");
            System.out.println("4. Filter songs by play count");
            System.out.println("5. Search by artist");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    manager.printAllSongs();
                    break;
                case 2:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine().trim();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine().trim();
                    System.out.print("Enter play count: ");
                    int playCount = 0;
                    try {
                        playCount = scanner.nextInt();
                        scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("Invalid play count.");
                        scanner.nextLine();
                        break;
                    }
                    manager.addSong(title, artist, playCount);
                    break;
                case 3:
                    System.out.print("Enter song title to remove: ");
                    String removeTitle = scanner.nextLine().trim();
                    manager.removeSong(removeTitle);
                    break;
                case 4:
                    System.out.print("Enter minimum play count: ");
                    int minPlays = 0;
                    try {
                        minPlays = scanner.nextInt();
                        scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        break;
                    }
                    manager.filterByPlayCount(minPlays);
                    break;
                case 5:
                    System.out.print("Enter artist name to search: ");
                    String searchArtist = scanner.nextLine().trim();
                    manager.searchByArtist(searchArtist);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 to 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

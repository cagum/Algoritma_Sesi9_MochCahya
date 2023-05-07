import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TodoList {
    public static void main(String[] args) {
        Queue<String> todoQueue = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n==== Todo List ====");
            System.out.println("1. Tambah Kegiatan");
            System.out.println("2. Hapus Kegiatan Pertama");
            System.out.println("3. Tampilkan Todo List");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume new line character

            switch (choice) {
                case 1:
                    System.out.print("Masukkan kegiatan: ");
                    String activity = scanner.nextLine();
                    todoQueue.add(activity);
                    System.out.println("Kegiatan \"" + activity + "\" berhasil ditambahkan.");
                    break;
                case 2:
                    if (todoQueue.isEmpty()) {
                        System.out.println("Todo list kosong.");
                    } else {
                        String removedActivity = todoQueue.poll();
                        System.out.println("Kegiatan \"" + removedActivity + "\" berhasil dihapus dari todo list.");
                    }
                    break;
                case 3:
                    if (todoQueue.isEmpty()) {
                        System.out.println("Todo list kosong.");
                    } else {
                        System.out.println("Todo List:");
                        for (String todo : todoQueue) {
                            System.out.println("- " + todo);
                        }
                    }
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }
}

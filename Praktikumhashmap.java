import java.util.*;
import java.util.Scanner;

public class Praktikumhashmap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> dataBuku = new HashMap<>();
    
        // Input data awal 5 buku
        System.out.println("Masukkan data untuk 5 buku:");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Nama : ");
            String nama = scanner.nextLine();
            int jumlah = 0;
    
            // Validasi input jumlah dengan exception handling
            while (true) {
                System.out.print("jumlah : ");
                try {
                    jumlah = Integer.parseInt(scanner.nextLine());
                    if (jumlah < 0) {
                        System.out.println("jumlah tidak boleh kosong, Coba lagi.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input harus berupa angka. Coba lagi.");
                }
            }
    
            dataBuku.put(nama, jumlah);
        }
    
        // Loop untuk menu utama
        boolean selesai = false;
        while (!selesai) {
            System.out.println("\nPilih aksi:");
            System.out.println("1. Tampilkan data Buku");
            System.out.println("2. Ubah jumlah Buku");
            System.out.println("3. Cari data Buku");
            System.out.println("4. Hapus data Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");

            int pilihan = 0;
    
            // Validasi input untuk memastikan hanya angka yang diterima
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka 1, 2, 3, 4, atau 5.");
                continue; // Kembali ke awal loop
             }
    
            switch (pilihan) {
                case 1:
                    // Menampilkan data buku
                    System.out.println("\nData Buku saat ini:");
                    tampilkanData(dataBuku);
                    break;

                case 2:
                    // Mengubah jumlah buku
                    System.out.print("Masukkan nama Buku yang ingin diubah jumlahnya: ");
                    String namaUbah = scanner.nextLine();
                    if (dataBuku.containsKey(namaUbah)) {
                        int jumlahBaru = 0;
                        while (true) {
                            System.out.print("Masukkan jumlah baru untuk buku " + namaUbah + ": ");
                            try {
                                jumlahBaru = Integer.parseInt(scanner.nextLine());
                                if (jumlahBaru < 0) {
                                    System.out.println("jumlah tidak boleh kosong, Coba lagi.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Input harus berupa angka. Coba lagi.");
                            }
                        }
                        dataBuku.replace(namaUbah, jumlahBaru);
                        System.out.println("jumlah " + namaUbah + " berhasil diubah.");
                    } else {
                        System.out.println("Nama Buku tidak ditemukan.");
                    }
                    break;

                case 3:
                    // Mencari data Buku
                    System.out.print("Masukkan nama Buku yang ingin dicari: ");
                    String namaCari = scanner.nextLine();
                     if (dataBuku.containsKey(namaCari)) {
                        System.out.println("jumlah " + namaCari + ": " + dataBuku.get(namaCari));
                    } else {
                        System.out.println("Nama Buku tidak ditemukan.");
                    }
                    break;

                case 4:
                     // Menghapus data Buku
                    System.out.print("Masukkan nama Buku yang ingin dihapus: ");
                    String namaHapus = scanner.nextLine();
                    if (dataBuku.containsKey(namaHapus)) {
                        dataBuku.remove(namaHapus);
                        System.out.println("Data Buku " + namaHapus + " berhasil dihapus.");
                    } else {
                        System.out.println("Nama Buku tidak ditemukan.");
                    }
                    break;
    
                case 5:
                    // Keluar
                    selesai = true;
                    System.out.println("Program selesai.");
                    break;
    
                default:
                    System.out.println("Pilihan tidak valid. Masukkan angka 1, 2, 3, 4, atau 5.");
            }
        }
        scanner.close();
    }
    
    // Method untuk menampilkan data
    public static void tampilkanData(HashMap<String, Integer> map) {
        if (map.isEmpty()) {
            System.out.println("Tidak ada data yang tersedia.");
        } else {
             for (String nama : map.keySet()) {
               System.out.println("Nama: " + nama + ", jumlah: " + map.get(nama));                }
        }
    }
}

package app;

import java.util.Scanner;

/**
 * Kelas utama untuk menjalankan program aplikasi console
 * Berisi menu utama dan logika pemilihan fitur
 */
public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membuat objek pangkalan (kelas utama)
        Pangkalan pangkalan = new Pangkalan("Pangkalan LPG Sejahtera", "Jl. Merdeka No.10");
        pangkalan.inisialisasiData(); // Inisialisasi pegawai dan stok gas

        int pilihan;
        do {
            // Menampilkan menu utama
            System.out.println("=== MENU PANGKALAN GAS LPG 3KG ===");
            System.out.println("1. Lihat Pegawai");
            System.out.println("2. Lihat Stok Gas");
            System.out.println("3. Tambah Transaksi");
            System.out.println("4. Lihat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // membersihkan buffer input

            // Menjalankan menu berdasarkan pilihan
            switch (pilihan) {
                case 1:
                    pangkalan.tampilkanPegawai(); // menampilkan data pegawai
                    break;
                case 2:
                    pangkalan.tampilkanStok(); // menampilkan stok gas
                    break;
                case 3:
                    // Input data transaksi baru
                    System.out.print("Nama Pelanggan: ");
                    String nama = input.nextLine();
                    System.out.print("Jumlah Tabung: ");
                    int jumlah = input.nextInt();
                    input.nextLine();
                    System.out.print("Metode Pembayaran (BRI/DANA/Mandiri): ");
                    String metode = input.nextLine();
                    System.out.print("ID Pegawai Pengantar (P01/P02): ");
                    String idPegawai = input.nextLine();

                    pangkalan.tambahTransaksi(nama, jumlah, metode, idPegawai);
                    break;
                case 4:
                    pangkalan.tampilkanTransaksi(); // menampilkan semua transaksi
                    break;
                case 5:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println();
        } while (pilihan != 5);

        input.close(); // menutup scanner
    }
}

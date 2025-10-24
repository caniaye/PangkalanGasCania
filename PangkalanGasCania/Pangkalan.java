package app;

import java.util.ArrayList;

/**
 * Kelas utama yang merepresentasikan pangkalan gas LPG
 * Menyimpan daftar pegawai, stok gas, dan transaksi
 */
public class Pangkalan {
    // Atribut private untuk menerapkan konsep enkapsulasi
    private String namaPangkalan;
    private String alamat;
    private ArrayList<Pegawai> daftarPegawai;   // Aggregation ke Pegawai
    private Gas stokGas;                         // Composition ke Gas
    private ArrayList<Transaksi> daftarTransaksi; // Composition ke Transaksi

    // Konstruktor untuk inisialisasi objek Pangkalan
    public Pangkalan(String nama, String alamat) {
        this.namaPangkalan = nama;
        this.alamat = alamat;
        this.daftarPegawai = new ArrayList<>();
        this.daftarTransaksi = new ArrayList<>();
    }

    // Method untuk menambahkan data awal
    public void inisialisasiData() {
        daftarPegawai.add(new Pegawai("P01", "Andi"));
        daftarPegawai.add(new Pegawai("P02", "Budi"));
        stokGas = new Gas("G01", 18000, 50); // stok awal 50 tabung
    }

    // Menampilkan daftar pegawai
    public void tampilkanPegawai() {
        System.out.println("=== Daftar Pegawai ===");
        for (Pegawai p : daftarPegawai) {
            System.out.println("ID Pegawai: " + p.getId() + " | Nama: " + p.getNama());
        }
    }

    // Menampilkan stok gas yang tersedia
    public void tampilkanStok() {
        System.out.println("=== Stok Gas ===");
        stokGas.lihatData();
    }

    // Menambahkan transaksi baru
    public void tambahTransaksi(String pelanggan, int jumlah, String metode, String idPegawai) {
        // Mencari pegawai berdasarkan ID
        Pegawai pengantar = null;
        for (Pegawai p : daftarPegawai) {
            if (p.getId().equalsIgnoreCase(idPegawai)) {
                pengantar = p;
                break;
            }
        }

        // Validasi data pegawai
        if (pengantar == null) {
            System.out.println("Pegawai tidak ditemukan!");
            return;
        }

        // Cek stok gas cukup atau tidak
        if (stokGas.getJumlahStok() < jumlah) {
            System.out.println("Stok gas tidak mencukupi!");
            return;
        }

        // Kurangi stok gas sesuai pembelian
        stokGas.kurangiStok(jumlah);

        // Buat objek pembayaran dan transaksi baru
        Pembayaran bayar = new Pembayaran(metode, stokGas.getHarga() * jumlah);
        Transaksi t = new Transaksi("T" + (daftarTransaksi.size() + 1), pelanggan, jumlah, pengantar, bayar);
        daftarTransaksi.add(t);

        // Tampilkan hasil transaksi
        System.out.println("Transaksi berhasil ditambahkan!");
        t.tampilkanRincian();
    }

    // Menampilkan semua transaksi yang tersimpan
    public void tampilkanTransaksi() {
        System.out.println("=== Daftar Transaksi ===");
        for (Transaksi t : daftarTransaksi) {
            t.tampilkanRincian();
            System.out.println("-------------------------");
        }
    }
}

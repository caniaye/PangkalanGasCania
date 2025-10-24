package app;

/**
 * Kelas untuk mencatat setiap transaksi pembelian gas
 * Menghubungkan antara pelanggan, pegawai, dan pembayaran
 */
public class Transaksi {
    private String idTransaksi;
    private String namaPelanggan;
    private int jumlahTabung;
    private double totalBayar;
    private Pegawai pegawai;      // Association ke Pegawai
    private Pembayaran pembayaran; // Composition ke Pembayaran

    // Konstruktor transaksi
    public Transaksi(String id, String pelanggan, int jumlah, Pegawai pegawai, Pembayaran pembayaran) {
        this.idTransaksi = id;
        this.namaPelanggan = pelanggan;
        this.jumlahTabung = jumlah;
        this.pegawai = pegawai;
        this.pembayaran = pembayaran;
        this.totalBayar = hitungTotal(pembayaran.getJumlahBayar());
    }

    // Menghitung total pembayaran (harga * jumlah tabung)
    public double hitungTotal(double nominal) {
        return nominal;
    }

    // Menampilkan detail transaksi
    public void tampilkanRincian() {
        System.out.println("=== Rincian Transaksi ===");
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Pelanggan: " + namaPelanggan);
        System.out.println("Jumlah Tabung: " + jumlahTabung);
        System.out.println("Total Bayar: Rp " + totalBayar);
        System.out.println("Diantar oleh: " + pegawai.getNama());
        pembayaran.lihatData(); // menampilkan info pembayaran
    }
}

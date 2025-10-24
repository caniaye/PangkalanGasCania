package app;

/**
 * Kelas untuk mencatat data pembayaran pelanggan
 * Termasuk metode, jumlah, dan status pembayaran
 */
public class Pembayaran {
    private String metode;
    private double jumlahBayar;
    private String status;

    public Pembayaran(String metode, double jumlah) {
        this.metode = metode;
        this.jumlahBayar = jumlah;
        this.status = "Lunas"; // default pembayaran berhasil
    }

    // Getter jumlah bayar
    public double getJumlahBayar() {
        return jumlahBayar;
    }

    // Menampilkan proses pembayaran
    public void prosesPembayaran() {
        System.out.println("Pembayaran via " + metode + " sebesar Rp" + jumlahBayar + " berhasil!");
    }

    // Menampilkan data pembayaran
    public void lihatData() {
        System.out.println("Metode Bayar: " + metode + " | Status: " + status);
    }
}

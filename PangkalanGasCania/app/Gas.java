package app;

/**
 * Kelas yang menyimpan informasi stok gas LPG
 * Termasuk ID gas, harga per tabung, dan jumlah stok
 */
public class Gas {
    private String idGas;
    private double harga;
    private int jumlahStok;

    public Gas(String id, double harga, int stok) {
        this.idGas = id;
        this.harga = harga;
        this.jumlahStok = stok;
    }

    // Mengurangi jumlah stok gas setelah transaksi
    public void kurangiStok(int jumlah) {
        this.jumlahStok -= jumlah;
    }

    // Getter harga gas
    public double getHarga() {
        return harga;
    }

    // Getter jumlah stok
    public int getJumlahStok() {
        return jumlahStok;
    }

    // Menampilkan data stok gas
    public void lihatData() {
        System.out.println("ID Gas: " + idGas + " | Harga: Rp" + harga + " | Stok: " + jumlahStok + " tabung");
    }
}

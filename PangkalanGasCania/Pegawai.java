package app;

/**
 * Kelas untuk menyimpan data pegawai (petugas)
 * Mewakili aktor yang bertugas mengantar gas ke pelanggan
 */
public class Pegawai {
    private String idPegawai;
    private String namaPegawai;

    public Pegawai(String id, String nama) {
        this.idPegawai = id;
        this.namaPegawai = nama;
    }

    // Mengembalikan ID pegawai
    public String getId() {
        return idPegawai;
    }

    // Mengembalikan nama pegawai
    public String getNama() {
        return namaPegawai;
    }

    // Menampilkan data pegawai ke console
    public void lihatData() {
        System.out.println("Pegawai: " + idPegawai + " - " + namaPegawai);
    }
}

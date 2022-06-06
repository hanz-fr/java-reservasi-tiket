import java.time.LocalDate;

public class DetailTransaksi {
    String kodeTrs;
    String idCustomer;
    String jenisPembayaran;
    LocalDate tanggal;
    int jumlahTransaksi;


    // Constructor
    DetailTransaksi(String kodeTrs, String idCustomer, String jenisPembayaran, LocalDate tanggal, int jumlahTransaksi){
        this.kodeTrs = kodeTrs;
        this.idCustomer = idCustomer;
        this.jenisPembayaran = jenisPembayaran;
        this.tanggal = tanggal;
        this.jumlahTransaksi = jumlahTransaksi;
    }
}

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tiket {
    String kodeBooking;
    String asalTujuan;
    String destinasiTujuan;
    String perusahaanTransportasi;
    String passengerId;
    LocalDate tanggal;
    LocalDateTime jam;
    int harga;


    // Constructor
    Tiket(
            String kodeBooking,
            String asalTujuan,
            String destinasiTujuan,
            String perusahaanTransportasi,
            String passengerId,
            LocalDate tanggal,
            LocalDateTime jam,
            int harga
    ) {
        this.kodeBooking = kodeBooking;
        this.asalTujuan = asalTujuan;
        this.destinasiTujuan = destinasiTujuan;
        this.perusahaanTransportasi = perusahaanTransportasi;
        this.passengerId = passengerId;
        this.tanggal = tanggal;
        this.jam = jam;
        this.harga = harga;
    }
}



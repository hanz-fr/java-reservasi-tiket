public class Transportasi {
    String perusahaan;
    String jenis;
    String kelas;

    Transportasi(String perusahaan, String jenis, String kelas){
        this.perusahaan = perusahaan;
        this.jenis = jenis;
        this.kelas = kelas;
    }
}


// Transportasi Bus
class Bus extends Transportasi {
    String mesin;
    String tipe;
    int tahunProduksi;
    int seatQty;

    Bus(String perusahaan, String jenis, String kelas, String mesin, String tipe, int tahunProduksi, int seatQty){
        super(perusahaan, jenis, kelas);
        this.tipe = tipe;
        this.mesin = mesin;
        this.tahunProduksi = tahunProduksi;
        this.seatQty = seatQty;
    }


    // Display Info Bus
    void detailBus(){
        System.out.println("Perusahaan : " + this.perusahaan);
        System.out.println("Jenis Transportasi : " + this.jenis);
        System.out.println("Kelas : " + this.kelas);

        System.out.println("Mesin : " + this.mesin);
        System.out.println("Tipe : " + this.tipe);
        System.out.println("Tahun Produksi : " + this.tahunProduksi);
        System.out.println("Jumlah Seat : " + this.seatQty);
    };
}


// Transportasi Kereta
class Kereta extends Transportasi {
    String tipe;
    int seatQty;

    Kereta(String perusahaan, String jenis, String kelas, String tipe, int seatQty) {
        super(perusahaan, jenis, kelas);
        this.tipe = tipe;
        this.seatQty = seatQty;
    }

    // Display Info Kereta
    void detailKereta(){
        System.out.println("Perusahaan : " + this.perusahaan);
        System.out.println("Jenis Transportasi : " + this.jenis);
        System.out.println("Kelas : " + this.kelas);

        System.out.println("Tipe : " + this.tipe);
        System.out.println("Jumlah Seat : " + this.seatQty);
    };
}


// Transportasi Pesawat
class Pesawat extends Transportasi {
    String tipe;
    int seatQty;

    Pesawat(String perusahaan, String jenis, String kelas, String tipe, int seatQty){
        super(perusahaan, jenis, kelas);
        this.seatQty = seatQty;
        this.tipe = tipe;
    }

    void detailKereta(){
        System.out.println("Perusahaan : " + this.perusahaan);
        System.out.println("Jenis Transportasi : " + this.jenis);
        System.out.println("Kelas : " + this.kelas);

        System.out.println("Tipe : " + this.tipe);
        System.out.println("Jumlah Seat : " + this.seatQty);
    };
}
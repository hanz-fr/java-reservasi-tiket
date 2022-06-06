import java.math.BigInteger;

public class Customer extends Rekening implements Transaksi {
    String fname;
    String lname;
    String email;
    String alamat;
    BigInteger telepon;

    // Constructor Customer
    Customer(String nomorRekening, int jumlahSaldo, String fname, String lname, String email, String alamat, BigInteger telepon) {
        super(nomorRekening, jumlahSaldo);
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    @Override
    public int beli(int harga) {
        jumlahSaldo -= harga;
        return jumlahSaldo;
    }

    @Override
    public void pakai() {

    }

    @Override
    void inputSaldo(int jumlahInput) {
        jumlahSaldo += jumlahInput;
    }
}

abstract class Rekening {
    protected String nomorRekening;
    protected int jumlahSaldo;

    Rekening(String nomorRekening, int jumlahSaldo){
        this.nomorRekening = nomorRekening;
        this.jumlahSaldo = jumlahSaldo;
    }

    abstract void inputSaldo(int jumlahInput);
}

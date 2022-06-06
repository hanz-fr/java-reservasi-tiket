import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

public class main {

    private static void displayWelcome() {
        System.out.println("+------------ Selamat Datang di iTravel ------------+");
        System.out.println("|                                                   |");
        System.out.println("|          Silahkan pilih program dibawah:          |");
        System.out.println("|                  (1) Registrasi                   |");
        System.out.println("|                    (2) Keluar                     |");
        System.out.println("|                                                   |");
        System.out.println("+---------------------------------------------------+");
        System.out.print("> ");
    }

    private static void displaySuccess() {
        System.out.println("+---------------------------------------------------+");
        System.out.println("|                                                   |");
        System.out.println("|               Registrasi Berhasil!                |");
        System.out.println("|                                                   |");
        System.out.println("+---------------------------------------------------+");
    }


    private static void mainMenu(Customer customer) {
        System.out.println("+---------------------------------------------------+");
        System.out.println("|  Hai " + customer.fname + ", mau jalan-jalan kemana nih?");
        System.out.println("+---------------------------------------------------+");
        System.out.println("|            ITRAVEL CLI TICKET BOOKING             |");
        System.out.println("|                                                   |");
        System.out.println("|           Silahkan pilih opsi dibawah:            |");
        System.out.println("|               (1) Profile Info                    |");
        System.out.println("|               (2) Pesan Tiket                     |");
        System.out.println("|               (3) Bank Account Info               |");
        System.out.println("|               (4) Top-Up Bank Account             |");
        System.out.println("|               (5) My Tickets                      |");
        System.out.println("|                                                   |");
        System.out.println("+---------------------------------------------------+");
        System.out.print("> ");
    }


    private static void displayProfile(String fname, String lname, String email, String alamat, BigInteger telepon) {
        System.out.println("+---------------------------------------------------+");
        System.out.println("|                                                   |");
        System.out.println("|                  Profile Info                     |");
        System.out.println("|                                                   |");
        System.out.println("+---------------------------------------------------+");
        System.out.println(" ");
        System.out.println("            Nama        : " + fname + " " + lname);
        System.out.println("            Email       : " + email);
        System.out.println("            Alamat      : " + alamat);
        System.out.println("            No. Telepon : " + telepon);
        System.out.println(" ");
        System.out.println("+---------------------------------------------------+");
    }

    private static void displayBankAccount(String nomorRekening, int jumlahSaldo) {
        System.out.println("+---------------------------------------------------+");
        System.out.println("|                                                   |");
        System.out.println("|                  My Bank Account                  |");
        System.out.println("|                                                   |");
        System.out.println("+---------------------------------------------------+");
        System.out.println(" ");
        System.out.println("            No. Rekening  : " + nomorRekening);
        System.out.println("            Jumlah Saldo  : " + jumlahSaldo);
        System.out.println(" ");
        System.out.println("+---------------------------------------------------+");
    }

    private static void displayTopUpMenu(Customer customer) {
        Scanner input = new Scanner(System.in); // untuk scan input

        System.out.print("Masukkan Jumlah Saldo : ");
        int saldo = input.nextInt();

        System.out.println("Konfirmasi jumlah saldo : " + saldo);
        System.out.println("(y/n)");
        String opt2a = input.next();

        if (opt2a.equals("y")) {
            customer.inputSaldo(saldo);
            System.out.println("Top-Up Berhasil.");
        } else if (opt2a.equals("n")) {
            System.out.println("Top-Up Dibatalkan.");
        } else {
            System.out.println("False Input.");
        }
    }


    private static Tiket displayPaymentMenu(int harga, Customer customer, String asal, String destinasi, String perusahaanTransportasi, LocalDate tanggal, LocalDateTime jam){
        Scanner input = new Scanner(System.in);

        Tiket t1 = new Tiket(null, null, null, null, null, null, null, 0);

        System.out.println("------------------------------------------");
        System.out.println("Total : " + harga);
        System.out.println("------------------------------------------");
        System.out.println("Pilih jenis pembayaran : ");
        System.out.println("(1) Bank ");
        System.out.println("(2) OVO - ! Service under development.");
        System.out.println("(3) GoPay - ! Service under development.");
        System.out.println("(4) Cancel");
        System.out.println("------------------------------------------");
        int opt = input.nextInt();

        switch(opt){
            case 1:
                System.out.print("Masukkan nomor rekening anda : ");
                String norek = input.next();

                if (!Objects.equals(norek, customer.nomorRekening)){
                    System.out.println("Nomor rekening salah!");
                    displayPaymentMenu(harga, customer, asal, destinasi, perusahaanTransportasi, tanggal, jam);
                } else if (Objects.equals(norek, customer.nomorRekening)){
                    System.out.println("Nomor rekening terkonfirmasi.");
                    System.out.println("Konfirmasi pembayaran sebesar : " + harga);
                    System.out.println("(y)/(n)");
                    String opt2 = input.next();

                    switch (opt2) {
                        case "y" -> {
                            customer.beli(harga);

                            t1.asalTujuan = asal;
                            t1.destinasiTujuan = destinasi;
                            t1.kodeBooking = "T001";
                            t1.perusahaanTransportasi = perusahaanTransportasi;
                            t1.passengerId = "P001";
                            t1.tanggal = tanggal;
                            t1.jam = jam;
                            t1.harga = harga;


                            System.out.println("-----------------------------");
                            System.out.println("     Pembayaran berhasil!    ");
                            System.out.println("-----------------------------");
                            System.out.println();
                            System.out.println("Tiket berhasil ditambahkan di akun anda.");
                            System.out.println();
                            confirmReturn(customer);
                        }
                        case "n" -> {
                            System.out.println("Anda membatalkan pembayaran.");
                            displayPaymentMenu(harga, customer, asal, destinasi, perusahaanTransportasi, tanggal, jam);
                        }
                        default -> System.out.println("ERROR");
                    }
                } else {
                    System.out.println("ERROR");
                    confirmReturn(customer);
                }
            case 2:
                System.out.println("Sorry, OVO Payment is currently unavailable. Please select another option.");
                displayPaymentMenu(harga, customer, asal, destinasi, perusahaanTransportasi, tanggal, jam);
                break;
            case 3:
                System.out.println("Sorry, GoPay Payment is currently unavailable. Please select another option.");
                displayPaymentMenu(harga, customer, asal, destinasi, perusahaanTransportasi, tanggal, jam);
                break;
            case 4:
                System.out.println("Pembayaran di cancel.");
                confirmReturn(customer);
            default:
                System.out.println("ERROR. INVALID INPUT");
        }

        return t1;
    }


    private static void displayMyTicket(Tiket ticket, Customer customer){
        System.out.println("+=========================================+");
        System.out.println("                 My Ticket                 ");
        System.out.println("+=========================================+");

        if (ticket == null) {
            System.out.println();
            System.out.println("You dont have any tickets.");
            System.out.println();
        } else {
            System.out.println(ticket.kodeBooking);
            System.out.println(ticket.passengerId);
            System.out.println(ticket.asalTujuan);
            System.out.println(ticket.destinasiTujuan);
            System.out.println(ticket.perusahaanTransportasi);
            System.out.println(ticket.tanggal);
            System.out.println(ticket.jam);
            System.out.println(ticket.harga);
        }

        System.out.println("+=========================================+");
        confirmReturn(customer);
    }

    private static void confirmReturn(Customer c1) {
        Scanner input = new Scanner(System.in); // untuk scan input
        System.out.println("Kembali ke halaman utama? (y/n)");
        System.out.print("> ");
        String opt = input.next();
        switch(opt) {
            case "y":
                mainMenu(c1);

                int opt2 = input.nextInt();

                conditionalStatement(opt2, c1);

                confirmReturn(c1);
                break;
            case "n":
                break;
            default:
                System.out.println("False input.");
        }
    }

    private static void conditionalStatement(int opt2, Customer customer) {
        if(opt2 == 1){

            displayProfile(customer.fname, customer.lname, customer.email, customer.alamat, customer.telepon); // tampilkan profile customer jika memilih opsi 1

        } else if (opt2 == 2) {

            Scanner input = new Scanner(System.in);

            // tampilkan perintah untuk memesan tiket jika memilih opsi 2
            System.out.println("Tujuan kota:\n(1) Bandung\n(2) Jakarta\n(3) Surabaya\n(4) Solo\n(5) Balikpapan\n(6) Medan\n(7) Makassar");
            System.out.print("> ");
            String opt1 =input.next();
            opt1 = switch (opt1) {
                case "1" -> "Bandung";
                case "2" -> "Jakarta";
                case "3" -> "Surabaya";
                case "4" -> "Solo";
                case "5" -> "Balikpapan";
                case "6" -> "Medan";
                case "7" -> "Makassar";
                default -> "INVALID";
            };

            System.out.println("Asal kota:\n(1) Bandung\n(2) Jakarta\n(3) Surabaya\n(4) Solo\n(5) Balikpapan\n(6) Medan\n(7) Makassar");
            System.out.print("> ");
            String opt3 = input.next();
            opt3 = switch (opt3) {
                case "1" -> "Bandung";
                case "2" -> "Jakarta";
                case "3" -> "Surabaya";
                case "4" -> "Solo";
                case "5" -> "Balikpapan";
                case "6" -> "Medan";
                case "7" -> "Makassar";
                default -> "INVALID";
            };


            System.out.println("Kapan anda mau berangkat?\n(1) Hari ini\n(2) Besok\n(3) Lusa");
            System.out.print("> ");
            String opt4 = input.next();
            opt4 = switch (opt4) {
                case "1" -> "Hari ini";
                case "2" -> "Besok";
                case "3" -> "Lusa";
                default -> "INVALID";
            };


            System.out.println("Jam berapa anda mau berangkat?\n(1) 10:00\n(2) 12:00\n(3) 14:00\n(4) 16:00\n(5) 18:00\n(6) 20:00");
            System.out.print("> ");
            String opt5 = input.next();
            opt5 = switch (opt5) {
                case "1" -> "10:00";
                case "2" -> "12:00";
                case "3" -> "14:00";
                case "4" -> "16:00";
                case "5" -> "18:00";
                case "6" -> "20:00";
                default -> "INVALID";
            };

            System.out.println("Jenis transportasi yang dipakai\n(1) Kereta\n(2) Bus\n(3) Pesawat");
            System.out.print("> ");
            String opt6 = input.next();
            opt6 = switch (opt6) {
                case "1" -> "Kereta";
                case "2" -> "Bus";
                case "3" -> "Pesawat";
                default -> "INVALID";
            };

            switch (opt6) {
                case "Kereta" -> {
                    System.out.println("Silahkan pilih tipe kereta dibawah\n(1) KA-01\n(2) KA-05\n(3) KA-10");
                    System.out.print("> ");
                    String opt7 = input.next();
                    opt7 = switch (opt7) {
                        case "1" -> "KA-01";
                        case "2" -> "KA-05";
                        case "3" -> "KA-10";
                        default -> "INVALID";
                    };
                }
                case "Bus" -> {
                    System.out.println("Silahkan pilih perusahaan otobus dibawah\n(1) PO Haryanto\n(2) PO Budiman\n(3) PO Primajasa\n(4) PO Scorpion Holiday");
                    System.out.print("> ");
                    String opt8 = input.next();
                    opt8 = switch (opt8) {
                        case "1" -> "PO Haryanto";
                        case "2" -> "PO Budiman";
                        case "3" -> "PO Primajasa";
                        case "4" -> "PO Scorpion Holiday";
                        default -> "INVALID";
                    };
                }
                case "Pesawat" -> {
                    System.out.println("Silahkan pilih maskapai pesawat dibawah\n(1) Garuda Airlines\n(2) Lion Air\n(3) Air Asia\n(4) Citilink\n(5) Wings Air");
                    System.out.print("> ");
                    String opt9 = input.next();
                    opt9 = switch (opt9) {
                        case "1" -> "Garuda Airlines";
                        case "2" -> "Lion Air";
                        case "3" -> "Air Asia";
                        case "4" -> "Citilink";
                        case "5" -> "Wings Air";
                        default -> "INVALID";
                    };
                }
                default -> System.out.println("False input");
            }

            System.out.println("Silahkan pilih kelas dari agensi/maskapai tersebut\n(1) Premium\n(2) Bisnis\n(3) Ekonomi");
            System.out.print("> ");
            String opt10 = input.next();
            opt10 = switch (opt10) {
                case "1" -> "Premium";
                case "2" -> "Bisnis";
                case "3" -> "Ekonomi";
                default -> "INVALID";
            };

            System.out.println("Periksa kembali pesanan tiket anda." + "\nNama : " + customer.fname + " " + customer.lname + "\nEmail : " + customer.email + "\nNo. Telepon : " + customer.telepon + "\nDestinasi : " + opt1 + "\nAsal Kota : " + opt3 + "\nTransportasi : " + opt6 + "\nKelas : " + opt10 + "\nTanggal : " + opt4 + "\nJam Berangkat : " + opt5);
            System.out.println("Lanjut ke pembayaran? (y/n)");
            String opt = input.next();
            switch (opt) {
                case "y" -> displayPaymentMenu(1250000, customer, opt3, opt1, opt6, LocalDate.now(), LocalDateTime.now());
                case "n" -> System.out.println("Pemesanan tiket dibatalkan.");
                default -> System.out.println("False input.");
            }
        } else if (opt2 == 3) {

            displayBankAccount(customer.nomorRekening, customer.jumlahSaldo); // tampilkan detail akun bank customer jika memilih opsi 3

        } else if (opt2 == 4) {

            displayTopUpMenu(customer); // tampilkan menu untuk topup jika customer memilih opsi 4.

        } else if (opt2 == 5) {
            displayMyTicket(null, customer);
        }
        else {
            System.out.println("False Input. Program exit with error code 1.");
        }
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // untuk scan input


        displayWelcome(); // tampilan welcome saat pertama kali program dijalankan

        int opt1 = input.nextInt(); // input untuk memilih opsi 1 atau 2



        if (opt1 == 1) {

            System.out.println("+---------------------------------------------------+");
            System.out.println("|                                                   |");
            System.out.println("|        Silahkan registrasi terlebih dahulu.       |");
            System.out.println("|                                                   |");
            System.out.println("+---------------------------------------------------+");

            System.out.print("Nama Depan : ");
            String fname = input.next();
            input.nextLine();

            System.out.print("Nama Belakang : ");
            String lname = input.next();
            input.nextLine();

            System.out.print("Email : ");
            String email = input.next();
            input.nextLine();

            System.out.print("Alamat (Spasi dengan '.') : ");
            String alamat = input.next();
            input.nextLine();

            System.out.print("Nomor Rekening : ");
            String nomorRekening = input.next();
            input.nextLine();

            System.out.print("Nomor HP : ");
            BigInteger telepon = input.nextBigInteger();

            // Objek Customer (Data berasal dari inputan user)
            Customer c1 = new Customer(nomorRekening,0,fname, lname, email, alamat, telepon);


            displaySuccess(); // tampilan sukses jika registrasi berhasil

            mainMenu(c1); // jika registrasi berhasil, maka tampilan main menu akan muncul.


            int opt2 = input.nextInt();

            conditionalStatement(opt2, c1); // tampilkan pengkondisian sesuai dengan input yang user masukkan

            confirmReturn(c1); // setelah pengkondisian selesai, tampilkan konfirmasi untuk melanjutkan program atau menyelesaikan program


        } else if (opt1 == 2) {
            System.out.println("Terima kasih telah menggunakan iTravel!");
        } else {
            System.out.println("False input. Program exit with error code 1");
        }
    }



}

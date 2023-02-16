package pkg;
import java.util.Scanner;
public class BahasaPemrogramanUAS {

    String data[];
    String kata;
    static int n = 30;
    static int j = 10;
    static String[] namaBarang = new String[n];
    static int[] hargaBarang = new int[n];

    static void showBarang(){
        System.out.println("""
                ========================================================
                |           List Barang Toko Astrea Sederhana          |
                ========================================================
                |   No |  Nama Barang |        Harga                   |"""
                    );
        for (int i=0; i<=j-1;i++){
            System.out.println("|   " + (i+1) + ". | " + namaBarang[i] +" | "+ hargaBarang[i] + " |");
        }
    }

    static int mCari(String data[], String kata){

        int indeksBarang;
        boolean found;
        indeksBarang = 0;
        found = false;
        
        if(indeksBarang < j){
        while (indeksBarang < j && !found) {
            if (data[indeksBarang].equals(kata)) {
                found = true;
            } else {
                indeksBarang = indeksBarang + 1;
            }
            }
        }
        else{
            System.out.println("Barang tidak ditemukan");
        }
    return indeksBarang;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        Scanner inputKata = new Scanner(System.in);

        String[] pilihanBarang = new String[n];
        String[] barangTemp = new String[n];
        int[] jmlhBarang = new int[n];
        int[] penjualanBarang = new int[n];
        int[] penjualanBarangTemp = new int[n];
        int[] jumlahBarangTemp = new int[n];

        namaBarang[0] = "Aqua";
        namaBarang[1] = "Bango";
        namaBarang[2] = "Beras";
        namaBarang[3] = "Mie Sedaap";
        namaBarang[4] = "Rinso";
        namaBarang[5] = "Saus Tomat";
        namaBarang[6] = "Shampoo Lifeboy";
        namaBarang[7] = "Taro";
        namaBarang[8] = "Tepung Terigu";
        namaBarang[9] = "Telur";
        hargaBarang[0] = 4000;
        hargaBarang[1] = 28000;
        hargaBarang[2] = 62000;
        hargaBarang[3] = 3000;
        hargaBarang[4] = 7000;
        hargaBarang[5] = 9500;
        hargaBarang[6] = 12000;
        hargaBarang[7] = 7500;
        hargaBarang[8] = 10000;
        hargaBarang[9] = 8500;
        barangTemp[0] = "Aqua";
        barangTemp[1] = "Bango";
        barangTemp[2] = "Beras";
        barangTemp[3] = "Mie Sedaap";
        barangTemp[4] = "Rinso";
        barangTemp[5] = "Saus Tomat";
        barangTemp[6] = "Shampoo Lifeboy";
        barangTemp[7] = "Taro";
        barangTemp[8] = "Tepung Terigu";
        barangTemp[9] = "Telur";
        
        String ubahNama, kataBenda, tempKata;
        int ubahHarga, temp, tempHarga, hasilPencarian, indeks, inputTombol, inputTombolUI , jmlhBenda, pembayaran, totalPembayaran, kembalian, tambah;
        boolean yakin, yakin2, selesai;

        totalPembayaran = 0;
        yakin = false;
        yakin2 = false;
        selesai = false;
        tambah = 1;
        
        do{
            System.out.println("""
                ========================================================
                |                                                      |
                |       Hai User, Login Sebagai Apa Hari Ini?          |
                |                                                      |
                ========================================================
                |                                                      |
                |   1.  Pegawai Kasir                                  |
                |   2.  Admin                                          |
                |   3.  Owner                                          |
                |   0.  Keluar                                         |
                |                                                      |
                ========================================================
                    """);
                    inputTombolUI = input.nextInt();
            switch (inputTombolUI) {

            case 1 :
        do{
            System.out.println("""
                    ========================================================
                    |                                                      |
                    |          Selamat Datang di Menu Kasir                |
                    |                                                      |
                    ========================================================
                    |                                                      |
                    |   1.  Tampilkan Barang                               |
                    |   2.  Pilih Barang                                   |
                    |   3.  Cari Barang                                    |
                    |   4.  Total Barang                                   |
                    |   0.  Keluar                                         |
                    |                                                      |
                    ========================================================
                    """);
            inputTombol = input.nextInt();
            switch (inputTombol) {
                case 1 :
                    showBarang();
                    break;
            
                case 2 :
                while(!selesai){
                        System.out.print("Masukkan nama barang : ");
                        kataBenda = inputKata.nextLine();
                        hasilPencarian = mCari(namaBarang, kataBenda);
                        pilihanBarang[hasilPencarian] = namaBarang[hasilPencarian];
                        System.out.print("Jumlah Barang :");
                        jmlhBenda = input.nextInt();
                        jmlhBarang[hasilPencarian] = jmlhBenda;
                        System.out.println("""
                    ========================================================
                    |                                                      |
                    |           Selesai Melakukan Pemilihan                |
                    |                   (true/false)                       |
                    ========================================================
                        """);
                        selesai = input.nextBoolean();
                    }
                    break;

                case 3 :
                while(!yakin){
                System.out.println("""
                    ========================================================
                    |                                                      |
                    |                   Pencarian Barang                   |
                    |                                                      |
                    ========================================================
                    |                                                      |
                    |        Masukkan Nama Barang Yang Ingin Dicari        |
                    |                                                      |
                    ========================================================
                        """);
                    kataBenda = inputKata.nextLine();
                    hasilPencarian = mCari(namaBarang, kataBenda);
                    System.out.println("""
                    ========================================================
                    |                                                      |
                    |           Benarkah ini yang anda cari                |
                    |                   (true/false)                       |
                    ========================================================
                            """);
                    System.out.println((hasilPencarian + 1) + ". | " + namaBarang[hasilPencarian] +" | "+ hargaBarang[hasilPencarian] + " |");
                    yakin = input.nextBoolean();
                }
                    break;

                case 4 :
                System.out.println("""
                    ========================================================
                    |                                                      |
                    |               Barang yang anda pilih                 |
                    |                                                      |
                    ========================================================
                        """);
                for (int i=0; i<=j-1;i++){
                    System.out.println("|   " + (i+1) + ". | " + pilihanBarang[i] +" | Jumlah : "+ jmlhBarang[i] + " |");
                }
                for (int i=0; i<=j-1;i++){
                    jumlahBarangTemp[i] = jumlahBarangTemp[i] + jmlhBarang[i];
                    totalPembayaran = totalPembayaran + (jmlhBarang[i] * hargaBarang[i]);
                    penjualanBarang[i] = penjualanBarang[i] + (jmlhBarang[i] * hargaBarang[i]);
                    penjualanBarangTemp[i] = penjualanBarangTemp[i] + (jmlhBarang[i] * hargaBarang[i]);
                    }
                System.out.println("|   Total Pembayaran : " + totalPembayaran + "    |");
                System.out.print(" Uang yang ingin anda bayarkan :");
                pembayaran = input.nextInt();
                kembalian = pembayaran - totalPembayaran;
                for (int i=0; i<=j-1;i++){
                    System.out.println("|   " + (i+1) + ". | " + pilihanBarang[i] +" | Jumlah : "+ jmlhBarang[i] + " |");
                }
                System.out.println("==================================================================================");
                System.out.println("|                                               Total Pembayaran : " + totalPembayaran +"   |");
                System.out.println("|                                               Pembayaran : " + pembayaran + "     |");
                System.out.println("|                                               Kembalian : " + kembalian + "   |");
                System.out.println("==================================================================================");
                            totalPembayaran = 0;
                            for (int i=0; i<=j-1;i++){
                                jmlhBarang[i] = 0;
                                pilihanBarang[i] = "null";
                            }
                    break;

                default:
                
                    break;
            
            }
            yakin = false;
            selesai = false;
        }while(inputTombol!=0);

        break;

            case 2 :
                    do{
                        System.out.println("""
                ========================================================
                |                                                      |
                |               Selamat Datang Admin                   |
                |                                                      |
                ========================================================
                |                                                      |
                |   1.  Tampilkan barang                               |
                |   2.  Tambah Barang                                  |
                |   3.  Ubah Barang                                    |
                |   4.  Hapus Barang                                   |
                |   0.  Keluar                                         |
                |                                                      |
                ========================================================
                    """);
                        inputTombol = input.nextInt();
            switch (inputTombol) {
                case 1 :
                    showBarang();
                    break;

                case 2 :
                j = j + tambah;
                System.out.print("Masukkan nama barang :");
                namaBarang[j-1] = inputKata.nextLine();
                barangTemp[j-1] = namaBarang[j-1];
                System.out.print("Masukkan harga barang baru :");
                hargaBarang[j-1] = input.nextInt();
                    break;

                case 3 :
                while(!yakin2){
                System.out.print(" Input Barang yang ingin diubah : ");
                kataBenda = inputKata.nextLine();
                    hasilPencarian = mCari(namaBarang, kataBenda);
                System.out.println("Hasil Pencarian");
                System.out.println((hasilPencarian + 1) + ". | " + namaBarang[hasilPencarian] +" | "+ hargaBarang[hasilPencarian] + " |");
                System.out.println("""
                        |           Ubah Data           |
                        """);
                        System.out.print("Masukkan Nama Barang :");
                        ubahNama = inputKata.nextLine();
                        System.out.print("Masukkan Harga Barang :");
                        ubahHarga = input.nextInt();
                        namaBarang[hasilPencarian] = ubahNama;
                        barangTemp[hasilPencarian] = ubahNama;
                        hargaBarang[hasilPencarian] = ubahHarga;
                        yakin2 = true;
                }
                    break;
                case 4 :
                System.out.print("Input nama barang yang ingin dihapus :");
                kataBenda = inputKata.nextLine();
                    hasilPencarian = mCari(namaBarang, kataBenda);
                    namaBarang[hasilPencarian] = "null";
                    hargaBarang[hasilPencarian] = 0;
                    break;
                default :
                    break;
                    }
                yakin2 = false;
                }while(inputTombol!=0);

                break;

            case 3:
                do{
                        System.out.println("""
                ========================================================
                |                                                      |
                |               Selamat Datang Owner                   |
                |                                                      |
                ========================================================
                |                                                      |
                |   1.  Tampilkan Penjualan                            |
                |   2.  Tampilkan Top 5 Terlaris                       |
                |   0.  Keluar                                         |
                |                                                      |
                ========================================================
                    """);
                        inputTombol = input.nextInt();
            switch (inputTombol) {
                case 1:
                System.out.println("""
                ========================================================
                |      Penjualan Barang Toko Astrea Sederhana          |
                ========================================================
                |   No |  Nama Barang |  Harga Barang  |   Penjualan   |"""
                    );
        for (int i=0; i<=j-1;i++){
            System.out.println("|   " + (i+1) + ". | " + namaBarang[i] +" | "+ hargaBarang[i] + " | " + penjualanBarang[i] + " |");
        }
                break;

                case 2 :
                System.out.println("""
                            ======================================================================
                            |                       Top Barang Terlaris                          |
                            ======================================================================
                            | No. | Nama Barang | Total Penjualan Barang | Jumlah Barang Terjual |""");
                for (int i = 0; i <= n - 2; i++) {
                    indeks = i;
                    for (int k = i + 1 ; k <= n - 1; k++) {
                        if (jumlahBarangTemp[indeks] < jumlahBarangTemp[k]) {
                            indeks = k;
                        }
                    }
                            temp = jumlahBarangTemp[indeks];
                            jumlahBarangTemp[indeks] = jumlahBarangTemp[i];
                            jumlahBarangTemp[i] = temp;
                            tempKata = barangTemp[indeks];
                            barangTemp[indeks] = barangTemp[i];
                            barangTemp[i] = tempKata;
                            tempHarga = penjualanBarangTemp[indeks];
                            penjualanBarangTemp[indeks] = penjualanBarangTemp[i];
                            penjualanBarangTemp[i] = tempHarga;
                }
                for (int i = 0; i < 5; i++){
                    System.out.println("|   " + (i + 1) + ". | " + barangTemp[i] + "    |   " + penjualanBarangTemp[i] + "  |   " + jumlahBarangTemp[i] );
                }
                    break;

                default :
                break;
            }
                }while(inputTombol!=0);
                
            }
    }while(inputTombolUI!=0);
    }
}

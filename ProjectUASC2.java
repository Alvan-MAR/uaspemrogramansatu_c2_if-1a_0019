
import java.util.Scanner;

public class ProjectUASC2 {
    public String[] namaPenyewa = new String[2];
    public int[] jenisKendaraan = new int[2];
    public int[] jumlahHariSewa = new int[2];
    public double tarifMotor = 75000, tarifMobil = 250000, tarifMinibus = 400000;
    public Scanner ns = new Scanner(System.in);
    public boolean statusInputData = false;
    public String[] kategoriPenyewaan = new String[2];
    public double diskon = 0.85;
    public double[] totalBiayaSewa = new double[2];
    public String ulang = "tidak";
    public int pilihan = 0;

    public void menuUtama(){
        System.out.println("Program Penyewaan Kendaraan Otomatis");
        System.out.println("Menu Yang Tersedia:");
        System.out.println("1. Input Data");
        System.out.println("2. Tampilkan Data");
        System.out.println("3. Ringkasan Rental");
        System.out.println("4. Keluar");
        System.out.print("Silahkan Pilih Menu: ");
    }
    
    public int inputMenu(){
        try {
            pilihan = ns.nextInt();
            ns.nextLine();
            return pilihan;
        } catch (Exception e) {
            System.out.println(e);
            return pilihan = 0;
        }
        
    }

    public void inputData() {
        System.out.println("Menu Input Data:");
        System.out.println("1. Nama Penyewa");
        System.out.println("2. Jenis Kendaraan:");
        System.out.println("    1. Motor");
        System.out.println("    2. Mobil");
        System.out.println("    3. Minibus");
        System.out.println("3. Jumlah Hari Sewa (Diskon 15% apabila menyewa lebih dari 3 hari)");
        for (int i = 0; i < 2; i++){
            System.out.print("Masukkan Nama Penyewa ke-" + (i+1) + ": ");
            namaPenyewa[i] = ns.nextLine();     
            boolean validasiInputKendaraan = false;
            boolean validasiInputHariSewa = false;
            try {
            
                System.out.print("Masukkan Jenis Kendaraan ke-" + (i+1) + "(Masukkan angka): ");
                    jenisKendaraan[i] = ns.nextInt();
                    ns.nextLine();
                    validasiInputKendaraan = true;
                System.out.print("Masukkan Jumlah Hari Sewa ke-" + (i+1) + ": ");
                    jumlahHariSewa[i] = ns.nextInt();
                    ns.nextLine();
                    validasiInputHariSewa = true;  
            } catch (Exception e) {
                System.out.println(e);
            }
            statusInputData = true;
        }

    }
    public void totalTarifSewa(){
        for(int i = 0; i <3 ; i++){
            switch (jenisKendaraan[i]) {
                case 1:
                    if (jumlahHariSewa[i] > 3){
                        totalBiayaSewa[i] = (tarifMotor * jumlahHariSewa[i]) * diskon;
                        if (totalBiayaSewa[i] < 300000){
                            kategoriPenyewaan[i] = "Ekonomis" ;
                        }
                        else if (totalBiayaSewa[i] > 300000 && totalBiayaSewa[i] < 750000){
                            kategoriPenyewaan[i] = "Standar";
                        }
                        else {
                            kategoriPenyewaan[i] = "Premium";
                        }
                        
                    }
                    else{
                        totalBiayaSewa[i] = tarifMotor * jumlahHariSewa[i];
                        if (totalBiayaSewa[i] < 300000){
                            kategoriPenyewaan[i] = "Ekonomis" ;
                        }
                        else if (totalBiayaSewa[i] > 300000 && totalBiayaSewa[i] < 750000){
                            kategoriPenyewaan[i] = "Standar";
                        }
                        else {
                            kategoriPenyewaan[i] = "Premium";
                        }
                    }
                    
                    break;
                    
                case 2:
                    if (jumlahHariSewa[i] > 3){
                        totalBiayaSewa[i] = (tarifMobil * jumlahHariSewa[i]) * diskon;
                        if (totalBiayaSewa[i] < 300000){
                            kategoriPenyewaan[i] = "Ekonomis" ;
                        }
                        else if (totalBiayaSewa[i] > 300000 && totalBiayaSewa[i] < 750000){
                            kategoriPenyewaan[i] = "Standar";
                        }
                        else {
                            kategoriPenyewaan[i] = "Premium";
                        }
                    }
                    else{
                        totalBiayaSewa[i] = tarifMobil * jumlahHariSewa[i];
                        if (totalBiayaSewa[i] < 300000){
                            kategoriPenyewaan[i] = "Ekonomis" ;
                        }
                        else if (totalBiayaSewa[i] > 300000 && totalBiayaSewa[i] < 750000){
                            kategoriPenyewaan[i] = "Standar";
                        }
                        else {
                            kategoriPenyewaan[i] = "Premium";
                        }
                    }
                    break;
                case 3:
                    if (jumlahHariSewa[i] > 3){
                        totalBiayaSewa[i] = (tarifMinibus * jumlahHariSewa[i]) * diskon;
                        if (totalBiayaSewa[i] < 300000){
                        kategoriPenyewaan[i] = "Ekonomis" ;
                        }
                        else if (totalBiayaSewa[i] > 300000 && totalBiayaSewa[i] < 750000){
                        kategoriPenyewaan[i] = "Standar";
                        }
                        else {
                            kategoriPenyewaan[i] = "Premium";
                        }
                        
                    }
                    else{
                        totalBiayaSewa[i] = tarifMinibus * jumlahHariSewa[i];
                        if (totalBiayaSewa[i] < 300000){
                            kategoriPenyewaan[i] = "Ekonomis" ;
                        }
                        else if (totalBiayaSewa[i] > 300000 && totalBiayaSewa[i] < 750000){
                            kategoriPenyewaan[i] = "Standar";
                        }
                        else {
                        kategoriPenyewaan[i] = "Premium";
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void tampilkanData(){
        if (statusInputData == false){
            System.out.println("Data belum tersedia");
        }
        else{
            System.out.println("Data Penyewaan:");
            for (int i = 0; i < 3; i++){
                System.out.println("No. Urut: " + (i));
                System.out.println("Nama Penyewa: " + namaPenyewa[i]);
                System.out.println("Jenis Kendaraan: " + jenisKendaraan[i]);
                System.out.println("Jumlah Hari Sewa: " + jumlahHariSewa[i]);
                System.out.println("Total Biaya Sewa (Rp): " + totalBiayaSewa[i]);
                System.out.println("Kategori Penyewaan: " + kategoriPenyewaan[i]);
                System.out.println("");
            }
        }
    }
    public double rata2BiayaSewa (int n){
        if(n == 0){
            return 1;
        }
        else{
            return (totalBiayaSewa[n-1] + rata2BiayaSewa(n-1)) / namaPenyewa.length;
        }
        
    }

    public void ringkasanRental (){
        if(statusInputData == false){
            System.out.println("Data belum tersedia");
        }
        else{
            for (int i = 0; i < namaPenyewa.length; i++){
                System.out.println("Total Penyewaan: " + namaPenyewa.length);
                System.out.println("Rata-Rata Biaya Sewa: " + rata2BiayaSewa(namaPenyewa.length));
            }
        }
    }

    public static void main(String[] args) {
        ProjectUASC2 obj = new ProjectUASC2();
        do {
            obj.menuUtama();
            obj.inputMenu();
            switch (obj.pilihan) {
                case 1:
                    obj.inputData();
                    System.out.print("Apakah Anda Ingin Mengulang? (Ya/Tidak): ");
                    obj.ulang = obj.ns.nextLine();
                    break;

                case 2:
                    obj.totalTarifSewa();
                    obj.tampilkanData();
                    System.out.print("Apakah Anda Ingin Mengulang? (Ya/Tidak): ");
                    obj.ulang = obj.ns.nextLine();
                    break;

                case 3:
                    obj.ringkasanRental();
                    System.out.print("Apakah Anda Ingin Mengulang? (Ya/Tidak): ");
                    obj.ulang = obj.ns.nextLine();
                    break;

                case 4:
                    obj.ulang = "tidak";
                    break;
            
                default:
                    break;
            }
            
            
        } while (obj.ulang.equalsIgnoreCase("ya"));
        System.out.println("Program Selesai");
        obj.ns.close();
    }


}

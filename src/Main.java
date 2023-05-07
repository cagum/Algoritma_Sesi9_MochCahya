import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Nomor 1
        Scanner input = new Scanner(System.in);
        boolean next = true;
        LinkedList<Warga> listWarga = new LinkedList<Warga>();
        Integer totalMembayarUang = 0;
        Integer totalMembayarBeras = 0;
        Integer totalUangSedekah = 0;

        do {
            Warga warga = new Warga();
            System.out.print("Nama warga : ");
            warga.nama = input.nextLine();

            System.out.print("Apakah anda ingin sedekah atau zakat? [zakat/sedekah] : ");
            warga.type = input.nextLine();
            if (warga.type.equals("zakat")) {
                System.out.print("Apakah anda ingin zakat uang atau beras ? [uang/beras] : ");
                String typeZakat = input.nextLine();
                if (typeZakat.equals("uang")) {
                    warga.isBeras = false;
                    warga.nominal = 25000;
                    totalMembayarUang ++;
                } else {
                    totalMembayarBeras ++;
                    warga.isBeras = true;
                }
            } else {
                System.out.print("Masukkan nominal sedekah anda : ");
                warga.nominal = Integer.parseInt(input.nextLine());
                totalUangSedekah += warga.nominal;
            }

            System.out.print("Apakah anda ingin menambah warga baru ? [Y/n] ");
            String isnext = input.nextLine();

            listWarga.offer(warga);

            if (isnext.equals("n")) {
                next = false;
            } else {
                next = true;
            }


        } while (next);


        System.out.println("Nama\t\tType\t\tJenis Pemberian\t\tNominal");
        while (!listWarga.isEmpty()) {
            Warga warga = listWarga.peek();
            System.out.print(warga.nama + "\t\t");
            System.out.print(warga.type + "\t\t");
            System.out.print(warga.isBeras ? "beras" : "uang");
            System.out.print("\t\t\t");
            System.out.print(warga.nominal);
            System.out.println();
            listWarga.poll();
        }

        System.out.println("total warga yang membayar zakat dengan uang : " + totalMembayarUang);
        System.out.println("total warga yang membayar zakat dengan beras : " + totalMembayarBeras);
        System.out.println("total uang zakat terkumpul : " + (totalMembayarUang * 2.5));
        System.out.println("total beras zakat terkumpul : " + (totalMembayarBeras * 35000));
        System.out.println("total uang sedekah : " + totalUangSedekah);

    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

class Node {
    String isi;
    List<Node> anak;

    public Node(String isi) {
        this.isi = isi;
        this.anak = new ArrayList<Node>();
    }

    public void tambahAnak(Node nodeAnak) {
        this.anak.add(nodeAnak);
    }
}

public class Nomor2 {

    public static void cetakPerKedalaman(Node s, int n) {
        if (s == null) return;

        // Jika n sudah 0, kita sampai di lantai yang dicari
        if (n == 0) {
            System.out.print(s.isi + " ");
            return; // Berhenti di sini 
        }

        // Jika belum sampai, turun ke semua anak
        if (s.anak != null) {
            for (int i = 0; i < s.anak.size(); i++) {
                cetakPerKedalaman(s.anak.get(i), n - 1);
            }
        }
    }

    public static void main(String[] args) {
        // Membangun pohon (Root A sampai G)
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");

        a.tambahAnak(b); a.tambahAnak(c); a.tambahAnak(d);
        b.tambahAnak(e); b.tambahAnak(f);
        e.tambahAnak(g);

        // Setting Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai kedalaman (n): ");
        
        // Cek apakah yang diinput angka atau bukan
        if (input.hasNextInt()) {
            int n = input.nextInt();
            
            System.out.print("Simpul pada kedalaman " + n + ": ");
            cetakPerKedalaman(a, n);
            System.out.println();
        } else {
            System.out.println("Error: Masukkan harus berupa angka!");
        }

        input.close();
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList; 
import java.util.Queue;      

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

public class TUGAS {

    // 1. Method BFS untuk mencetak DAUN saja
    public static void cetakDaunBFS(Node root) {
        if (root == null) return;

        // Queue digunakan untuk menyimpan antrean simpul yang akan diperiksa
        Queue<Node> antrean = new LinkedList<>();
        antrean.add(root);

        while (!antrean.isEmpty()) {
            // Ambil simpul dari depan antrean
            Node s = antrean.poll();

            if (s.anak == null || s.anak.isEmpty()) {
                System.out.print(s.isi + " ");
            } else {
                // Jika punya anak, masukkan semua anaknya ke dalam antrean
                for (int i = 0; i < s.anak.size(); i++) {
                    antrean.add(s.anak.get(i));
                }
            }
        }
    }

    // 2. Main Method
    public static void main(String[] args) {
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

        System.out.print("Simpul Daun (Versi BFS): ");
        cetakDaunBFS(a);
        System.out.println();
    }
}
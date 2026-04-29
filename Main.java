import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Representasi Node untuk General Tree
class Node<T> {
    T value;
    List<Node<T>> children;

    public Node(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(Node<T> child) {
        this.children.add(child);
    }
}

class SimpleTree<T> {
    Node<T> root;

    public SimpleTree(Node<T> root) {
        this.root = root;
    }

    // Metode Utama untuk Soal 4.3f
    public void printAtDepth(int n) {
        System.out.print("Simpul pada kedalaman " + n + ": ");
        printAtDepthRecursive(this.root, n);
        System.out.println();
    }

    // Logika Rekursif [cite: 43, 44, 45]
    private void printAtDepthRecursive(Node<T> currentNode, int n) {
        if (currentNode == null) return;

        // Syarat 1: Jika n sudah 0, berarti ini kedalaman yang diminta 
        if (n == 0) {
            System.out.print(currentNode.value + " ");
            // Syarat 2: Berhenti di sini, jangan kunjungi anak (depth > n) 
            return;
        }

        // Jika belum sampai (n > 0), turun ke anak-anaknya 
        for (Node<T> child : currentNode.children) {
            printAtDepthRecursive(child, n - 1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. Membangun pohon sesuai Gambar 1 
        Node<String> a = new Node<>("A"); // Depth 0
        Node<String> b = new Node<>("B"); // Depth 1
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E"); // Depth 2
        Node<String> f = new Node<>("F");
        Node<String> h = new Node<>("H");
        Node<String> k = new Node<>("K");
        Node<String> l = new Node<>("L");
        Node<String> m = new Node<>("M");
        Node<String> g = new Node<>("G"); // Depth 3
        Node<String> i = new Node<>("I");
        Node<String> j = new Node<>("J");
        Node<String> nNode = new Node<>("N");

        // Menghubungkan sesuai struktur di PDF [cite: 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22]
        a.addChild(b); a.addChild(c); a.addChild(d);
        b.addChild(e); b.addChild(f);
        c.addChild(h);
        d.addChild(k); d.addChild(l); d.addChild(m);
        e.addChild(g);
        h.addChild(i); h.addChild(j);
        m.addChild(nNode);

        SimpleTree<String> tree = new SimpleTree<>(a);

        // 2. Sistem Input untuk Pengguna
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kedalaman (n) yang ingin dicetak: ");
        
        if (scanner.hasNextInt()) {
            int targetDepth = scanner.nextInt();
            tree.printAtDepth(targetDepth);
        } else {
            System.out.println("Input harus berupa angka!");
        }
        
        scanner.close();
    }
}
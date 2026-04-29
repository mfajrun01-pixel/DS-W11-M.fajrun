import java.util.ArrayList;
import java.util.List;

class Node {
    String value;
    List<Node> children;

    public Node(String value) {
        this.value = value;
        this.children = new ArrayList<Node>();
    }

    public void addChild(Node child) {
        this.children.add(child);
    }
}

public class Main1 { 
    public static void main(String[] args) {
        // Membangun pohon sesuai Gambar 1 [cite: 8, 23]
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");

        // Susun struktur [cite: 34]
        a.addChild(b); 
        a.addChild(c);  
        a.addChild(d);
        b.addChild(e); 
        b.addChild(f);
        e.addChild(g);

        System.out.print("Simpul Daun: ");
        printLeaves(a);
        System.out.println();
    }

    // Jawaban Soal 4.3e: Cetak daun dari kiri ke kanan [cite: 34]
    public static void printLeaves(Node node) {
        if (node == null) return;
        
        if (node.children.isEmpty()) {
            System.out.print(node.value + " ");
        } else {
            for (Node child : node.children) {
                printLeaves(child);
            }
        }
    }
}
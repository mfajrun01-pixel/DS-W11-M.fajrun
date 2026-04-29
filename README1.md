A. O(n)
Kenapa bisa begitu?Jumlah Objek yang Dikunjungi: Soal hanya meminta kita mencetak nama direktori. Karena jumlah total direktori adalah $n$, maka program harus mengunjungi setiap direktori tersebut tepat satu kali.

B. O(N+n)
Cara Menemukan File: Untuk bisa mencetak nama sebuah file, program tidak bisa langsung "loncat" ke file tersebut. Program harus melewati atau membuka direktori tempat file itu berada.
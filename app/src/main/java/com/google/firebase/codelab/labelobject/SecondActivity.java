package com.google.firebase.codelab.labelobject;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView fname;
    TextView fket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        fname = (TextView)findViewById(R.id.fName);
        fket = (TextView)findViewById(R.id.fket);

        String jeruk = "Jeruk adalah sumber vitamin C yang sangat baik, nutrisi yang memperkuat sistem kekebalan tubuh.\n" +
                "\n" +
                "Vitamin C memiliki efek meningkatkan kekebalan yang dapat membantu tubuh melawan penyakit, seperti flu atau infeksi virus. Satu studi menemukan bahwa vitamin C membantu mencegah pneumonia dan mendukung perawatan tetanus.";
        String lemon = "Buah-buahan jeruk seperti jeruk manis, lemon, jeruk nipis dan sebagainya merupakan sumber vitamin C yang sangat populer. Buah jeruk adalah sumber vitamin C yang sangat baik, nutrisi yang memperkuat sistem kekebalan tubuh.\n" +
                "\n" +
                "Vitamin C memiliki efek meningkatkan kekebalan yang dapat membantu tubuh melawan penyakit, seperti flu atau infeksi virus. Satu studi menemukan bahwa vitamin C membantu mencegah pneumonia dan mendukung perawatan tetanus.";
        String kiwi = "Kiwi secara alami penuh dengan ragam nutrisi penting, termasuk folat, potasium, vitamin K, dan vitamin C. Vitamin C meningkatkan sel darah putih untuk melawan infeksi, sementara nutrisi kiwi lainnya menjaga agar seluruh tubuh berfungsi dengan baik.\n" +
                "\n" +
                "Kiwi padat nutrisi dan penuh vitamin C. Satu studi bahkan menemukan bahwa kiwi dapat mendukung fungsi kekebalan tubuh dan mengurangi kemungkinan mengembangkan penyakit seperti pilek atau flu. Hal ini terutama berlaku pada kelompok berisiko seperti orang dewasa di atas usia 65 dan anak-anak.";
        String strawberry = "Manfaat strawberry (stroberi) ternyata berasal dari kandungan antosianin pemberi warna terang pada buah ini. Zat tersebut bersifat antioksidan dan memberikan berbagai manfaat untuk tubuh, seperti melenturkan pembuluh darah dan menurunkan tekanan darah. Buah strawberry juga memiliki banyak kandungan gizi, termasuk vitamin C, karbohidrat, protein, polifenol, folat, mangan, air, serat, dan kalium. Buah strawberry juga hanya sedikit mengandung kalori dan lemak, serta memiliki indeks glikemik yang rendah.";
        String blueberry = "Salah satu manfaat blueberry yang dinilai luar biasa adalah khasiatnya yang membantu meningkatkan daya ingat jangka pendek. Kabar baiknya lagi, buah yang satu ini mengandung kalori yang rendah, di samping kandungan vitamin C sebesar 10,8 mg dan 2,7 g serat dari tiap ¾ cangkir buah blueberry utuh yang segar.\n" +
                "\n" +
                "Lebih dari itu, penelitian telah membuktikan bahwa senyawa yang banyak terdapat pada blueberry dapat membantu mencegah penyakit kronis yang selama ini menjadi momok bagi seseorang, meliputi pencegahan beberapa jenis kanker, diabetes, dan penyakit jantung.";
        String mangga = "Mangga adalah sumber nutrisi penambah kekebalan tubuh yang baik. Mangga mengandung vitamin A yang sangat penting untuk sistem kekebalan tubuh yang sehat, karena membantu melawan infeksi. Satu cangkir mangga menyediakan sekitar seperempat dari target harian untuk vitamin A.\n" +
                "\n" +
                "Selain itu, jumlah mangga yang sama menyediakan hampir tiga perempat dari kebutuhan vitamin C harian. Mangga juga mengandung folat, vitamin K, vitamin E dan beberapa vitamin B, yang membantu kekebalan tubuh. Tidak mendapatkan cukup vitamin dan nutrisi ini dikaitkan dengan kerentanan yang lebih besar terhadap infeksi.";
        String apel = "Buah apel memberikan dampak baik pada tubuh mulai dari kulit hingga dagingnya. Kamu dapat merasakan tubuh menjadi lebih sehat setelah mengonsumsi apel secara rutin. Apel kaya akan kandungan antioksidan, flavonoid, dan serat makanan. Kandungan tersebut membantu untuk mengurangi risiko kanker, diabetes, hingga jantung.\n" +
                "\n" +
                "Maka dari itu, untuk merasakan manfaat dari apel, kamu disarankan paling tidak mengonsumsi dua buah setiap harinya";
        if (message == null){
            fname.setText("Objek tidak ditemukan");

            fket.setText("eror");
        }
        else if (message.equals("Strawberry")){
            fname.setText(message);
            fket.setText(strawberry);
        }
        else if(message.equals("Jeruk")){
            fname.setText(message);
            fket.setText(jeruk);
        }
        else if(message.equals("Apel")){
            fname.setText(message);
            fket.setText(apel);
        }
        else if(message.equals("Kiwi")){
            fname.setText(message);
            fket.setText(kiwi);
        }
        else if(message.equals("Mangga")){
            fname.setText(message);
            fket.setText(mangga);
        }
        else if(message.equals("Lemon")){
            fname.setText(message);
            fket.setText(lemon);
        }
        else if(message.equals("Blueberry")){
            fname.setText(message);
            fket.setText(blueberry);
        }
    }

}

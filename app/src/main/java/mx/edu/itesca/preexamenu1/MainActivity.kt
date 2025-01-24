package mx.edu.itesca.preexamenu1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val t_c : EditText = findViewById(R.id.et_c)
        val t_f : EditText = findViewById(R.id.et_f)

        val to_c : Button = findViewById(R.id.btn_to_c)
        val to_f : Button = findViewById(R.id.btn_to_f)

        to_c.setOnClickListener {

            val f=t_f.text.toString().toIntOrNull()

            if(f!=null)
                t_c.setText(((f - 32)/1.8).toString())
            else
                t_c.setText("ERROR")
        }

        to_f.setOnClickListener {

            val c=t_c.text.toString().toIntOrNull()

            if(c!=null)
                t_f.setText((c*1.8+32).toString())
            else
                t_f.setText("ERROR")
        }

    }
}
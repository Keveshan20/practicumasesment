package vcmsa.keveshan.practicumasesment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code starts here
        val rap = findViewById<Button>(R.id.btnRap)
        rap.setOnClickListener {
            val intent = Intent(this, RapActivity::class.java)
            startActivity(intent)
        }
        val dance = findViewById<Button>(R.id.bntDance)
        dance.setOnClickListener {
            val intent = Intent(this, DanceActivity::class.java)
            startActivity(intent)
        }
        val love = findViewById<Button>(R.id.btnLoveSongs)
        love.setOnClickListener {
            val intent = Intent(this, LoveSongActivity::class.java)
            startActivity(intent)
        }
        val memories = findViewById<Button>(R.id.BtnMemories)
        memories.setOnClickListener {
            val intent = Intent(this, MemoriesActivity::class.java)
            startActivity(intent)
        }
        val back = findViewById<Button>(R.id.BtnReturn)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


    }
}
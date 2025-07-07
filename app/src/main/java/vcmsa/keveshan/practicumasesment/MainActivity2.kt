package vcmsa.keveshan.practicumasesment


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code starts here
        val playlist = findViewById<Button>(R.id.btnPlaylist)
        playlist.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            }
        val add = findViewById<Button>(R.id.btnAddToPlaylist)
        add.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)

        }
    }
}
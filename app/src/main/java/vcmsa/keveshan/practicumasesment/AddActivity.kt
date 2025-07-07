package vcmsa.keveshan.practicumasesment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.semantics.text
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddActivity : AppCompatActivity() {

    private lateinit var songTitleEditText: EditText
    private lateinit var artistNameEditText: EditText
    private lateinit var ratingEditText: EditText
    private lateinit var userCommentEditText: EditText
    private var currentCategory: String = "Unknown"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        currentCategory = intent.getStringExtra("SONG_CATEGORY") ?: "Unknown"

        songTitleEditText = findViewById(R.id.edtSongTitle)
        artistNameEditText = findViewById(R.id.edtArtistName)
        ratingEditText = findViewById(R.id.edtRating)
        userCommentEditText = findViewById(R.id.edtUsereComment) // Corrected typo: edtUserComment

        val addBtn = findViewById<Button>(R.id.btnAdd)
        addBtn.setOnClickListener {
            addSongToList()
        }

        val backBtn = findViewById<Button>(R.id.BtnReturn)
        backBtn.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun addSongToList() {
        val title = songTitleEditText.text.toString().trim()
        val artist = artistNameEditText.text.toString().trim()
        val ratingStr = ratingEditText.text.toString().trim()
        val comment = userCommentEditText.text.toString().trim()

        if (title.isEmpty() || artist.isEmpty() || ratingStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields (Title, Artist, Rating)", Toast.LENGTH_SHORT).show()
            return
        }

        val rating = ratingStr.toFloatOrNull()
        if (rating == null || rating < 0 || rating > 5) {
            Toast.makeText(this, "Please enter a valid rating (0-5)", Toast.LENGTH_SHORT).show()
            return
        }

        val newSong = Song(title, artist, rating, comment, currentCategory)
        DataRepository.addSong(currentCategory, newSong)

        Toast.makeText(this, "Song added to $currentCategory", Toast.LENGTH_SHORT).show()


        songTitleEditText.text.clear()
        artistNameEditText.text.clear()
        ratingEditText.text.clear()
        userCommentEditText.text.clear()




        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra("SHOW_CATEGORY", currentCategory)

        }
        startActivity(intent)


    }
}

class DataRepository {
    companion object {
        fun addSong(currentCategory: String, newSong: Song) {
            TODO("Not yet implemented")
        }
    }

}

class Song(title: String, artist: String, rating: Float, comment: String, currentCategory: String) {

}

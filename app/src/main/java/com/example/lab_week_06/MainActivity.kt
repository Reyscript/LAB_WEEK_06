package com.example.lab_week_06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object: CatViewHolder.OnClickListener {
            override fun onClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(createCatData())
    }

    private fun createCatData(): List<CatModel> {
        return listOf(
            CatModel(
                Gender.Male,
                CatBreed.BalineseJavanese,
                "Fred",
                "Silent and deadly hunter with amazing stealth abilities",
                "https://cdn2.thecatapi.com/images/7dj.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Wilma",
                "Cuddly assassin who loves naps and warm blankets",
                "https://cdn2.thecatapi.com/images/egv.jpg"
            ),
            CatModel(
                Gender.Unknown,
                CatBreed.AmericanCurl,
                "Curious George",
                "Award winning investigator of mysterious sounds",
                "https://cdn2.thecatapi.com/images/bar.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.BalineseJavanese,
                "Reyarune",
                "Mystical cat with ancient wisdom and magical powers",
                "https://cdn2.thecatapi.com/images/9u1.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.ExoticShorthair,
                "Devarune",
                "Divine feline blessed with celestial grace",
                "https://cdn2.thecatapi.com/images/bu1.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.AmericanCurl,
                "Furina",
                "Elegant dancer with water-like fluid movements",
                "https://cdn2.thecatapi.com/images/d5q.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.BalineseJavanese,
                "Castorice",
                "Noble knight protecting the household kingdom",
                "https://cdn2.thecatapi.com/images/6s6.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Evernight",
                "Midnight hunter with stars in her eyes",
                "https://cdn2.thecatapi.com/images/7r7.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.AmericanCurl,
                "Leo",
                "Adventurous explorer of cardboard boxes",
                "https://cdn2.thecatapi.com/images/8u8.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.BalineseJavanese,
                "Tiara",
                "Beautiful princess who demands royal treatment",
                "https://cdn2.thecatapi.com/images/9i9.jpg"
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected ${cat.name} - ${getBreedDisplayName(cat.breed)}")
            .setPositiveButton("OK") { _, _ -> }.show()
    }

    private fun getBreedDisplayName(breed: CatBreed): String {
        return when (breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
            else -> "Unknown"
        }
    }
}
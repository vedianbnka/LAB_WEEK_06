package com.vedianbunka.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vedianbunka.lab_week_06.model.CatBreed
import com.vedianbunka.lab_week_06.model.CatModel
import com.vedianbunka.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(
            layoutInflater,
            GlideImageLoader(this),
            object : CatAdapter.OnClickListener {
                override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //Instantiate ItemTouchHelper for the swipe to delete callback and
//attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Male, CatBreed.Siberian, "Leo", "King of the neighborhood", "https://cdn2.thecatapi.com/images/3bk.jpg"),
                CatModel(Gender.Female, CatBreed.Bengal, "Luna", "Elegant hunter with bright eyes", "https://cdn2.thecatapi.com/images/b1a.jpg"),
                CatModel(Gender.Male, CatBreed.MaineCoon, "Thor", "Big but gentle giant", "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
                CatModel(Gender.Female, CatBreed.Persian, "Cleo", "Loves naps and attention", "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg"),
                CatModel(Gender.Unknown, CatBreed.Sphynx, "Mystic", "Always curious, always exploring", "https://cdn2.thecatapi.com/images/134.jpg"),
                CatModel(Gender.Male, CatBreed.Savannah, "Shadow", "Fast and energetic adventurer", "https://cdn2.thecatapi.com/images/2ke.jpg"),
                CatModel(Gender.Female, CatBreed.Abyssinian, "Bella", "Graceful climber and explorer", "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg")            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}

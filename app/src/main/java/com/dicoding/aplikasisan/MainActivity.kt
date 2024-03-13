package com.dicoding.aplikasisan

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFood: RecyclerView
    private val list = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvFood = findViewById(R.id.rv_food)
        rvFood.setHasFixedSize(true)
        list.addAll(getlistFood())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvFood.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvFood.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_about_me -> {
                // Tambahkan kode untuk menampilkan "About Me" di sini
                val intent = Intent(this, AboutMeActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedFood(food: Food) {
        Toast.makeText(this, "Kamu memilih " + food.name, Toast.LENGTH_SHORT).show()
    }

    private fun getlistFood(): ArrayList<Food> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFood = ArrayList<Food>()
        for (i in dataName.indices) {
            val food = Food(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listFood.add(food)
        }
        return listFood
    }

    private fun showRecyclerList() {
        rvFood.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvFood.adapter = listFoodAdapter

        listFoodAdapter.setOnItemClickCallback(object : ListFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Food) {
                showSelectedFood(data)
            }
        })
    }


}

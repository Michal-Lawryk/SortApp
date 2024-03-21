package com.example.sortapp

import com.example.sortapp.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun sort(view: View) {
        val values = binding.editText.text.split(" ", ",", ", ", " ,")
        val unsorted: ArrayList<Int> = ArrayList()
        values.forEach {
            unsorted.add(it.toInt())
        }
        if (binding.rbBubbleSort.isChecked){
            val result = bubbleSort(unsorted)
            binding.resultView.text = result.toString().replace("[", "").replace("]", ""). replace(",", "")
        }
        else if (binding.rbInsterSort.isChecked){
            val result = insertSort(unsorted)
            binding.resultView.text = result.toString().replace("[", "").replace("]", ""). replace(",", "")
        }
    }

    private fun bubbleSort(array: ArrayList<Int>): ArrayList<Int> {
        val n = array.size
        var swapped: Boolean
        do {
            swapped = false
            for (i in 1 until n) {
                if (array[i - 1] > array[i]) {
                    val temp = array[i]
                    array[i] = array[i - 1]
                    array[i - 1] = temp
                    swapped = true
                }
            }
        } while (swapped)
        return array
    }

    private fun insertSort(array: ArrayList<Int>): ArrayList<Int> {
        val n = array.size
        for (i in 1 until n) {
            val key = array[i]
            var j = i - 1

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]
                j--
            }
            array[j + 1] = key
        }
        return array
    }

    fun showContent(view: View){
        if (binding.rbBubbleSort.isChecked){
            binding.textView3.text = getString(R.string.bubble_sort_description)
        }
        else if (binding.rbInsterSort.isChecked) {
            binding.textView3.text = getString(R.string.inster_sort_description)
        }
    }
}
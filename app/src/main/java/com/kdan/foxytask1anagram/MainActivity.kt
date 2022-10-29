package com.kdan.foxytask1anagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.kdan.foxytask1anagram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textField.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                binding.anagram.text = Anagram.convert(
                    binding.textField.text.toString(),
                    binding.filterField.text.toString())
            }
        })
        binding.filterField.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                binding.anagram.text = Anagram.convert(
                    binding.textField.text.toString(),
                    binding.filterField.text.toString())            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString(TEXT_FIELD, binding.textField.text.toString())
            putString(FILTER_FIELD, binding.filterField.text.toString() )
        }
        super.onSaveInstanceState(outState)
    }

    companion object {
        const val TEXT_FIELD = "currentTextField"
        const val FILTER_FIELD = "currentFilterField"
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedTextField = savedInstanceState.getString(TEXT_FIELD).toString()
        val savedFilterField = savedInstanceState.getString(FILTER_FIELD).toString()

        binding.textField.text.replace(0, savedTextField.length, savedTextField)
        binding.filterField.text.replace(0, savedFilterField.length, savedFilterField)
    }

}

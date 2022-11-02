package com.kdan.foxytask1anagram

import android.content.ClipData
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.kdan.foxytask1anagram.databinding.ActivityMainBinding
import android.content.ClipboardManager as ClipboardManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textField.doAfterTextChanged {
            binding.anagram.text = Anagram.convert(
                binding.textField.text.toString(),
                binding.filterField.text.toString()
            )
        }

        binding.filterField.doAfterTextChanged {
            binding.anagram.text = Anagram.convert(
                binding.textField.text.toString(),
                binding.filterField.text.toString()
            )
        }

        binding.anagram.setOnClickListener { copyTextToClipboard() }

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

    private fun copyTextToClipboard() {
        val textToCopy = binding.anagram.text
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", textToCopy)
        clipboardManager.setPrimaryClip(clipData)
        Toast.makeText(this, "Copied:\n$textToCopy", Toast.LENGTH_LONG).show()
    }

}

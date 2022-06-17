package com.xizz.filesave

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xizz.filesave.ui.theme.FileSaveTheme
import java.io.File
import java.util.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FileSaveTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    FilePathDisplay(
                        listOfNotNull(
                            dataDir,
                            filesDir,
                            cacheDir,
                            getExternalFilesDir(null),
                            externalCacheDir
                        )
                    ) { path ->
                        try {
                            val file = File.createTempFile(UUID.randomUUID().toString(), ".txt", path)
                            Log.e("xizz", file.path)
                            Log.e("xizz", file.absolutePath)
                            Log.e("xizz", "${file.exists()}")
                        } catch (e: Exception) {
                            Log.e("xizz", e.toString())
                            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FilePathDisplay(paths: List<File>, createBitmap: (File) -> Unit = {}) {

    Column {
        paths.forEach {
            Text(it.absolutePath)
            OutlinedButton(
                onClick = { createBitmap(it) }
            ) {
                Text("Create a File Here")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FileSaveTheme {
        FilePathDisplay(listOf(File("path/file")))
    }
}
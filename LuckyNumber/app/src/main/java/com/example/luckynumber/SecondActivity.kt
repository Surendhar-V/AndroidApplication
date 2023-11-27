package com.example.luckynumber

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.OutputStream
import kotlin.random.Random


class SecondActivity : AppCompatActivity() {

    val required_permissions = arrayOf<String>(
        android.Manifest.permission.READ_MEDIA_IMAGES
    )

    var is_storage_image_permitted:Boolean = false

    lateinit var tv_msg : TextView
    lateinit var tv_luckyNumber : TextView
    lateinit var btn_share1 : Button
    lateinit var btn_share2 : Button
    lateinit var container : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tv_msg = findViewById(R.id.tv_msg2)
        tv_luckyNumber = findViewById(R.id.tv_lucky_number)
        btn_share1 = findViewById(R.id.btn_share1)
        btn_share2 = findViewById(R.id.btn_share2)
        container = findViewById(R.id.Container)

        // == for study permission related to android 13
        if(!is_storage_image_permitted){
            requestPermissionStorageImages()
        }


        val intent  = intent
        val userName = intent.getStringExtra("name")


        val randomNumber = generateRandomNumber()
        tv_luckyNumber.setText("$randomNumber")

        btn_share1.setOnClickListener { shareBtn1(userName.toString(), randomNumber) }
        btn_share2.setOnClickListener {
            onClick()
        }

    }

    private fun onClick(){
        val screenshot: Bitmap = captureScreenShot(container)
        storeImageAsJPEGAndShare(screenshot)
    }

    private fun captureScreenShot(view : View): Bitmap {

        val returnBitmap :Bitmap = Bitmap.createBitmap(view.width , view.height, Bitmap.Config.ARGB_8888)
        val canvas : Canvas = Canvas(returnBitmap);
        val bgdrawable = view.background
        if(bgdrawable!=null){
            bgdrawable.draw(canvas)
        }else{
            canvas.drawColor(Color.WHITE)
        }

        view.draw(canvas)
        return returnBitmap

    }

    private fun storeImageAsJPEGAndShare(bitmap: Bitmap) {


        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val contentResolver: ContentResolver = contentResolver
                val contentValues: ContentValues = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, "Image_.jpg")
                    put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
                    put(
                        MediaStore.MediaColumns.RELATIVE_PATH,
                        "${Environment.DIRECTORY_PICTURES}${File.separator}Lucky Number"
                    )
                }
                val imageUri: Uri? =
                    contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

                if (imageUri != null) {
                    val outst: OutputStream? = contentResolver.openOutputStream(imageUri)
                    outst?.let {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
                        it.close()

                        Toast.makeText(this, "Image is saved", Toast.LENGTH_SHORT).show()

                        val share = Intent(Intent.ACTION_SEND)
                        share.type = "image/jpeg"
                        share.putExtra(Intent.EXTRA_STREAM, imageUri)
                        startActivity(Intent.createChooser(share, "Share Image"))
                    } ?: run {
                        // Handling null output stream
                        Toast.makeText(this, "Failed to get output stream", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Handling null imageUri - Denial of permission
                    Toast.makeText(this, "Permission denied to access images and videos", Toast.LENGTH_SHORT).show()
                }
            }
        }
        catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }



    private fun shareBtn1(userName : String , randomNum : Int){

            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_SUBJECT , "$userName got lucky number Today")
            intent.putExtra(Intent.EXTRA_TEXT , "Hey there! My lucky number is $randomNum")

            startActivity(Intent.createChooser(intent , "Choose a Plateform"))

    }

    private fun generateRandomNumber() : Int{

        val randomNumber = Random.nextInt(0 , 1000)
        return randomNumber

    }

    private fun requestPermissionStorageImages(){

        if(ContextCompat.checkSelfPermission(this , required_permissions[0]) == PackageManager.PERMISSION_GRANTED){
            Log.d("SecondActivity" , "${required_permissions[0]} Grandted")
            is_storage_image_permitted = true
        }else{
            //new android 13 code after onActivityResult is deprecated , now ActivityResultLauncher..
            required_permission_launcher_storage_images.launch(required_permissions[0]);

        }



    }
    private val required_permission_launcher_storage_images: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Log.d("Second Activity", "${required_permissions[0]} Granted")
                is_storage_image_permitted = true
            } else {
                Log.d("Second Activity", "${required_permissions[0]} Not Granted")
                is_storage_image_permitted = false
            }
        }


}
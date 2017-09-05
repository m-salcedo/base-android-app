package io.nucleos.baseapp.common

import android.app.Activity
import android.content.ClipData
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import com.soundcloud.android.crop.Crop
import io.nucleos.baseapp.utils.Constant
import io.reactivex.Maybe
import io.reactivex.subjects.PublishSubject
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class ImageCropper(val activity: RxActivity) {

    private val  TAG = "TAG_${ImageCropper::class.java.simpleName}"
    private val REQUEST_IMAGE_CAPTURE = 1001

    private val imageUri = Uri.fromFile(File(activity.cacheDir, Constant.Key.CROPPED))
    private var subject: PublishSubject<Uri>? = null
    private lateinit var outputCameraUri: Uri

    init {
        activity.onActivityResultObservable.subscribe { handleActivityResult(it) }
    }

    fun cropFromCamera(): Maybe<Uri> {
        val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        outputCameraUri = getImageUri()

        takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputCameraUri)
        takePhotoIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
        takePhotoIntent.clipData = ClipData.newRawUri(null, outputCameraUri)

        if (takePhotoIntent.resolveActivity(activity.packageManager) != null) {
            activity.startActivityForResult(takePhotoIntent, REQUEST_IMAGE_CAPTURE)
        }
        subject = PublishSubject.create<Uri>()
        return subject!!.firstElement()
    }

    fun cropFromGallery(): Maybe<Uri> {
        Crop.pickImage(activity)
        subject = PublishSubject.create<Uri>()
        return subject!!.firstElement()
    }

    /**
     *
     */
    private fun handleActivityResult(result: RxActivity.Result) {
        val (requestCode, resultCode, data) = result
        if (resultCode ==  Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_IMAGE_CAPTURE -> beginCrop(outputCameraUri)
                Crop.REQUEST_PICK -> beginCrop(data?.data!!)
                Crop.REQUEST_CROP -> { subject?.onNext(imageUri) }
                else -> subject?.onComplete()
            }
        } else {
            subject?.onComplete()
        }
    }

    /**
     *
     */
    private fun beginCrop(src: Uri): Unit = Crop.of(src, imageUri).start(activity)

    /**
     *
     */
    private  fun getImageUri(): Uri {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageName = "IMAGE_$timeStamp"
        val storageDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val file = File.createTempFile(imageName, ".jpg", storageDir)
        return FileProvider.getUriForFile(activity, "${activity.packageName}.fileprovider", file)
    }
}

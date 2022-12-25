package ir.cactus.app.cactusipdetector.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.ShowToast(message:String,duration:Int= Toast.LENGTH_LONG){
    Toast.makeText(this,message,duration).show();
}
fun Context.ShowSnack(view:View,message:String,duaration:Int=Snackbar.LENGTH_LONG){
    Snackbar.make(view,message,duaration).show();
}
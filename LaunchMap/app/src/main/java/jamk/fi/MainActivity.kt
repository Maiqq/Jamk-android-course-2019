package jamk.fi

import android.content.Intent
import android.content.pm.ResolveInfo
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    fun showMap(view:View){

        // get latitude and longitude values
        val lat = latitudeEditText.text.toString().toDouble()
        val lng = longitudeEditText.text.toString().toDouble()

        // Build the intent
        val geoUriString:String = "geo:"+lat+","+lng+"?q="+lat+","+lng
        val location = Uri.parse(geoUriString)
        val mapIntent = Intent(Intent.ACTION_VIEW, location)

        // Verify it resolves
        val activities: List<ResolveInfo> = packageManager.queryIntentActivities(mapIntent, 0)
        val isIntentSafe: Boolean = activities.isNotEmpty()

        // Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(mapIntent)
        } else {
            Toast.makeText(this, "There is no activity to handle map intent!", Toast.LENGTH_LONG).show();
        }
    }


}

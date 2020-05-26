package app.itakura.reirei.mogudoco

import android.content.Context
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 場所名から緯度・経度を取得する。
         * @param context
         * @param 場所名
         * @return 緯度・経度の配列、または、null
         */
        public static double[] getLocationFromPlaceName (Context context, String name) {
            Geocoder geocoder = new Geocoder(context, Locale.getDefault());
            try {
                List&lt;Address&gt; location = geocoder.getFromLocationName(name, 1);
                if (location == null || location.size() &lt; 1) {
                    return null;
                }

                Address address = location . get (0);
                double[] latlng = { address.getLatitude(), address.getLongitude() };
                return latlng;
            } catch (IOException e) {
                // 例外処理
                return null;
            }
        }
    }
}
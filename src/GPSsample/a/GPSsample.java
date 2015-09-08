package GPSsample.a;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

// Import android location library
import android.location.*;

public class GPSsample extends Activity {
    /** Called when the activity is first created. */
	// Init the GPS module
	private LocationManager localManager;
    private LocationListener locationListener;
    
    // Init the Textfield
    private EditText lngText;
    private EditText latText;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Init the GPS service
		localManager = (LocationManager) getSystemService(GPSsample.this.LOCATION_SERVICE);

		// Init the location listener
		locationListener = new MyLocationListener();

		// Update the location
		localManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				locationListener);  
        
        // Init the text
        final TextView lngView = (TextView) findViewById(R.id.lngTextView);
        final TextView latView = (TextView) findViewById(R.id.latTextView);
        
        lngView.setText("¸g«×¡G");
        latView.setText("½n«×¡G");
        
        // Init the text box
        lngText = (EditText) findViewById(R.id.lngEditText);
        latText = (EditText) findViewById(R.id.latEditText);
        lngText.setText("118.32198666666666");
        latText.setText("24.449396666666669");
    }
    
    private class MyLocationListener implements LocationListener 
    {
    	// Update the GPS event
        public void onLocationChanged(Location loc) {
            if (loc != null){
        		lngText.setText(Double.toString(loc.getLongitude()));
        		latText.setText(Double.toString(loc.getLatitude()));
            }
        }

        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }

        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }

        public void onStatusChanged(String provider, int status, 
            Bundle extras) {
            // TODO Auto-generated method stub
        }
    }
}


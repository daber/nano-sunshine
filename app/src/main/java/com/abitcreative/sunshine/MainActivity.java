package com.abitcreative.sunshine;

import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        if (id == R.id.action_showLocation) {
            String location = PreferenceManager.getDefaultSharedPreferences(this).getString(getString(R.string.key_location), getString(R.string.location_default_value));
            Uri uri = Uri.parse("geo:0,0").buildUpon().appendQueryParameter("q", location).build();
            Intent i = new Intent(Intent.ACTION_VIEW, uri);

            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

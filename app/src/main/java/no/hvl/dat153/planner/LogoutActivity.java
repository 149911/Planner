package no.hvl.dat153.planner;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.prefs.Preferences;

public class LogoutActivity extends AppCompatActivity {

    TextView helloUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggedin);

        helloUser = findViewById(R.id.helloUser);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sharedPreferences.getString("username", "");

        helloUser.setText(username);


    }


    public void logOut(View v) {
        Intent launchActivity = new Intent(LogoutActivity.this, MainActivity.class);
        startActivity(launchActivity);
    }

}

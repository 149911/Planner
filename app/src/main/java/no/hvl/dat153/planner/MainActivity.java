package no.hvl.dat153.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database d1;
    EditText editUsername;
    EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        d1 = new Database(new ArrayList<User>());
        for (int i = 0; i < 5; i++) {
            User u = new User("Simen" + i, "Pass" + i);
            d1.leggTilBruker(u);
        }
    }

    public void onClick(View view) {

        editUsername = findViewById(R.id.editTextUsername);
        editPassword = findViewById(R.id.editTextPassword);

        //Toast.makeText(this, editUsername.getText().toString(), Toast.LENGTH_SHORT).show();

        if(d1.userExist(editUsername.getText().toString(), editPassword.getText().toString())) {
            Toast.makeText(this, "Fant bruker", Toast.LENGTH_SHORT).show();
            Intent launchActivity = new Intent(MainActivity.this, LogoutActivity.class);
            startActivity(launchActivity);
        } else {
            Toast.makeText(this, "Fant ikke bruker", Toast.LENGTH_SHORT).show();
        }

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", editUsername.getText().toString());
        editor.apply();

    }

}
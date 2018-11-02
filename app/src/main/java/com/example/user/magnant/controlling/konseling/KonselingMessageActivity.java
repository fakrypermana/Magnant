package com.example.user.magnant.controlling.konseling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.user.magnant.MainActivity;
import com.example.user.magnant.R;
import com.example.user.magnant.controlling.ControlFragment;

public class KonselingMessageActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konseling_message);

//        if (savedInstanceState == null){
//            getSupportFragmentManager().beginTransaction()
//                    .add(android.R.id.content, new ControlFragment()).commit();}

        //setupview
        toolbar = findViewById(R.id.toolbar_message_konseling);
        setSupportActionBar(toolbar);
        setTitle("Konseling");

        //setuplayout



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar_message_konseling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_call:
                Toast.makeText(KonselingMessageActivity.this, "Anda bisa menelepon dokter", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_video:
                Toast.makeText(KonselingMessageActivity.this, "Anda bisa video call dengan dokter", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_end:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.user.magnant.controlling.konseling.messaging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.magnant.MainActivity;
import com.example.user.magnant.R;
import com.example.user.magnant.controlling.konseling.model.Message;

import java.util.ArrayList;
import java.util.List;

public class KonselingMessageActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView mMessageRecycler;
    private MessageListAdapter mMessageAdapter;
    private List<Message> messageList = new ArrayList<>();
    private EditText edt_chatbox;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konseling_message);

//        if (savedInstanceState == null){
//            getSupportFragmentManager().beginTransaction()
//                    .add(android.R.id.content, new ControlFragment()).commit();}

        //setupview
        toolbar = findViewById(R.id.toolbar_message_konseling);
        mMessageRecycler = findViewById(R.id.reyclerview_message_list);
        edt_chatbox = findViewById(R.id.edittext_chatbox);
        btn_send = findViewById(R.id.button_chatbox_send);

        String message = edt_chatbox.getText().toString().trim();
        setSupportActionBar(toolbar);
        setTitle("Konseling");
        messageList.add(new Message(message,"Dr. Sinta Wijayanti","11:40"));

        //setuplayout
        mMessageAdapter = new MessageListAdapter(this, messageList);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMessageRecycler.setAdapter(mMessageAdapter);


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

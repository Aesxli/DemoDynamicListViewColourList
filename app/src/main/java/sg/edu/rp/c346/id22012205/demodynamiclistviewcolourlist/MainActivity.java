package sg.edu.rp.c346.id22012205.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText etElement;
Button btnAdd;
ListView lvColour;
EditText etPosition;
Button btnRemove;
Button btnUpdate;
    ArrayList<String> alColours;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etElement=findViewById(R.id.editTextColour);
        btnAdd=findViewById(R.id.buttonAddItem);
        lvColour=findViewById(R.id.listViewColour);
        etPosition=findViewById(R.id.editTextPosition);
        btnRemove=findViewById(R.id.buttonRemoveItem);
        btnUpdate=findViewById(R.id.buttonUpdateItem);
        alColours=new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");
        ArrayAdapter aaColour=new ArrayAdapter(this, android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(aaColour);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String Colouradd=etElement.getText().toString();
                int Position=Integer.parseInt(String.valueOf(etPosition.getText().toString()));
                alColours.add((Position),Colouradd);
                aaColour.notifyDataSetChanged();

            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=Integer.parseInt(String.valueOf(etPosition.getText().toString()));
                alColours.remove(position);
                aaColour.notifyDataSetChanged();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colourupdate=etElement.getText().toString();
                int position=Integer.parseInt(String.valueOf(etPosition.getText().toString()));
                alColours.set(position,colourupdate);
                aaColour.notifyDataSetChanged();
            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view , int Position, long id) {
                String colour = alColours.get(Position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
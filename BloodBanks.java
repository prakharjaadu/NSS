package lpunss.bloodbanks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class BloodBanks extends AppCompatActivity {

    String[] items;
    ArrayList<String> listitems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_banks);
        listView= (ListView)findViewById(R.id.listview);
        editText=(EditText) findViewById(R.id.txtsearch);
        initlist();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    //reset listview
                    initlist();
                }
                else {
                    // perform search
                    searchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void searchItem(String textToSearch){
        for(String item:items){
            if(!item.contains(textToSearch)) {
                listitems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void initlist()
    {
        items=new String[]{"Ohri Hospital's Blood Bank ","jalandhar blood council","bbc heart care pruthi hospital"};
        listitems=new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,R.layout.names,R.id.txtitem,listitems);
        listView.setAdapter(adapter);
    }
}

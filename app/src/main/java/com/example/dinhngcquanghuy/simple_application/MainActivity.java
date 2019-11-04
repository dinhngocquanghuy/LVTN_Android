package com.example.dinhngcquanghuy.simple_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        final ListView listView = findViewById(R.id.listView);
        // array of selected item listview
        final ArrayList<String> selected_item = new ArrayList<>();

        // make textview scrollable
        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        // Add item for spinner
        final Spinner spinner = findViewById(R.id.spinner);
        ArrayList<String> spinner_array = new ArrayList<>();
        spinner_array.add("123");
        spinner_array.add("456");
        spinner_array.add("789");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, spinner_array);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int index, long l) {
                TextView textView = (TextView) findViewById(R.id.textView);
                Object clickItemObj = spinner.getSelectedItem();
                textView.setText("");
                textView.append("Compobox:");
                textView.append("\n");
                textView.append(clickItemObj.toString());
            }

            public void onNothingSelected(AdapterView<?> parent)
            {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("");
            }
        });

        // Add item for listview
        ArrayList<String> listview_array = new ArrayList<>();
        listview_array.add("123");
        listview_array.add("456");
        listview_array.add("789");
        ArrayAdapter<String> array_Adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice, listview_array);
        listView.setAdapter(array_Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                TextView textView = (TextView) findViewById(R.id.textView);
                Object clickItemObj = adapterView.getAdapter().getItem(index);
                textView.setText("");
                if(!listView.isItemChecked(index)) {
                    selected_item.remove(clickItemObj.toString());
                    textView.append("ListView:");
                    for(int i=0;i<selected_item.size();i++) {
                        textView.append("\n");
                        textView.append(selected_item.get(i));
                    }
                } else {
                    selected_item.add(clickItemObj.toString());
                    textView.append("ListView:");
                    for(int i=0;i<selected_item.size();i++) {
                        textView.append("\n");
                        textView.append(selected_item.get(i));
                    }
                }
            }
        });

        // Radio button onclick event
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selected_radio_button_id = radioGroup.getCheckedRadioButtonId();
                RadioButton selected_radio_button = (RadioButton)findViewById(selected_radio_button_id);
                String selected_radio_button_value = selected_radio_button.getText().toString();
                textView.setText("");
                textView.append("RadioGroup:");
                textView.append("\n");
                textView.append(selected_radio_button_value);
            }
        });

        // Checkbox onclick event
        // array save selected item
        final ArrayList<String> checkbox_selected_item = new ArrayList<String>();
        final CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkBox2);
        final CheckBox checkBox2 = (CheckBox)findViewById(R.id.checkBox3);
        final CheckBox checkBox3 = (CheckBox)findViewById(R.id.checkBox4);
        final CheckBox checkBox4 = (CheckBox)findViewById(R.id.checkBox);
        //////////////////////////////////////////////////////////////////////////////////////
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                helperCheckbox(isChecked,checkBox1,checkbox_selected_item);
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                helperCheckbox(isChecked,checkBox2,checkbox_selected_item);
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                helperCheckbox(isChecked,checkBox3,checkbox_selected_item);
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                helperCheckbox(isChecked,checkBox4,checkbox_selected_item);
            }
        });
    }

    @Override
    public void onClick(View view) {
        final EditText editText = (EditText) findViewById(R.id.editText);
        final TextView textView = (TextView) findViewById(R.id.textView);
        String content  = editText.getText().toString();
        textView.setText("");
        textView.append("Input:");
        textView.append("\n");
        textView.append(content);
    }

    private void helperCheckbox(boolean isChecked, CheckBox checkBox, ArrayList<String> checkboxSelectedArray) {
        if(!isChecked) {
            String value = checkBox.getText().toString();
            checkboxSelectedArray.remove(value);
            final TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("");
            textView.append("Checkbox:");
            for(int i=0; i<checkboxSelectedArray.size(); i++) {
                textView.append("\n");
                textView.append(checkboxSelectedArray.get(i));
            }
        } else {
            String value = checkBox.getText().toString();
            checkboxSelectedArray.add(value);
            final TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("");
            textView.append("Checkbox:");
            for(int i=0; i<checkboxSelectedArray.size(); i++) {
                textView.append("\n");
                textView.append(checkboxSelectedArray.get(i));
            }
        }
    }
}

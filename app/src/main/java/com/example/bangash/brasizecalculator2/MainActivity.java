package com.example.bangash.brasizecalculator2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bangash.brasizecalculator2.R;

public class MainActivity extends AppCompatActivity {
    Spinner spStandard;
    EditText etBust, etBand;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //widgets initialization
        spStandard = (Spinner) findViewById(R.id.spStandard);
        etBust = (EditText) findViewById(R.id.etBust);
        etBand = (EditText) findViewById(R.id.etBand);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        tvResult = (TextView) findViewById(R.id.tvResult);

        //static data for spinner
        String[] standards = {"EUROPE", "UK", "USA", "ASIA"};
        ArrayAdapter spArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, standards);
        spStandard.setAdapter(spArrayAdapter);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingStandards();

            }
        });

        //placing cursor in next edit text after typing two numbers
        etBust.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etBust.getText().toString().length() >= 2) {
                    etBand.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    ////////////////////////////////////////// setting data//////////////////////////////////////////////////////////////////
    private void settingStandards() {

        if (etBust.getText().toString().equals("") || etBand.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Enter some value !", Toast.LENGTH_SHORT).show();
        } else {
            String bustValue = etBust.getText().toString();
            int convertedBustValue = Integer.parseInt(bustValue);

            String bandValue = etBand.getText().toString();
            int convertedBandValue = Integer.parseInt(bandValue);

            if (convertedBustValue < 28 || convertedBustValue > 44) {
                Toast.makeText(MainActivity.this, "Range Should Be B/W 28 and 44", Toast.LENGTH_SHORT).show();
            } else if (convertedBandValue < 28 || convertedBandValue > 44) {
                Toast.makeText(MainActivity.this, "Range Should Be B/W 28 and 44", Toast.LENGTH_SHORT).show();
            } else if (convertedBandValue > convertedBustValue) {
                Toast.makeText(MainActivity.this, "Bust Value Should Be Greater Than Band Vale ", Toast.LENGTH_LONG).show();

            } else {

                if (spStandard.getSelectedItem() == "EUROPE") {

                    String equalToZero = "A";
                    String equalToOne = "B";
                    String equalToTwo = "C";
                    String equalToThree = "D";
                    String equalToFour = "E";
                    String equalToFive = "F";
                    String equalToSix = "G";
                    String equalToSeven = "H";
                    String equalToEight = "I";

                    int Result = convertedBustValue - convertedBandValue;

                    if (Result == 0) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToZero);

                    } else if (Result == 1) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToOne);

                    } else if (Result == 2) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToTwo);

                    } else if (Result == 3) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToThree);

                    } else if (Result == 4) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToFour);

                    } else if (Result == 5) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToFive);

                    } else if (Result == 6) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToSix);

                    } else if (Result == 7) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToSeven);

                    } else if (Result == 8) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToEight);

                    } else {
                        tvResult.setText("Sorry See Another Resource For Your Size, Click Here");
                        tvResult.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.calculator.net/bra-size-calculator.html"));
                                startActivity(browserIntent);

                            }
                        });
                    }

                } else if (spStandard.getSelectedItem() == "UK") {
                    String equalToZero = "A";
                    String equalToOne = "B";
                    String equalToTwo = "C";
                    String equalToThree = "D";
                    String equalToFour = "DD";
                    String equalToFive = "E";
                    String equalToSix = "F";
                    String equalToSeven = "G";
                    String equalToEight = "H";

                    int Result = convertedBustValue - convertedBandValue;

                    if (Result == 0) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToZero);

                    } else if (Result == 1) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToOne);

                    } else if (Result == 2) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToTwo);

                    } else if (Result == 3) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToThree);

                    } else if (Result == 4) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToFour);

                    } else if (Result == 5) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToFive);

                    } else if (Result == 6) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToSix);

                    } else if (Result == 7) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToSeven);

                    } else if (Result == 8) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToEight);

                    } else {
                        tvResult.setText("Sorry See Another Resource For Your Size,  Click Here");
                        tvResult.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.calculator.net/bra-size-calculator.html"));
                                startActivity(browserIntent);

                            }
                        });
                    }

                } else if (spStandard.getSelectedItem() == "USA") {
                    String equalToZero = "AA";
                    String equalToOne = "A";
                    String equalToTwo = "B";
                    String equalToThree = "C";
                    String equalToFour = "D";
                    String equalToFive = "DD";
                    String equalToSix = "DDD,E";
                    String equalToSeven = "F";
                    String equalToEight = "G";

                    int Result = convertedBustValue - convertedBandValue;

                    if (Result == 0) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToZero);

                    } else if (Result == 1) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToOne);

                    } else if (Result == 2) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToTwo);

                    } else if (Result == 3) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToThree);

                    } else if (Result == 4) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToFour);

                    } else if (Result == 5) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToFive);

                    } else if (Result == 6) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToSix);

                    } else if (Result == 7) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToSeven);

                    } else if (Result == 8) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToEight);

                    } else {
                        tvResult.setText("Sorry See Another Resource For Your Size, Click Here");
                        tvResult.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.calculator.net/bra-size-calculator.html"));
                                startActivity(browserIntent);

                            }
                        });
                    }

                } else if (spStandard.getSelectedItem() == "ASIA") {
                    String equalToZero = "AA";
                    String equalToOne = "A";
                    String equalToTwo = "B";
                    String equalToThree = "C";
                    String equalToFour = "D";
                    String equalToFive = "DD";
                    String equalToSix = "E";
                    String equalToSeven = "F";
                    String equalToEight = "G";

                    int Result = convertedBustValue - convertedBandValue;

                    if (Result == 0) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToZero);

                    } else if (Result == 1) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToOne);

                    } else if (Result == 2) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToTwo);

                    } else if (Result == 3) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToThree);

                    } else if (Result == 4) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToFour);

                    } else if (Result == 5) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToFive);

                    } else if (Result == 6) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToSix);

                    } else if (Result == 7) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToSeven);

                    } else if (Result == 8) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToEight);

                    } else {
                        tvResult.setText("Sorry See Another Resource For Your Size, Click Here");
                        tvResult.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.calculator.net/bra-size-calculator.html"));
                                startActivity(browserIntent);

                            }
                        });
                    }

                }
            }


        }
    }

    ////////////////////////////////////////////showing dialog on back key press/////////////////////////////////////////
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do You Want To Exit");
            builder.setTitle("Attention !");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.create();
            builder.show();
            return true;
        }

        return super.onKeyDown(keyCode, event); //handles other keys
    }


//////////////////////////////////////////////menu for help////////////////////////////////////////////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_app_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.help) {
            Intent helpIntent = new Intent(this, HelpActivity.class);
            startActivity(helpIntent);
        } else if (id == R.id.our_apps) {

        } else if (id == R.id.about_us) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.custom_dialog, null);
            final AlertDialog customDialog = new AlertDialog.Builder(this).create();
            customDialog.setView(view);
            customDialog.setTitle("About Us");
            ImageView ivImage = (ImageView) view.findViewById(R.id.ivImage);
            ivImage.setImageResource(R.drawable.logo);
            TextView tvMsg = (TextView)view.findViewById(R.id.tvMsg);
            tvMsg.setText("We Are Digital Applications");
            customDialog.show();
            customDialog.setCanceledOnTouchOutside(true);
        }
        return super.onOptionsItemSelected(item);
    }
}
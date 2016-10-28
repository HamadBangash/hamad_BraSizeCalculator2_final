package com.dgaps.android.brasizecalculator2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {
    Spinner spStandard;
    EditText etBust, etBand;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        //widgets initialization
        spStandard = (Spinner) findViewById(R.id.spStandard);
        etBust = (EditText) findViewById(R.id.etBust);
        etBand = (EditText) findViewById(R.id.etBand);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        tvResult = (TextView) findViewById(R.id.tvResult);

        //setting images in edit text

        //static data for spinner
        String[] standards = {"EUROPE", "UK", "USA", "ASIA"};
        ArrayAdapter<String> spArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, standards);
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

        etBand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (etBand.getText().toString().length() == 1) {
                    InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    manager.hideSoftInputFromWindow(etBand.getWindowToken(), 0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etBand.getText().toString().length() == 1) {
                    btnCalculate.setFocusable(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    ////////////////////////////////////////// setting data//////////////////////////////////////////////////////////////////
    private void settingStandards() {

        if (etBust.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Enter bust value !", Toast.LENGTH_SHORT).show();
        } else if (etBand.getText().toString().equals("")) {
            Toast.makeText(this, "Enter band value !", Toast.LENGTH_SHORT).show();

        } else {
            String bustValue = etBust.getText().toString();
            int convertedBustValue = Integer.parseInt(bustValue);

            String bandValue = etBand.getText().toString();
            int convertedBandValue = Integer.parseInt(bandValue);

            if (convertedBustValue < 28 || convertedBustValue > 48) {
                tvResult.setText("Bust value should be B/W 28 and 48");
                return;
            } else if (convertedBandValue < 28 || convertedBandValue > 48) {
                tvResult.setText("Band value should be B/W 28 and 48 and Less than bust value");
                return;
            } else if (convertedBandValue > convertedBustValue) {
                tvResult.setText("Bust " + "(" + convertedBustValue + ")" + " value should be greater than band value");

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
                    String equalToNine = "J";
                    String equalToTen = "K";

                    int Result = 0;
                    if (convertedBandValue % 2 == 1) {
                        convertedBandValue = convertedBandValue + 1;
                        if (convertedBustValue < convertedBandValue) {
                            Result = 0;
                        } else {
                            Result = convertedBustValue - convertedBandValue;
                        }
                    } else {
                        Result = convertedBustValue - convertedBandValue;
                    }

                    if (Result == 0) {
                        if (convertedBandValue == 28) {
                            tvResult.setText("Bra Size : " + 60 + equalToZero);
                        } else if (convertedBandValue == 30) {
                            tvResult.setText("Bra Size : " + 65 + equalToZero);
                        } else if (convertedBandValue == 32) {
                            tvResult.setText("Bra Size : " + 70 + equalToZero);
                        } else if (convertedBandValue == 34) {
                            tvResult.setText("Bra Size : " + 75 + equalToZero);
                        } else if (convertedBandValue == 36) {
                            tvResult.setText("Bra Size : " + 80 + equalToZero);
                        } else if (convertedBandValue == 38) {
                            tvResult.setText("Bra Size : " + 85 + equalToZero);
                        } else if (convertedBandValue == 40) {
                            tvResult.setText("Bra Size : " + 90 + equalToZero);
                        } else if (convertedBandValue == 42) {
                            tvResult.setText("Bra Size : " + 95 + equalToZero);
                        } else if (convertedBandValue == 44) {
                            tvResult.setText("Bra Size : " + 100 + equalToZero);
                        } else if (convertedBandValue == 46) {
                            tvResult.setText("Bra Size : " + 105 + equalToZero);
                        } else if (convertedBandValue == 48) {
                            tvResult.setText("Bra Size : " + 110 + equalToZero);
                        }

                    } else if (Result == 1) {
                        if (convertedBandValue == 28) {
                            tvResult.setText("Bra Size : " + 60 + equalToOne);
                        } else if (convertedBandValue == 30) {
                            tvResult.setText("Bra Size : " + 65 + equalToOne);
                        } else if (convertedBandValue == 32) {
                            tvResult.setText("Bra Size : " + 70 + equalToOne);
                        } else if (convertedBandValue == 34) {
                            tvResult.setText("Bra Size : " + 75 + equalToOne);
                        } else if (convertedBandValue == 36) {
                            tvResult.setText("Bra Size : " + 80 + equalToOne);
                        } else if (convertedBandValue == 38) {
                            tvResult.setText("Bra Size : " + 85 + equalToOne);
                        } else if (convertedBandValue == 40) {
                            tvResult.setText("Bra Size : " + 90 + equalToOne);
                        } else if (convertedBandValue == 42) {
                            tvResult.setText("Bra Size : " + 95 + equalToOne);
                        } else if (convertedBandValue == 44) {
                            tvResult.setText("Bra Size : " + 100 + equalToOne);
                        } else if (convertedBandValue == 46) {
                            tvResult.setText("Bra Size : " + 105 + equalToOne);
                        } else if (convertedBandValue == 48) {
                            tvResult.setText("Bra Size : " + 110 + equalToOne);
                        }
                    } else if (Result == 2) {
                        if (convertedBandValue == 28) {
                            tvResult.setText("Bra Size : " + 60 + equalToTwo);
                        } else if (convertedBandValue == 30) {
                            tvResult.setText("Bra Size : " + 65 + equalToTwo);
                        } else if (convertedBandValue == 32) {
                            tvResult.setText("Bra Size : " + 70 + equalToTwo);
                        } else if (convertedBandValue == 34) {
                            tvResult.setText("Bra Size : " + 75 + equalToTwo);
                        } else if (convertedBandValue == 36) {
                            tvResult.setText("Bra Size : " + 80 + equalToTwo);
                        } else if (convertedBandValue == 38) {
                            tvResult.setText("Bra Size : " + 85 + equalToTwo);
                        } else if (convertedBandValue == 40) {
                            tvResult.setText("Bra Size : " + 90 + equalToTwo);
                        } else if (convertedBandValue == 42) {
                            tvResult.setText("Bra Size : " + 95 + equalToTwo);
                        } else if (convertedBandValue == 44) {
                            tvResult.setText("Bra Size : " + 100 + equalToTwo);
                        } else if (convertedBandValue == 46) {
                            tvResult.setText("Bra Size : " + 105 + equalToTwo);
                        } else if (convertedBandValue == 48) {
                            tvResult.setText("Bra Size : " + 110 + equalToTwo);
                        }

                    } else if (Result == 3) {
                        if (convertedBandValue == 28) {
                            tvResult.setText("Bra Size : " + 60 + equalToThree);
                        } else if (convertedBandValue == 30) {
                            tvResult.setText("Bra Size : " + 65 + equalToThree);
                        } else if (convertedBandValue == 32) {
                            tvResult.setText("Bra Size : " + 70 + equalToThree);
                        } else if (convertedBandValue == 34) {
                            tvResult.setText("Bra Size : " + 75 + equalToThree);
                        } else if (convertedBandValue == 36) {
                            tvResult.setText("Bra Size : " + 80 + equalToThree);
                        } else if (convertedBandValue == 38) {
                            tvResult.setText("Bra Size : " + 85 + equalToThree);
                        } else if (convertedBandValue == 40) {
                            tvResult.setText("Bra Size : " + 90 + equalToThree);
                        } else if (convertedBandValue == 42) {
                            tvResult.setText("Bra Size : " + 95 + equalToThree);
                        } else if (convertedBandValue == 44) {
                            tvResult.setText("Bra Size : " + 100 + equalToThree);
                        } else if (convertedBandValue == 46) {
                            tvResult.setText("Bra Size : " + 105 + equalToThree);
                        } else if (convertedBandValue == 48) {
                            tvResult.setText("Bra Size : " + 110 + equalToThree);
                        }

                    } else if (Result == 4) {
                        if (convertedBandValue == 28) {
                            tvResult.setText("Bra Size : " + 60 + equalToFour);
                        } else if (convertedBandValue == 30) {
                            tvResult.setText("Bra Size : " + 65 + equalToFour);
                        } else if (convertedBandValue == 32) {
                            tvResult.setText("Bra Size : " + 70 + equalToFour);
                        } else if (convertedBandValue == 34) {
                            tvResult.setText("Bra Size : " + 75 + equalToFour);
                        } else if (convertedBandValue == 36) {
                            tvResult.setText("Bra Size : " + 80 + equalToFour);
                        } else if (convertedBandValue == 38) {
                            tvResult.setText("Bra Size : " + 85 + equalToFour);
                        } else if (convertedBandValue == 40) {
                            tvResult.setText("Bra Size : " + 90 + equalToFour);
                        } else if (convertedBandValue == 42) {
                            tvResult.setText("Bra Size : " + 95 + equalToFour);
                        } else if (convertedBandValue == 44) {
                            tvResult.setText("Bra Size : " + 100 + equalToFour);
                        } else if (convertedBandValue == 46) {
                            tvResult.setText("Bra Size : " + 105 + equalToFour);
                        } else if (convertedBandValue == 48) {
                            tvResult.setText("Bra Size : " + 110 + equalToFour);
                        }

                    } else if (Result == 5) {
                        if (convertedBandValue == 28) {
                            tvResult.setText("Bra Size : " + 60 + equalToFive);
                        } else if (convertedBandValue == 30) {
                            tvResult.setText("Bra Size : " + 65 + equalToFive);
                        } else if (convertedBandValue == 32) {
                            tvResult.setText("Bra Size : " + 70 + equalToFive);
                        } else if (convertedBandValue == 34) {
                            tvResult.setText("Bra Size : " + 75 + equalToFive);
                        } else if (convertedBandValue == 36) {
                            tvResult.setText("Bra Size : " + 80 + equalToFive);
                        } else if (convertedBandValue == 38) {
                            tvResult.setText("Bra Size : " + 85 + equalToFive);
                        } else if (convertedBandValue == 40) {
                            tvResult.setText("Bra Size : " + 90 + equalToFive);
                        } else if (convertedBandValue == 42) {
                            tvResult.setText("Bra Size : " + 95 + equalToFive);
                        } else if (convertedBandValue == 44) {
                            tvResult.setText("Bra Size : " + 100 + equalToFive);
                        } else if (convertedBandValue == 46) {
                            tvResult.setText("Bra Size : " + 105 + equalToFive);
                        } else if (convertedBandValue == 48) {
                            tvResult.setText("Bra Size : " + 110 + equalToFive);
                        }

                    } else if (Result == 6) {
                        if (convertedBandValue == 28) {
                            tvResult.setText("Bra Size : " + 60 + equalToSix);
                        } else if (convertedBandValue == 30) {
                            tvResult.setText("Bra Size : " + 65 + equalToSix);
                        } else if (convertedBandValue == 32) {
                            tvResult.setText("Bra Size : " + 70 + equalToSix);
                        } else if (convertedBandValue == 34) {
                            tvResult.setText("Bra Size : " + 75 + equalToSix);
                        } else if (convertedBandValue == 36) {
                            tvResult.setText("Bra Size : " + 80 + equalToSix);
                        } else if (convertedBandValue == 38) {
                            tvResult.setText("Bra Size : " + 85 + equalToSix);
                        } else if (convertedBandValue == 40) {
                            tvResult.setText("Bra Size : " + 90 + equalToSix);
                        } else if (convertedBandValue == 42) {
                            tvResult.setText("Bra Size : " + 95 + equalToSix);
                        } else if (convertedBandValue == 44) {
                            tvResult.setText("Bra Size : " + 100 + equalToSix);
                        } else if (convertedBandValue == 46) {
                            tvResult.setText("Bra Size : " + 105 + equalToSix);
                        } else if (convertedBandValue == 48) {
                            tvResult.setText("Bra Size : " + 110 + equalToSix);
                        }
                    } else if (Result == 7) {
                        if (convertedBandValue == 28) {
                            tvResult.setText("Bra Size : " + 60 + equalToSeven);
                        } else if (convertedBandValue == 30) {
                            tvResult.setText("Bra Size : " + 65 + equalToSeven);
                        } else if (convertedBandValue == 32) {
                            tvResult.setText("Bra Size : " + 70 + equalToSeven);
                        } else if (convertedBandValue == 34) {
                            tvResult.setText("Bra Size : " + 75 + equalToSeven);
                        } else if (convertedBandValue == 36) {
                            tvResult.setText("Bra Size : " + 80 + equalToSeven);
                        } else if (convertedBandValue == 38) {
                            tvResult.setText("Bra Size : " + 85 + equalToSeven);
                        } else if (convertedBandValue == 40) {
                            tvResult.setText("Bra Size : " + 90 + equalToSeven);
                        } else if (convertedBandValue == 42) {
                            tvResult.setText("Bra Size : " + 95 + equalToSeven);
                        } else if (convertedBandValue == 44) {
                            tvResult.setText("Bra Size : " + 100 + equalToSeven);
                        } else if (convertedBandValue == 46) {
                            tvResult.setText("Bra Size : " + 105 + equalToSeven);
                        } else if (convertedBandValue == 48) {
                            tvResult.setText("Bra Size : " + 110 + equalToSeven);
                        }

                    } else if (Result == 8) {
                        if (convertedBandValue == 28) {
                            tvResult.setText("Bra Size : " + 60 + equalToEight);
                        } else if (convertedBandValue == 30) {
                            tvResult.setText("Bra Size : " + 65 + equalToEight);
                        } else if (convertedBandValue == 32) {
                            tvResult.setText("Bra Size : " + 70 + equalToEight);
                        } else if (convertedBandValue == 34) {
                            tvResult.setText("Bra Size : " + 75 + equalToEight);
                        } else if (convertedBandValue == 36) {
                            tvResult.setText("Bra Size : " + 80 + equalToEight);
                        } else if (convertedBandValue == 38) {
                            tvResult.setText("Bra Size : " + 85 + equalToEight);
                        } else if (convertedBandValue == 40) {
                            tvResult.setText("Bra Size : " + 90 + equalToEight);
                        } else if (convertedBandValue == 42) {
                            tvResult.setText("Bra Size : " + 95 + equalToEight);
                        } else if (convertedBandValue == 44) {
                            tvResult.setText("Bra Size : " + 100 + equalToEight);
                        } else if (convertedBandValue == 46) {
                            tvResult.setText("Bra Size : " + 105 + equalToEight);
                        } else if (convertedBandValue == 48) {
                            tvResult.setText("Bra Size : " + 110 + equalToEight);
                        }

                    } else if (Result == 9) {
                        if (convertedBandValue == 28) {
                            tvResult.setText("Bra Size : " + 60 + equalToNine);
                        } else if (convertedBandValue == 30) {
                            tvResult.setText("Bra Size : " + 65 + equalToNine);
                        } else if (convertedBandValue == 32) {
                            tvResult.setText("Bra Size : " + 70 + equalToNine);
                        } else if (convertedBandValue == 34) {
                            tvResult.setText("Bra Size : " + 75 + equalToNine);
                        } else if (convertedBandValue == 36) {
                            tvResult.setText("Bra Size : " + 80 + equalToNine);
                        } else if (convertedBandValue == 38) {
                            tvResult.setText("Bra Size : " + 85 + equalToNine);
                        } else if (convertedBandValue == 40) {
                            tvResult.setText("Bra Size : " + 90 + equalToNine);
                        } else if (convertedBandValue == 42) {
                            tvResult.setText("Bra Size : " + 95 + equalToNine);
                        } else if (convertedBandValue == 44) {
                            tvResult.setText("Bra Size : " + 100 + equalToNine);
                        } else if (convertedBandValue == 46) {
                            tvResult.setText("Bra Size : " + 105 + equalToNine);
                        } else if (convertedBandValue == 48) {
                            tvResult.setText("Bra Size : " + 110 + equalToNine);
                        }
                    } else if (Result == 10) {
                        if (convertedBandValue == 28) {
                            tvResult.setText("Bra Size : " + 60 + equalToTen);
                        } else if (convertedBandValue == 30) {
                            tvResult.setText("Bra Size : " + 65 + equalToTen);
                        } else if (convertedBandValue == 32) {
                            tvResult.setText("Bra Size : " + 70 + equalToTen);
                        } else if (convertedBandValue == 34) {
                            tvResult.setText("Bra Size : " + 75 + equalToTen);
                        } else if (convertedBandValue == 36) {
                            tvResult.setText("Bra Size : " + 80 + equalToTen);
                        } else if (convertedBandValue == 38) {
                            tvResult.setText("Bra Size : " + 85 + equalToTen);
                        } else if (convertedBandValue == 40) {
                            tvResult.setText("Bra Size : " + 90 + equalToTen);
                        } else if (convertedBandValue == 42) {
                            tvResult.setText("Bra Size : " + 95 + equalToTen);
                        } else if (convertedBandValue == 44) {
                            tvResult.setText("Bra Size : " + 100 + equalToTen);
                        } else if (convertedBandValue == 46) {
                            tvResult.setText("Bra Size : " + 105 + equalToTen);
                        } else if (convertedBandValue == 48) {
                            tvResult.setText("Bra Size : " + 110 + equalToTen);
                        }
                    } else {
                        tvResult.setText("Your Size Is Out of Range");
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
                    String equalToNine = "I";
                    String equalToTen = "J";

                    int Result = 0;
                    if (convertedBandValue % 2 == 1) {
                        convertedBandValue = convertedBandValue + 1;
                        if (convertedBustValue < convertedBandValue) {
                            Result = 0;
                        } else {
                            Result = convertedBustValue - convertedBandValue;
                        }
                    } else {
                        Result = convertedBustValue - convertedBandValue;
                    }
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

                    } else if (Result == 9) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToNine);
                    } else if (Result == 10) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToTen);
                    } else {
                        tvResult.setText("Your Size Is Out of Range");
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
                    String equalToNine = "H";
                    String equalToTen = "I";

                    int Result = 0;
                    if (convertedBandValue % 2 == 1) {
                        convertedBandValue = convertedBandValue + 1;
                        if (convertedBustValue < convertedBandValue) {
                            Result = 0;
                        } else {
                            Result = convertedBustValue - convertedBandValue;
                        }
                    } else {
                        Result = convertedBustValue - convertedBandValue;
                    }

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

                    } else if (Result == 9) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToNine);
                    } else if (Result == 10) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToTen);
                    } else {
                        tvResult.setText("Your Size Is Out of Range");
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
                    String equalToNine = "J";
                    String equalToTen = "K";

                    int Result = 0;
                    if (convertedBandValue % 2 == 1) {
                        convertedBandValue = convertedBandValue + 1;
                        if (convertedBustValue < convertedBandValue) {
                            Result = 0;
                        } else {
                            Result = convertedBustValue - convertedBandValue;
                        }
                    } else {
                        Result = convertedBustValue - convertedBandValue;
                    }

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

                    } else if (Result == 9) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToNine);
                    } else if (Result == 10) {
                        tvResult.setText("Bra Size : " + convertedBandValue + equalToTen);
                    } else {
                        tvResult.setText("Your Size Is Out of Range");
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
            TextView tvMsg = (TextView) view.findViewById(R.id.tvMsg);
            tvMsg.setText("We Are Digital Applications");
            customDialog.show();
            customDialog.setCanceledOnTouchOutside(true);
        }
        return super.onOptionsItemSelected(item);
    }
}
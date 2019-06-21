package com.shapeapp.cos;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public TextInputEditText productname;
    public Uri postImageUri = null;
    public TextInputEditText shortdiscription;
    public TextInputEditText mrp;
    public TextInputEditText listingprice;
    public Spinner category;
   public RadioButton yesn;
    public Spinner type;
    public TextInputEditText url;
    public Button sub;
    public ImageView img;
    public TextInputEditText maxret;
    public TextInputEditText minquant;
    public TextInputEditText maxquant;
    public TextInputEditText stock;
    public TextInputEditText lowstock;
    public TextInputLayout tilmaxret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finals);
        shortdiscription = (TextInputEditText) findViewById(R.id.etShortDiscript);
        mrp = findViewById(R.id.etMrpP);
        listingprice = findViewById(R.id.etListingPrice);
        url = findViewById(R.id.etVideoUrl);
        maxret = findViewById(R.id.etMaximumRet);
        minquant = findViewById(R.id.etMinQuantity);
        productname = (TextInputEditText) findViewById(R.id.etProductName);
        lowstock = findViewById(R.id.etLowStock);

        type = findViewById(R.id.spUserType);
        category = findViewById(R.id.spCategory);
        maxquant = findViewById(R.id.etMinQuant);
        stock = findViewById(R.id.etStockTo);
        sub = findViewById(R.id.btnChooseIMage);
        img = findViewById(R.id.imageView);
        getSupportActionBar().setTitle("Product");

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)

                        .start(MainActivity.this);

            }
        });

        final String types[] = new String[]{"All", "Restricted", "Confidential"};
        final String categories[] = new String[]{"Categories", "Yes", "No", "ggh", "njnkk", "hihjjo"};


        ArrayAdapter<String> adap =new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,types);
        type.setAdapter(adap);

        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String mnb = types[+position];


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        ArrayAdapter<String> adapte =new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,categories);
        category.setAdapter(adapte);

        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String mnb = categories[+position];


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );}
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        tilmaxret=findViewById(R.id.etMax);
        maxret=findViewById(R.id.etMaximumRet);
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_yes:
                if (checked)
                    // Pirates are the best

                    tilmaxret.setVisibility(View.VISIBLE);

                break;
            case R.id.radio_no:
                if (checked)
                    tilmaxret.setVisibility(View.INVISIBLE);


                    break;
        }
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
img.setVisibility(View.VISIBLE);
            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {

                    postImageUri = result.getUri();
img.setImageURI(postImageUri);

                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                    Exception error = result.getError();

                }
            }

        }
}

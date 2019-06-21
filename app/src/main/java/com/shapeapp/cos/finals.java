package com.shapeapp.cos;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class finals extends AppCompatActivity {
    public TextInputEditText productname;
    public Uri postImageUri = null;
    public TextInputEditText shortdiscription;
    public TextInputEditText mrp;
    public TextInputEditText listingprice;
    public Spinner category;
    public Spinner yesn;
    public Spinner type;
    public TextInputEditText url;
    public Button sub;
    public Button img;
    public TextInputEditText maxret;
    public TextInputEditText minquant;
    public TextInputEditText maxquant;
    public TextInputEditText stock;
    public TextInputEditText lowstock;
public Button chooseImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finals);
        shortdiscription=(TextInputEditText)findViewById(R.id.etShortDiscription);
        mrp=findViewById(R.id.etMrp);
        listingprice=findViewById(R.id.etListing);
        url=findViewById(R.id.etVideo);
        maxret=findViewById(R.id.etMaximumRet);
        minquant=findViewById(R.id.etMinQuant);
        productname=(TextInputEditText)findViewById(R.id.etProduct);
        lowstock=findViewById(R.id.etLowStock);
        yesn=findViewById(R.id.spReturnable);
        type=findViewById(R.id.spUserType);
        category=findViewById(R.id.spCategory);
        maxquant=findViewById(R.id.etMinQuant);
        stock=findViewById(R.id.etStockTo);
chooseImage=findViewById(R.id.btnChooseIMage);
        img=findViewById(R.id.button);
       chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)

                        .start(finals.this);

            }
        });

        final String yes[]=new String[]{"Yes/No","Yes","No"};
        final String types[]=new String[]{"All","Restricted","Confidential"};
        final String categories[]=new String[]{"Categories","Yes","No","ggh","njnkk","hihjjo"};
        ArrayAdapter<String> adaptere =new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,yes);
        yesn.setAdapter(adaptere);

        yesn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String mnb = yes[+position];


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
img.setVisibility(View.VISIBLE);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                postImageUri = result.getUri();


            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                Exception error = result.getError();

            }
        }

    }
}



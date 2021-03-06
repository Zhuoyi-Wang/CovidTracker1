package au.edu.unsw.infs3634.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3634.covidtracker.intent_message";
    private static final String TAG = "DetailActivity";

    private TextView mCountry;
    private ImageView mSearch;
    private TextView mNewCases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mCountry = findViewById(R.id.tvCountry);
        mSearch = findViewById(R.id.ivSearch);
        mNewCases = findViewById(R.id.tvCasesDesc);

        Intent intent = getIntent();


        if (intent.hasExtra(DetailActivity.INTENT_MESSAGE)) {
            String countryCode = intent.getStringExtra(DetailActivity.INTENT_MESSAGE);
            Log.d(TAG, msg:"Intent message is :: " + countryCode);

            Country country = Country.getCountry(countryCode);
            Log.d(TAG, msg:"Intent message is :: " + country.getCountry());

            setTitle(country.getCountryCode());

            mCountry.setText(country.getCountry());
            mNewCases.setText(country.getNewConfirmed().toString());
            mSearch.setOnClickListener(new View.OnclickListener(){
                @Override
                 public void onClick(View v){

                }
            });

        }


        };
    }
private void googleSearch(String countryName){
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=covid+"+countryName));
}


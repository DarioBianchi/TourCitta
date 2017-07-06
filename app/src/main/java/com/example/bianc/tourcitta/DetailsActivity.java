package com.example.bianc.tourcitta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.id;
import static android.R.attr.start;

public class DetailsActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    private ImageView imageView;
    private TextView textView; //
    private String posto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.tool_bar);

        setSupportActionBar(myToolbar);
        myToolbar.setOnMenuItemClickListener(this);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icona_dettagli);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        imageView = (ImageView) findViewById(R.id.imageViewDetails); //
        textView = (TextView) findViewById(R.id.textViewDetails); //

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras!=null) {
            String luogo = (String) extras.getSerializable("luogo");
            initUI(luogo);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        // or call onBackPressed()
        return true;
    }


    private void initUI(String luogo) {
        String str1;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;

        switch (luogo){
            case "Cattedrale di Como":
                imageView.setImageResource(R.drawable.cattedrale_como);
                str1 = "La cattedrale di Santa Maria Assunta è il principale edificio di culto della città di Como, chiesa madre della diocesi omonima. Situata vicino al lago, rappresenta uno dei più ragguardevoli monumenti dell'Italia settentrionale.";
                textView.setText(String.valueOf(str1));
                posto = luogo;

                break;
            case "Teatro Sociale":
                imageView.setImageResource(R.drawable.teatro_sociale);
                str2 = "Il Teatro Sociale di Como è il teatro d'opera di Como. Ospitò Niccolò Paganini, Franz Liszt e Giuditta Pasta.";
                textView.setText(String.valueOf(str2));

                posto = luogo;
                break;
            case "Biblioteca Comunale di Como":
                imageView.setImageResource(R.drawable.biblioteca_comunale);
                str3 ="La biblioteca Comunale di Como è un luogo accogliente dove poter trovare libri di qualsiasi genere. Ospita inoltre un ampio spazio riservato allo studio.";
                textView.setText(String.valueOf(str3));
                posto = luogo;
                break;
            case "Chiesa Cattolica Parrocchiale S.Giuliano":
                imageView.setImageResource(R.drawable.chiesa_s_giuliano);
                str4 ="Via Monti Maurizio 53 - 22100 Como (CO)";
                textView.setText(String.valueOf(str4));
                posto = "Chiesa Cattolica Parrocchiale San Giuliano";
                break;
            case "Chiesa di S.Giacomo":
                imageView.setImageResource(R.drawable.chiesa_s_giacomo);
                str5 ="La chiesa di San Giacomo sorge nel centro di Como, dietro al Palazzo del Broletto, a metà strada tra la Cattedrale e il Palazzo Vescovile. Il suo aspetto attuale è il frutto delle demolizioni e delle trasformazioni di una grande basilica edificata probabilmente nella seconda metà dell’XI secolo.";
                textView.setText(String.valueOf(str5));
                posto="Chiesa di San Giacomo";
                break;
            case "Funicolare Como - Brunate":
                imageView.setImageResource(R.drawable.funicolare_como_brunate);
                str6 ="La funicolare, che dal 1894 collega Como e Brunate, è ancora oggi il mezzo più veloce per muoversi fra le due località, ma anche l’occasione per godere di un incantevole panorama sul lago e sulle Alpi. ";
                textView.setText(String.valueOf(str6));
                posto = luogo;
                break;
            case "Parrocchia Sant. Agata":
                imageView.setImageResource(R.drawable.parrocchia_s_agata);
                str7 ="Via Francesco Cetti, 2, 22100 Como CO";
                textView.setText(String.valueOf(str7));
                posto ="Parrocchia Sant Agata";
                break;
            case "Parrocchia S.Donnino":
                imageView.setImageResource(R.drawable.parrocchia_s_donnino);
                str8 ="La chiesa, che conserva in buona parte il ricco assetto decorativo seicentesco, è ubicata all'interno del perimetro delle mura e sorge in posizione sopraelevata rispetto al tracciato della via Diaz, collegata da una breve scalinata.";
                textView.setText(String.valueOf(str8));
                posto="Parrocchia San Donnino";
                break;
            case "Tempio Voltiano":
                imageView.setImageResource(R.drawable.tempio_voltiano);
                str9 ="Il Tempio Voltiano è un museo scientifico situato a Como, sul Lungo Lario Marconi.";
                textView.setText(String.valueOf(str9));
                posto = luogo;
                break;
            case "Parrocchia S.Fedele":
                imageView.setImageResource(R.drawable.parrocchia_s_fedele);
                str10 ="La basilica prepositurale insigne collegiata di San Fedele è un importante luogo di culto cattolico del centro storico di Como, dedicato all'omonimo santo, evangelizzatore della chiesa comasca e martire nel III secolo a Sorico.";
                textView.setText(String.valueOf(str10));
                posto="Parrocchia San Fedele";
                break;
            case "Parrocchia S.S.Crocifisso":
                imageView.setImageResource(R.drawable.chiesa_s_s_crocifisso);
                str11 ="Come attestano le antiche vedute di Como, la chiesa dell’Annunciata aveva una semplice facciata rivolta verso il torrente Cosia ed era orientata come le principali chiese cittadine con l’abside rivolta a est.";
                textView.setText(String.valueOf(str11));
                posto ="Parrocchia Santissimo Crocifisso";
                break;
            case "Chiesa Cattolica Parrocchiale S.Bartolomeo":
                imageView.setImageResource(R.drawable.chiesa_s_bartolomeo);
                str12 ="Via Milano, 161, 22100 Como CO";
                textView.setText(String.valueOf(str12));
                posto="Chiesa Cattolica Parrocchiale San Bartolomeo";
                break;

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Log.d("OnMenu",item.toString() +" "+ item.getItemId());
        if (item.getItemId()==R.id.action_add_todo) {
            Intent intent = new Intent(getApplicationContext(),CommentsActivity.class);
            Bundle extras = new Bundle();
            extras.putSerializable("luogo",posto);
            intent.putExtras(extras);
            startActivity(intent);
            return true;
        }
        return false;
    }
}

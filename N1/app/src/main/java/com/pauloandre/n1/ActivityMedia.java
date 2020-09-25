package com.pauloandre.n1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityMedia extends AppCompatActivity {

    private String nome;
    private String media;
    private TextView nomeText;
    private TextView mediaText;
    private TextView situacaoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        nome = getIntent().getStringExtra("EXTRA_NOME");
        media = getIntent().getStringExtra("EXTRA_MEDIA");
        nomeText = (TextView)findViewById(R.id.textViewNome2);
        mediaText = (TextView)findViewById(R.id.textViewMedia);
        situacaoText = (TextView)findViewById(R.id.textViewSituacao);

        nomeText.setText(nome);
        mediaText.setText(media);
        if (Double.parseDouble(media) >= 7) {
            situacaoText.setText("aprovado(a)");
        } else {
            situacaoText.setText("reprovado(a)");
        }
    }

}
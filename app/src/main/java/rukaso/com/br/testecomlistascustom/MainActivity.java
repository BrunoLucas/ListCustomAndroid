package rukaso.com.br.testecomlistascustom;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rukaso.com.br.testecomlistascustom.adapter.AdapterCustom;
import rukaso.com.br.testecomlistascustom.vo.Personagem;

public class MainActivity extends AppCompatActivity {

    private ListView listaDePersonagensListView;

    private List<Personagem> listaPersonagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        listaDePersonagensListView = (ListView) findViewById(R.id.listaPersonagens);
        listaPersonagens = mockListaPersonagens();

        AdapterCustom adapterCustom = new AdapterCustom(getApplicationContext(), R.layout.layout_lista_personagens_custom);

        for(Personagem personagem : listaPersonagens){
            adapterCustom.add(personagem);
        }

        listaDePersonagensListView.setAdapter(adapterCustom);

        listaDePersonagensListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), listaPersonagens.get(position).getNome(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private List<Personagem> mockListaPersonagens(){
        List<Personagem> mock = new ArrayList<>();
        Personagem hobbit = new Personagem();
        hobbit.setNome("Hobbit");
        hobbit.setDescricao("Pequenos mas grandes");
        hobbit.setImagem(R.drawable.hobbitimage);
        mock.add(hobbit);
        Personagem homem = new Personagem();
        homem.setNome("Homem");
        homem.setDescricao("Dominadores da próxima era");
        homem.setImagem(R.drawable.manimage);
        mock.add(homem);
        Personagem elfo = new Personagem();
        elfo.setNome("Elfo");
        elfo.setDescricao("Criaturas da natureza");
        elfo.setImagem(R.drawable.elfimage);
        mock.add(elfo);
        Personagem anao = new Personagem();
        anao.setNome("Anão");
        anao.setDescricao("Guerreiros do metal");
        anao.setImagem(R.drawable.dwarfimage);
        mock.add(anao);

        return mock;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

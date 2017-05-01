package rukaso.com.br.testecomlistascustom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import rukaso.com.br.testecomlistascustom.R;
import rukaso.com.br.testecomlistascustom.vo.Personagem;

/**
 * Created by lucas on 01/05/17.
 */

public class AdapterCustom extends ArrayAdapter {

    public AdapterCustom(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view  = convertView;

        DataHandler dataHandler;

         if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.layout_lista_personagens_custom, parent, false);

             dataHandler = new DataHandler();
             dataHandler.setImagem((ImageView)view.findViewById(R.id.imageView));
             dataHandler.setNome((TextView) view.findViewById(R.id.textView));
             dataHandler.setDescricao((TextView) view.findViewById(R.id.textView2));
             view.setTag(dataHandler);
         } else{
             dataHandler = (DataHandler) view.getTag();
         }

        Personagem personagem = (Personagem) this.getItem(position);
        dataHandler.getImagem().setImageResource(personagem.getImagem());
        dataHandler.getNome().setText(personagem.getNome());
        dataHandler.getDescricao().setText(personagem.getDescricao());

        return view;
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }
}

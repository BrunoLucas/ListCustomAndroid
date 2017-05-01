package rukaso.com.br.testecomlistascustom.adapter;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lucas on 01/05/17.
 */
public class DataHandler {

    protected ImageView imagem;
    protected TextView nome;
    protected TextView descricao;


    public ImageView getImagem() {
        return imagem;
    }

    public void setImagem(ImageView imagem) {
        this.imagem = imagem;
    }

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getDescricao() {
        return descricao;
    }

    public void setDescricao(TextView descricao) {
        this.descricao = descricao;
    }
}

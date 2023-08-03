package dominando.android.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dominando.android.affirmations.R
import dominando.android.affirmations.model.Affirmation


//Adaptador para o [RecyclerView] em [MainActivity]. Exibe o objeto de dados [Afirmação].
class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    //Forneça uma referência às exibições para cada item de dados
    // Itens de dados complexos podem precisar de mais de uma visualização por item e
    // você fornece acesso a todas as exibições de um item de dados em um detentor de exibição.
    // Cada item de dados é apenas um objeto Afirmação.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    //O método onCreateViewHolder() é chamado pelo gerenciador de layout para criar novos
    // armazenadores de visualização para o RecyclerView (quando não há armazenadores de
    // visualização existentes que possam ser reutilizados). Lembre-se de que um armazenador de
    // visualização representa uma única visualização de item da lista.

    //Criar novas visualizações (chamadas pelo gerenciador de layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    //O método getItemCount() precisa retornar o tamanho do conjunto de dados. Os dados do app
    // estão na propriedade dataset que você está transmitindo ao construtor do ItemAdapter,
    // e você pode acessar o tamanho usando size
    override fun getItemCount(): Int {
        return dataset.size
    }

    //onBindViewHolder(). Esse método é chamado pelo gerenciador de layout para substituir o
    // conteúdo de uma visualização de item de lista.

    //O método onBindViewHolder() tem dois parâmetros, um ItemViewHolder criado anteriormente
    // pelo método onCreateViewHolder() e um int que representa a position do item atual na lista.
    // Neste método, você encontrará o objeto Affirmation correto do conjunto de dados com base na posição.

    //Substitua o conteúdo de uma exibição (chamada pelo gerenciador de layout)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //crie um item val e acesse o item na position especificada no dataset
        //Retorne o tamanho do seu conjunto de dados (chamado pelo gerenciador de layout)
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourdeId)
    }
}
package dominando.android.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import dominando.android.affirmations.adapter.ItemAdapter
import dominando.android.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializar dados
        val myDataset =  Datasource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        //Atribua o objeto ItemAdapter à propriedade adapter do recyclerView
        recyclerView.adapter = ItemAdapter(this, myDataset)

        //Use esta configuração para melhorar o desempenho se você souber que as alterações
        // no conteúdo não altera o tamanho do layout do RecyclerView
        recyclerView.setHasFixedSize(true)

    }


}
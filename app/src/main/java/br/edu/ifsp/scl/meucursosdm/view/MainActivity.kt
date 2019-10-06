package br.edu.ifsp.scl.meucursosdm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import br.edu.ifsp.scl.meucursosdm.R
import br.edu.ifsp.scl.meucursosdm.adapter.DisciplinasAdapter
import br.edu.ifsp.scl.meucursosdm.controller.CursoController
import br.edu.ifsp.scl.meucursosdm.model.Disciplina
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var listaDisciplinas: MutableList<Disciplina>
    lateinit var disciplinasAdapter: DisciplinasAdapter
    lateinit var cursoController: CursoController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // lista de disciplinas do Adapter
        listaDisciplinas = mutableListOf()
        disciplinasAdapter = DisciplinasAdapter(this,
            R.layout.disciplina_item,
            listaDisciplinas)

        // Setando o adapter do ListView
        disciplinasLv.adapter = disciplinasAdapter
        // Criando Controller e solicitando atualização de lista
        cursoController = CursoController(this)
        // Inserindo disciplinas falsas
        insereDisciplinasFalsas()

        // Solicitando todas as disciplinas para o Controller
        cursoController.buscaTodas()
    }

    private fun insereDisciplinasFalsas() {
        for (i in 1..50) {
            val d = Disciplina("D${i}", "Disciplina ${i}", "Ementa ${i}")
            cursoController.insereDisciplina(d)
        }
    }

    fun atualizaLista(listaAtualizada: List<Disciplina>) {
        // Limpa lista anterior (abordagem de teste)
        listaDisciplinas.clear()
        // Adiciona os elementos retornados pelo Controller
        listaDisciplinas.addAll(listaAtualizada)
        // Notifica o Adapter das mudanças na sua fonte de daddos
        disciplinasAdapter.notifyDataSetChanged()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.menu_contexto, menu)
    }
}

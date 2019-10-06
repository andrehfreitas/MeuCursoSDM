package br.edu.ifsp.scl.meucursosdm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
}

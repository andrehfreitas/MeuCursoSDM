package br.edu.ifsp.scl.meucursosdm.controller

import br.edu.ifsp.scl.meucursosdm.view.MainActivity
import br.edu.ifsp.scl.meucursosdm.model.Disciplina
import br.edu.ifsp.scl.meucursosdm.model.DisciplinaSqlite

class CursoController(val mainActivity: MainActivity) {
    val disciplinaDao: DisciplinaDao
    init {
        disciplinaDao = DisciplinaSqlite(mainActivity)
    }
    fun insereDisciplina(disciplina: Disciplina){
        disciplinaDao.createDisciplina(disciplina)
        buscaTodas()
    }
    fun buscaDisciplina(codigo: String){
        val disciplina: Disciplina = disciplinaDao.readDisciplina(codigo)
        mainActivity.atualizaLista(mutableListOf(disciplina))
    }
    fun buscaTodas() {
        mainActivity.atualizaLista(disciplinaDao.readDisciplinas())
    }
    fun atualiza(disciplina: Disciplina) {
        disciplinaDao.updateDisciplina(disciplina)
        buscaTodas()
    }
    fun remove(codigo: String) {
        disciplinaDao.deleteDisciplina(codigo)
        buscaTodas()
    }
}
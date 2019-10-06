package br.edu.ifsp.scl.meucursosdm.model

interface DisciplinaDAO {
    fun create createDisciplina(disciplina: Disciplina)
    fun readDisciplina (codigo: String): Disciplina
    fun readDisciplinas(): MutableList<Disciplina>
    fun updateDisciplina(disciplina: Disciplina)
    fun deleteDisciplina(codigo: String)
}
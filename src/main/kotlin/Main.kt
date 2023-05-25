enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }
data class Usuario(val nome: String)
data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Usuario>()
    private val duracaoTotal = conteudos.sumOf { it.duracao }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun listaMatriculados() {
        println("\nAlunos na formação: $nome ($nivel)")
        for (inscito in inscritos) {
           println("\t ${inscito.nome}")
        }
    }

    fun listaConteudos() {
        println("\nConteúdos da Formação: $nome ($nivel)")
        for (conteudo in conteudos) {
            println("\t ${conteudo.nome}")
        }
    }

    override fun toString(): String {
        return "Formacao = $nome ($nivel) \nDuracao Total = $duracaoTotal"
    }
}

fun main() {

    val kotlinTQIConteudos = listOf(
        ConteudoEducacional("Principios de Agilidade e Desenvolvimento de Software", 960),
        ConteudoEducacional("Docker Fundamentals", 420),
        ConteudoEducacional("Dominando a Linguagem de Progrmação Java", 1560, Nivel.INTERMEDIARIO),
        ConteudoEducacional("Refinando sua técnica com desafios de Código Java", 300, Nivel.INTERMEDIARIO),
        ConteudoEducacional("Dominando a Linguagem de Programação Kotlin", 780, Nivel.INTERMEDIARIO),
        ConteudoEducacional("Refinando sua técnica com desafios de Código Kotlin", 300, Nivel.INTERMEDIARIO),
        ConteudoEducacional("Primeiros Passos com SQL", 300),
        ConteudoEducacional("Explorando o Spring Framework com Java e Kotlin", 1260, Nivel.AVANCADO)
    )

    val kotlinTQI = Formacao("Bootcamp TQI - Backend Developer", Nivel.AVANCADO, kotlinTQIConteudos)

    kotlinTQI.matricular(Usuario("Joao Ribas"))
    kotlinTQI.matricular(Usuario("Eloah Favaro"))
    kotlinTQI.matricular(Usuario("Lara Ribas"))
    kotlinTQI.matricular(Usuario("Livia Rodrigues"))

    println(kotlinTQI)
    kotlinTQI.listaConteudos()
    kotlinTQI.listaMatriculados()

}
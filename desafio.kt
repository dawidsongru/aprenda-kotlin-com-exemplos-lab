// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
// Aluno: Dawidson Pereira
// Curso: Bootcamp de Desenvolvimento Backend com Kotlin

// Enum para os níveis de conhecimento
enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

// Data class para representar um usuário
data class Usuario(val nome: String, val nivel: Nivel)

// Data class para representar um conteúdo educacional
data class ConteudoEducacional(
    val nome: String,
    val duracao: Int = 60,
    val nivel: Nivel
) {
    // Função para formatar a informação do conteúdo
    override fun toString(): String =
        "Nome: $nome, Duração: $duracao minutos, Nível: $nivel"
}

// Data class para representar uma formação
data class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>()

    // Função para matricular vários usuários na formação
    fun matricular(vararg usuarios: Usuario) {
        usuarios.forEach { usuario ->
            inscritos.add(usuario)
        }
    }

    // Função para formatar a informação da formação
    override fun toString(): String =
        "Nome: $nome, Nível: $nivel, Conteúdos: ${conteudos.joinToString(", ")}"
}

// Simulação de cenários de teste
fun main() {
    // Criando usuários
    val usuario1 = Usuario("João", Nivel.BASICO)
    val usuario2 = Usuario("Maria", Nivel.INTERMEDIARIO)

    // Criando conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 120, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Desenvolvimento Web com Kotlin", 180, Nivel.INTERMEDIARIO)

    // Criando uma formação
    val formacao = Formacao("Desenvolvedor Kotlin", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))

    // Matriculando usuários na formação
    formacao.matricular(usuario1, usuario2)

    // Imprimindo informações da formação e seus inscritos
    println("Formação: $formacao")
    println("Inscritos:")
    formacao.inscritos.forEach { usuario ->
        println(" - $usuario")
    }
}

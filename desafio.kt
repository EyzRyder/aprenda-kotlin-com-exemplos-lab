enum class Nivel { BASICO, INTERMEDIARIO, AVACADO }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val grauDeDificuldade: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    val systemInscritos = mutableListOf<Usuario>()
    val inscritos: List<Usuario> = systemInscritos             
    
    fun matricular(vararg usuarios: Usuario): Unit {
        //"Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).
         for (usuario in usuarios) {
             systemInscritos.add(usuario)
             usuario.run{
                 println("O $nome foi matriculado.")
             }
         }
    }
    
    fun getSysInscritos(): List<Usuario> {                                  
  	  return inscritos
	}
}

fun main() {
    // Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.
    // Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.
    
    val conteudos = listOf(
    ConteudoEducacional(nome="Syntax",duracao=30,grauDeDificuldade=Nivel.BASICO),
    ConteudoEducacional(nome="POO",grauDeDificuldade=Nivel.INTERMEDIARIO),
	ConteudoEducacional(nome="Funções",grauDeDificuldade=Nivel.INTERMEDIARIO),
    ConteudoEducacional(nome="Server",duracao=120,grauDeDificuldade=Nivel.AVACADO),
    ConteudoEducacional(nome="Android Studio",duracao=120,grauDeDificuldade=Nivel.AVACADO),
)
    val curso = Formacao("Kotlin",conteudos)
    curso.run{
        println("Curso de formação de $nome foi criado.")
    }
    
    curso.matricular(Usuario("Jorge"),Usuario("Amanda"))

}

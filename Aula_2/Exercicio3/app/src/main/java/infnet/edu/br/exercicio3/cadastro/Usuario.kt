package infnet.edu.br.exercicio3.cadastro

import java.io.Serializable

/**
 * Created by eafdecision3 on 23/09/17.
 */

class Usuario: Serializable{
    lateinit var nome:String
    lateinit var email:String
    lateinit var telefone:String
    lateinit var idade:Number

    override fun toString(): String {
        return "Usuario(nome='$nome', email='$email', telefone='$telefone', idade=$idade)"
    }


}


package infnet.edu.br.exercicio9.Models

import java.io.Serializable

/**
 * Created by eafdecision3 on 30/09/17.
 */

class Contato(var nome:String, var telefone:String, var email:String) :Serializable {

    override fun toString(): String {
        return this.nome
    }
}
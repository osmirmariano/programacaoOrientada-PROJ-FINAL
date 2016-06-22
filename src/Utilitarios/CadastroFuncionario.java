/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import ManipulaBanco.ConectaMYSQL;

/**
 *
 * @author Adrianne
 */
public class CadastroFuncionario {
    
    String Nome,RG,CPF,Endereco,cargo;
    float Salario;
    String Comando;
    
    public CadastroFuncionario(String Nome,String RG, String CPF,String Endereco,String cargo,float Salario){
        this.Nome=Nome;
        this.RG=RG;
        this.CPF=CPF;
        this.Endereco=Endereco;
        this.cargo=cargo;
        this.Salario=Salario;
    }
    
    public void cadastra(){
        Comando = "INSERT INTO funcionarios(Nome,RG,CPF,Endereco,cargo,Salario)VALUES(?,?,?,?,?,?) ";
        ConectaMYSQL conecta = new ConectaMYSQL();
        conecta.inserirFuncionario(Comando,Nome,RG,CPF,Endereco,cargo,Salario);
    }
}

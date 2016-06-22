/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import ManipulaBanco.ConectaMYSQL;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrianne
 */
public class CadastroFilme {
    String NomeFilme,Categoria,Genero,Diretor,Estrela;
    int Codigo,Anolancamento;    
    String Comando;
    String status ;
    
    public CadastroFilme(String NomeFilme,String Genero,int Codigo,int Anolancamento,String Diretor,String Estrela,String status){
        this.Anolancamento=Anolancamento;
        this.Codigo=Codigo;
        this.Diretor = Diretor;
        this.Estrela=Estrela;
        this.Genero=Genero;
        this.NomeFilme=NomeFilme;
        this.status=status;
    }

   
    public void cadastraFilme(){
        
        Comando = "INSERT INTO filmes(nomefilme,genero,codigo,lancamento,diretor,estrela,status)VALUES(?,?,?,?,?,?,?) ";
        ConectaMYSQL conecta = new ConectaMYSQL();
       conecta.inserirFilmes(Comando,NomeFilme,Genero,Codigo,Anolancamento,Diretor,Estrela,status);
    }
}


package Utilitarios;

import ManipulaBanco.ConectaMYSQL;
/**
 *
 * @author Adrianne
 */
public class CadastroCliente {
    String Nome,Rg,Cpf,Endereco,NomeAutorizado;
    int TelefoneFixo,TelefoneCelular,TelefoneAutorizado;
    double saldo;
    
    /**
     *
     * @param Nome
     * @param Rg
     * @param Cpf
     * @param Endereco
     * @param TelefoneFixo
     * @param TelefoneCelular
     * @param NomeAutorizado
     * @param TelefoneAutorizado
     * @param saldo
     */
    public CadastroCliente(String Nome,String Rg,String Cpf,String Endereco,int TelefoneFixo,int TelefoneCelular,String NomeAutorizado,int TelefoneAutorizado,double saldo){
        this.Nome=Nome;
        this.Cpf=Cpf;
        this.Rg =Rg;
        this.Endereco = Endereco;
        this.TelefoneFixo=TelefoneFixo;
        this.TelefoneCelular=TelefoneCelular;
        this.TelefoneAutorizado=TelefoneAutorizado;
        this.NomeAutorizado=NomeAutorizado;
        this.saldo=saldo;
    }

    public void cadastraCliente(){
        
        String Comando = "INSERT INTO clientes(nome,rg,cpf,endereco,telefonefixo,telefonecelular,nomeautorizado,telefoneautorizado,saldo)VALUES(?,?,?,?,?,?,?,?,?) ";
        ConectaMYSQL conecta = new ConectaMYSQL();
        conecta.inserirCliente(Comando,Nome,Rg,Cpf,Endereco,TelefoneFixo,TelefoneCelular,NomeAutorizado,TelefoneAutorizado,saldo);
    }
}

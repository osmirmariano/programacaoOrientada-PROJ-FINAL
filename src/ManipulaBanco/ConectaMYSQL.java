package ManipulaBanco;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConectaMYSQL {
    
    public ResultSet rs;// armazena resultado de pesquisa passada  para o statement
    //Driver de conexao que identifica o banco de dados
    private final String Driver="org.postgresql.Driver"; // Postgree eh especifico
    private final String Caminho= "jdbc:postgresql://localhost:5432/Locadora";//Setar local de banco de dados
    private final String Usuario="postgres";
    private final String Senha="1234";
    Connection conn; // Realiza conexão com bd
    String Comando;
    Statement stmt ;
    

     public void open() {
	try {
                System.setProperty("jdbc.Drivers",Driver);		
		conn = DriverManager.getConnection(Caminho,Usuario,Senha);
                stmt = conn.createStatement();
	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro de conexao com o banco de dados: " + e.getMessage());
	}
      }
        
     public void close() {
	try {
		conn.close();
	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Impossivel encerrar conexao! : " + e.getMessage());
	}
    }
     public void inserirFuncionario(String Comando,String Nome,String RG, String CPF,String Endereco,String cargo,float Salario){
	try {
		// Abrindo a conexão com o banco
		open(); 
                JOptionPane.showMessageDialog(null,"Comando : "+Comando);
                PreparedStatement Func = conn.prepareStatement(Comando); 
                Func.setString(1,Nome);
                Func.setString(2,RG); 
                Func.setString(3,CPF); 
                Func.setString(4,Endereco); 
                Func.setString(5,cargo); 
                Func.setFloat(6,Salario); 
                Func.execute();
                JOptionPane.showMessageDialog(null,"Cadastro Realizado!");
		close();
                
	} catch (SQLException e) {
		// Fechando a conexão com o banco
		close();
               JOptionPane.showMessageDialog(null,"Inserção nao foi feita. Erro : " + e.getMessage());
	}
    } 
    public void inserirFilmes(String Comando,String nomefilme,String genero,int codigo,int lancamento,String diretor,String estrela,String status){
	try {
		// Abrindo a conexão com o banco
		open();
                PreparedStatement prepared = conn.prepareStatement(Comando); 
                
                prepared.setString(1,nomefilme);
                prepared.setString(2,genero); 
                prepared.setInt(3,codigo); 
                prepared.setInt(4,lancamento); 
                prepared.setString(5,diretor); 
                prepared.setString(6,estrela);
                prepared.setString(7,status);
                prepared.execute();
                JOptionPane.showMessageDialog(null,"Cadastro Realizado!");
		close();
                
	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Inserção nao foi feita. Erro : "+e.getMessage());
		// Fechando a conexão com o banco
		close();
               
	}
    }  
    public void inserirCliente(String Comando,String Nome,String Rg,String Cpf,String Endereco,int TelefoneFixo,int TelefoneCelular,String NomeAutorizado,int TelefoneAutorizado,double saldo){
	try {
		// Abrindo a conexão com o banco
		open();
                PreparedStatement prepared = conn.prepareStatement(Comando); 
                
                prepared.setString(1,Nome);
                prepared.setString(2,Rg); 
                prepared.setString(3,Cpf); 
                prepared.setString(4,Endereco); 
                prepared.setInt(5,TelefoneFixo); 
                prepared.setInt(6,TelefoneCelular); 
                prepared.setString(7,NomeAutorizado); 
                prepared.setInt(8,TelefoneAutorizado); 
                prepared.setDouble(9,saldo); 
                prepared.execute();
                JOptionPane.showMessageDialog(null,"Cadastro Realizado!");
		close();                
	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Inserção nao foi feita. Erro : "+e.getMessage());
		// Fechando a conexão com o banco
		close();
               
	}
    }  
    
    public ResultSet pesquisa(String sql) throws SQLException{   
            open(); 
            System.out.println(sql);
            try{           
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);                              
                conn.close();
             return rs;
            }
            catch(NullPointerException e){
               JOptionPane.showMessageDialog(null,"Erro Ponteiro"+e.getMessage());
            }
            return null;
    }
    
    public String LocaFilme(String sql) throws SQLException{
            open(); 
            try{           
                rs = stmt.executeQuery(sql); 
                rs.next();
                String status;
                status = rs.getString(1);
                conn.close();
                return status;
            }
            catch(NullPointerException e){
               JOptionPane.showMessageDialog(null,"Erro Ponteiro"+e.getMessage());
               conn.close();
            }
            return "";            
    }
    public void Altera(String sql) throws SQLException{
            open(); 
            try{           
                stmt.executeUpdate(sql);
                conn.close();
                JOptionPane.showMessageDialog(null,"Informação alterada");
            }
            catch(NullPointerException e){
               JOptionPane.showMessageDialog(null,"Erro Ponteiro"+e.getMessage());
               conn.close();
            }
    }
}



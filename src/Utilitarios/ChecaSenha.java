/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import Interface.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrianne
 */
public class ChecaSenha extends Login{
    
    public ChecaSenha(String Login,String Senha){
        super(Login,Senha);
    }
    
    public int Checa(){
        if(Login.equals("Gerente") && Senha.equals("Gerente123")){
           JOptionPane.showMessageDialog(null,"Login Efetuado!");
           return 1;
        }
        else{
            if(Login.equals("Funcionario")&& Senha.equals("Funcionario123")){
                JOptionPane.showMessageDialog(null,"Login Efetuado!");
                return 2;
            }
            else{
                JOptionPane.showMessageDialog(null,"Senha ou Login Errados");
                return 0;
            }
        }
      
    }
    
    
    
}

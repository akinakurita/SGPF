/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author leo
 */
public class FornecedorDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGPFPU");
    EntityManager em = emf.createEntityManager();
    
    public List obterFornecedor(){
        Query qry = em.createQuery("SELECT c FROM Fornecedor c");
        
        List<Fornecedor> listaDeFornecedores = qry.getResultList();
        
        return listaDeFornecedores;
    }
    
    public Fornecedor recuperaFornecedor(int pk){
        try{
            return  em.find(Fornecedor.class, pk);  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, ("Fornecedor não encontrado " + e.getMessage()), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        }   
                
    }
        
    
    public void salvarFornecedor(Fornecedor fornecedor){
        
        try{
            em.getTransaction().begin();
            em.persist(fornecedor);
            em.getTransaction().commit();            
            
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, ("Erro ao salvar: " + e.getMessage()), "ERRO", JOptionPane.ERROR_MESSAGE);
            
            
        }
        
    }
    
    public void removerFornecedor(Fornecedor fornecedor){
        try{
            em.getTransaction().begin();
            em.remove(fornecedor);
            em.getTransaction().commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, ("Erro ao remover: " + e.getMessage()), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void atualizarFornecedor(int pk, String nome, String razao, String endereco, String cpfcnpj, String telefone, String email){
        try{
            Fornecedor fornecedor = this.recuperaFornecedor(pk);
            em.getTransaction().begin();
            fornecedor.setNomeFantasia(nome);
            fornecedor.setRazaoSocial(razao);
            fornecedor.setEnderecoPessoa(endereco);
            fornecedor.setCpfcnpj(cpfcnpj);
            fornecedor.setTelefonePessoa(telefone);
            fornecedor.setEmailPessoa(email);
            em.getTransaction().commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, ("Erro ao atualizar: " + e.getMessage()), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

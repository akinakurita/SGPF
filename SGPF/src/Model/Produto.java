/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.*;


/**
 *
 * @author akina
 */

@Entity 
@Table(name = "PRODUTO")

public class Produto {
   
   @Id
   @GeneratedValue (strategy = GenerationType.AUTO)
   private int IdProduto;
   
   @Column(length = 100, name = "NOME_PRODUTO", nullable = false)
   private String NomeProduto;
   
   @Column(length = 32, name = "QUANT_PRODUTO", nullable = true)
   private Double Quantidade;
   
   @Column (length = 10, name = "UNIDADE_PRODUTO", nullable = true)
   @Enumerated(EnumType.STRING)
   private Unidade UnidadeProduto;
   
   

    public Produto() {
        
    }
  

    public int getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(int IdProduto) {
        this.IdProduto = IdProduto;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String NomeProduto) {
        this.NomeProduto = NomeProduto;
    }

    public Double getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Double Quantidade) {
        this.Quantidade = Quantidade;
    }

    public Unidade getUnidadeProduto() {
        return UnidadeProduto;
    }

    public void setUnidadeProduto(Unidade UnidadeProduto) {
        this.UnidadeProduto = UnidadeProduto;
    }
 
    
}

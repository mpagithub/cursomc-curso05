package com.mpa.cursomc.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mpa.cursomc.domain.enums.TipoCliente;


@SuppressWarnings("serial")
@Entity
public class Cliente extends AbstractEntity<Integer> {

	private String nome;
	private String email;
	private String cpfOuCpnj;
	private Integer tipo;
	
	// OBS.:  Essa classe grava um integer para o tipo de cliente, mas expoem para o mundo, um enum TipoCliente, getTipo() retorna um TipoCliente
	
	
	//@JsonManagedReference
	/* Quando se tem relacionamentos bidirecionais, pode ocorrer o problema de referência cíclica, quando vc busca um cliente, a busca
	   tenta trazer a lista de endereços dele, só que cada endereço tbm faz referencia a um cliente. Gera erro  - Expected ',' instead of ''  -- ~[jackson-databind-;
	   Para que os endereços sejam serializados ao pesquisar um cliente, sem que aconteça referência cíclica, use @JsonManagedReference.
	   Do outro lado vc deve anotar como @JsonBackReference
	   
       JsonManagedReference indica que o atributo deve ser serializado
       JsonBackReference cria uma dependência lógica do atributo, mas não o serializa.
	 */

	@OneToMany(mappedBy="cliente")
	private List<Endereco> enderecos = new ArrayList<>();
		
	
	@ElementCollection                  // Para que o JPA crie a tabela no banco com base na collection abaixo
	@CollectionTable(name="TELEFONE")   // Define o nome da tabela que será criada no banco 
	private Set<String> telefones = new HashSet<>();  // Set é um conjunto, e conjunto não permite valores repetidos.
	// Como a telefone no diagrama refere-se a uma entidade fraca, não tem nem id, totalmente dependente da tabela cliente, pode se fazer conforme acima...
	
	
	//@JsonBackReference   // Os pedidos de um cliente não serão serializados porque os clientes de um pedido serão
	@JsonIgnore
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	
	
	public Cliente() {}
	
	
	public Cliente(Integer id, String nome, String email, String cpfOuCpnj, TipoCliente tipo) {
		super();
		this.setId(id);
		this.nome = nome;
		this.email = email;
		this.cpfOuCpnj = cpfOuCpnj;
		this.tipo = tipo.getCod();
	}




	public Set<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfOuCpnj() {
		return cpfOuCpnj;
	}
	public void setCpfOuCpnj(String cpfOuCpnj) {
		this.cpfOuCpnj = cpfOuCpnj;
	}
	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	
}

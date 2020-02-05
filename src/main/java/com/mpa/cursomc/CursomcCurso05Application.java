package com.mpa.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mpa.cursomc.domain.Categoria;
import com.mpa.cursomc.domain.Cidade;
import com.mpa.cursomc.domain.Cliente;
import com.mpa.cursomc.domain.Endereco;
import com.mpa.cursomc.domain.Estado;
import com.mpa.cursomc.domain.Pagamento;
import com.mpa.cursomc.domain.PagamentoComBoleto;
import com.mpa.cursomc.domain.PagamentoComCartao;
import com.mpa.cursomc.domain.Pedido;
import com.mpa.cursomc.domain.Produto;
import com.mpa.cursomc.domain.enums.EstadoPagamento;
import com.mpa.cursomc.domain.enums.TipoCliente;
import com.mpa.cursomc.repositories.CategoriaRepository;
import com.mpa.cursomc.repositories.CidadeRepository;
import com.mpa.cursomc.repositories.ClienteRepository;
import com.mpa.cursomc.repositories.EnderecoRepository;
import com.mpa.cursomc.repositories.EstadoRepository;
import com.mpa.cursomc.repositories.PagamentoRepository;
import com.mpa.cursomc.repositories.PedidoRepository;
import com.mpa.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcCurso05Application implements CommandLineRunner{   
	// CommandLineRunner  vai rodar o metodo run, no momento da inicializacao 

	@Autowired
	private CategoriaRepository catRep;
	
	@Autowired
	private ProdutoRepository prodRep;

	@Autowired
	private EstadoRepository estRep;

	@Autowired
	private CidadeRepository cidRep;
	
	@Autowired
	private ClienteRepository cliRep;

	@Autowired
	private EnderecoRepository endRep;

	@Autowired
	private PedidoRepository pedRep;
	
	@Autowired
	private PagamentoRepository pagRep;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcCurso05Application.class, args);
	}

	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().add(p2);
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().add(cat1);
				
		catRep.saveAll(Arrays.asList(cat1,cat2));
		prodRep.saveAll(Arrays.asList(p1,p2,p3));
		
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estRep.saveAll(Arrays.asList(est1,est2));
		cidRep.saveAll(Arrays.asList(c1,c2,c3));
		
		
		
		Cliente cli1 = new Cliente(null,"Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(null,"Rua Flores", "300","Apto 203", "Jardim", "38220834",cli1, c1);
		Endereco e2 = new Endereco(null,"Avenida Matos", "105","Sala 800", "Centro", "38777012",cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		cliRep.saveAll(Arrays.asList(cli1));
		endRep.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1 );  
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2 );
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2017 00:00"),null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedRep.saveAll(Arrays.asList(ped1,ped2));
		pagRep.saveAll(Arrays.asList(pagto1,pagto2));
		
		
	}

	
	
	
	
}

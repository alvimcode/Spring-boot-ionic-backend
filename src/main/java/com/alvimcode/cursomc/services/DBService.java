package com.alvimcode.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvimcode.cursomc.domain.Categoria;
import com.alvimcode.cursomc.domain.Cidade;
import com.alvimcode.cursomc.domain.Cliente;
import com.alvimcode.cursomc.domain.Endereco;
import com.alvimcode.cursomc.domain.Estado;
import com.alvimcode.cursomc.domain.ItemPedido;
import com.alvimcode.cursomc.domain.Pagamento;
import com.alvimcode.cursomc.domain.PagamentoComBoleto;
import com.alvimcode.cursomc.domain.PagamentoComCartao;
import com.alvimcode.cursomc.domain.Pedido;
import com.alvimcode.cursomc.domain.Produto;
import com.alvimcode.cursomc.enums.EstadoPagamento;
import com.alvimcode.cursomc.enums.TipoCliente;
import com.alvimcode.cursomc.repositories.CategoriaRepository;
import com.alvimcode.cursomc.repositories.CidadeRepository;
import com.alvimcode.cursomc.repositories.ClienteRepository;
import com.alvimcode.cursomc.repositories.EnderecoRepository;
import com.alvimcode.cursomc.repositories.EstadoRepository;
import com.alvimcode.cursomc.repositories.ItemPedidoRepository;
import com.alvimcode.cursomc.repositories.PagamentoRepository;
import com.alvimcode.cursomc.repositories.PedidoRepository;
import com.alvimcode.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public void instantiateTestDatabase() throws ParseException {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "cama");
		Categoria cat4 = new Categoria(null, "mesa");
		Categoria cat5 = new Categoria(null, "eletronicos");
		Categoria cat6 = new Categoria(null, "home");
		Categoria cat7 = new Categoria(null, "conzinha");
		Categoria cat8 = new Categoria(null, "sala de estar");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de Escritorio", 300.00);
		Produto p5 = new Produto(null, "Toalha", 30.00);
		Produto p6 = new Produto(null, "Colcha", 50.00);
		Produto p7 = new Produto(null, "Tv true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 94.00);
		Produto p9 = new Produto(null, "Abaju", 56.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 4000.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p3, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat3));
		p8.getCategorias().addAll(Arrays.asList(cat4));
		p9.getCategorias().addAll(Arrays.asList(cat5));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		Estado est1 = new Estado(null, "minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "uberlandia", est1);
		Cidade c2 = new Cidade(null, "São paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Alvim lopes", "alvim.lopez@gmail.com", "367859647815", TipoCliente.PESSOAFISICA,
				null, null);
		cli1.getTelefones().addAll(Arrays.asList("8956781", "61992957419"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apt 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Brasilia", "150", "Apt 004", "pedro silva", "5897452", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2018 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2018 19:00"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}

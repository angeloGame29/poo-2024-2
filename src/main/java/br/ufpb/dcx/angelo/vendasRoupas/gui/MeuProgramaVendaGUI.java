package br.ufpb.dcx.angelo.vendasRoupas.gui;

import br.ufpb.dcx.angelo.vendasRoupas.SistemaVendas;
import br.ufpb.dcx.angelo.vendasRoupas.SistemaVendasDeRoupas;

import javax.swing.*;
import java.awt.*;

public class MeuProgramaVendaGUI extends JFrame {
    SistemaVendas sistema = new SistemaVendasDeRoupas();
    JMenuBar menuBarra = new JMenuBar();
    public MeuProgramaVendaGUI (){
        //=========================[ JANELA PRINCIPAL ]==================================
        setTitle("MENU DE VENDAS");
        setSize(600,550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#4b4452"));
        setLayout(null);

        //============================[ ELEMENTOS ]===============================
        JMenu menuGestao = new JMenu("GERENCIAMENTO");
        JMenuItem itemCadastrarProduto = new JMenuItem("Cadastrar Produto");
        menuGestao.add(itemCadastrarProduto);
        JMenuItem itemCadastrarVenda = new JMenuItem("Cadastrar Venda");
        menuGestao.add(itemCadastrarVenda);
        JMenuItem itemFecharPrograma = new JMenuItem("Fechar Programa");
        menuGestao.add(itemFecharPrograma);

        JMenu menuConsulta = new JMenu("CONSULTA");
        JMenuItem pesquisaProduto = new JMenuItem("Pesquisar Todos os Produtos");
        menuConsulta.add(pesquisaProduto);
        JMenuItem pesquisaVendas = new JMenuItem("Pesquisar Todas as Vendas");
        menuConsulta.add(pesquisaVendas);
        JMenuItem pesquisaDescricao = new JMenuItem("Pesquisar Descrição do Produto");
        menuConsulta.add(pesquisaDescricao);

        JMenu menuOperacao = new JMenu("OPERAÇÕES");
        JMenuItem contaVendasProduto = new JMenuItem("Contar Quantidade de Vendas de um Produto");
        menuOperacao.add(contaVendasProduto);
        JMenuItem calculaValorTotal = new JMenuItem("Obter Valor Total das Vendas do Mês");
        menuOperacao.add(calculaValorTotal);

        JMenu menuSistema = new JMenu("SISTEMA");
        JMenuItem existeProduto = new JMenuItem("Verificar se um Produto Existe");
        menuSistema.add(existeProduto);
        JMenuItem existeVenda = new JMenuItem("Verificar se Existe Venda de um Produto");
        menuSistema.add(existeVenda);
        //===================[ ESTILIZAÇÃO DOS ELEMENTOS ]========================================

        //======================[ AÇÕES DOS ELEMENTOS ]=====================================

        //========================[ ADD ELEMENTOS ]===================================
        setJMenuBar(menuBarra);
        menuBarra.add(menuGestao);
        menuBarra.add(menuConsulta);
        menuBarra.add(menuOperacao);
        menuBarra.add(menuSistema);
    }
}

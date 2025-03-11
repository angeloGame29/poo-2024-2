package br.ufpb.dcx.angelo.vendasRoupas.gui;

import br.ufpb.dcx.angelo.vendasRoupas.SistemaVendas;
import br.ufpb.dcx.angelo.vendasRoupas.SistemaVendasDeRoupas;

import javax.swing.*;
import java.awt.*;

public class MeuProgramaVendaGUI extends JFrame {
    SistemaVendas sistema = new SistemaVendasDeRoupas();
    JMenuBar menuBarra = new JMenuBar();
    JButton btnCadastrar, btnPesquisar, btnCalcularVendas, btnVerificarProduto;

    public MeuProgramaVendaGUI (){
        //=========================[ JANELA PRINCIPAL ]==================================
        setTitle("MENU DE VENDAS");
        setSize(600,550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#4b4452"));
        setLayout(new BorderLayout());

        //============================[ ELEMENTOS ]===============================
        JMenu menuGestao = new JMenu("GERENCIAMENTO");
        JMenuItem itemCadastrarProduto = new JMenuItem("Cadastrar Produto");
        JMenuItem itemCadastrarVenda = new JMenuItem("Cadastrar Venda");
        JMenuItem itemFecharPrograma = new JMenuItem("Fechar Programa");
        menuGestao.add(itemCadastrarProduto);
        menuGestao.add(itemCadastrarVenda);
        menuGestao.add(itemFecharPrograma);

        JMenu menuConsulta = new JMenu("CONSULTA");
        JMenuItem pesquisaProduto = new JMenuItem("Pesquisar Todos os Produtos");
        JMenuItem pesquisaVendas = new JMenuItem("Pesquisar Todas as Vendas");
        JMenuItem pesquisaDescricao = new JMenuItem("Pesquisar Descrição do Produto");
        menuConsulta.add(pesquisaProduto);
        menuConsulta.add(pesquisaVendas);
        menuConsulta.add(pesquisaDescricao);

        JMenu menuOperacao = new JMenu("OPERAÇÕES");
        JMenuItem contaVendasProduto = new JMenuItem("Contar Quantidade de Vendas de um Produto");
        JMenuItem calculaValorTotal = new JMenuItem("Obter Valor Total das Vendas do Mês");
        menuOperacao.add(contaVendasProduto);
        menuOperacao.add(calculaValorTotal);

        JMenu menuSistema = new JMenu("SISTEMA");
        JMenuItem existeProduto = new JMenuItem("Verificar se um Produto Existe");
        JMenuItem existeVenda = new JMenuItem("Verificar se Existe Venda de um Produto");
        menuSistema.add(existeProduto);
        menuSistema.add(existeVenda);

        btnCadastrar = new JButton("CADASTRAR");
        btnCadastrar.setFocusable(false);
        btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnCalcularVendas = new JButton("CALCULAR");
        btnCalcularVendas.setFocusable(false);
        btnCalcularVendas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnPesquisar = new JButton("PESQUISAR");
        btnPesquisar.setFocusable(false);
        btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnVerificarProduto = new JButton("VERIFICAR");
        btnVerificarProduto.setFocusable(false);
        btnVerificarProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JToolBar toolPesquisar = new JToolBar();
        JLabel lblPesquisar = new JLabel("PESQUISAR: ");
        JTextField txtPesquisar = new JTextField(20);
        toolPesquisar.add(lblPesquisar);
        toolPesquisar.add(txtPesquisar);
        toolPesquisar.setFloatable(false);

        //===================[ ESTILIZAÇÃO DOS ELEMENTOS ]========================================

        //======================[ AÇÕES DOS ELEMENTOS ]=====================================

        //========================[ ADD ELEMENTOS ]===================================
        setJMenuBar(menuBarra);
        menuBarra.add(menuGestao);
        menuBarra.add(menuConsulta);
        menuBarra.add(menuOperacao);
        menuBarra.add(menuSistema);

        this.add(toolPesquisar,BorderLayout.PAGE_START);
        this.add(btnCadastrar,BorderLayout.WEST);
        this.add(btnCalcularVendas,BorderLayout.CENTER);
        this.add(btnPesquisar,BorderLayout.EAST);
        this.add(btnVerificarProduto,BorderLayout.AFTER_LINE_ENDS);
    }
}

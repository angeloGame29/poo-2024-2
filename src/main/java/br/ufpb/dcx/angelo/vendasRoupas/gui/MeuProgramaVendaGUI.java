package br.ufpb.dcx.angelo.vendasRoupas.gui;

import br.ufpb.dcx.angelo.vendasRoupas.SistemaVendas;
import br.ufpb.dcx.angelo.vendasRoupas.SistemaVendasDeRoupas;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MeuProgramaVendaGUI extends JFrame {
    SistemaVendas sistema = new SistemaVendasDeRoupas();
    JMenuBar menuBarra = new JMenuBar();
    JButton btnCadastrar, btnPesquisar, btnCalcularVendas, btnVerificarProduto,btnSair;

    public MeuProgramaVendaGUI (){
        //=========================[ JANELA PRINCIPAL ]==================================
        setTitle("MENU DE VENDAS");
        setSize(600,550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#4b4452"));
        setLayout(new GridLayout(5,1, 10,10));
//        setLayout(new BorderLayout());

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

        btnCalcularVendas = new JButton("CALCULAR");

        btnPesquisar = new JButton("PESQUISAR");

        btnVerificarProduto = new JButton("VERIFICAR");

        btnSair = new JButton("SAIR");

        JToolBar toolPesquisar = new JToolBar();
        JLabel lblPesquisar = new JLabel("          PESQUISAR: ");
        JTextField txtPesquisar = new JTextField(20);
        toolPesquisar.add(lblPesquisar);
        toolPesquisar.add(txtPesquisar);
        toolPesquisar.setFloatable(false);

        //===================[ ESTILIZAÇÃO DOS ELEMENTOS ]========================================
        btnCadastrar.setBackground(Color.decode("#487d76"));
        btnCadastrar.setForeground(Color.decode("#e8da5e"));
        btnCadastrar.setFont(new Font("Serif",Font.BOLD,23));
        btnCadastrar.setFocusable(false);
        btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnCalcularVendas.setBackground(Color.decode("#487d76"));
        btnCalcularVendas.setForeground(Color.decode("#e8da5e"));
        btnCalcularVendas.setFont(new Font("Serif",Font.BOLD,23));
        btnCalcularVendas.setFocusable(false);
        btnCalcularVendas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnPesquisar.setBackground(Color.decode("#487d76"));
        btnPesquisar.setForeground(Color.decode("#e8da5e"));
        btnPesquisar.setFont(new Font("Serif",Font.BOLD,23));
        btnPesquisar.setFocusable(false);
        btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnVerificarProduto.setBackground(Color.decode("#487d76"));
        btnVerificarProduto.setForeground(Color.decode("#e8da5e"));
        btnVerificarProduto.setFont(new Font("Serif",Font.BOLD,23));
        btnVerificarProduto.setFocusable(false);
        btnVerificarProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnSair.setBackground(Color.decode("#487d76"));
        btnSair.setForeground(Color.decode("#e8da5e"));
        btnSair.setFont(new Font("Serif",Font.BOLD,23));
        btnSair.setFocusable(false);
        btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        menuBarra.setBackground(Color.decode("#487d76"));
        menuBarra.setBorder(null);
        toolPesquisar.setBackground(Color.decode("#487d76"));
        lblPesquisar.setForeground(Color.decode("#e8da5e"));
        menuGestao.setForeground(Color.decode("#e8da5e"));
        menuConsulta.setForeground(Color.decode("#e8da5e"));
        menuOperacao.setForeground(Color.decode("#e8da5e"));
        menuSistema.setForeground(Color.decode("#e8da5e"));

        //======================[ AÇÕES DOS ELEMENTOS ]=====================================

        //========================[ ADD ELEMENTOS ]===================================
        setJMenuBar(menuBarra);
        menuBarra.add(menuGestao);
        menuBarra.add(menuConsulta);
        menuBarra.add(menuOperacao);
        menuBarra.add(menuSistema);
        menuBarra.add(toolPesquisar);

        this.add(btnCadastrar);
        this.add(btnCalcularVendas);
        this.add(btnPesquisar);
        this.add(btnVerificarProduto);
        this.add(btnSair);
    }
}

package br.ufpb.dcx.angelo.vendasRoupas.controller;

import br.ufpb.dcx.angelo.vendasRoupas.Produto;
import br.ufpb.dcx.angelo.vendasRoupas.SistemaVendas;
import br.ufpb.dcx.angelo.vendasRoupas.Venda;
import br.ufpb.dcx.angelo.vendasRoupas.gui.MeuProgramaVendaGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendaCadastraProdutoController extends JDialog implements ActionListener {
    private SistemaVendas sistema;
    private MeuProgramaVendaGUI meuPrograma;

    public VendaCadastraProdutoController (SistemaVendas sistema, MeuProgramaVendaGUI meuPrograma){
        this.sistema = sistema;
        this.meuPrograma = meuPrograma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dlgCadastrar = new JDialog(this,"", true);
        dlgCadastrar.setSize(600,550);
        dlgCadastrar.setLocationRelativeTo(null);
        dlgCadastrar.getContentPane().setBackground(Color.decode("#4b4452"));

        JLabel lblCodigo, lblDescricao;
        Button btnCadastrar;





        dlgCadastrar.setVisible(true);
    }
}

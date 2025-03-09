package br.ufpb.dcx.angelo.vendasRoupas.gui;

import javax.swing.*;
import java.awt.*;

public class TelaDeLoginVendaGUI extends JFrame {
    JLabel imagemDeLogin, tituloJanela;
    ImageIcon imgRoupa = new ImageIcon("./img/imgsVenda/imgInicio.png");

    public TelaDeLoginVendaGUI(){
        //=========================[ JANELA PRINCIPAL ]==================================
        setTitle("JANELA DE LOGIN");
        setSize(600,550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#4b4452"));
        setLayout(null);


        //=========================[ ELEMENTOS ]==================================
        Image imagemMod = imgRoupa.getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH);
        ImageIcon novaImagem = new ImageIcon(imagemMod);
        imagemDeLogin = new JLabel(novaImagem);
        tituloJanela = new JLabel("ENTRAR NO MENU VENDAS");
        JLabel lblUsuario = new JLabel("USUÁRIO:");
        JLabel lblSenha = new JLabel("SENHA:");
        JTextField txtUsuario = new JTextField("angelo");
        JPasswordField pwdSenha = new JPasswordField();
        JButton btnEntrar = new JButton("ENTRAR");

        //=========================[ ESTILIZAÇÃO DOS ELEMENTOS ]==================================
        imagemDeLogin.setBounds(10,125,250,250);

        tituloJanela.setBounds(260,100,350,50);
        tituloJanela.setFont(new Font("Serif",Font.BOLD,22));
        tituloJanela.setForeground(Color.decode("#92b55f"));

        lblUsuario.setBounds(300,210,120,20);
        lblUsuario.setForeground(Color.decode("#92b55f"));

        txtUsuario.setBounds(360, 210, 180,20);
        txtUsuario.setBackground(Color.decode("#487d76"));
        txtUsuario.setForeground(Color.decode("#e8da5e"));
        txtUsuario.setBorder(null);

        lblSenha.setBounds(313,240,100,20);
        lblSenha.setForeground(Color.decode("#92b55f"));

        pwdSenha.setBounds(360,240,180,20);
        pwdSenha.setBackground(Color.decode("#487d76"));
        pwdSenha.setForeground(Color.decode("#e8da5e"));
        pwdSenha.setBorder(null);

        btnEntrar.setBounds(300,280,240,25);
        btnEntrar.setBackground(Color.decode("#487d76"));
        btnEntrar.setForeground(Color.decode("#e8da5e"));
        btnEntrar.setFont(new Font("Serif",Font.BOLD,15));
        btnEntrar.setFocusable(false);
        btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //=========================[ AÇÕES DA JANELA ]==================================
        btnEntrar.addActionListener(evt -> {
            String usuario = txtUsuario.getText().trim();
            String senha = String.valueOf(pwdSenha.getPassword());

            if(usuario.equals("angelo") && senha.equals("angelo123")){
                MeuProgramaVendaGUI meuPrograma = new MeuProgramaVendaGUI();
                this.dispose();
                meuPrograma.setVisible(true);
            } else if (usuario.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Por favor, preencha todos os campos");
            } else{
                JOptionPane.showMessageDialog(this,"Nome de usuário ou senha inválido(a)");
            }
        });

        //=========================[ ADD ELEMENTOS ]==================================
        add(imagemDeLogin);
        add(tituloJanela);
        add(lblUsuario);
        add(lblSenha);
        add(txtUsuario);
        add(pwdSenha);
        add(btnEntrar);
    }
    public static void main(String [] args){
        JFrame janelaVendas = new TelaDeLoginVendaGUI();
        janelaVendas.setVisible(true);
        janelaVendas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

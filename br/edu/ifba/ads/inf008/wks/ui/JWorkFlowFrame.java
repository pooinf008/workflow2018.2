package br.edu.ifba.ads.inf008.wks.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.ifba.ads.inf008.wks.sessao.AppProjeto;
import br.edu.ifba.ads.inf008.wks.sessao.AppProjetoIF;


public class JWorkFlowFrame extends JFrame implements ActionListener{
	
	public JButton btnOk;
	private JLabel lblId;
	private JLabel lblDesc;
	private JLabel lblDuracao;
	private JTextField txtId;
	private JTextField txtDesc;
	private JTextField txtDuracao;
	private AppProjetoIF app;	
	
	
	public JWorkFlowFrame() throws HeadlessException, ClassNotFoundException, IOException, SQLException {
		super();
		this.app = new AppProjeto();
		this.asm();
	}

	public void asm() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 2));
		this.lblId = new JLabel("Id: ");
		this.lblDesc = new JLabel("Descricao: ");
		this.lblDuracao= new JLabel("Duracao: ");
		this.txtId = new JTextField();
		this.txtDesc = new JTextField();
		this.txtDuracao = new JTextField();
		center.add(lblId); center.add(txtId);
		center.add(lblDesc); center.add(txtDesc);
		center.add(lblDuracao); center.add(txtDuracao);
		this.setSize(500, 300);
		this.setTitle("WorkFlow");
		this.getContentPane().setLayout(new BorderLayout());
		this.btnOk = new JButton("OK");
		this.btnOk.addActionListener(this);
		this.getContentPane().add(btnOk, BorderLayout.SOUTH);
		this.getContentPane().add(center, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	private void showInfo() throws NumberFormatException, Exception {
		String message =  this.txtId.getText() + ": " + this.txtDesc.getText() + ": " + this.txtDuracao.getText();
		this.app.addAtividade(this.txtId.getText(), 
				this.txtDesc.getText(), 
				Integer.parseInt(this.txtDuracao.getText())); 
		JOptionPane.showMessageDialog(this, message, "CLICK DO BOTÃO", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void main(String[] args) throws Exception, ClassNotFoundException, IOException, SQLException {
		JWorkFlowFrame jwff = new JWorkFlowFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			this.showInfo();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

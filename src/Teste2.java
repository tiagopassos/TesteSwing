    import java.awt.Dimension;
    import java.awt.GridLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.ArrayList;
     
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;
    import javax.swing.JScrollPane;
    import javax.swing.JTable;
    import javax.swing.JTextField;
    import javax.swing.WindowConstants;
     
     
    public class Teste2 extends JFrame {
           
            private JTextField jtf_nome;
            private JTextField jtf_estado;
            private JTextField jtf_cidade;
            private JButton incluir;
            private JButton limpar;
           
            private JTable table;
            private JScrollPane jsp;
           
            private JPanel main;
            private JPanel dados;
            private JPanel tableDados;
           
            private ArrayList<Pessoa> p;
           
            public Teste2(){
                    super("Exemplo de Mable Model");
                    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    jtf_nome = new JTextField(15);
                    jtf_estado = new JTextField(15);
                    jtf_cidade = new JTextField(15);
                    incluir = new JButton("Incluir");
                    limpar = new JButton("Limpar");
                    main = new JPanel();
                    dados = new JPanel(new GridLayout(4, 2));
                    tableDados = new JPanel();
                    jsp = new JScrollPane();
                    p = new ArrayList<Pessoa>();
                    table= new JTable();
            }
           
            private void execute(){
                    adicionarListeners();
                    modelaTela();
            }
           
            private void adicionarListeners() {
                    incluir.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                    if(jtf_nome!=null && jtf_nome.getText().equals("")==true){
                                            JOptionPane.showMessageDialog(null, "Digite o nome");
                                    }
                                    else if(jtf_cidade!=null && jtf_cidade.getText().equals("")==true){
                                            JOptionPane.showMessageDialog(null, "Digite a cidade");
                                    }
                                    else if(jtf_estado!=null && jtf_estado.getText().equals("")==true){
                                            JOptionPane.showMessageDialog(null, "Digite o estado");
                                    }
                                    else{
                                            p.add(new Pessoa(jtf_nome.getText(), jtf_cidade.getText(), jtf_estado.getText()));
                                            limpar();
                                            listar();
                                    }
                            }
     
                           
                    });
                    limpar.addActionListener(new ActionListener() {
                           
                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                    limpar();
                            }
                    });
            }
           
            private void limpar() {
                    jtf_nome.setText("");
                    jtf_cidade.setText("");
                    jtf_estado.setText("");
                   
            }
           
            private void listar() {
                    table.setModel(new MinhaTableModel(new String[]{"Nome", "Cidade", "Estado"}, p.size(), 3));
                    for(int i=0; i<p.size(); i++){
                            table.setValueAt(p.get(i).getNome(), i, 0);
                            table.setValueAt(p.get(i).getCidade(), i, 1);
                            table.setValueAt(p.get(i).getEstado(), i, 2);
                    }
                   
                    jsp.setViewportView(table);
                    jsp.setAutoscrolls(true);
                    table.setAutoCreateRowSorter(true);
                   
            }
           
            private void modelaTela(){
                    dados.add(new JLabel("Nome:"));
                    dados.add(jtf_nome);
                    dados.add(new JLabel("Estado:"));
                    dados.add(jtf_estado);
                    dados.add(new JLabel("Cidade:"));
                    dados.add(jtf_cidade);
                    dados.add(incluir);
                    dados.add(limpar);
                    table.setModel(new MinhaTableModel(new String[]{"Nome", "Cidade", "Estado"}, 0, 3));
                    jsp.setViewportView(table);
                    tableDados.add(jsp);
                   
                    main.add(dados);
                    main.add(tableDados);
                   
                    this.setContentPane(main);
                    this.setSize(600,700);
                    this.setVisible(true);
            }
           
            public static void main(String[] args){
                    Teste2 t = new Teste2();
                    t.execute();
            }
    }

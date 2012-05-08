
      
    import java.awt.FlowLayout;  
      
    import javax.swing.JButton;  
    import javax.swing.JFrame;  
    import javax.swing.JLabel;  
    import javax.swing.JTextField;  
    import javax.swing.SwingUtilities;  
    import javax.swing.UIManager;  
      
    public class Teste1 extends JFrame {  
      
        // --> atributos  
        private static final long serialVersionUID = 1L;  
        private JLabel labelNome;  
        private JTextField textFieldNome;  
        private JButton buttonOk;  
      
        // --> construtor da classe  
        public Teste1() {  
            // --> muda o titulo e o leiaute  
            setTitle("Programa Swing1");  
            setLayout(new FlowLayout());  
            // --> instancia os componentes  
            labelNome = new JLabel("Nome: ");  
            textFieldNome = new JTextField(15);  
            buttonOk = new JButton("OK");  
            // --> adiciona os componentes a janela  
            add(labelNome);  
            add(textFieldNome);  
            add(buttonOk);  
            // --> ajusta o tamanho, a posicao e a acao ao fechar  
            pack();  
            setLocationRelativeTo(null);  
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
            // --> mostra a janela  
            setVisible(true);  
      
        }  
      
        // --> metodo main  
        public static void main(String[] args) {  
            // muda o LookAndFeel para parecer com uma aplicacao nativa  
            try {  
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
            // --> cria um novo objeto do tipo Swing1  
            // por causa da execucao multithreading da  
            // API swing,isso deve ser feito dessa forma:  
            SwingUtilities.invokeLater(new Runnable() {  
                public void run() {  
                    new Teste1();  
                }  
            });  
        }  
    }  
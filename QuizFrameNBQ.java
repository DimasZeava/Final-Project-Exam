package pkg;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuizFrameNBQ extends JFrame implements ActionListener{
    
    JFrame frame = new JFrame("NBQ (Quiz Belajar Bahasa Jepang)");
    JButton playQuiz;
    JLabel gambarNBQ = new JLabel();

    soundsNBQ sound = new soundsNBQ();

    QuizFrameNBQ(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(250, 250, 250));
        frame.setLayout(null);
        frame.setResizable(false);

        Image gambar = new ImageIcon(this.getClass().getResource("Nihon o Benkyou Quiz.jpg")).getImage();
		Image gambarEdit = gambar.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
		gambarNBQ.setIcon(new ImageIcon(gambarEdit));
		gambarNBQ.setBounds(175, 75, 300, 300);

        playQuiz = new JButton();
        playQuiz.setText("Mulai Quiz");
        playQuiz.setBounds(220,425,200,50);
        playQuiz.setBackground(new Color(220, 220, 220));
        playQuiz.addActionListener(this);

        frame.add(playQuiz);
        frame.add(gambarNBQ);
        frame.setVisible(true);

        playBGM(9);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == playQuiz){
            new QuizNBQ();
            frame.setVisible(false);
            sound.stop();
        }
    }
    public void playBGM(int i){

		sound.settingFile(i);
		sound.play();
		sound.loop();
	}
}

package pkg;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class QuizNBQ implements ActionListener {

	String[] pertanyaan = {
			"いますぐビールをのみますか？いいえ、おふろに　__ からのみます? Manakah jawaban yang tepat?",
			"りんご ___ みかんを買いました。Manakah jawaban yang tepat?",
			"このバスはゆうびんきょくのまえ　__ とおります。Manakah jawaban yang tepat?",
			"月よう日 ___ 火よう日にテストがあります。Manakah jawaban yang tepat?",
			"小川さん ___ おさけを飲みます。Manakah jawaban yang tepat?",
			"きのうは雨が __ かぜが __ しました。Manakah jawaban yang tepat?",
			"ここにじゅうしょを書いて　___ か？Manakah jawaban yang tepat?",
			"ドアが ___ 。Manakah jawaban yang tepat?",
			"もしもし、山本です ___ 、木下さんはいますか。Manakah jawaban yang tepat?",
			"家にいるよりここ　__ ほうがきけんですよ。Manakah jawaban yang tepat?",
			"まいあさ会社に __ まえにスポーツをします。Manakah jawaban yang tepat?"
	};
	String[][] pilihan = {
			{ "はいる", "はいり", "はいります", "はいって" },
			{ "が", "や", "は", "へ" },
			{ "で", "に", "へ", "を" },
			{ "で", "に", "を", "か" },
			{ "を", "しか", "だけ", "に" },
			{ "ふって/ふいて", "ふりて/ふきて", "ふりたり/ふきたり", "ふったり/ふいたり" },
			{ "ください", "くださいます", "くださいません", "くださいましょうか" },
			{ "しめます", "しめています", "しまっています", "しまってあります" },
			{ "が", "と", "て", "で" },
			{ "を", "な", "に", "の" },
			{ "行く", "行きます", "行った", "行って" }
	};
	char[] kunciJawaban = {
			'D',
			'B',
			'D',
			'D',
			'C',
			'D',
			'C',
			'C',
			'A',
			'D',
			'A'
	};
	int indeks;
	int jawabanBenar = 0;
	int totalPertanyaan = pertanyaan.length;
	int hasil;
	char jawaban;

	JFrame frame = new JFrame("NBQ (Quiz Belajar Bahasa Jepang)");
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton tombolA = new JButton();
	JButton tombolB = new JButton();
	JButton tombolC = new JButton();
	JButton tombolD = new JButton();
	JButton tombolMain = new JButton();
	JLabel jawaban_labelA = new JLabel();
	JLabel jawaban_labelB = new JLabel();
	JLabel jawaban_labelC = new JLabel();
	JLabel jawaban_labelD = new JLabel();
	JLabel gambarNBQ = new JLabel();
	JLabel randomGif = new JLabel();
	JTextField angkaBenar = new JTextField();
	JTextField persentase = new JTextField();

	soundsNBQ sound = new soundsNBQ();
	Timer timer = new Timer(1000, new ActionListener() {

		public void actionPerformed(ActionEvent e) {
				tampilkanJawaban();
		}
	});

	public QuizNBQ() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.getContentPane().setBackground(new Color(250, 250, 250));
		frame.setLayout(null);
		frame.setResizable(false);

		textfield.setBounds(0, 0, 650, 250);
		textfield.setBackground(new Color(238, 111, 87));
		textfield.setForeground(new Color(0, 0, 0));
		textfield.setFont(new Font("Autography", Font.BOLD, 50));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);

		textarea.setBounds(0, 250, 640, 50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(238, 111, 87));
		textarea.setForeground(new Color(0, 0, 0));
		textarea.setFont(new Font("Autography", Font.BOLD, 15));
		textarea.setEditable(false);

		Image gambar = new ImageIcon(this.getClass().getResource("Nihon o Benkyou Quiz.jpg")).getImage();
		Image gambarEdit = gambar.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		gambarNBQ.setIcon(new ImageIcon(gambarEdit));
		gambarNBQ.setBounds(0, 510, 100, 100);

		Image randomGifDancing = new ImageIcon(this.getClass().getResource("the-engineer.gif")).getImage();
		randomGif.setIcon(new ImageIcon(randomGifDancing));
		randomGif.setBounds(325, 500, 100, 100);

		tombolA.setBounds(175, 325, 50, 50);
		tombolA.setFont(new Font("MV Boli", Font.BOLD, 15));
		tombolA.setFocusable(false);
		tombolA.addActionListener(this);
		tombolA.setText("A");

		tombolB.setBounds(175, 380, 50, 50);
		tombolB.setFont(new Font("MV Boli", Font.BOLD, 15));
		tombolB.setFocusable(false);
		tombolB.addActionListener(this);
		tombolB.setText("B");

		tombolC.setBounds(175, 435, 50, 50);
		tombolC.setFont(new Font("MV Boli", Font.BOLD, 15));
		tombolC.setFocusable(false);
		tombolC.addActionListener(this);
		tombolC.setText("C");

		tombolD.setBounds(175, 490, 50, 50);
		tombolD.setFont(new Font("MV Boli", Font.BOLD, 15));
		tombolD.setFocusable(false);
		tombolD.addActionListener(this);
		tombolD.setText("D");

		jawaban_labelA.setBounds(245, 300, 500, 100);
		jawaban_labelA.setBackground(new Color(50, 50, 50));
		jawaban_labelA.setForeground(new Color(0, 0, 0));
		jawaban_labelA.setFont(new Font("Autography", Font.PLAIN, 25));

		jawaban_labelB.setBounds(245, 355, 500, 100);
		jawaban_labelB.setBackground(new Color(50, 50, 50));
		jawaban_labelB.setForeground(new Color(0, 0, 0));
		jawaban_labelB.setFont(new Font("Autography", Font.PLAIN, 25));

		jawaban_labelC.setBounds(245, 410, 500, 100);
		jawaban_labelC.setBackground(new Color(50, 50, 50));
		jawaban_labelC.setForeground(new Color(0, 0, 0));
		jawaban_labelC.setFont(new Font("Autography", Font.PLAIN, 25));

		jawaban_labelD.setBounds(245, 465, 500, 100);
		jawaban_labelD.setBackground(new Color(50, 50, 50));
		jawaban_labelD.setForeground(new Color(0, 0, 0));
		jawaban_labelD.setFont(new Font("Autography", Font.PLAIN, 25));

		angkaBenar.setBounds(225, 265, 200, 100);
		angkaBenar.setBackground(new Color(250, 250, 250));
		angkaBenar.setForeground(new Color(25, 255, 0));
		angkaBenar.setFont(new Font("Ink Free", Font.BOLD, 50));
		angkaBenar.setBorder(BorderFactory.createBevelBorder(1));
		angkaBenar.setHorizontalAlignment(JTextField.CENTER);
		angkaBenar.setEditable(false);

		persentase.setBounds(225, 365, 200, 100);
		persentase.setBackground(new Color(250, 250, 250));
		persentase.setForeground(new Color(25, 255, 0));
		persentase.setFont(new Font("Ink Free", Font.BOLD, 50));
		persentase.setBorder(BorderFactory.createBevelBorder(1));
		persentase.setHorizontalAlignment(JTextField.CENTER);
		persentase.setEditable(false);

		frame.add(gambarNBQ);
		frame.add(jawaban_labelA);
		frame.add(jawaban_labelB);
		frame.add(jawaban_labelC);
		frame.add(jawaban_labelD);
		frame.add(tombolA);
		frame.add(tombolB);
		frame.add(tombolC);
		frame.add(tombolD);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);

		playBGM(9);

		nextQuestion();
	}

	public void nextQuestion() {
		if (indeks >= totalPertanyaan) {
			hasilSeluruh();

		} else {
			textfield.setText("Pertanyaan ke - " + (indeks + 1));
			textarea.setText(pertanyaan[indeks]);
			jawaban_labelA.setText(pilihan[indeks][0]);
			jawaban_labelB.setText(pilihan[indeks][1]);
			jawaban_labelC.setText(pilihan[indeks][2]);
			jawaban_labelD.setText(pilihan[indeks][3]);
		}
	}

	public void actionPerformed(ActionEvent e) {

		tombolA.setEnabled(false);
		tombolB.setEnabled(false);
		tombolC.setEnabled(false);
		tombolD.setEnabled(false);

		if (e.getSource() == tombolA) {
			jawaban = 'A';
			if (jawaban == kunciJawaban[indeks]) {
				jawabanBenar++;
				playSoundsEffect(6);
			}
		}
		if (e.getSource() == tombolB) {
			jawaban = 'B';
			if (jawaban == kunciJawaban[indeks]) {
				jawabanBenar++;
				playSoundsEffect(6);
			}
		}
		if (e.getSource() == tombolC) {
			jawaban = 'C';
			if (jawaban == kunciJawaban[indeks]) {
				jawabanBenar++;
				playSoundsEffect(6);
			}
		}
		if (e.getSource() == tombolD) {
			jawaban = 'D';
			if (jawaban == kunciJawaban[indeks]) {
				jawabanBenar++;
				playSoundsEffect(6);
			}
		}
		tampilkanJawaban();
	}

	public void tampilkanJawaban() {

		tombolA.setEnabled(false);
		tombolB.setEnabled(false);
		tombolC.setEnabled(false);
		tombolD.setEnabled(false);

		if (kunciJawaban[indeks] == 'A')
			jawaban_labelA.setForeground(new Color(25, 255, 0));
		if (kunciJawaban[indeks] == 'B')
			jawaban_labelB.setForeground(new Color(25, 255, 0));
		if (kunciJawaban[indeks] == 'C')
			jawaban_labelC.setForeground(new Color(25, 255, 0));
		if (kunciJawaban[indeks] == 'D')
			jawaban_labelD.setForeground(new Color(25, 255, 0));

		if (kunciJawaban[indeks] != 'A')
			jawaban_labelA.setForeground(new Color(255, 0, 0));
		playSoundsEffect(5);
		if (kunciJawaban[indeks] != 'B')
			jawaban_labelB.setForeground(new Color(255, 0, 0));
		playSoundsEffect(5);
		if (kunciJawaban[indeks] != 'C')
			jawaban_labelC.setForeground(new Color(255, 0, 0));
		playSoundsEffect(5);
		if (kunciJawaban[indeks] != 'D')
			jawaban_labelD.setForeground(new Color(255, 0, 0));
		playSoundsEffect(5);

		Timer pause = new Timer(2000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				jawaban_labelA.setForeground(new Color(0, 0, 0));
				jawaban_labelB.setForeground(new Color(0, 0, 0));
				jawaban_labelC.setForeground(new Color(0, 0, 0));
				jawaban_labelD.setForeground(new Color(0, 0, 0));

				jawaban = ' ';
				tombolA.setEnabled(true);
				tombolB.setEnabled(true);
				tombolC.setEnabled(true);
				tombolD.setEnabled(true);
				indeks++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}

	public void hasilSeluruh() {

		tombolA.setEnabled(false);
		tombolB.setEnabled(false);
		tombolC.setEnabled(false);
		tombolD.setEnabled(false);

		hasil = (int) ((jawabanBenar / (double) totalPertanyaan) * 100);

		if (jawabanBenar == 0) {
			playSoundsEffect(0);
		} else if (jawabanBenar > 0 && jawabanBenar < 4) {
			playSoundsEffect(7);
		} else if (jawabanBenar >= 4 && jawabanBenar < 6) {
			playSoundsEffect(8);
		} else if (jawabanBenar == 6) {
			playSoundsEffect(1);
		} else if (jawabanBenar > 6 && jawabanBenar < 9) {
			playSoundsEffect(2);
		} else if (jawabanBenar > 8 && jawabanBenar < 11) {
			playSoundsEffect(3);
		} else if (jawabanBenar == 11) {
			playSoundsEffect(4);
		}

		textfield.setText("Hasil Anda");
		textarea.setText("");
		jawaban_labelA.setText("");
		jawaban_labelB.setText("");
		jawaban_labelC.setText("");
		jawaban_labelD.setText("");

		angkaBenar.setText("(" + jawabanBenar + "/" + totalPertanyaan + ")");
		persentase.setText(hasil + "%");

		frame.add(angkaBenar);
		frame.add(persentase);
		frame.add(randomGif);

		tombolA.setVisible(false);
		tombolB.setVisible(false);
		tombolC.setVisible(false);
		tombolD.setVisible(false);

	}

	public void playSoundsEffect(int i) {

		sound.settingFile(i);
		sound.play();
	
	}

	public void playBGM(int i){

		sound.settingFile(i);
		sound.play();
		sound.loop();
	}
	
}

package petter.bjelm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;

public class GUI extends JFrame {

	private JPanel panel;
	private int i;
	private int lastRow = 0;
	private int rowX = 0;
	private int rowY = 0;
	private int setButtonsPerRows = 9;
	private int buttonCounter = 0;
	private ArrayList<String> anArray;
	private ArrayList<JButton> anArrayTwo;
	private ArrayList<String> URLArray;
	private GetCategory data;
	private ImageParsing imageParse;
	private JButton[] buttons;
	private JComboBox comboBox;
	private GetImgFromURL URLImage;

	private int buttonWidth = 100;
	private int buttonHeight = 100;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public GUI() {
		super("Add component on JFrame at runtime");

		anArray = new ArrayList<String>();
		anArrayTwo = new ArrayList<JButton>();
		URLArray = new ArrayList<String>();
		URLImage = new GetImgFromURL();
		imageParse = new ImageParsing();

		try {
			data = new GetCategory("", "");
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		JButton button = new JButton("Skaldjur");
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rowY = 0;
				lastRow = setButtonsPerRows;
				rowX = 30;
				buttonCounter = 0;
				data.setCategory("Skaldjur");
				// buttons = new JButton[0];

				if (buttons != null) {
					for (i = 0; i < buttons.length; i++) {

						panel.remove(buttons[i]);
						panel.revalidate();
						panel.repaint();

					}
				}

				try {
					anArray = data.getArray();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					URLArray = imageParse.getURLArray("Skaldjur");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				for (int i = 0; i < URLArray.size(); i++) {
					System.out.println(URLArray.get(i));
				}

				buttons = new JButton[anArray.size()];

				for (i = 0; i < buttons.length; i++) {

					buttons[i] = new JButton(anArray.get(i).replace('_', ' '));

					if (i == lastRow) {
						rowY = rowY + buttonHeight;
						lastRow = i + setButtonsPerRows;
						// System.out.println(rowY + " Y");

					} else {

					}

					// System.out.println(buttonCounter);
					if (buttonCounter == setButtonsPerRows) {
						buttonCounter = 0;

						buttons[i].setBounds(
								(buttonWidth * buttonCounter + 10), rowY,
								buttonWidth, buttonHeight);
					} else {

						buttons[i].setBounds(
								(buttonWidth * buttonCounter + 10), rowY,
								buttonWidth, buttonHeight);
					}

					buttonCounter++;
					// System.out.println(rowX);
					// buttons[i].setBounds((150*buttonCounter+10), rowY,
					// buttonWidth, buttonWidth);

					buttons[i].setActionCommand(anArray.get(i));

					buttons[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String choice = e.getActionCommand();
							JOptionPane.showMessageDialog(null,
									"You have clicked: " + choice);
						}
					});

					panel.add(buttons[i]);
					panel.revalidate();
					validate();
					panel.repaint();
				}

			}

		});

		String[] patternExamples = { "Januari", "Februari", "Mars", "April",
				"Maj", "Juni", "Juli", "Augusti", "September", "Oktober",
				"November", "December", };

		comboBox = new JComboBox(patternExamples);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = comboBox.getSelectedIndex();

				switch (index) {
				case 0:
					data.setDate("01");
					imageParse.setDate("01");
					break;
				case 1:
					data.setDate("02");
					imageParse.setDate("02");
					break;
				case 2:
					data.setDate("03");
					imageParse.setDate("03");
					break;
				case 3:
					data.setDate("04");
					imageParse.setDate("04");
					break;
				case 4:
					data.setDate("05");
					imageParse.setDate("05");
					break;
				case 5:
					data.setDate("06");
					imageParse.setDate("06");
					break;
				case 6:
					data.setDate("07");
					imageParse.setDate("07");
					break;
				case 7:
					data.setDate("08");
					imageParse.setDate("08");
					break;
				case 8:
					data.setDate("09");
					imageParse.setDate("09");
					break;
				case 9:
					data.setDate("10");
					imageParse.setDate("10");
					break;
				case 10:
					data.setDate("11");
					imageParse.setDate("11");
					break;
				case 11:
					data.setDate("12");
					imageParse.setDate("12");
					break;
				default:
					data.setDate("00");
					imageParse.setDate("00");
					break;
				}
			}
		});

		JButton buttonTwo = new JButton("Gr�nsaker");
		buttonTwo.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonTwo
				.setIcon(new ImageIcon(
						URLImage.getURLImage("http://upload.wikimedia.org/wikipedia/commons/6/6f/Cabbage_and_cross_section_on_white.jpg")));
		panel = new JPanel();
		panel.setBorder(null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																panel,
																GroupLayout.DEFAULT_SIZE,
																932,
																Short.MAX_VALUE)
														.addComponent(comboBox,
																0, 932,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				buttonTwo,
																				GroupLayout.DEFAULT_SIZE,
																				457,
																				Short.MAX_VALUE)
																		.addGap(18)
																		.addComponent(
																				button,
																				GroupLayout.DEFAULT_SIZE,
																				457,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								groupLayout
										.createSequentialGroup()
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																button,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																buttonTwo,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(comboBox,
												GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panel,
												GroupLayout.PREFERRED_SIZE,
												642, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setAutoCreateGaps(true);
		gl_panel.setAutoCreateContainerGaps(true);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGap(0, 736, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGap(0, 539, Short.MAX_VALUE));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		buttonTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rowY = 0;
				lastRow = setButtonsPerRows;
				rowX = 30;
				buttonCounter = 0;
				data.setCategory("Gr�nsaker");

				// buttons = new JButton[0];

				if (buttons != null) {
					for (i = 0; i < buttons.length; i++) {

						panel.remove(buttons[i]);
						panel.revalidate();
						panel.repaint();

					}
				}

				try {
					anArray = data.getArray();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					URLArray = imageParse.getURLArray("Gr�nsaker");
				} catch (Exception e6) {
					// TODO Auto-generated catch block
					e6.printStackTrace();
				}

				for (int i = 0; i < URLArray.size(); i++) {
					System.out.println(URLArray.get(i));
				}

				buttons = new JButton[anArray.size()];

				for (i = 0; i < buttons.length; i++) {

					buttons[i] = new JButton(anArray.get(i).replace('_', ' '));

					if (i == lastRow) {
						rowY = rowY + buttonHeight;
						lastRow = i + setButtonsPerRows;
						// System.out.println(rowY + " Y");

					} else {

					}

					// System.out.println(buttonCounter);
					if (buttonCounter == setButtonsPerRows) {
						buttonCounter = 0;

						buttons[i].setBounds(
								(buttonWidth * buttonCounter + 10), rowY,
								buttonWidth, buttonHeight);
					} else {

						buttons[i].setBounds(
								(buttonWidth * buttonCounter + 10), rowY,
								buttonWidth, buttonHeight);
					}

					buttonCounter++;
					// System.out.println(rowX);
					// buttons[i].setBounds((150*buttonCounter+10), rowY,
					// buttonWidth, buttonWidth);

					buttons[i].setActionCommand(anArray.get(i));

					buttons[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String choice = e.getActionCommand();
							JOptionPane.showMessageDialog(null,
									"You have clicked: " + choice);
						}
					});

					panel.add(buttons[i]);
					panel.revalidate();
					validate();
					panel.repaint();
				}

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(960, 768);
		setVisible(true);
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
}
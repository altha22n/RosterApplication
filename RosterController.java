import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This is the controller class It controls the functionality of the roster and
 * waitlist It also has all the GUI methods
 * 
 * @author Nada-Al-Thawr
 *
 */
public class RosterController extends JPanel implements ActionListener {
	/*
	 * Instantiante the variables
	 */
	JButton addButton;
	JButton dropButton;
	JTextField textArea;
	JLabel rosterLabel;
	JLabel waitListLabel;
	JPanel listPanel;
	JPanel rosterPanel;
	JPanel waitPanel;
	// create a roster and waitlist
	DoublyLinkedList<String> rosterList = new DoublyLinkedList<String>();
	DoublyLinkedList<String> waitList = new DoublyLinkedList<String>();

	/**
	 * controller calls super class
	 */
	public RosterController() {
		// calls super
		super(new BorderLayout());
		// call create display
		createDisplay();
	}

	public void createDisplay() {
		// create the main panel using gridlayout
		JPanel myPanel = new JPanel(new GridLayout(5, 1));
		// create the text panel
		JPanel textPanel = new JPanel(new GridLayout(1, 1));
		// button panelfor the buttons
		JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
		// title panel for the labels of the lists
		JPanel titlePanel = new JPanel(new GridLayout(1, 2));

		// create the labels for the waitinglist and roster list
		JLabel waitTitle = new JLabel("Waiting List");
		JLabel rosterTitle = new JLabel("Roster List");
		// add them both to the titlepanel
		titlePanel.add(rosterTitle);
		titlePanel.add(waitTitle);

		// create the add and drop buttons
		addButton = new JButton("Add");
		dropButton = new JButton("Drop");
		// create the textfield
		textArea = new JTextField("Write the name here..");

		// set the fonts and sizes of the text
		Font myFont = new Font("LucidaSans", Font.BOLD, 15);
		Font titleFont = new Font("LucidaSans", Font.BOLD, 20);
		Font textFont = new Font("LucidaSans", Font.PLAIN, 20);

		// set the fonts for the buttons, textfield and labels
		addButton.setFont(myFont);
		dropButton.setFont(myFont);
		rosterTitle.setFont(titleFont);
		waitTitle.setFont(titleFont);
		textArea.setFont(textFont);

		// add action listener
		addButton.addActionListener(this);
		dropButton.addActionListener(this);

		// add the buttons and textfield to the panel
		buttonsPanel.add(addButton);
		buttonsPanel.add(dropButton);
		textPanel.add(textArea);

		// add all the panels to the main panel
		myPanel.add(textPanel);
		myPanel.add(buttonsPanel);
		myPanel.add(titlePanel);
		// calling createListsPanel which retruns a JPanel
		myPanel.add(createListsPanel());

		// adding myPanel to be added to the frame
		// bc this class extends JPanel
		add(myPanel);

	}

	/**
	 * this method returns the panel that has the panels and labels of the lists
	 * 
	 * @return listPanel
	 */
	public JPanel createListsPanel() {
		// create the panels and use GridLayout
		listPanel = new JPanel(new GridLayout(1, 2));
		rosterPanel = new JPanel(new GridLayout(6, 1));
		waitPanel = new JPanel(new GridLayout(6, 1));

		// create the roster and waitlist labels
		rosterLabel = new JLabel();
		waitListLabel = new JLabel();
		// add the labels to the panels and the panels to the main panel
		rosterPanel.add(rosterLabel);
		waitPanel.add(waitListLabel);
		listPanel.add(rosterPanel);
		listPanel.add(waitPanel);
		// return the listPanel
		return listPanel;
	}

	/**
	 * this method adds names to the lists
	 */
	public void addNames() {
		// if the rosterList size is smaller than 6
		if (rosterList.size() < 6) {
			// get the text that was inputed
			String textInserted = textArea.getText();
			// use insert first to insert in the roster list
			rosterList.insertFirst(textInserted);
			// System.out.println("this is the text: " + textInserted);
			// set the current node as the head of the roster list
			DoublyLinkedListNode<String> currentNode = (DoublyLinkedListNode<String>) rosterList.head;
			// update the panel
			rosterPanel.removeAll();
			// while current node is not null
			while (currentNode != null) {
				// create a new JLabel and put the data of the current node
				JLabel namesLabel = new JLabel(currentNode.getData());
				// add the label to the roster panel
				rosterPanel.add(namesLabel);
				// validate and repaint
				rosterPanel.validate();
				rosterPanel.repaint();
				// keep getting the next node
				currentNode = (DoublyLinkedListNode<String>) currentNode
						.getNext();

			}
		}

		else {
			// else if the waitlist size is smaller than 10
			if (waitList.size() < 10) {
				// get the text
				String textInserted = textArea.getText();
				// insert first in the waitlist
				waitList.insertFirst(textInserted);
				// current wait node is the head
				DoublyLinkedListNode<String> currentWaitNode = (DoublyLinkedListNode<String>) waitList.head;
				// update the panel
				waitPanel.removeAll();
				// while currentNode is not null
				while (currentWaitNode != null) {
					// create and add labels
					JLabel waitNamesLabel = new JLabel(
							currentWaitNode.getData());
					waitPanel.add(waitNamesLabel);
					// repaint and validate
					waitPanel.validate();
					waitPanel.repaint();
					// get next
					currentWaitNode = (DoublyLinkedListNode<String>) currentWaitNode
							.getNext();
				}
			}
		}

	}

	/**
	 * this method is supposed to drop and remove names It is not working the
	 * way it should It deleted the first one but not the last or the middle
	 */
	public void removeName() {
		// current node is head
		DoublyLinkedListNode<String> currentNode = (DoublyLinkedListNode<String>) rosterList.head;
		// get text
		String nameEntered = textArea.getText();
		System.out.println("the name entered is: " + nameEntered);
		System.out.println("we are comparing to: " + currentNode.getData());
		// while current node is not null
		while (currentNode != null) {
			// if the name enteres is equal to the data in the current node
			if (nameEntered.equals(currentNode.getData())) {
				// and if the current node is equal to the first node in the
				// roster list
				if (currentNode == rosterList.getFirstNode()) {
					System.out.println("hi");
					// call delete first, validate and repaint
					rosterList.deleteFirst();
					rosterPanel.validate();
					rosterPanel.repaint();
					break;
					// else if it's equal to the last node
				} else if (currentNode == rosterList.getLastNode()) {
					// call delete last, validate and repaint
					rosterList.deleteLast();
					rosterPanel.validate();
					rosterPanel.repaint();
					break;
				}

			}

			else {
				// else keep getting the next node
				currentNode = (DoublyLinkedListNode<String>) currentNode
						.getNext();
			}

		}
		// update the panel
		rosterPanel.removeAll();

	}

	/**
	 * action performed when buttons are clicked
	 */
	public void actionPerformed(ActionEvent e) {
		// if add button is clicked
		if (e.getSource() == addButton) {
			// call add names
			addNames();
		}
		// if drop button is clicked
		if (e.getSource() == dropButton) {
			// call remove name
			removeName();

		}
	}
}

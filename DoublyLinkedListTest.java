/**
 * This is a testing class to test the DoublyLinkedList and DoublyLinkedListNode functionalities
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {
	// create a new empty test list
	DoublyLinkedList<String> testList = new DoublyLinkedList<String>();

	@Before
	// add to the list
	public void createTestList() {
		testList.insertFirst("S");
		testList.insertFirst("E");
		testList.insertFirst("O");
		testList.insertFirst("T");
		testList.insertFirst("A");
		testList.insertFirst("T");
		testList.insertFirst("O");
		testList.insertFirst("P");
	}

	@Test
	public void testInsertFirst() {
		// test insert first
		testList.insertFirst("O");

		String message = "Testing insert first, expecting OPOTATO.";
		assertEquals(message, "OPOTATOES", testList.toString());
	}

	@Test
	public void testGetFirstNode() {
		// test get first node
		String message = "Testing get first node, expecting P";
		assertEquals(message, "P", testList.getFirstNode().toString());

	}

	@Test
	public void testInsertAfter() {
		// test insert after
		String message = "Testing insert after, calling it one time.";
		testList.insertAfter(testList.getFirstNode().getNext(), "Y");
		assertEquals(message, "POYTATOES", testList.toString());

	}

	@Test
	public void testInsertLast() {
		// test insert last
		String message = "Testing insert last, calling it one time.";
		testList.insertLast("S");
		assertEquals(message, "POTATOESS", testList.toString());

	}

	@Test
	public void testDeleteFirst() {
		// test delete first
		testList.deleteFirst();
		String message = "Testing delete first, calling it one time.";
		assertEquals(message, "OTATOES", testList.toString());
	}

	@Test
	public void testDeleteNext() {
		// test delete next
		testList.deleteNext(testList.getFirstNode());
		String message = "Testing delete next, calling it one time.";
		assertEquals(message, "PTATOES", testList.toString());
	}

	@Test
	public void testDeleteLast() {
		// test delete last
		testList.deleteLast();
		String message = "Testing delete last, calling it one time.";
		assertEquals(message, "POTATOE", testList.toString());
	}

	@Test
	public void testSetPrevious() {
		DoublyLinkedListNode<String> newNode = new DoublyLinkedListNode<String>(
				"B");
		testList.tail.setPrevious(newNode);
		// testList.tail.getPrevious().setPrevious(firstNode);
		String message = "Testing set previous, calling it one time.";
		assertEquals(message, "B", testList.tail.getPrevious().toString());

	}

}

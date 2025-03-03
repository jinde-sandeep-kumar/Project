package kodnest.com;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Project extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Project frame = new Project();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Project() {
        setBackground(new Color(240, 240, 240));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        JPanel contentPane = new JPanel();
        contentPane.setForeground(new Color(0, 64, 0));
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("DATA STRUCTURES");
        lblTitle.setBounds(67, 10, 261, 35);
        lblTitle.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 22));
        contentPane.add(lblTitle);

        JButton btnArray = new JButton("Array");
        btnArray.setBackground(new Color(201, 233, 209));
        btnArray.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnArray.setBounds(30, 80, 150, 40);
        contentPane.add(btnArray);

        JButton btnStack = new JButton("Stack");
        btnStack.setBackground(new Color(201, 233, 209));
        btnStack.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnStack.setBounds(200, 80, 150, 40);
        contentPane.add(btnStack);

        JButton btnQueue = new JButton("Queue");
        btnQueue.setBackground(new Color(201, 233, 209));
        btnQueue.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnQueue.setBounds(30, 150, 150, 40);
        contentPane.add(btnQueue);

        JButton btnCircularQueue = new JButton("Circular Queue");
        btnCircularQueue.setBackground(new Color(201, 233, 209));
        btnCircularQueue.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnCircularQueue.setBounds(200, 150, 150, 40);
        contentPane.add(btnCircularQueue);

        JButton btnSinglyLinkedList = new JButton("Singly Linked List");
        btnSinglyLinkedList.setBackground(new Color(201, 233, 209));
        btnSinglyLinkedList.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnSinglyLinkedList.setBounds(30, 220, 150, 56);
        contentPane.add(btnSinglyLinkedList);

        JButton btnDoublyLinkedList = new JButton("Doubly Linked List");
        btnDoublyLinkedList.setBackground(new Color(201, 233, 209));
        btnDoublyLinkedList.setFont(new Font("Times New Roman", Font.BOLD, 13));
        btnDoublyLinkedList.setBounds(200, 220, 150, 56);
        contentPane.add(btnDoublyLinkedList);

        btnArray.addActionListener(e -> new ArrayFrame().setVisible(true));
        btnStack.addActionListener(e -> new StackFrame().setVisible(true));
        btnQueue.addActionListener(e -> new QueueFrame().setVisible(true));
        btnCircularQueue.addActionListener(e -> new CircularQueueFrame().setVisible(true));
        btnSinglyLinkedList.addActionListener(e -> new SinglyLinkedListFrame().setVisible(true));
        btnDoublyLinkedList.addActionListener(e -> new DoublyLinkedListFrame().setVisible(true));
    }

    // Array Frame
    private class ArrayFrame extends JFrame {
		private static final long serialVersionUID = 1L;
		private int[] array;
        private int size;
        private JTextArea resultArea;

        public ArrayFrame() {
            setTitle("Array.Java");
            setBounds(100, 100, 450, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            panel.setBackground(Color.LIGHT_GRAY);
            panel.setLayout(null);
            setContentPane(panel);

            JLabel label = new JLabel("Array DataStructures");
            label.setFont(new Font("Arial", Font.BOLD, 15));
            label.setBounds(150, 10, 200, 20);
            panel.add(label);

            JButton createButton = new JButton("Create");
            createButton.setBounds(30, 50, 100, 30);
            panel.add(createButton);

            JButton insertButton = new JButton("Insert");
            insertButton.setBounds(150, 50, 100, 30);
            panel.add(insertButton);

            JButton deleteButton = new JButton("Delete");
            deleteButton.setBounds(270, 50, 100, 30);
            panel.add(deleteButton);

            JButton displayButton = new JButton("Display");
            displayButton.setBounds(150, 100, 100, 30);
            panel.add(displayButton);

            JButton backButton = new JButton("Back");
            backButton.setBounds(330, 10, 90, 25);
            backButton.addActionListener(e -> dispose());
            panel.add(backButton);

            resultArea = new JTextArea();
            resultArea.setBounds(30, 150, 380, 100);
            resultArea.setEditable(false);
            panel.add(resultArea);

            createButton.addActionListener(e -> {
                String input = JOptionPane.showInputDialog(this, "Enter size of the array:");
                if (input != null && !input.isEmpty()) {
                    size = Integer.parseInt(input);
                    array = new int[size];
                    resultArea.setText("Array of size " + size + " created.");
                }
            });

            insertButton.addActionListener(e -> {
                if (array == null) {
                    JOptionPane.showMessageDialog(this, "Create an array first!");
                    return;
                }
                String elementInput = JOptionPane.showInputDialog(this, "Enter element to insert:");
                String positionInput = JOptionPane.showInputDialog(this, "Enter position (0 to " + (size - 1) + "):");
                if (elementInput != null && positionInput != null) {
                    int element = Integer.parseInt(elementInput);
                    int position = Integer.parseInt(positionInput);
                    if (position >= 0 && position < size) {
                        array[position] = element;
                        resultArea.setText("Inserted " + element + " at position " + position + ".\n" + displayArray());
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid position!");
                    }
                }
            });

            deleteButton.addActionListener(e -> {
                if (array == null) {
                    JOptionPane.showMessageDialog(this, "Create an array first!");
                    return;
                }
                String positionInput = JOptionPane.showInputDialog(this, "Enter position to delete (0 to " + (size - 1) + "):");
                if (positionInput != null) {
                    int position = Integer.parseInt(positionInput);
                    if (position >= 0 && position < size) {
                        array[position] = 0;
                        resultArea.setText("Deleted element at position " + position + ".\n" + displayArray());
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid position!");
                    }
                }
            });

            displayButton.addActionListener(e -> {
                if (array == null) {
                    resultArea.setText("No array created yet.");
                } else {
                    resultArea.setText("Array: " + Arrays.toString(array));
                }
            });
        }

        private String displayArray() {
            return "Array: " + Arrays.toString(array);
        }
    }

  // Stack Frame
    private class StackFrame extends JFrame {
		private static final long serialVersionUID = 1L;
		private Stack<Integer> stack = new Stack<>();
        private JTextArea resultArea;

        public StackFrame() {
            setTitle("Stack.Java");
            setBounds(100, 100, 450, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            panel.setLayout(null);
            setContentPane(panel);

            JLabel label = new JLabel("Stack DataStructures");
            label.setFont(new Font("Arial", Font.BOLD, 15));
            label.setBounds(150, 10, 200, 20);
            panel.add(label);

            JTextField inputField = new JTextField();
            inputField.setBounds(30, 50, 100, 30);
            panel.add(inputField);

            JButton pushButton = new JButton("Push");
            pushButton.setBounds(150, 50, 100, 30);
            panel.add(pushButton);

            JButton popButton = new JButton("Pop");
            popButton.setBounds(270, 50, 100, 30);
            panel.add(popButton);

            JButton displayButton = new JButton("Display Stack");
            displayButton.setBounds(150, 100, 150, 30);
            panel.add(displayButton);

            resultArea = new JTextArea();
            resultArea.setBounds(30, 150, 380, 100);
            resultArea.setEditable(false);
            panel.add(resultArea);

            pushButton.addActionListener(e -> {
                String input = inputField.getText();
                if (!input.isEmpty()) {
                    stack.push(Integer.parseInt(input));
                    resultArea.setText("Pushed: " + input + "\n" + displayStack());
                    inputField.setText("");
                }
            });

            popButton.addActionListener(e -> {
                if (!stack.isEmpty()) {
                    Integer popped = stack.pop();
                    resultArea.setText("Popped: " + popped + "\n" + displayStack());
                } else {
                    resultArea.setText("Stack is empty.");
                }
            });

            displayButton.addActionListener(e -> resultArea.setText(displayStack()));
            
            JButton backButton = new JButton("Back");
            backButton.setBounds(330, 10, 90, 25);
            backButton.addActionListener(e -> dispose());
            panel.add(backButton);
        }

        private String displayStack() {
            return "Stack: " + stack.toString();
        }
    }

    // Queue Frame
    private class QueueFrame extends JFrame {
		private static final long serialVersionUID = 1L;
		private Queue<Integer> queue = new LinkedList<>();
        private JTextArea resultArea;

        public QueueFrame() {
            setTitle("Queue.Java");
            setBounds(100, 100, 450, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            panel.setLayout(null);
            setContentPane(panel);

            JLabel label = new JLabel("Queue DataStructures");
            label.setFont(new Font("Arial", Font.BOLD, 15));
            label.setBounds(150, 10, 200, 20);
            panel.add(label);

            JTextField inputField = new JTextField();
            inputField.setBounds(30, 50, 100, 30);
            panel.add(inputField);

            JButton enqueueButton = new JButton("Enqueue");
            enqueueButton.setBounds(150, 50, 100, 30);
            panel.add(enqueueButton);

            JButton dequeueButton = new JButton("Dequeue");
            dequeueButton.setBounds(270, 50, 100, 30);
            panel.add(dequeueButton);

            JButton displayButton = new JButton("Display Queue");
            displayButton.setBounds(150, 100, 150, 30);
            panel.add(displayButton);

            resultArea = new JTextArea();
            resultArea.setBounds(30, 150, 380, 100);
            resultArea.setEditable(false);
            panel.add(resultArea);

            enqueueButton.addActionListener(e -> {
                String input = inputField.getText();
                if (!input.isEmpty()) {
                    queue.add(Integer.parseInt(input));
                    resultArea.setText("Enqueued: " + input + "\n" + displayQueue());
                    inputField.setText("");
                }
            });

            dequeueButton.addActionListener(e -> {
                Integer dequeued = queue.poll();
                if (dequeued != null) {
                    resultArea.setText("Dequeued: " + dequeued + "\n" + displayQueue());
                } else {
                    resultArea.setText("Queue is empty.");
                }
            });

            displayButton.addActionListener(e -> resultArea.setText(displayQueue()));

            JButton backButton = new JButton("Back");
            backButton.setBounds(330, 10, 90, 25);
            backButton.addActionListener(e -> dispose());
            panel.add(backButton);
        }

        private String displayQueue() {
            return "Queue: " + queue.toString();
        }
    }

    private class CircularQueueFrame extends JFrame {
		private static final long serialVersionUID = 1L;
		private int[] queue;
        private int front, rear, size;
        private JTextArea resultArea;

        public CircularQueueFrame() {
            setTitle("Circular Queue.Java");
            setBounds(100, 100, 450, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            panel.setLayout(null);
            setContentPane(panel);

            JLabel label = new JLabel("Circular Queue DataStructures");
            label.setFont(new Font("Arial", Font.BOLD, 12));
            label.setBounds(130, 10, 200, 20);
            panel.add(label);

            JButton createButton = new JButton("Create Queue");
            createButton.setBounds(30, 50, 150, 30);
            panel.add(createButton);

            JButton enqueueButton = new JButton("Enqueue");
            enqueueButton.setBounds(200, 50, 150, 30);
            panel.add(enqueueButton);

            JButton dequeueButton = new JButton("Dequeue");
            dequeueButton.setBounds(30, 100, 150, 30);
            panel.add(dequeueButton);

            JButton displayButton = new JButton("Display");
            displayButton.setBounds(200, 100, 150, 30);
            panel.add(displayButton);

            resultArea = new JTextArea();
            resultArea.setBounds(30, 150, 380, 100);
            resultArea.setEditable(false);
            panel.add(resultArea);

            JButton backButton = new JButton("Back");
            backButton.setBounds(330, 10, 90, 25);
            backButton.addActionListener(e -> dispose());
            panel.add(backButton);

            createButton.addActionListener(e -> {
                String input = JOptionPane.showInputDialog(this, "Enter size of the queue:");
                if (input != null && !input.isEmpty()) {
                    size = Integer.parseInt(input);
                    queue = new int[size];
                    front = rear = -1;
                    resultArea.setText("Circular Queue of size " + size + " created.");
                }
            });

            enqueueButton.addActionListener(e -> {
                if (queue == null) {
                    JOptionPane.showMessageDialog(this, "Create a queue first!");
                    return;
                }
                if ((rear + 1) % size == front) {
                    JOptionPane.showMessageDialog(this, "Queue is full!");
                    return;
                }
                String elementInput = JOptionPane.showInputDialog(this, "Enter element to enqueue:");
                if (elementInput != null) {
                    int element = Integer.parseInt(elementInput);
                    if (front == -1) {
                        front = 0;
                    }
                    rear = (rear + 1) % size;
                    queue[rear] = element;
                    resultArea.setText("Enqueued: " + element + "\n" + displayQueue());
                }
            });

            dequeueButton.addActionListener(e -> {
                if (queue == null || front == -1) {
                    JOptionPane.showMessageDialog(this, "Queue is empty!");
                    return;
                }
                int element = queue[front];
                if (front == rear) {
                    front = rear = -1;
                } else {
                    front = (front + 1) % size;
                }
                resultArea.setText("Dequeued: " + element + "\n" + displayQueue());
            });

            displayButton.addActionListener(e -> resultArea.setText(displayQueue()));
        }

        private String displayQueue() {
            if (front == -1) {
                return "Queue is empty.";
            }
            StringBuilder sb = new StringBuilder();
            int i = front;
            while (i != rear) {
                sb.append(queue[i]).append(" ");
                i = (i + 1) % size;
            }
            sb.append(queue[rear]);
            return "Queue: " + sb.toString();
        }
    }

    // Singly Linked List Frame
    private class SinglyLinkedListFrame extends JFrame {
		private static final long serialVersionUID = 1L;

		private class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node head;
        private JTextArea resultArea;

        public SinglyLinkedListFrame() {
            setTitle("Singly Linked List.Java");
            setBounds(100, 100, 450, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            panel.setLayout(null);
            setContentPane(panel);

            JLabel label = new JLabel("Singly Linked List DataStructures");
            label.setFont(new Font("Arial", Font.BOLD, 12));
            label.setBounds(130, 10, 200, 20);
            panel.add(label);

            JButton insertButton = new JButton("Insert");
            insertButton.setBounds(30, 50, 150, 30);
            panel.add(insertButton);

            JButton deleteButton = new JButton("Delete");
            deleteButton.setBounds(200, 50, 150, 30);
            panel.add(deleteButton);

            JButton displayButton = new JButton("Display");
            displayButton.setBounds(30, 100, 150, 30);
            panel.add(displayButton);

            resultArea = new JTextArea();
            resultArea.setBounds(30, 150, 380, 100);
            resultArea.setEditable(false);
            panel.add(resultArea);

            JButton backButton = new JButton("Back");
            backButton.setBounds(330, 10, 90, 25);
            backButton.addActionListener(e -> dispose());
            panel.add(backButton);

            insertButton.addActionListener(e -> {
                String elementInput = JOptionPane.showInputDialog(this, "Enter element to insert:");
                if (elementInput != null) {
                    int element = Integer.parseInt(elementInput);
                    Node newNode = new Node(element);
                    if (head == null) {
                        head = newNode;
                    } else {
                        Node temp = head;
                        while (temp.next != null) {
                            temp = temp.next;
                        }
                        temp.next = newNode;
                    }
                    resultArea.setText("Inserted: " + element + "\n" + displayList());
                }
            });

            deleteButton.addActionListener(e -> {
                if (head == null) {
                    JOptionPane.showMessageDialog(this, "List is empty!");
                    return;
                }
                int element = head.data;
                head = head.next;
                resultArea.setText("Deleted: " + element + "\n" + displayList());
            });

            displayButton.addActionListener(e -> resultArea.setText(displayList()));
        }

        private String displayList() {
            if (head == null) {
                return "List is empty.";
            }
            StringBuilder sb = new StringBuilder();
            Node temp = head;
            while (temp != null) {
                sb.append(temp.data).append(" ");
                temp = temp.next;
            }
            return "List: " + sb.toString();
        }
    }

    // Doubly Linked List Frame
    private class DoublyLinkedListFrame extends JFrame {
		private static final long serialVersionUID = 1L;

		private class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node head, tail;
        private JTextArea resultArea;

        public DoublyLinkedListFrame() {
            setTitle("Doubly Linked List.Java");
            setBounds(100, 100, 450, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            panel.setLayout(null);
            setContentPane(panel);

            JLabel label = new JLabel("Doubly Linked List DataStructures");
            label.setFont(new Font("Arial", Font.BOLD, 12));
            label.setBounds(130, 10, 200, 20);
            panel.add(label);

            JButton insertButton = new JButton("Insert");
            insertButton.setBounds(30, 50, 150, 30);
            panel.add(insertButton);

            JButton deleteButton = new JButton("Delete");
            deleteButton.setBounds(200, 50, 150, 30);
            panel.add(deleteButton);

            JButton displayButton = new JButton("Display");
            displayButton.setBounds(30, 100, 150, 30);
            panel.add(displayButton);

            resultArea = new JTextArea();
            resultArea.setBounds(30, 150, 380, 100);
            resultArea.setEditable(false);
            panel.add(resultArea);

            JButton backButton = new JButton("Back");
            backButton.setBounds(330, 10, 90, 25);
            backButton.addActionListener(e -> dispose());
            panel.add(backButton);

            insertButton.addActionListener(e -> {
                String elementInput = JOptionPane.showInputDialog(this, "Enter element to insert:");
                if (elementInput != null) {
                    int element = Integer.parseInt(elementInput);
                    Node newNode = new Node(element);
                    if (head == null) {
                        head = tail = newNode;
                    } else {
                        tail.next = newNode;
                        tail = newNode;
                    }
                    resultArea.setText("Inserted: " + element + "\n" + displayList());
                }
            });

            deleteButton.addActionListener(e -> {
                if (head == null) {
                    JOptionPane.showMessageDialog(this, "List is empty!");
                    return;
                }
                int element = head.data;
                head = head.next;
                if (head != null) {
                } else {
                    tail = null;
                }
                resultArea.setText("Deleted: " + element + "\n" + displayList());
            });

            displayButton.addActionListener(e -> resultArea.setText(displayList()));
        }

        private String displayList() {
            if (head == null) {
                return "List is empty.";
            }
            StringBuilder sb = new StringBuilder();
            Node temp = head;
            while (temp != null) {
                sb.append(temp.data).append(" ");
                temp = temp.next;
            }
            return "List: " + sb.toString();
        }
    }
}

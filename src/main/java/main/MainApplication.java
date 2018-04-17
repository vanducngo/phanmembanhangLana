package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.google.gson.Gson;

import api.UriGHTKAPI;
import constant.UriConstant;
import model.Order;
import model.OrderDetail;
import javax.swing.JTextArea;

public class MainApplication {

	private JFrame frame;
	private JTextField inputOrderId;
	private JLabel lblCustomerName;
	private JLabel lblPrice;
	private JTextArea txtAreaAddress;
	private JLabel lblOrderId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplication window = new MainApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblLanashop = new JLabel("GradleExample");

		inputOrderId = new JTextField();
		inputOrderId.setText("S5436.SG1.26H.88740181");
		inputOrderId.setToolTipText("M\u00E3");
		inputOrderId.setColumns(10);

		JLabel lblMnHng = new JLabel("M\u00E3 \u0111\u01A1n h\u00E0ng");

		JButton btnTmKim = new JButton("T\u00ECm ki\u1EBFm");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String orderId = inputOrderId.getText();
				String jsonRequest = UriGHTKAPI
						.executeGetReQuest(UriConstant.HOST.GHTK + UriConstant.API.OrderDetails + orderId);
				Gson gson = new Gson();
				OrderDetail orderDetails = gson.fromJson(jsonRequest, OrderDetail.class);
				if (orderDetails != null && orderDetails.getOrder() != null) {
					Order order = orderDetails.getOrder();

					lblOrderId.setText(order.getOrderId());
					lblCustomerName.setText(order.getCustomerName());
					txtAreaAddress.setText(order.getAddress());
					lblPrice.setText(order.getOrderPrice());
				}

			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		JButton btnNewButton = new JButton("In Mã Đơn Hàng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblLanashop))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap(8, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblMnHng).addGap(10)
												.addComponent(inputOrderId, GroupLayout.PREFERRED_SIZE, 223,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(btnTmKim).addGap(18)
												.addComponent(btnNewButton)
												.addPreferredGap(ComponentPlacement.RELATED)))))
				.addGap(77).addComponent(panel, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(19)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblLanashop).addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblMnHng)
										.addComponent(inputOrderId, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnTmKim)
										.addComponent(btnNewButton))))
				.addContainerGap(162, Short.MAX_VALUE)));

		JLabel lblNewLabel = new JLabel("Mã đơn hàng:");

		lblOrderId = new JLabel("");

		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng:");

		lblCustomerName = new JLabel("");

		JLabel lblaCh = new JLabel("Địa chỉ:");

		JLabel lblGiTin = new JLabel("Giá tiền:");

		lblPrice = new JLabel("");

		txtAreaAddress = new JTextArea();
		txtAreaAddress.setEditable(false);
		txtAreaAddress.setLineWrap(true);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel_1).addComponent(lblNewLabel))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblOrderId).addComponent(lblCustomerName)))
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblaCh).addGap(22)
												.addComponent(txtAreaAddress, GroupLayout.PREFERRED_SIZE, 339,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblGiTin)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblPrice)))
								.addContainerGap(29, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(16)
				.addGroup(gl_panel
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(lblOrderId))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
						.addComponent(lblCustomerName))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblaCh)
						.addComponent(txtAreaAddress, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(
						gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblGiTin).addComponent(lblPrice))
				.addContainerGap(47, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}

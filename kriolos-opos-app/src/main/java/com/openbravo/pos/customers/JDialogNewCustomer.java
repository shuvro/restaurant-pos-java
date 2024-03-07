package com.openbravo.pos.customers;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.MessageInf;
import com.openbravo.data.loader.LocalRes;
import com.openbravo.data.user.DirtyManager;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.forms.BeanFactoryException;
import com.openbravo.pos.forms.DataLogicSales;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JDialogNewCustomer extends javax.swing.JDialog {

    private static final Logger LOGGER = Logger.getLogger(JDialogNewCustomer.class.getName());

    private static final long serialVersionUID = 1L;
    private DataLogicCustomers dlCustomer;
    private DataLogicSales dlSales;
    private CustomerInfoExt selectedCustomer;
    private CustomersView customersView;

    /**
     * Creates new form quick New Customer
     *
     * @param parent
     */
    protected JDialogNewCustomer(java.awt.Frame parent) {
        super(parent, true);
    }

    /**
     * Creates new form quick New Customer
     *
     * @param parent
     */
    protected JDialogNewCustomer(java.awt.Dialog parent) {
        super(parent, true);
    }

    private void init(AppView app) {

        try {
            dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");
            dlCustomer = (DataLogicCustomers) app.getBean("com.openbravo.pos.customers.DataLogicCustomers");

            initComponents();

            DirtyManager dirty = new DirtyManager();
            customersView = new CustomersView(app, dirty);
            customersView.writeValueInsert();
            formPanel.setLayout(new java.awt.BorderLayout());
            formPanel.add(customersView, java.awt.BorderLayout.CENTER);

            getRootPane().setDefaultButton(m_jBtnOK);
        } catch (BeanFactoryException ex) {
            LOGGER.log(Level.SEVERE, "Error ", ex);
        }
    }

    public Object createValue() throws BasicException {
        return customersView.createValue();
    }

    public static JDialogNewCustomer getDialog(Component parent, AppView app) {

        Window window = getWindow(parent);

        JDialogNewCustomer quicknewcustomer;

        if (window instanceof Frame) {
            quicknewcustomer = new JDialogNewCustomer((Frame) window);
        } else {
            quicknewcustomer = new JDialogNewCustomer((Dialog) window);
        }

        quicknewcustomer.init(app);

        return quicknewcustomer;
    }

    protected static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window) parent;
        } else {
            return getWindow(parent.getParent());
        }
    }

    public CustomerInfoExt getSelectedCustomer() {
        return selectedCustomer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        m_jBtnCancel = new javax.swing.JButton();
        m_jBtnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(AppLocal.getIntString("label.customer")); // NOI18N
        setMaximumSize(new java.awt.Dimension(960, 600));
        setMinimumSize(new java.awt.Dimension(480, 360));
        setPreferredSize(new java.awt.Dimension(700, 480));
        setResizable(false);

        formPanel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        formPanel.setMaximumSize(new java.awt.Dimension(695, 420));
        formPanel.setPreferredSize(new java.awt.Dimension(695, 420));

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        getContentPane().add(formPanel, java.awt.BorderLayout.NORTH);
        formPanel.getAccessibleContext().setAccessibleName("");

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        m_jBtnCancel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jBtnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/cancel.png"))); // NOI18N
        m_jBtnCancel.setText(AppLocal.getIntString("Button.cancel")); // NOI18N
        m_jBtnCancel.setFocusPainted(false);
        m_jBtnCancel.setFocusable(false);
        m_jBtnCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jBtnCancel.setPreferredSize(new java.awt.Dimension(80, 45));
        m_jBtnCancel.setRequestFocusEnabled(false);
        m_jBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jBtnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(m_jBtnCancel);

        m_jBtnOK.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jBtnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        m_jBtnOK.setText(AppLocal.getIntString("button.ok")); // NOI18N
        m_jBtnOK.setFocusPainted(false);
        m_jBtnOK.setFocusable(false);
        m_jBtnOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jBtnOK.setPreferredSize(new java.awt.Dimension(80, 45));
        m_jBtnOK.setRequestFocusEnabled(false);
        m_jBtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jBtnOKActionPerformed(evt);
            }
        });
        jPanel2.add(m_jBtnOK);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(714, 487));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jBtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jBtnOKActionPerformed

        if ("".equals("VALID FORM HERE")) {
            JOptionPane.showMessageDialog(
                    null,
                    AppLocal.getIntString("message.customercheck"),
                    "Customer check",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                Object customer = createValue();
                String m_oId = ((Object[]) customer)[0].toString();

                int status = dlCustomer.getTableCustomers().getInsertSentence().exec(customer);

                if (status > 0) {
                    selectedCustomer = dlSales.loadCustomerExt(m_oId);
                    dispose();
                } else {
                    MessageInf msg = new MessageInf(MessageInf.SGN_NOTICE,
                            LocalRes.getIntString("message.nosave"), "Error save");
                    msg.show(this);
                }

            } catch (BasicException ex) {
                LOGGER.log(Level.SEVERE, "Error ", ex);
                MessageInf msg = new MessageInf(MessageInf.SGN_NOTICE,
                        LocalRes.getIntString("message.nosave"), ex);
                msg.show(this);
            }
        }
    }//GEN-LAST:event_m_jBtnOKActionPerformed

    private void m_jBtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jBtnCancelActionPerformed

        dispose();

    }//GEN-LAST:event_m_jBtnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel formPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton m_jBtnCancel;
    private javax.swing.JButton m_jBtnOK;
    // End of variables declaration//GEN-END:variables

}
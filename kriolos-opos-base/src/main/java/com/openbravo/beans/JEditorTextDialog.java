//    KriolOS POS
//    Copyright (c) 2019-2023 KriolOS
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.beans;

import com.openbravo.editor.JEditorKeys;
import com.openbravo.editor.JEditorString;
import com.openbravo.editor.JEditorText;
import java.awt.*;
import javax.swing.*;

public class JEditorTextDialog extends javax.swing.JDialog {
    
    private static LocaleResources m_resources;
    private static final long serialVersionUID = 1L;
    private JEditorKeys m_jKeyPad = new JEditorKeys();
    private JEditorText m_jtextEditor = new JEditorString();
    

    public JEditorTextDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal); 
        initComponents();
        init();
        
    }
 
    public JEditorTextDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);  
        initComponents();
        init();
    }    
    
    private void init() {
     
        jPanelKe.add(m_jKeyPad);
        jPanelInput.add(m_jtextEditor);
        
        if (m_resources == null) {
            m_resources = new LocaleResources();
            m_resources.addBundleName("beans_messages");
        }
       
        getRootPane().setDefaultButton(jcmdOK);   
        
        m_jtextEditor.addEditorKeys(m_jKeyPad);
        m_jtextEditor.reset();
        m_jtextEditor.activate();
        
        m_jPanelTitle.setBorder(RoundedBorder.createGradientBorder());

    }
    
    public void setEditor(JEditorText newTextEditor){
        jPanelInput.removeAll();
        m_jtextEditor = newTextEditor;
        jPanelInput.add(m_jtextEditor);
        m_jtextEditor.addEditorKeys(m_jKeyPad);
        m_jtextEditor.reset();
        m_jtextEditor.activate();
  
        revalidate();
    }
    
    public String getValue(){
        return m_jtextEditor.getText();
    }
    
    private void setTitle(String title, String message, Icon icon) {
        setTitle(title);
        m_lblMessage.setText(message);
        m_lblMessage.setIcon(icon);
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

    public static String showEditor(Component parent, String title) {
        return showEditor(parent, title, null, null);
    }

    public static String showEditor(Component parent, String title, String message) {
        return showEditor(parent, title, message, null);
    }

    public static String showEditor(Component parent, String title, String message, Icon icon) {
        
        Window window = getWindow(parent);      
        
        JEditorTextDialog dialog;
        if (window instanceof Frame) { 
            dialog = new JEditorTextDialog((Frame) window, true);
        } else {
            dialog = new JEditorTextDialog((Dialog) window, true);
        }
        
        return showDialog(dialog, title, message, icon);
    }
    
    protected static String showDialog(JEditorTextDialog dialog, String title, String message, Icon icon) {
        dialog.setTitle(title, message, icon);
        dialog.setVisible(true);
        return dialog.getValue();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcmdCancel = new javax.swing.JButton();
        jcmdOK = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanelGrid = new javax.swing.JPanel();
        jPanelKe = new javax.swing.JPanel();
        jPanelInput = new javax.swing.JPanel();
        m_jPanelTitle = new javax.swing.JPanel();
        m_lblMessage = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(350, 450));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeWindow(evt);
            }
        });

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jcmdCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcmdCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/cancel.png"))); // NOI18N
        jcmdCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        jcmdCancel.setPreferredSize(new java.awt.Dimension(80, 45));
        jcmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jcmdCancel);

        jcmdOK.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcmdOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        jcmdOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        jcmdOK.setPreferredSize(new java.awt.Dimension(80, 45));
        jcmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdOKActionPerformed(evt);
            }
        });
        jPanel1.add(jcmdOK);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel2.setMaximumSize(new java.awt.Dimension(320, 365));
        jPanel2.setPreferredSize(new java.awt.Dimension(320, 365));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanelGrid.setPreferredSize(new java.awt.Dimension(310, 360));

        jPanelKe.setPreferredSize(new java.awt.Dimension(300, 300));
        jPanelKe.setLayout(new javax.swing.BoxLayout(jPanelKe, javax.swing.BoxLayout.Y_AXIS));
        jPanelGrid.add(jPanelKe);

        jPanelInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanelInput.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanelInput.setLayout(new java.awt.BorderLayout());
        jPanelGrid.add(jPanelInput);

        jPanel2.add(jPanelGrid, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        m_jPanelTitle.setMaximumSize(new java.awt.Dimension(310, 35));
        m_jPanelTitle.setMinimumSize(new java.awt.Dimension(300, 35));
        m_jPanelTitle.setPreferredSize(new java.awt.Dimension(310, 35));
        m_jPanelTitle.setLayout(new java.awt.BorderLayout());

        m_lblMessage.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, java.awt.Color.darkGray), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        m_lblMessage.setMaximumSize(new java.awt.Dimension(300, 30));
        m_lblMessage.setMinimumSize(new java.awt.Dimension(300, 30));
        m_lblMessage.setPreferredSize(new java.awt.Dimension(300, 30));
        m_jPanelTitle.add(m_lblMessage, java.awt.BorderLayout.CENTER);

        getContentPane().add(m_jPanelTitle, java.awt.BorderLayout.NORTH);

        setSize(new java.awt.Dimension(308, 489));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jNumberKeys21KeyPerformed(com.openbravo.beans.JNumberEvent evt) {//GEN-FIRST:event_jNumberKeys21KeyPerformed
 
    }//GEN-LAST:event_jNumberKeys21KeyPerformed

    private void jcmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdOKActionPerformed
          
        setVisible(false);
        dispose();     
        
    }//GEN-LAST:event_jcmdOKActionPerformed

    private void jcmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdCancelActionPerformed

        setVisible(false);
        dispose();    
        
    }//GEN-LAST:event_jcmdCancelActionPerformed

    private void closeWindow(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeWindow

        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_closeWindow

    private void m_jKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jKeysActionPerformed
    }//GEN-LAST:event_m_jKeysActionPerformed
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelGrid;
    private javax.swing.JPanel jPanelInput;
    private javax.swing.JPanel jPanelKe;
    private javax.swing.JButton jcmdCancel;
    private javax.swing.JButton jcmdOK;
    private javax.swing.JPanel m_jPanelTitle;
    private javax.swing.JLabel m_lblMessage;
    // End of variables declaration//GEN-END:variables
    
}

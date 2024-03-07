/*
 * Copyright (C) 2023 Paulo Borges
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.openbravo.pos.util;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author poolb
 */
public class BarAndQrCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = new JFrame();
        //f.setFont(new Font("SimSun",Font.PLAIN, 12));
        f.setTitle("BarCode and QrCOde ");
        //f.setTitle("Hello world! - \u7535\u8111\u4F60\u597D\uFF01");
        f.setBounds(100, 50, 500, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        JTextField enterText = new JTextField("Paulo Borges");

        Image customer = BarcodeImage.getBarcode128(enterText.getText());

        com.openbravo.data.gui.JImageEditor imgPanel = new com.openbravo.data.gui.JImageEditor();
        imgPanel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        imgPanel.setPreferredSize(new java.awt.Dimension(250, 250));

        com.openbravo.data.gui.JImageEditor imgPanel2 = new com.openbravo.data.gui.JImageEditor();
        imgPanel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        imgPanel2.setPreferredSize(new java.awt.Dimension(250, 250));

        String[] codes = new String[]{"QRCODE", "CODE128", "CODABAR", "CODE39", "EAN8", "EAN13", "UPCA"};

        JComboBox<String> _fontCombo = new JComboBox<>(codes);         // JComboBox of fonts
        _fontCombo.setSelectedItem("128"); // Select initial font
        _fontCombo.addActionListener((ActionEvent e) -> {
            String codeType = (String) _fontCombo.getSelectedItem();

            imgPanel2.setImage(com.openbravo.pos.util.BarcodeUtils.getCode(enterText.getText(),codeType));
            switch (codeType) {

                case "QRCODE":
                    imgPanel.setImage((BufferedImage) BarcodeImage.getQRCode(enterText.getText()));
                    break;

                case "CODE39":
                    imgPanel.setImage((BufferedImage) BarcodeImage.getBarcodeCode39(enterText.getText()));
                    break;

                case "CODE128":
                    imgPanel.setImage((BufferedImage) BarcodeImage.getBarcode128(enterText.getText()));
                    break;

                case "EAN8":
                    imgPanel.setImage((BufferedImage) BarcodeImage.getBarcodeEAN8(enterText.getText()));
                    break;

                case "EAN13":
                    imgPanel.setImage((BufferedImage) BarcodeImage.getBarcodeEAN13(enterText.getText()));
                    break;
                    
                case "UPCA":
                    imgPanel.setImage((BufferedImage) BarcodeImage.getBarcodeUPCA(enterText.getText()));
                    break;
            }
        });

        panel.add(enterText);
        panel.add(_fontCombo);
        panel.add(imgPanel);
        panel.add(imgPanel2);

        f.add(panel);
        f.setSize(800, 480);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}

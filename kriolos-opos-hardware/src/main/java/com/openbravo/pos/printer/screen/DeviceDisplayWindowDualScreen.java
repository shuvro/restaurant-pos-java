package com.openbravo.pos.printer.screen;

import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.printer.DeviceDisplay;
import com.openbravo.pos.printer.screen.DeviceDisplayPanel;
import com.openbravo.pos.util.ThumbNailBuilder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeviceDisplayWindowDualScreen extends JFrame implements DeviceDisplay, DeviceDisplayAdvance {

    private static final long serialVersionUID = 1L;

    private final String m_sName;

    private final DeviceDisplayPanel m_display;

    JPanel m_jContainer = new JPanel();

    JPanel m_jPanTitle = new JPanel();

    JPanel m_jPanDisplay = new JPanel();

    JLabel m_jTitle = new JLabel();

    JLabel m_jPoweredby = new JLabel();

    JLabel m_jCalendar = new JLabel();

    JLabel m_jLogo = new JLabel();

    JLabel m_jImage = new JLabel();

    JPanel m_jListContainer = new JPanel();

    JFrame display_frame = new JFrame();

    private final DateFormat m_hourminformat = new SimpleDateFormat("h:mm a");

    private Timer tDateTime;

    public DeviceDisplayWindowDualScreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();
        for (GraphicsDevice screen : screens) {
            JFrame dualview = new JFrame(screen.getDefaultConfiguration());
            this.display_frame.setLocationRelativeTo(dualview);
            dualview.dispose();
        }
        this.display_frame.setUndecorated(true);
        this.m_sName = AppLocal.getIntString("display.window", AppLocal.APP_NAME);
        this.m_display = new DeviceDisplayPanel(3.0D);
        this.m_jContainer.setLayout(new BorderLayout());
        this.m_jPanTitle.setLayout(new BorderLayout());
        this.m_jPanDisplay.setLayout(new BorderLayout());
        Color background = new Color(254, 254, 254);
        this.m_jPanTitle.setBackground(background);
        this.m_jTitle.setText("<html><center><style=font-size:20px;><font color = black>" + m_sName + "</font></style>");
        this.m_jTitle.setHorizontalAlignment(0);
        this.m_jTitle.setBackground(background);
        this.m_jPanTitle.add(this.m_jTitle, "Center");
        this.m_jCalendar.setBackground(background);
        this.m_jPanTitle.add(this.m_jCalendar, "West");
        URL powerIconUrl = getClass().getResource("/com/openbravo/images/poweredby.png");
        if (powerIconUrl != null) {
            ImageIcon powerBy = new ImageIcon(powerIconUrl);
            this.m_jPoweredby.setIcon(powerBy);
        }
        this.m_jPoweredby.setText(AppLocal.APP_VERSION);
        this.m_jPoweredby.setBackground(background);
        this.m_jLogo.setHorizontalAlignment(0);

        URL appLogoUrl = getClass().getResource("/com/openbravo/images/logo.png");
        if (appLogoUrl != null) {
            ImageIcon customerDisplayLogo = new ImageIcon();
            this.m_jLogo.setIcon(customerDisplayLogo);
        }
        this.m_jPanTitle.add(this.m_jPoweredby, "East");
        this.m_jPanDisplay.add(this.m_jPanTitle, "First");
        this.m_jPanDisplay.add(this.m_jLogo, "Center");
        this.m_jPanDisplay.add(this.m_jImage, "After");
        this.m_jContainer.add(this.m_jPanDisplay, "First");
        this.m_jContainer.add(this.m_display.getDisplayComponent(), "Before");
        this.m_jListContainer.setLayout(new BorderLayout());
        this.m_jContainer.add(this.m_jListContainer, "Center");
        this.display_frame.add(this.m_jContainer);
        this.display_frame.setDefaultCloseOperation(2);
        this.display_frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
        this.display_frame.pack();
        this.display_frame.setExtendedState(6);
        setDateTime();
        this.display_frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (DeviceDisplayWindowDualScreen.this.tDateTime != null) {
                    DeviceDisplayWindowDualScreen.this.tDateTime.cancel();
                    DeviceDisplayWindowDualScreen.this.tDateTime.purge();
                }
            }
        });
        this.display_frame.setVisible(true);
        initComponents();
    }
    
    private void initComponents(){
       setTitle(this.m_sName);
    }

    private void setDateTime() {
        this.tDateTime = new Timer();
        this.tDateTime.schedule(new TimerTask() {
            @Override
            public void run() {
                Calendar cal = Calendar.getInstance();
                DeviceDisplayWindowDualScreen.this.m_jCalendar.setText(Formats.SIMPLEDATE.formatValue(cal.getTime()) + " " + DeviceDisplayWindowDualScreen.this.m_hourminformat.format(cal.getTime()));
            }
        }, 250L, 60000L);
    }

    @Override
    public String getDisplayName() {
        return this.m_sName;
    }

    @Override
    public String getDisplayDescription() {
        return null;
    }

    @Override
    public JComponent getDisplayComponent() {
        return null;
    }

    @Override
    public void writeVisor(int animation, String sLine1, String sLine2) {
        this.m_display.writeVisor(animation, sLine1, sLine2);
    }

    @Override
    public void writeVisor(String sLine1, String sLine2) {
        this.m_display.writeVisor(sLine1, sLine2);
    }

    @Override
    public void clearVisor() {
        this.m_display.clearVisor();
    }

    @Override
    public boolean hasFeature(int feature) {
        return ((0x3 & feature) > 0);
    }

    @Override
    public boolean setProductImage(BufferedImage img) {
        BufferedImage resizeImg = ThumbNailBuilder.resize(img, 400, 384);
        this.m_jImage.setIcon((img == null) ? null : new ImageIcon(resizeImg));
        return true;
    }

    @Override
    public boolean setTicketLines(JPanel ticketlines) {
        this.m_jListContainer.add((Component) ticketlines);
        return true;
    }

    @Override
    public void setCustomerImage(BufferedImage customerImage) {
        if (customerImage != null) {
            ImageIcon customerDisplayLogo = new ImageIcon(ThumbNailBuilder.resize(customerImage, 1024, 384));
            this.m_jLogo.setIcon(customerDisplayLogo);
        }
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
        this.m_jTitle.setText("<html><center><style=font-size:20px;><font color = black>" + title + "</font></style>");
    }

    @Override
    public void repaintLines() {
    }

}

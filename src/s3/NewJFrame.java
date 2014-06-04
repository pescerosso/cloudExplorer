package s3;

import jaco.mp3.player.MP3Player;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class NewJFrame extends javax.swing.JFrame implements ItemListener {

    Credentials cred = new Credentials();
    BucketClass bucket = new BucketClass();
    Acl objectacl = new Acl();
    String Home = System.getProperty("user.home");
    String OS = System.getProperty("os.name");
    String[] bucketarray = null;
    String[] objectarray = null;
    String[] syncarray = null;
    String[] account_array = new String[20];
    String[] simple_account_array = new String[account_array.length];
    int active_account = 0;
    int object_size = 500000;
    int total_accounts = 0;
    JRadioButton b[] = new JRadioButton[object_size];
    JRadioButton d[] = new JRadioButton[object_size];
    JRadioButton f[] = new JRadioButton[account_array.length];
    int active_bucket = 0;
    String object_acl_change = null;
    String temp_file = (Home + File.separator + "object.tmp");
    String config_file = (Home + File.separator + "s3.config");
    String[] localdata = new String[object_size];
    JFrame dialog = new JFrame();
    JLabel dialog_label = new JLabel("Please wait for operation to complete. This will close upon completion.");
    JPanel dialog_panel = new JPanel();
    int initial_display = 1000;
    int account_counter = 0;
    int content_counter = 0;
    int previous_objectarray_length = 0;
    Put put;
    Get get;
    Delete del;
    SyncFromS3 syncFromS3;
    SyncToS3 syncToS3;
    boolean isSyncingToS3 = true;
    JButton more = new JButton("Show all Objects");
    boolean limited = true;
    public static boolean object_thread_status;
    public static boolean bucket_thread_status;
    ReloadBuckets buckets = null;
    boolean host_alive = false;

    public NewJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jScrollPane27 = new javax.swing.JScrollPane();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane28 = new javax.swing.JScrollPane();
        jButton9 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        scrollPane1 = new java.awt.ScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jFileChooser1 = new javax.swing.JFileChooser();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jFileChooser2 = new javax.swing.JFileChooser();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jButton16 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/s3/logo_cloudian.png"))); // NOI18N
        jLabel10.setOpaque(true);

        jTextField10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jButton6.setBackground(java.awt.SystemColor.text);
        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(266, 266, 266))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(420, 420, 420))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(3, 3, 3))
        );

        panel1.setBackground(java.awt.Color.white);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Access Key");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Secret Key");

        jTextField2.setFont(new java.awt.Font("OpenSymbol", 0, 15)); // NOI18N

        jLabel5.setText("Host URL");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Port");

        jLabel7.setText("Region");

        jButton8.setBackground(java.awt.SystemColor.text);
        jButton8.setText("Save");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setBackground(java.awt.SystemColor.text);
        jButton10.setText("Clear");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel11.setText("UserID (optional)");

        jLabel12.setText("GroupID (optional)");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jPanel21.setBackground(java.awt.SystemColor.text);
        jPanel21.setAlignmentX(0.0F);
        jPanel21.setAlignmentY(0.0F);
        jPanel21.setAutoscrolls(true);
        jPanel21.setOpaque(false);

        jScrollPane28.setBorder(null);
        jScrollPane28.setOpaque(false);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 137, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        jScrollPane27.setViewportView(jPanel21);

        jButton9.setBackground(java.awt.SystemColor.text);
        jButton9.setText("Load");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton2.setBackground(java.awt.SystemColor.text);
        jButton2.setText("Delete Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton17.setBackground(java.awt.SystemColor.text);
        jButton17.setText("Abort");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4)
                                        .addComponent(jTextField3)
                                        .addComponent(jTextField2)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField8)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jButton10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton8)
                            .addGap(50, 50, 50)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 114, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(56, 56, 56))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8)
                        .addComponent(jButton10))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton17)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Settings", jPanel3);

        scrollPane1.setBackground(java.awt.SystemColor.text);

        jPanel1.setBackground(java.awt.SystemColor.text);

        jPanel5.setBackground(java.awt.SystemColor.text);
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);
        jPanel5.setAutoscrolls(true);
        jPanel5.setOpaque(false);

        jScrollPane3.setBorder(null);
        jScrollPane3.setOpaque(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel5);

        jLabel1.setText("Bucket");

        jPanel10.setBackground(java.awt.SystemColor.text);

        jButton3.setBackground(java.awt.SystemColor.text);
        jButton3.setText("Download");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(java.awt.SystemColor.text);
        jButton1.setText("Abort download");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(java.awt.SystemColor.text);
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setBackground(java.awt.SystemColor.text);
        jButton7.setText("Properties");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton12.setBackground(java.awt.SystemColor.text);
        jButton12.setText("Edit");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(java.awt.SystemColor.text);
        jButton13.setText("Select All");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(java.awt.SystemColor.text);
        jButton14.setText("Deselect All");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(0, 0, 0)
                .addComponent(jButton4)
                .addGap(0, 0, 0)
                .addComponent(jButton7)
                .addGap(0, 0, 0)
                .addComponent(jButton12)
                .addGap(0, 0, 0)
                .addComponent(jButton13)
                .addGap(0, 0, 0)
                .addComponent(jButton14)
                .addGap(0, 0, 0)
                .addComponent(jButton1)
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel11.setBackground(javax.swing.UIManager.getDefaults().getColor("text"));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 797, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );

        jScrollPane7.setViewportView(jPanel11);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 60, Short.MAX_VALUE))
        );

        scrollPane1.add(jPanel1);

        jTabbedPane1.addTab("Object Explorer", scrollPane1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jFileChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        jFileChooser1.setDragEnabled(true);
        jFileChooser1.setMultiSelectionEnabled(true);
        jFileChooser1.setOpaque(true);
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(java.awt.SystemColor.text);
        jButton5.setText("Upload");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setText("Destination in Bucket:");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jButton15.setBackground(java.awt.SystemColor.text);
        jButton15.setText("Abort upload");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton15)
                .addContainerGap(138, Short.MAX_VALUE))
            .addComponent(jFileChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton15))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Upload", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jFileChooser2.setBackground(new java.awt.Color(255, 255, 255));
        jFileChooser2.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        jFileChooser2.setDragEnabled(true);
        jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser2ActionPerformed(evt);
            }
        });

        jToggleButton3.setBackground(java.awt.SystemColor.text);
        jToggleButton3.setText("Sync to S3");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setBackground(java.awt.SystemColor.text);
        jToggleButton4.setText("Sync from S3");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jButton16.setBackground(java.awt.SystemColor.text);
        jButton16.setText("Abort");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jFileChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jFileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton4)
                    .addComponent(jButton16))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sync", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jButton11.setBackground(java.awt.SystemColor.text);
        jButton11.setText("Save");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel8.setText("Object Name:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(1, 1, 1)
                .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addGap(14, 14, 14))
            .addComponent(jScrollPane4)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Text Editor", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setText("Version: 1.9 (Development)\n\nPlease submit bugs via github: https://github.com/rusher81572/s3 \n\nWhat is new in this release? \n\n1. Object Explorer will only show the first 1000 objects. Added a button \"Show all objects\" to display all the objects.\n2. Syncing now syncs subdirectories.\n3. For stability, delete operations are limited to 500.\n4. Object explorer displays the total number of objects in the bucket.\n5. Fixed bug that makes sync work again after aborting a sync.\n\n----------------------------------------------------------------------------------\n\nVersion: 1.8\n\n1. Deletes are now threaded.\n2. Fixed a bug to allow multiple \"Sync to S3\" operations without reloading objects manually.\n3. Toolbar in \"Object Explorer\" is now persistent when scrolling.\n4. Secret key contains special characters for privacy reasons.\n5. Fixed a bug when creating buckets on AWS.\n6. Fixed a bug when deleting an object from the search results.\n\n* Special note for Background Sync users *\n\nBackground Sync will not recursively sync directories.\n\n----------------------------------------------------------------------------------\nVersion: 1.7.3\n\n1. Logging window scrolls automatically now.\n2. Support for @ in the object name.\n\n----------------------------------------------------------------------------------\nVersion: 1.7.2\n\n1. Fixed a bug with background sync.\n2. Background Sync is now working properly.\n\n----------------------------------------------------------------------------------\n\nVersion: 1.7.1 \n\n1. Code improvements.\n2. Fixed bug with displaying images.\n3. Fixed bug with playing music.\n\n\nIf you plan on using this feature, background sync will automatically use the first account entry in ~/s3.config\n\n----------------------------------------------------------------------------------\n\nVersion: 1.7\n\nCode improvements.\nSupport for aborting Uploads and Downloads.\nPUT and GET operations are done in a separate thread.\n\n----------------------------------------------------------------------------------\nVersion: 1.6\n\nFaster search. \nSettings is now the default startup tab so the user can quickly choose the S3 account to load.\nUpon selecting a bucket. Object Explorer will automatically load and display the objects.\nImprovement to accounts. Single click to load account and buckets.\nMajor GUI changes.\nFixed text editor window size.");
        jTextArea4.setBorder(null);
        jTextArea4.setCaretPosition(0);
        jScrollPane6.setViewportView(jTextArea4);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("About", jPanel7);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        jMenu1.setText("File");

        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Bucket");

        jMenuItem1.setText("Create Bucket");
        jMenuItem1.setToolTipText("");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Bucket ACL");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Delete");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Objects");

        jMenuItem6.setText("Modify Object ACL");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("View Object ACL");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem14.setText("Play Music File");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuItem8.setText("View in Image Viewer");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Background Syncing");

        jMenuItem15.setText("Run");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem9.setText("Configure");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String convertObject(String what, String operation) {

        if (what.contains("/")) {
            what = what.replace("/", File.separator);
        }

        if (what.contains("\\")) {
            what = what.replace("\\", File.separator);
        }

        int count = 0;
        int slash_counter = 0;
        String out_file = null;
        int another_counter = 0;

        for (int y = 0; y != what.length(); y++) {
            if (what.substring(y, y + 1).contains(File.separator)) {
                slash_counter++;
                another_counter = y;
            }
        }

        for (int y = 0; y != what.length(); y++) {
            if (y == another_counter) {
                if (operation.contains("download")) {
                    if (what.contains(File.separator)) {
                        out_file = (what.substring(y, what.length()));
                    } else {
                        out_file = (what);
                    }
                } else {
                    out_file = (what.substring(y + 1, what.length()));
                }
            }
        }
        return out_file;
    }

    public void loadBuckets() {
        //preload();
        jTextArea1.append("\nPlease wait, loading Buckets.");
        calibrateTextArea();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if ((jTextField1.getText().length() > 1 || jTextField2.getText().length() > 1)) {
                    var();
                    reloadBuckets();
                } else {
                    jTextArea1.append("\nError: Configuration not loaded\n");
                }
                calibrateTextArea();
            }
        });
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (active_bucket > 0) {

            more.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    limited = false;
                    jButton6.doClick();
                }
            });

            reloadObjects();

            try {
                int found = 0;
                int display_counter = initial_display;

                jTabbedPane1.setSelectedIndex(1);

                if (limited) {
                    jPanel11.add(more);
                } else {
                    display_counter = objectarray.length;
                }

                for (int i = 1; i != display_counter; i++) {
                    if (d[i] != null) {
                        if (d[i].getText().toLowerCase().contains(jTextField10.getText().toLowerCase())) {
                            jPanel11.add(d[i]);
                            d[i].setVisible(true);
                            found++;
                        } else {
                            d[i].setVisible(false);
                        }
                    }
                }

                if (found == 0) {
                    reloadObjects();
                    jTextArea1.append("\nNo objects found for search. \n");
                } else {
                    int display = objectarray.length - 1;
                    jTextArea1.append("\nLoaded objects. Total number of objects in this bucket: " + display + ". Displaying a maximum of: " + initial_display + " objects at a time.");
                    calibrateTextArea();
                }
            } catch (Exception searchBar) {

            }
        } else {
            jTextArea1.append("\nError: No bucket has been selected\n");
        }

        calibrateTextArea();
    }

    void clear_old_radio_buttons() {

        try {
            for (int c = 1; c != bucketarray.length; c++) {
                if (c == active_bucket) {
                } else {
                    b[c].setSelected(false);
                }
            }
        } catch (Exception clear_old_radio) {
        }

    }

    public void itemStateChanged(ItemEvent event) {
        try {
            for (int h = 1; h != bucketarray.length; h++) {
                if (bucketarray.length > 1) {
                    if (b[h] != null) {
                        if (b[h].isSelected()) {
                            if (h != active_bucket) {
                                active_bucket = h;
                                cred.setBucket(b[h].getText());
                                clear_old_radio_buttons();
                                h = bucketarray.length;
                                objectarray = null;
                                jTextArea1.append("\nPlease wait, loading objects.");
                                calibrateTextArea();
                                java.awt.EventQueue.invokeLater(new Runnable() {
                                    public void run() {
                                        jButton6.doClick();
                                    }
                                });
                            }
                        }
                    }
                }
            }
        } catch (Exception ItemStateChanged) {
        }

        try {
            for (int h = 1; h != account_array.length; h++) {
                if (f[h] != null) {
                    if (f[h].isSelected()) {
                        if (h != active_account) {
                            active_account = h;
                            changeAccountRadioButtons();
                            h = account_array.length;
                            objectarray = null;
                            active_bucket = 0;
                            jButton9.doClick();
                        }
                    }
                }
            }
        } catch (Exception ItemStateChanged) {
        }

    }

    public void changeAccountRadioButtons() {
        try {
            for (int c = 1; c != account_array.length; c++) {
                if (c == active_account) {
                } else {
                    f[c].setSelected(false);
                }
            }
        } catch (Exception clear_old_radio) {
        }
    }

    void loadConfig() {
        String data = null;
        account_array = new String[20];
        config_file = (Home + File.separator + "s3.config");

        try {
            for (int k = 0; k != account_array.length; k++) {
                account_array[k] = null;
                f[k].setText("");
            }
        } catch (Exception nads) {
        }

        try {
            FileReader fr = new FileReader(config_file);
            BufferedReader bfr = new BufferedReader(fr);
            String read = null;
            int h = 0;
            while ((read = bfr.readLine()) != null) {
                if (read != null) {
                    if (read.length() > 1) {
                        account_array[h] = read;
                        content_counter++;
                    }
                }
                h++;
            }
        } catch (Exception loadConfig) {
        }

        for (int h = 0; h != account_array.length; h++) {
            if (account_array[h] != null) {
                String[] foo = account_array[h].split("@");
                jPanel21.setLayout(new BoxLayout(jPanel21, BoxLayout.Y_AXIS));
                f[h] = new JRadioButton();
                f[h].setText(foo[2]);
                f[h].addItemListener(this);
                jPanel21.add(f[h]);
                jPanel21.revalidate();
                validate();
            }
        }

        jPanel21.setLayout(new BoxLayout(jPanel21, BoxLayout.Y_AXIS));
        jPanel21.repaint();
        jPanel21.revalidate();
        jPanel21.validate();

        if (content_counter == 0) {
            jTextArea1.append("\nError: No saved configurations found.\n");
            account_counter = 0;
        }
        calibrateTextArea();
    }

    void drawBuckets() {
        jPanel5.removeAll();
        jPanel5.revalidate();
        jPanel5.repaint();
        jPanel5.setLayout(new BoxLayout(jPanel5, BoxLayout.PAGE_AXIS));

        if (bucketarray != null) {
            for (int h = 1; h != bucketarray.length; h++) {
                jPanel5.setLayout(new BoxLayout(jPanel5, BoxLayout.Y_AXIS));
                b[h] = new JRadioButton();
                b[h].setText(bucketarray[h]);
                b[h].addItemListener(this);
                jPanel5.add(b[h]);
                setLocation(h, 5);
                jPanel5.revalidate();
                validate();
            }

            objectarray = null;
            reloadObjects();

            if (bucketarray.length > 1 && b[1] != null) {
                active_bucket = 2;
                b[1].doClick();
            }
        }

    }

    Boolean ping(String address) {
        host_alive = true;
        try {
            InetAddress s3address = InetAddress.getByName(address);
            jTextArea1.append("\nLooking up: " + s3address.isReachable(3000));
            calibrateTextArea();
        } catch (UnknownHostException e) {
            host_alive = false;
        } catch (IOException e) {
            host_alive = false;
        }
        return host_alive;
    }

    void reloadBuckets() {
        if ((jTextField1.getText().length() > 1 || jTextField2.getText().length() > 1)) {
            var();
            String host = null;
            bucketarray = null;
            if (jTextField3.getText().contains("http") || jTextField3.getText().contains("https")) {
                if (jTextField3.getText().contains("http")) {
                    host = jTextField3.getText().replace("http://", "");
                } else {
                    host = jTextField3.getText().replace("https://", "");
                }
            }
            if (ping(host)) {
                ReloadBuckets buckets = new ReloadBuckets(cred.getAccess_key(), cred.getSecret_key(), cred.getEndpoint());
                buckets.run();
                active_bucket = 0;

                while (bucket_thread_status) {
                    System.out.print("\nWaiting");
                }

                String bucketlist = buckets.bucketlist;
                bucketarray = bucketlist.split(" ");
                System.out.print("\nDebug");
                drawBuckets();
            } else {
                jTextArea1.append("\nError: host not found");
            }
        } else {
            jTextArea1.append("\nError: Configuration not loaded\n");
        }
        calibrateTextArea();
    }

    void redrawObjects() {
        jPanel11.setLayout(new BoxLayout(jPanel11, BoxLayout.PAGE_AXIS));

        for (int h = 1; h != objectarray.length; h++) {
            jPanel11.setLayout(new BoxLayout(jPanel11, BoxLayout.Y_AXIS));
            d[h] = new JRadioButton();
            d[h].setText(objectarray[h]);
        }
        jPanel11.setLayout(new BoxLayout(jPanel11, BoxLayout.PAGE_AXIS));

        if (objectarray.length > initial_display) {
            limited = true;
        } else {
            limited = false;
        }

    }

    void reloadObjects() {

        if ((jTextField1.getText().length() > 1 || jTextField2.getText().length() > 1)) {
            var();
            jPanel11.removeAll();
            jPanel11.revalidate();
            jPanel11.repaint();
            jPanel11.setLayout(new BoxLayout(jPanel11, BoxLayout.PAGE_AXIS));

            try {
                for (int h = 1; h != bucketarray.length; h++) {
                    if (b[h] != null) {
                        if (b[h].isSelected()) {
                            ReloadObjects object = new ReloadObjects(cred.getAccess_key(), cred.getSecret_key(), b[h].getText(), cred.getEndpoint());
                            object.run();
                            String objectlist = object.objectlist;
                            objectarray = objectlist.split("@@");
                            previous_objectarray_length = objectarray.length;
                        }
                    }
                }

                while (object_thread_status) {
                }

                redrawObjects();

            } catch (Exception listing) {
            }

        } else {
            jTextArea1.append("\nError: Configuration not loaded\n");
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    void preload() {

        config_file = (Home + File.separator + "s3.config");

        File checkConfig = new File(config_file);
        if (checkConfig.exists()) {
            jButton9.doClick();
        }
    }

    void editorSync(String file) {

        temp_file = (Home + File.separator + "object.tmp");

        File tmp = new File(temp_file);

        try {
            FileWriter fr = new FileWriter(temp_file);
            BufferedWriter bfr = new BufferedWriter(fr);
            bfr.write(jTextArea2.getText());
            bfr.close();
        } catch (Exception writeConfig) {
            jTextArea1.append("\n" + writeConfig.getMessage() + "\n");
        }
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if ((jTextField1.getText().length() > 1 || jTextField2.getText().length() > 1)) {
            var();
            // reloadBuckets();
            String response = JOptionPane.showInputDialog(null, "Bucket Name: ", "Create a bucket", JOptionPane.OK_CANCEL_OPTION);
            jTextArea1.append("\n" + bucket.makeBucket(cred.getAccess_key(), cred.getSecret_key(), response.toLowerCase(), cred.getEndpoint(), cred.getRegion()));
            reloadBuckets();
        } else {
            jTextArea1.append("\nError: Configuration not loaded\n");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            if (active_bucket > 0) {
                final JFrame bucketACL = new JFrame("Bucket ACL Settings");
                final JCheckBox static_website = new JCheckBox("Static Website");
                final JButton bucketACLbutton = new JButton("Commit");

                bucketACLbutton.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (static_website.isSelected()) {
                            objectacl.setBUCKETwebsite(object_acl_change, cred.getAccess_key(), cred.getSecret_key(), cred.getEndpoint(), cred.getBucket());
                            jTextArea1.append("\nWebsite access enabled.\n");
                            bucketACL.setVisible(false);
                        } else {
                            objectacl.removeBUCKETwebsite(object_acl_change, cred.getAccess_key(), cred.getSecret_key(), cred.getEndpoint(), cred.getBucket());
                            jTextArea1.append("\nBucket is no longer serving a website.\n");
                            bucketACL.setVisible(false);
                        }
                    }
                });

                JPanel foopanel = new JPanel();
                bucketACL.setPreferredSize(new Dimension(225, 75));
                bucketACL.setResizable(false);
                foopanel.setLayout(new BoxLayout(foopanel, BoxLayout.PAGE_AXIS));
                bucketACL.add(foopanel);
                foopanel.add(static_website);
                foopanel.add(bucketACLbutton);
                bucketACL.setLocation(500, 500);
                bucketACL.pack();
                bucketACL.setVisible(true);

            } else {
                jTextArea1.append("\nError: No bucket has been selected\n");
            }
        } catch (Exception Download) {
            jTextArea1.append("\n" + Download.getMessage() + "\n");
        }
        calibrateTextArea();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if ((jTextField1.getText().length() > 1 || jTextField2.getText().length() > 1)) {
            var();

            for (int i = 0; i != bucketarray.length; i++) {
                if (b[i] != null) {

                    if (b[i].isSelected()) {
                        jTextArea1.append(bucket.deleteBucket(cred.access_key, cred.secret_key, b[i].getText(), cred.end_point, cred.region));
                        b[i].setSelected(false);
                        active_bucket = 0;
                    }
                }
            }
            reloadBuckets();
        } else {
            jTextArea1.append("\nError: Configuration not loaded\n");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(-1);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {

            if (active_bucket > 0) {
                final JFrame parent = new JFrame("Object ACL Settings");
                final JCheckBox public_box = new JCheckBox("Public");
                final JCheckBox url_box = new JCheckBox("URL Access");
                final JCheckBox private_box = new JCheckBox("Private Access");
                final JButton acl = new JButton("Commit");

                acl.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        for (int i = 1; i != previous_objectarray_length; i++) {
                            try {
                                if (d[i].isSelected()) {
                                    object_acl_change = d[i].getText();
                                    if (public_box.isSelected()) {
                                        objectacl.setACLpublic(object_acl_change, cred.getAccess_key(), cred.getSecret_key(), cred.getEndpoint(), cred.getBucket());
                                        jTextArea1.append("\nPublic set for object: " + object_acl_change + "\n");
                                        parent.setVisible(false);
                                    }

                                    if (url_box.isSelected()) {
                                        jTextArea1.append("\n" + objectacl.setACLurl(object_acl_change, cred.getAccess_key(), cred.getSecret_key(), cred.getEndpoint(), cred.getBucket()));
                                        parent.setVisible(false);
                                    }
                                    if (private_box.isSelected()) {
                                        objectacl.setACLprivate(object_acl_change, cred.getAccess_key(), cred.getSecret_key(), cred.getEndpoint(), cred.getBucket());
                                        jTextArea1.append("\nPrivate access set for object: " + object_acl_change + "\n");
                                        parent.setVisible(false);
                                    }
                                }
                            } catch (Exception ObjectACL) {
                                jTextArea1.append("\n" + ObjectACL.getMessage() + "\n");
                            }
                        }
                        calibrateTextArea();
                    }

                });

                JPanel foopanel = new JPanel();
                parent.setPreferredSize(new Dimension(225, 120));
                parent.setResizable(false);
                foopanel.setLayout(new BoxLayout(foopanel, BoxLayout.PAGE_AXIS));
                parent.add(foopanel);
                foopanel.add(public_box);
                foopanel.add(url_box);
                foopanel.add(private_box);
                foopanel.add(acl);
                parent.setLocation(500, 500);
                parent.pack();
                parent.setVisible(true);
            } else {
                jTextArea1.append("\nError: No bucket has been selected");
            }
        } catch (Exception Download) {
            jTextArea1.append("\n" + Download.getMessage());
        }

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {

            if (active_bucket > 0) {
                for (int i = 1; i != previous_objectarray_length; i++) {
                    if (d[i].isSelected()) {
                        object_acl_change = d[i].getText();
                        jTextArea1.append("\n" + objectacl.viewACL(object_acl_change, cred.getAccess_key(), cred.getSecret_key(), cred.getEndpoint(), cred.getBucket()));
                    }
                }
            } else {
                jTextArea1.append("\nError: No bucket has been selected");
            }
        } catch (Exception Download) {
            jTextArea1.append("\n" + Download.getMessage());
        }
        calibrateTextArea();
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    void deleteFle(String what) {
        try {
            File file = new File(what);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception deleteFIle) {
            jTextArea1.append("\n" + deleteFIle.getMessage());
        }
    }
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        try {

            temp_file = (Home + File.separator + "object.tmp");

            JLabel image[] = new JLabel[objectarray.length];
            ImageIcon[] photo = new ImageIcon[objectarray.length];
            JFrame image_frame = new JFrame();
            JScrollBar bar = new JScrollBar(JScrollBar.VERTICAL);
            JPanel image_panel = new JPanel();
            JScrollPane scrolling_pane = new JScrollPane(image_panel);
            image_frame.setSize(new Dimension(2000, 1000));
            image_frame.add(scrolling_pane);

            for (int i = 1; i != previous_objectarray_length; i++) {
                if (d[i].isSelected()) {
                    image_panel.setLayout(new BoxLayout(image_panel, BoxLayout.PAGE_AXIS));
                    String new_object_name = convertObject(d[i].getText(), "download");
                    jTextArea1.setText("Please wait, the image is loading.");
                    get = new Get(d[i].getText(), cred.access_key, cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), temp_file + i);
                    get.run();
                    photo[i] = new ImageIcon(temp_file + i);
                    image[i] = new JLabel(photo[i]);
                    image_panel.add(image[i]);
                    image_frame.repaint();
                    image_frame.revalidate();
                    image_frame.validate();
                    deleteFle(temp_file + i);
                    break;
                }

            }
            image_frame.setVisible(true);
            image_frame.setAlwaysOnTop(true);
            dialog.setVisible(false);
        } catch (Exception imageLoading) {
            jTextArea1.append("\n" + imageLoading.getMessage());
        }
        calibrateTextArea();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (active_bucket > 0) {

            temp_file = (Home + File.separator + "object.tmp");
            editorSync(jTextField6.getText());
            put = new Put(temp_file, cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), jTextField6.getText());
            put.startc(temp_file, cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), jTextField6.getText());
            jTextArea1.append("\nSaved Object\n");
            objectarray = null;
            //reloadBuckets();
            b[active_bucket].setSelected(true);
        } else {
            jTextArea1.append("\nError: no bucket selected.");
        }
        calibrateTextArea();
    }//GEN-LAST:event_jButton11ActionPerformed


    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if (active_bucket > 0) {
            //syncing_to_S3 = true;
            SyncToS3.running = true;
            jTextArea1.setText("\nPlease wait for Sync to complete.");
            calibrateTextArea();
            reloadObjects();

            if (b[active_bucket].isSelected()) {
                if (jFileChooser2.getSelectedFile() == null) {
                    jTextArea1.append("\nEFrror: please select a destination directory.");
                } else {
                    syncToS3 = new SyncToS3(jFileChooser2.getSelectedFile(), cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), objectarray);
                    syncToS3.startc(jFileChooser2.getSelectedFile(), cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), objectarray);
                    objectarray = null;
                }
            } else {
                jTextArea1.append("\nError, no bucket has been selected.");
                calibrateTextArea();
            }

        } else {
            jTextArea1.append("\nError: No bucket selected.");
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jFileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser2ActionPerformed

    }//GEN-LAST:event_jFileChooser2ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField8.setText("");
            jTextField9.setText("");
        } catch (Exception clear) {
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    void calibrateTextArea() {
        jTextArea1.append("\n");
        try {
            jTextArea1.setCaretPosition(jTextArea1.getLineStartOffset(jTextArea1.getLineCount() - 1));
        } catch (Exception e) {

        }
    }

    void reloadAccounts() {
        String[] account = new String[account_array.length];
        String account_value = null;

        try {

            for (int i = 0; i != account_array.length; i++) {
                if (account_array[i] != null) {
                    if (f[i].isSelected()) {
                        active_account = i;
                        account = account_array[i].split("@");
                        jTextArea1.append("\nLoading configuration for: " + f[i].getText() + "\n");
                        jTextField1.setText(account[0]);
                        jTextField2.setText(account[1]);
                        jTextField3.setText(account[2]);
                        jTextField4.setText(account[3]);
                        jTextField5.setText(account[4]);
                        jTextField8.setText(account[5]);
                        jTextField9.setText(account[6]);
                    }
                }
            }

        } catch (Exception loadconfig) {
        }
        calibrateTextArea();
    }
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        if (account_counter == 0) {
            try {
                jPanel21.removeAll();
                jPanel21.revalidate();
                jPanel21.validate();
                jPanel21.repaint();
                loadConfig();
            } catch (Exception load) {
            }

            if (content_counter > 0) {
                account_counter = 1;
                total_accounts = 1;
                objectarray = null;
            }

        } else {
            reloadAccounts();
            if (active_account > 0) {
                bucketLoader();
            } else {
                jTextArea1.append("\nError: No account has been selected.");
            }
        }

    }//GEN-LAST:event_jButton9ActionPerformed
    void bucketLoader() {
        //preload();
        jTextArea1.append("\nPlease wait, loading Buckets.");
        calibrateTextArea();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if ((jTextField1.getText().length() > 1 || jTextField2.getText().length() > 1)) {
                    var();
                    reloadBuckets();
                    jTabbedPane1.setSelectedIndex(1);
                } else {
                    jTextArea1.append("\nError: Configuration not loaded\n");
                }
                calibrateTextArea();
            }
        });

    }
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String save = cred.writeConfig(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), jTextField5.getText(), jTextField8.getText(), jTextField9.getText());
        jTextArea1.append(save);
        account_counter = 0;
        jButton9.doClick();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if (active_bucket > 0) {
            jTextArea1.setText("\n\nPlease wait for the upload operation to complete.");
            File file = jFileChooser1.getSelectedFile();
            String upload = (file.getAbsolutePath());
            String new_object_name = convertObject(file.getAbsolutePath().toString(), "upload");
            jTextField7.setText(jTextField7.getText().replace("null", ""));
            put = new Put(upload, cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), jTextField7.getText() + new_object_name);
            put.startc(upload, cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), jTextField7.getText() + new_object_name);

        } else {
            jTextArea1.append("\nError: No bucket selected.");
        }
        objectarray = null;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        if (active_bucket > 0) {
            objectarray = null;
            reloadObjects();
            SyncFromS3.running = true;
            if (objectarray.length > 1) {
                jTextArea1.setText("\nPlease wait for SYNC to complete");
                calibrateTextArea();

                if (b[active_bucket].isSelected()) {

                    if (jFileChooser2.getSelectedFile() == null) {
                        jTextArea1.append("\nError: please select a destination directroy.");

                    } else {

                        String Destination = jFileChooser2.getSelectedFile().toString();
                        String[] ObjectsConverted = new String[objectarray.length];

                        for (int i = 1; i != objectarray.length; i++) {
                            if (objectarray[i] != null) {
                                ObjectsConverted[i] = convertObject(objectarray[i], "download");
                            }
                        }

                        syncFromS3 = new SyncFromS3(objectarray, ObjectsConverted, cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), Destination);
                        syncFromS3.startc(objectarray, ObjectsConverted, cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), Destination);
                    }

                } else {
                    jTextArea1.append("\nError: No bucket selected.");
                }

            } else {
                jTextArea1.append("\nError: Bucket has no objects to sync");
                calibrateTextArea();
            }
            calibrateTextArea();
    }//GEN-LAST:event_jToggleButton4ActionPerformed
    }
    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        try {

            temp_file = (Home + File.separator + "object.tmp");

            if (active_bucket > 0) {
                final MP3Player mp3 = new MP3Player(new File(temp_file));
                final JFrame musicFrame = new JFrame("Music Player");
                final JPanel musicPanel = new JPanel();
                final JButton stopMusic = new JButton("Stop Music");
                final JButton replayMusic = new JButton("Replay");
                final JButton closeMusic = new JButton("Close");

                stopMusic.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        mp3.stop();
                    }
                });
                replayMusic.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        mp3.stop();
                        mp3.play();
                    }
                });
                closeMusic.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        mp3.stop();
                        musicFrame.setVisible(false);
                    }
                });
                for (int h = 1; h != previous_objectarray_length; h++) {
                    if (d[h].isSelected()) {
                        musicFrame.setResizable(false);
                        musicFrame.add(musicPanel);
                        musicPanel.add(stopMusic);
                        musicPanel.add(replayMusic);
                        musicPanel.add(closeMusic);
                        musicFrame.setLocation(500, 200);
                        musicPanel.repaint();
                        musicPanel.revalidate();
                        musicPanel.validate();
                        musicFrame.pack();
                        jTextArea1.setText("Please wait, the song is loading.");
                        get = new Get(d[h].getText(), cred.access_key, cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), temp_file);
                        get.run();
                        mp3.play();
                        dialog.setVisible(false);
                        musicFrame.setVisible(true);
                        musicFrame.setAlwaysOnTop(true);
                        break;
                    }
                }

            } else {
                jTextArea1.append("\nError: No bucket has been selected");
            }
        } catch (Exception mp3player) {
            jTextArea1.append("\n" + mp3player.getMessage());
        }
        calibrateTextArea();

    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        Daemon daemon = new Daemon();
        daemon.gui = true;
        daemon.start();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        try {

            if (active_bucket > 0) {
                final JFrame bg_frame = new JFrame("Directory to Sync:");
                final JFileChooser bg_choose = new JFileChooser();
                bg_choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                final JButton bg_button = new JButton("Save");

                bg_button.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        File choice = new File(bg_choose.getSelectedFile().toString());
                        try {
                            FileWriter fr = new FileWriter(Home + File.separator + "s3config.sync");
                            BufferedWriter bfr = new BufferedWriter(fr);
                            bfr.write(bg_choose.getSelectedFile().toString() + " " + b[active_bucket].getText());
                            bfr.close();
                        } catch (Exception writeConfig) {
                            jTextArea1.append("\n" + writeConfig.getMessage());
                        }
                        bg_frame.setVisible(false);
                    }
                });

                JPanel bg_panel = new JPanel();
                bg_frame.setResizable(false);
                bg_panel.setLayout(new BoxLayout(bg_panel, BoxLayout.PAGE_AXIS));
                bg_panel.add(bg_choose);
                bg_frame.add(bg_panel);
                bg_panel.add(bg_button);
                bg_frame.setLocation(500, 500);
                bg_frame.pack();
                bg_frame.setVisible(true);
            } else {
                jTextArea1.append("\nError: No bucket has been selected");
            }
        } catch (Exception Download) {
            jTextArea1.append("\n" + Download.getMessage());
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (total_accounts != 0) {
            for (int i = 0; i != account_array.length; i++) {
                if (account_array[i] != null) {
                    if (f[i].isSelected()) {
                        jTextArea1.append("\nDeleting Account: " + f[i].getText() + "\n");
                        account_array[i] = null;
                    } else {
                        account_array[i] = account_array[i];
                    }
                }
            }

            try {
                FileWriter fr = new FileWriter(config_file);
                BufferedWriter bfr = new BufferedWriter(fr);
                String read = null;
                for (int i = 0; i != account_array.length; i++) {
                    if (account_array[i] != null) {
                        bfr.write(("\n" + account_array[i]));
                    }
                }
                bfr.close();
                account_counter = 0;
                content_counter = 0;
                loadConfig();
                jButton9.doClick();
            } catch (Exception loadConfig) {
            }

            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField8.setText("");
            jTextField9.setText("");
        } else {
            jTextArea1.append("\nError: No accounts have been loaded.\n");
        }
        calibrateTextArea();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (active_bucket > 0) {

            final JFrame download = new JFrame("Please choose destination directory.");
            final JPanel downloadPanel = new JPanel();
            final JFileChooser downloadChooser = new JFileChooser();
            downloadChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            final JButton downloadButton = new JButton("OK");

            downloadButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    jTextArea1.append("\nPlease wait for the download operation to complete.");
                    calibrateTextArea();
                    if (downloadChooser.getSelectedFile().getAbsolutePath() != null) {

                        File File_Destination = new File(downloadChooser.getSelectedFile().getAbsolutePath());
                        for (int i = 1; i != previous_objectarray_length; i++) {
                            if (d[i] != null) {

                                if (d[i].isSelected()) {
                                    download.setVisible(false);
                                    String new_object_name = convertObject(d[i].getText(), "download");
                                    get = new Get(d[i].getText(), cred.access_key, cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), File_Destination.toString() + File.separator + new_object_name);
                                    get.startc(d[i].getText(), cred.access_key, cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), File_Destination.toString() + File.separator + new_object_name);
                                    d[i].setSelected(false);
                                }
                            }
                        }

                    } else {

                        jTextArea1.append("\nError: destination not specified.");
                    }

                    calibrateTextArea();
                }
            });

            downloadPanel.setLayout(new BoxLayout(downloadPanel, BoxLayout.PAGE_AXIS));
            downloadPanel.add(downloadChooser);
            downloadPanel.add(downloadButton);
            download.add(downloadPanel);
            download.setLocation(500, 500);
            download.pack();
            try {
                for (int i = 1; i != objectarray.length; i++) {
                    if (d[i] != null) {
                        if (d[i].isSelected()) {
                            download.setVisible(true);
                        }
                    }
                }
            } catch (Exception GetThreadRUN) {
            }

        } else {
            jTextArea1.append("\nError: No bucket has been selected");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int delcounter = 0;
        try {

            if (active_bucket > 0) {
                //reloadObjects();
                calibrateTextArea();
                jTextArea1.append("\nPlease wait, deleting selected file(s)");
                calibrateTextArea();
                for (int i = 1; i != previous_objectarray_length; i++) {
                    if (d[i].isSelected()) {
                        if (delcounter < 500) {
                            del = new Delete(d[i].getText(), cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint());
                            del.startc(d[i].getText(), cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint());
                        }
                    }
                    delcounter++;
                }
            } else {
                jTextArea1.append("\nError: No bucked selected.");
            }
        } catch (Exception checkbox) {
        }
        objectarray = null;
        reloadObjects();
        jTextField10.setText("");
        jButton6.doClick();
        jTextArea1.append("\nMultiple Delete operation finished.");

        calibrateTextArea();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {

            if (active_bucket > 0) {
                for (int i = 1; i != previous_objectarray_length; i++) {
                    try {
                        if (d[i].isSelected()) {
                            jTextArea1.setText("\nFile Name: " + d[i].getText());
                            jTextArea1.append("\nSize: " + bucket.getObjectInfo(d[i].getText(), cred.getAccess_key(), cred.getSecret_key(), b[active_bucket].getText(), cred.getEndpoint(), "objectsize") + " KB");
                            jTextArea1.append("\nModified Date: " + bucket.getObjectInfo(d[i].getText(), cred.getAccess_key(), cred.getSecret_key(), b[active_bucket].getText(), cred.getEndpoint(), "objectdate"));
                            break;
                        }

                    } catch (Exception ObjectACL) {
                        jTextArea1.append("\n" + ObjectACL.getMessage() + "\n");
                    }
                }
            } else {
                jTextArea1.append("\nError: No bucket has been selected\n");
            }

        } catch (Exception Download) {
            jTextArea1.append("\n" + Download.getMessage());
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            temp_file = (Home + File.separator + "object.tmp");

            for (int i = 1; i != previous_objectarray_length; i++) {
                if (d[i].isSelected()) {
                    String new_object_name = convertObject(d[i].getText(), "download");
                    get = new Get(d[i].getText(), cred.access_key, cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), temp_file);
                    get.run();
                    try {
                        FileReader frr = new FileReader(temp_file);
                        BufferedReader bfrr = new BufferedReader(frr);
                        String read = null;
                        jTextArea2.setText("");
                        while ((read = bfrr.readLine()) != null) {
                            jTextArea2.append("\n" + read);
                        }
                        bfrr.close();
                    } catch (Exception tempFile) {
                        jTextArea1.append("\n" + tempFile.getMessage());
                    }
                    jTabbedPane1.setSelectedIndex(4);
                    jTextField6.setText(d[i].getText());
                }

            }

        } catch (Exception Download) {
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {
            for (int i = 1; i != previous_objectarray_length; i++) {
                if (d[i].isVisible()) {
                    d[i].setSelected(true);
                }
            }
        } catch (Exception SelectALL) {
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            for (int i = 1; i != previous_objectarray_length; i++) {
                if (d[i].isVisible()) {
                    d[i].setSelected(false);
                }
            }
        } catch (Exception SelectALL) {
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        put.stop();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        get.stop();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed

        if (SyncToS3.running) {
            Abort foo = new Abort("To");
            foo.run();
        }

        if (SyncFromS3.running) {
            Abort foo = new Abort("From");
            foo.run();
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        buckets.stop();
    }//GEN-LAST:event_jButton17ActionPerformed

    void var() {
        cred.setAccess_key(jTextField1.getText());
        cred.setSecret_key(jTextField2.getText());
        String endpoint = (jTextField3.getText() + ":" + jTextField4.getText());
        cred.setEndpoint(endpoint);
        cred.setRegion(jTextField5.getText());
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    public javax.swing.JFileChooser jFileChooser1;
    public static javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    public javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane27;
    public static javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    public javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private java.awt.Panel panel1;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables

}

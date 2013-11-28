package s3;

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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NewJFrame extends javax.swing.JFrame implements ItemListener {

    credentials Cred = new credentials();
    bucket Bucket = new bucket();
    delete Delete = new delete();
    acl ACL = new acl();
    public put Put = new put();
    get Get = new get();
    String Home = System.getProperty("user.home");
    String File_Destination = Home + "/Desktop/";
    String OS = System.getProperty("os.name");
    String[] bucketarray = null;
    String[] objectarray = null;
    JCheckBox b[] = new JCheckBox[1000];
    JCheckBox d[] = new JCheckBox[1000];
    int buckets_loaded = 0;
    int active_bucket = 0;
    String object_acl_change = null;
    String temp_file = (Home + "/object.tmp");
    String config_file = (Home + "/s3.config");

    public NewJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jFileChooser1 = new javax.swing.JFileChooser();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
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
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        scrollPane1 = new java.awt.ScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jFileChooser2 = new javax.swing.JFileChooser();
        jToggleButton3 = new javax.swing.JToggleButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
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
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        jFileChooser1.setDragEnabled(true);
        jFileChooser1.setMultiSelectionEnabled(true);
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(121, 121, 121))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Upload", jPanel2);

        jLabel3.setText("Access Key");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Secret Key");

        jLabel5.setText("Host URL");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Port");

        jLabel7.setText("Region");

        jButton8.setText("Save");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Load");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField4)
                                .addComponent(jTextField3)
                                .addComponent(jTextField2))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(2, 2, 2)
                        .addComponent(jTextField9)))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton9)
                            .addComponent(jButton10))
                        .addGap(1, 1, 1))))
        );

        jTabbedPane1.addTab("Settings", jPanel3);

        jPanel1.setAutoscrolls(true);

        jLabel2.setText("Objects");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(396, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(339, 339, 339))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 560, Short.MAX_VALUE))
        );

        scrollPane1.add(jPanel1);

        jTabbedPane1.addTab("Object Explorer", scrollPane1);

        jFileChooser2.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        jFileChooser2.setDragEnabled(true);
        jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Sync");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jFileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jFileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton3)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sync", jPanel4);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

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
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(1, 1, 1)
                .addComponent(jTextField6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addGap(14, 14, 14))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Text Editor", jPanel6);

        jButton3.setText("Delete Object");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setText("View Objects");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Download");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton1.setText("Load");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jToggleButton1.setText("Deselect All");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Select All");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1)
                        .addGap(63, 63, 63))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton1)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jLabel1.setText("Buckets");

        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);
        jPanel5.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel5);

        jScrollPane3.setViewportView(jScrollPane2);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/s3/logo_cloudian.png"))); // NOI18N

        jMenuBar1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));

        jMenu1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jMenu1.setText("File");

        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu3.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
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

        jMenu2.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jMenu2.setText("Objects");

        jMenuItem6.setText("ACL");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("View ACL");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jCheckBoxMenuItem1.setText("Edit File");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(291, 291, 291)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed
    String convertObject(String what, String operation) {

        String slash = "/";

        if (what.contains(":")) {
            what = what.substring(3, what.length());
        }

        int count = what.split(slash).length;
        count = count - 1;
        int slash_counter = 0;
        String out_file = null;
        int another_counter = 1;

        for (int y = 0; y != what.length(); y++) {

            if (what.substring(y, another_counter).contains(slash)) {
                slash_counter++;
            }

            if (slash_counter == count) {
                if (operation.contains("download")) {
                    out_file = (what.substring(y, what.length()));
                } else {
                    out_file = (what.substring(y + 1, what.length()));
                }
                break;
            }
            another_counter++;
        }
        return (out_file);
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (!OScheck()) {
            File_Destination = ("\\Desktop\\");
        }

        try {
            if (this.buckets_loaded > 0) {
                for (int i = 1; i != objectarray.length; i++) {
                    if (d[i].isSelected()) {
                        String new_object_name = convertObject(d[i].getText(), "download");
                        jTextArea1.append("\n" + Get.get(d[i].getText(), Cred.access_key, Cred.getSecret_key(), Cred.getBucket(), Cred.getEndpoint(), File_Destination + new_object_name));
                        jTextArea1.append("\n\nFinished downloading object to: " + File_Destination + new_object_name);
                        jTextArea1.setCaretPosition(jTextArea1.getSelectionEnd());
                    }
                }
            } else {
                jTextArea1.append("\nError: No bucket has been selected");
            }
        } catch (Exception Download) {
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        preload();

        if ((jTextField1.getText().length() > 1 || jTextField2.getText().length() > 1)) {
            this.var();
            reloadBuckets();
        } else {
            jTextArea1.append("\nError: Configuration not loaded");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {

            if (buckets_loaded > 0) {
                for (int i = 1; i != objectarray.length; i++) {
                    if (d[i].isSelected()) {
                        jTextArea1.append("\n" + Delete.deleteFile(d[i].getText(), Cred.getAccess_key(), Cred.getSecret_key(), Cred.getBucket(), Cred.getEndpoint()));
                        jTextArea1.setCaretPosition(jTextArea1.getSelectionEnd());

                    }
                }
            } else {
                jTextArea1.append("\nError: No bucked selected.");
            }
        } catch (Exception checkbox) {
        }
        reloadObjects();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        if (buckets_loaded > 0) {
            reloadObjects();
            jTabbedPane1.setSelectedIndex(2);
        } else {
            jTextArea1.append("\nError: no bucket has been selected.");
        }
    }

    public void itemStateChanged(ItemEvent e) {
        buckets_loaded = 0;

        for (int h = 1; h != bucketarray.length; h++) {
            if (b[h] != null) {
                if (b[h].isSelected()) {
                    active_bucket = h;
                    Cred.setBucket(b[h].getText());
                    buckets_loaded++;
                }
            }
        }
    }

    void reloadBuckets() {
        if ((jTextField1.getText().length() > 1 || jTextField2.getText().length() > 1)) {
            this.var();
            this.bucketarray = null;

            String bucketlist = Bucket.listBuckets(Cred.getAccess_key(), Cred.getSecret_key(), Cred.getEndpoint());
            bucketarray = bucketlist.split(" ");

            this.jPanel5.removeAll();
            this.jPanel5.revalidate();
            this.jPanel5.repaint();
            this.jPanel5.setLayout(new BoxLayout(this.jPanel5, BoxLayout.PAGE_AXIS));

            if (bucketarray != null) {
                for (int h = 1; h != bucketarray.length; h++) {
                    jPanel5.setLayout(new BoxLayout(jPanel5, BoxLayout.Y_AXIS));
                    b[h] = new JCheckBox();
                    b[h].setText(bucketarray[h]);

                    b[h].addItemListener(this);
                    this.jPanel5.add(b[h]);
                    this.setLocation(h, 5);
                    this.jPanel5.revalidate();
                    validate();
                }
            }
        } else {
            jTextArea1.append("\nError: Configuration not loaded");
        }
    }

    void reloadObjects() {
        if ((jTextField1.getText().length() > 1 || jTextField2.getText().length() > 1)) {
            this.var();
            this.objectarray = null;
            this.jPanel1.removeAll();
            this.jPanel1.revalidate();
            this.jPanel1.repaint();
            this.jPanel1.setLayout(new BoxLayout(this.jPanel1, BoxLayout.PAGE_AXIS));

            try {
                for (int h = 1; h != bucketarray.length; h++) {
                    if (b[h] != null) {
                        if (b[h].isSelected()) {
                            String objectlist = Bucket.listBucketContents(Cred.getAccess_key(), Cred.getSecret_key(), b[h].getText(), Cred.getEndpoint());
                            objectarray = objectlist.split("@");

                        }
                    }
                }

                for (int h = 1; h != objectarray.length; h++) {

                    jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
                    d[h] = new JCheckBox();
                    d[h].setText(objectarray[h]);
                    this.jPanel1.add(d[h]);
                    this.setLocation(h, 5);
                    this.jPanel1.revalidate();
                    validate();
                }

                this.jPanel1.setLayout(new BoxLayout(this.jPanel1, BoxLayout.PAGE_AXIS));

            } catch (Exception listing) {
                System.out.print("\n\nException in readObjects");
            }
        } else {
            jTextArea1.append("\nError: Configuration not loaded");
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    void preload() {

        if (!OScheck()) {
            config_file = (Home + "\\s3.config");
        }

        File checkConfig = new File(config_file);
        if (checkConfig.exists()) {
            jButton9.doClick();
        }
    }


    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if (this.buckets_loaded > 0) {
            File file = jFileChooser1.getSelectedFile();
            String upload = (file.getAbsolutePath());
            String new_object_name = convertObject(file.getAbsolutePath().toString(), "upload");
            jTextArea1.append("\n\nFinished uploading object: " + upload + " to bucket: " + Cred.getBucket());
            jTextField7.setText(jTextField7.getText().replace("null", ""));
            jTextArea1.append("\n" + Put.put(upload, Cred.getAccess_key(), Cred.getSecret_key(), Cred.getBucket(), Cred.getEndpoint(), this.jTextField7.getText() + new_object_name));
        } else {
            jTextArea1.append("\nError: No bucket selected.");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try {
            for (int i = 1; i != objectarray.length; i++) {
                d[i].setSelected(false);
            }
        } catch (Exception SelectALL) {
        }

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed

        try {
            for (int i = 1; i != objectarray.length; i++) {
                d[i].setSelected(true);
            }
        } catch (Exception SelectALL) {
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String load = Cred.loadConfig();
        String[] config_array = load.split(" ");
        jTextField1.setText(config_array[0]);
        jTextField2.setText(config_array[1]);
        jTextField3.setText(config_array[2]);
        jTextField4.setText(config_array[3]);
        jTextField5.setText(config_array[4]);

        try {
            jTextField8.setText(config_array[5]);
            jTextField9.setText(config_array[6]);
        } catch (Exception sdd) {

        }

        jTextArea1.append("\nLoaded configuration.");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String save = Cred.writeConfig(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), jTextField5.getText(), jTextField8.getText(), jTextField9.getText());
        jTextArea1.append(save);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
    }//GEN-LAST:event_jButton10ActionPerformed
    void editorSync(String file) {
        if (!OScheck()) {
            temp_file = (Home + "\\object.tmp");
        }

        File tmp = new File(temp_file);

        try {
            FileWriter fr = new FileWriter(temp_file);
            BufferedWriter bfr = new BufferedWriter(fr);
            bfr.write(jTextArea2.getText());
            bfr.close();
        } catch (Exception writeConfig) {
        }
    }
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (buckets_loaded > 0) {
            if (!OScheck()) {
                temp_file = (Home + "\\object.tmp");
            }

            editorSync(jTextField6.getText());
            jTextArea1.append("\n" + Delete.deleteFile(jTextField6.getText(), Cred.getAccess_key(), Cred.getSecret_key(), Cred.getBucket(), Cred.getEndpoint()));
            jTextArea1.append("\n" + Put.put(temp_file, Cred.getAccess_key(), Cred.getSecret_key(), Cred.getBucket(), Cred.getEndpoint(), jTextField6.getText()));
            jTextArea1.append("\nSaved Object");
            reloadBuckets();
            b[active_bucket].setSelected(true);
        } else {
            jTextArea1.append("\nError: no bucket selected.");
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if (buckets_loaded > 0) {
            if (b[active_bucket].isSelected()) {
                jTextArea1.append("\nStarting Sync:");
                uploadfileList(jFileChooser2.getSelectedFile());

            }
        } else {
            jTextArea1.append("\nError: No bucket selected.");
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jFileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser2ActionPerformed

    }//GEN-LAST:event_jFileChooser2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if ((jTextField1.getText().length() > 1 || jTextField2.getText().length() > 1)) {
            this.var();
            reloadBuckets();
            String response = JOptionPane.showInputDialog(null, "Bucket Name: ", JOptionPane.OK_CANCEL_OPTION);
            jTextArea1.append("\n" + Bucket.makeBucket(Cred.getAccess_key(), Cred.getSecret_key(), response.toLowerCase(), Cred.getEndpoint(), Cred.getRegion()));
            reloadBuckets();

        } else {
            jTextArea1.append("\nError: Configuration not loaded");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            if (this.buckets_loaded > 0) {
                final JFrame bucketACL = new JFrame("Bucket ACL Settings");
                final JCheckBox static_website = new JCheckBox("Static Website");
                final JButton bucketACLbutton = new JButton("Commit");

                bucketACLbutton.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (static_website.isSelected()) {
                            ACL.setBUCKETwebsite(object_acl_change, Cred.getAccess_key(), Cred.getSecret_key(), Cred.getEndpoint(), Cred.getBucket());
                            jTextArea1.append("\nWebsite access enabled.");
                            jTextArea1.setCaretPosition(jTextArea1.getSelectionEnd());
                            bucketACL.setVisible(false);
                        } else {
                            ACL.removeBUCKETwebsite(object_acl_change, Cred.getAccess_key(), Cred.getSecret_key(), Cred.getEndpoint(), Cred.getBucket());
                            jTextArea1.append("\nBucket is no longer serving a website.");
                            jTextArea1.setCaretPosition(jTextArea1.getSelectionEnd());
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
                jTextArea1.append("\nError: No bucket has been selected");
            }
        } catch (Exception Download) {
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if ((jTextField1.getText().length() > 1 || jTextField2.getText().length() > 1)) {
            this.var();

            for (int i = 0; i != bucketarray.length; i++) {
                if (b[i] != null) {

                    if (b[i].isSelected()) {
                        jTextArea1.append(Bucket.deleteBucket(Cred.access_key, Cred.secret_key, b[i].getText(), Cred.end_point, Cred.region));
                    }
                }
            }
            reloadBuckets();
        } else {
            jTextArea1.append("\nError: Configuration not loaded");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(-1);
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    boolean OScheck() {
        boolean result;
        if ((OS.contains("windows")) || OS.contains("Windows")) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }
    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        try {

            if (!OScheck()) {
                temp_file = (Home + "\\object.tmp");
            }

            for (int i = 1; i != objectarray.length; i++) {
                if (d[i].isSelected()) {
                    String new_object_name = convertObject(d[i].getText(), "download");
                    jTextArea1.append("\n" + Get.get(d[i].getText(), Cred.access_key, Cred.getSecret_key(), Cred.getBucket(), Cred.getEndpoint(), temp_file));

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

                    }
                    jTabbedPane1.setSelectedIndex(4);
                    jTextField6.setText(d[i].getText());
                }

            }

        } catch (Exception Download) {
        }
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {

            if (this.buckets_loaded > 0) {
                final JFrame parent = new JFrame("Object ACL Settings");
                final JCheckBox public_box = new JCheckBox("Public");
                final JCheckBox url_box = new JCheckBox("URL Access");
                final JCheckBox private_box = new JCheckBox("Private Access");
                final JButton acl = new JButton("Commit");

                acl.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        for (int i = 1; i != objectarray.length; i++) {
                            if (d[i].isSelected()) {
                                object_acl_change = d[i].getText();
                                if (public_box.isSelected()) {
                                    ACL.setACLpublic(object_acl_change, Cred.getAccess_key(), Cred.getSecret_key(), Cred.getEndpoint(), Cred.getBucket());
                                    jTextArea1.append("\nPublic set for object: " + object_acl_change);
                                    jTextArea1.setCaretPosition(jTextArea1.getSelectionEnd());
                                    parent.setVisible(false);
                                }

                                if (url_box.isSelected()) {
                                    jTextArea1.append("\n" + ACL.setACLurl(object_acl_change, Cred.getAccess_key(), Cred.getSecret_key(), Cred.getEndpoint(), Cred.getBucket()));
                                    jTextArea1.setCaretPosition(jTextArea1.getSelectionEnd());
                                    parent.setVisible(false);
                                }
                                if (private_box.isSelected()) {
                                    ACL.setACLprivate(object_acl_change, Cred.getAccess_key(), Cred.getSecret_key(), Cred.getEndpoint(), Cred.getBucket());
                                    jTextArea1.append("\nPrivate access set for object: " + object_acl_change);
                                    jTextArea1.setCaretPosition(jTextArea1.getSelectionEnd());
                                    parent.setVisible(false);
                                }

                            }
                        }

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
        }

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {

            if (this.buckets_loaded > 0) {
                for (int i = 1; i != objectarray.length; i++) {
                    if (d[i].isSelected()) {
                        object_acl_change = d[i].getText();
                        jTextArea1.append("\n" + ACL.viewACL(object_acl_change, Cred.getAccess_key(), Cred.getSecret_key(), Cred.getEndpoint(), Cred.getBucket()));
                    }
                }
            } else {
                jTextArea1.append("\nError: No bucket has been selected");
            }
        } catch (Exception Download) {
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void uploadfileList(File dir) {

        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                uploadfileList(files[i]);
            } else {
                jTextArea1.append("\nUploading file: " + files[i].getAbsolutePath());
                jTextArea1.repaint();
                jTextArea1.append("\n" + Put.put(files[i].getAbsolutePath(), Cred.getAccess_key(), Cred.getSecret_key(), Cred.getBucket(), Cred.getEndpoint(), files[i].getAbsolutePath()));
                jTextArea1.setCaretPosition(jTextArea1.getSelectionEnd());
            }
        }
    }

    void var() {
        Cred.setAccess_key(jTextField1.getText());
        Cred.setSecret_key(jTextField2.getText());
        String endpoint = (jTextField3.getText() + ":" + jTextField4.getText());
        Cred.setEndpoint(endpoint);
        Cred.setRegion(jTextField5.getText());
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JFileChooser jFileChooser1;
    public static javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables

}

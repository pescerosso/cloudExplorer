package cloudExplorer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class NewJFrame extends javax.swing.JFrame implements ItemListener {

    Credentials cred = new Credentials();
    BucketClass bucket = new BucketClass();
    Acl objectacl = new Acl();
    String Home = System.getProperty("user.home");
    String OS = System.getProperty("os.name");
    String[] bucketarray = null;
    public String[] objectarray = null;
    String[] syncarray = null;
    String[] account_array = new String[20];
    String[] simple_account_array = new String[account_array.length];
    int active_account = 0;
    int object_size = 500000;
    int total_accounts = 0;
    JRadioButton bucket_item[] = new JRadioButton[object_size];
    public JRadioButton object_item[] = new JRadioButton[object_size];
    JRadioButton account_item[] = new JRadioButton[account_array.length];
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
    public static boolean object_thread_status;
    ReloadBuckets buckets = null;
    boolean host_alive = false;
    public ArrayList<String> versioning_id;
    public ArrayList<String> versioning_date;
    public ArrayList<String> versioning_name;
    public Boolean versionDownload = false;
    ShowVersions showVersions;
    ImageViewer imageviewer;

    public NewJFrame() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass()
                .getResource("cloud.jpg")).getImage());
        this.jTextField3.setText("https://s3.amazonaws.com");
        this.jTextField4.setText("443");
        this.jCheckBox1.setSelected(true);
        File config = new File(config_file);
        if (config.exists()) {
            this.jButton9.doClick();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
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
        jScrollPane27 = new javax.swing.JScrollPane();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane28 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        scrollPane1 = new java.awt.ScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jFileChooser1 = new javax.swing.JFileChooser();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jFileChooser2 = new javax.swing.JFileChooser();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jButton16 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
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
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        jMenu4.setText("jMenu4");

        jMenuItem10.setText("jMenuItem10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextArea1.setColumns(20);
        jTextArea1.setForeground(java.awt.Color.black);
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
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cloudExplorer/cloudExplorerLogo.png"))); // NOI18N
        jLabel10.setOpaque(true);

        jTextField10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jButton6.setBackground(java.awt.SystemColor.text);
        jButton6.setText("Search");
        jButton6.setBorder(null);
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
                        .addGap(249, 249, 249))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(3, 3, 3))
        );

        panel1.setBackground(java.awt.Color.white);

        jTabbedPane1.setBackground(java.awt.SystemColor.text);
        jTabbedPane1.setBorder(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Access Key");

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Secret Key");

        jTextField2.setFont(new java.awt.Font("OpenSymbol", 0, 15)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setText("Host URL");

        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Port");

        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setText("Region");

        jTextField5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton8.setBackground(java.awt.SystemColor.text);
        jButton8.setText("Save");
        jButton8.setBorder(null);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setBackground(java.awt.SystemColor.text);
        jButton10.setText("Clear");
        jButton10.setBorder(null);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jScrollPane27.setBackground(java.awt.Color.white);
        jScrollPane27.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel21.setBackground(java.awt.SystemColor.text);
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel21.setAlignmentX(0.0F);
        jPanel21.setAlignmentY(0.0F);
        jPanel21.setAutoscrolls(true);

        jScrollPane28.setBackground(java.awt.SystemColor.text);
        jScrollPane28.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel12.setBackground(java.awt.SystemColor.text);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        jScrollPane28.setViewportView(jPanel12);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jScrollPane27.setViewportView(jPanel21);

        jButton9.setBackground(java.awt.SystemColor.text);
        jButton9.setText("Load Account");
        jButton9.setBorder(null);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton2.setBackground(java.awt.SystemColor.text);
        jButton2.setText("Delete Account");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton20.setBackground(java.awt.SystemColor.text);
        jButton20.setText("Set as migration account");
        jButton20.setBorder(null);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(java.awt.SystemColor.text);
        jCheckBox1.setForeground(java.awt.Color.blue);
        jCheckBox1.setText("Automatically load buckets");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)))
                .addGap(114, 114, 114)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(62, 62, 62)))
                .addContainerGap(37, Short.MAX_VALUE))
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton10)
                            .addComponent(jButton20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Settings", jPanel3);

        scrollPane1.setBackground(java.awt.SystemColor.text);

        jPanel1.setBackground(java.awt.SystemColor.text);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel5.setBackground(java.awt.SystemColor.text);
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);
        jPanel5.setAutoscrolls(true);

        jScrollPane3.setBackground(java.awt.SystemColor.text);
        jScrollPane3.setBorder(null);

        jPanel13.setBackground(java.awt.SystemColor.text);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel13);

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

        jScrollPane7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel11.setBackground(javax.swing.UIManager.getDefaults().getColor("text"));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
        );

        jScrollPane7.setViewportView(jPanel11);

        jPanel14.setBackground(java.awt.SystemColor.text);
        jPanel14.setOpaque(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        jButton3.setBackground(java.awt.SystemColor.text);
        jButton3.setText("Download");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(java.awt.SystemColor.text);
        jButton4.setText("Delete");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setBackground(java.awt.SystemColor.text);
        jButton7.setText("Properties");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton12.setBackground(java.awt.SystemColor.text);
        jButton12.setText("Edit");
        jButton12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(java.awt.SystemColor.text);
        jButton13.setText("Select All");
        jButton13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(java.awt.SystemColor.text);
        jButton14.setText("Deselect All");
        jButton14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton1.setBackground(java.awt.SystemColor.text);
        jButton1.setText("Abort");
        jButton1.setToolTipText("");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton17.setBackground(java.awt.SystemColor.text);
        jButton17.setText("Play");
        jButton17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(java.awt.SystemColor.text);
        jButton18.setText("Versions");
        jButton18.setToolTipText("");
        jButton18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setBackground(java.awt.SystemColor.text);
        jButton19.setText("View Image");
        jButton19.setToolTipText("");
        jButton19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        scrollPane1.add(jPanel1);

        jTabbedPane1.addTab("Object Explorer", scrollPane1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jFileChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jFileChooser1.setControlButtonsAreShown(false);
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        jFileChooser1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jFileChooser1.setDragEnabled(true);
        jFileChooser1.setMultiSelectionEnabled(true);
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(java.awt.SystemColor.text);
        jButton5.setText("Upload");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setText("Destination in Bucket:");

        jTextField7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jButton15.setBackground(java.awt.SystemColor.text);
        jButton15.setText("Abort upload");
        jButton15.setBorder(null);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel11.setText("Bucket Selected:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(132, 132, 132)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Upload", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jFileChooser2.setBackground(new java.awt.Color(255, 255, 255));
        jFileChooser2.setControlButtonsAreShown(false);
        jFileChooser2.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        jFileChooser2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jFileChooser2.setDragEnabled(true);
        jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser2ActionPerformed(evt);
            }
        });

        jToggleButton3.setBackground(java.awt.SystemColor.text);
        jToggleButton3.setText("Sync to S3");
        jToggleButton3.setBorder(null);
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setBackground(java.awt.SystemColor.text);
        jToggleButton4.setText("Sync from S3");
        jToggleButton4.setBorder(null);
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jButton16.setBackground(java.awt.SystemColor.text);
        jButton16.setText("Abort");
        jButton16.setBorder(null);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(java.awt.SystemColor.text);
        jRadioButton1.setText("Overwrite Existing");

        jLabel13.setText("Bucket Selected:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(132, 132, 132)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jToggleButton4)
                        .addGap(49, 49, 49)
                        .addComponent(jToggleButton3)
                        .addGap(43, 43, 43)
                        .addComponent(jRadioButton1))
                    .addComponent(jFileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jFileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Sync", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane4.setViewportView(jTextArea2);

        jButton11.setBackground(java.awt.SystemColor.text);
        jButton11.setText("Save");
        jButton11.setBorder(null);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jTextField6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
                .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Text Editor", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setText("Version 3.1\n\nCheckbox to disable automatically loading buckets after selecting an account.\nDefault Host URL and Port defaults to Amazon.\n\nFeatures:\n\n1. Tier buckets to and from Amazon Glacier.\n2. Sync files to and from S3 storage.\n3. Stream music from Amazon S3.\n4. Text editor.\n5. Modify Bucket and Object ACL's.\n6. Take screen shots and upload them to Amazon S3.\n7. Bucket versioning and lifecycles.\n8. Graphical and console based background syncing.\n9. Store multiple Amazon S3 accounts.\n10. Image viewer.\n11. Migrate data between S3 accounts.\n\nHow to migrate data between S3 accounts:\n\n1. Load the destination account and click \"Set as migration Account\" under Settings.\n2. Create the destination bucket with the same name as the origin bucket name.\n3. Load the origin S3 account and select the bucket to transfer to the new S3 account.\n4. Under the \"Tools\" menu, select \"Migrate bucket to another S3 account\".\n5. Type in the destination bucket name and click \"Start Bucket Migration\".\n6. Wait for transfers to complete.");
        jTextArea4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextArea4.setCaretPosition(0);
        jScrollPane6.setViewportView(jTextArea4);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jMenuBar1.setBackground(java.awt.SystemColor.text);
        jMenuBar1.setBorder(null);

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

        jMenuItem13.setText("Bucket Life Cycle");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuItem11.setText("Enable Versioning");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Suspend Versioning");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

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

        jMenuItem16.setText("Restore Object from Glacier");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);

        jMenuItem7.setText("View Object ACL");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

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

        jMenu6.setText("Tools");

        jMenuItem14.setText("Screen shot to S3");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem14);

        jMenuItem17.setText("Migrate bucket to another S3 account.");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem17);

        jMenuItem8.setText("Delete every object and version");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenuBar1.add(jMenu6);

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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (active_bucket > 0) {
            jButton4.setEnabled(true);
            jButton7.setEnabled(true);
            jButton12.setEnabled(true);
            jButton13.setEnabled(true);
            jButton14.setEnabled(true);
            jButton1.setEnabled(true);
            jButton17.setEnabled(true);
            jButton18.setEnabled(true);
            jButton19.setEnabled(true);
            reloadObjects();
            versionDownload = false;

            try {
                int found = 0;
                int display_counter = initial_display;

                jTabbedPane1.setSelectedIndex(1);

                display_counter = objectarray.length;
                for (int i = 1; i != display_counter; i++) {
                    if (object_item[i] != null) {
                        if (object_item[i].getText().toLowerCase().contains(jTextField10.getText().toLowerCase())) {
                            jPanel11.add(object_item[i]);
                            object_item[i].setVisible(true);
                            found++;
                        } else {
                            object_item[i].setVisible(false);
                        }
                    }
                }

                if (found == 0) {
                    reloadObjects();
                    jTextArea1.append("\nNo objects found for search. \n");
                } else {
                    int display = objectarray.length - 1;
                    jTextArea1.append("\nLoaded objects. Total number of objects in this bucket: " + display);
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
                    bucket_item[c].setSelected(false);
                }
            }
        } catch (Exception clear_old_radio) {
        }

    }

    public void itemStateChanged(ItemEvent event) {
        try {
            for (int h = 1; h != bucketarray.length; h++) {
                if (bucketarray.length > 1) {
                    if (bucket_item[h] != null) {
                        if (bucket_item[h].isSelected()) {
                            if (h != active_bucket) {
                                active_bucket = h;
                                jLabel11.setText("Bucket Selected: " + bucket_item[h].getText());
                                jLabel13.setText("Bucket Selected: " + bucket_item[h].getText());
                                cred.setBucket(bucket_item[h].getText());
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
                if (account_item[h] != null) {
                    if (account_item[h].isSelected()) {
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
                    account_item[c].setSelected(false);
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
                account_item[k].setText("");
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
                String[] analyze_array = account_array[h].split("@");
                jPanel21.setLayout(new BoxLayout(jPanel21, BoxLayout.Y_AXIS));
                account_item[h] = new JRadioButton();
                account_item[h].setText(analyze_array[2]);
                account_item[h].addItemListener(this);
                account_item[h].setBackground(Color.white);
                account_item[h].setForeground(Color.blue);
                jPanel21.add(account_item[h]);
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
                bucket_item[h] = new JRadioButton();
                bucket_item[h].setText(bucketarray[h]);
                bucket_item[h].addItemListener(this);
                bucket_item[h].setBackground(Color.white);
                bucket_item[h].setForeground(Color.blue);
                jPanel5.add(bucket_item[h]);
                setLocation(h, 5);
                jPanel5.revalidate();
                validate();
            }

            objectarray = null;

        }

    }

    void reloadBuckets() {
        if ((jTextField1.getText().length() > 1 || jTextField2.getText().length() > 1)) {
            var();
            bucketarray = null;
            ReloadBuckets buckets = new ReloadBuckets(cred.getAccess_key(), cred.getSecret_key(), cred.getEndpoint(), this);
            buckets.run();
            active_bucket = 0;
        } else {
            jTextArea1.append("\nError: Configuration not loaded\n");
        }
        calibrateTextArea();
    }

    void redrawObjects() {
        jPanel11.setLayout(new BoxLayout(jPanel11, BoxLayout.PAGE_AXIS));
        jPanel14.removeAll();
        for (int h = 1; h != objectarray.length; h++) {
            jPanel11.setLayout(new BoxLayout(jPanel11, BoxLayout.Y_AXIS));
            object_item[h] = new JRadioButton();
            object_item[h].setText(objectarray[h]);
            object_item[h].setBackground(Color.white);
            object_item[h].setForeground(Color.blue);
        }
        jPanel11.setLayout(new BoxLayout(jPanel11, BoxLayout.PAGE_AXIS));

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
                    if (bucket_item[h] != null) {
                        if (bucket_item[h].isSelected()) {
                            ReloadObjects object = new ReloadObjects(cred.getAccess_key(), cred.getSecret_key(), bucket_item[h].getText(), cred.getEndpoint(), this);
                            object.run();
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
            MakeBucket makebucket = new MakeBucket(this);
            makebucket.startc();
        } else {
            jTextArea1.append("\nError: Configuration not loaded\n");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        if (active_bucket > 0) {
            BucketACL bucketACL = new BucketACL(this);
            bucketACL.startc();
        } else {
            jTextArea1.append("\nError: No bucket has been selected\n");
        }


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if ((jTextField1.getText().length() > 1 || jTextField2.getText().length() > 1)) {
            var();

            for (int i = 0; i != bucketarray.length; i++) {
                if (bucket_item[i] != null) {

                    if (bucket_item[i].isSelected()) {
                        jTextArea1.append(bucket.deleteBucket(cred.access_key, cred.secret_key, bucket_item[i].getText(), cred.end_point, cred.region));
                        bucket_item[i].setSelected(false);
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

        if (active_bucket > 0) {
            ObjectACL acl = new ObjectACL(this);
            acl.startc();
        } else {
            jTextArea1.append("\nError: No bucket has been selected");
            calibrateTextArea();
        }


    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {

            if (active_bucket > 0) {
                for (int i = 1; i != previous_objectarray_length; i++) {
                    if (object_item[i].isSelected()) {
                        object_acl_change = object_item[i].getText();
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
            bucket_item[active_bucket].setSelected(true);
        } else {
            jTextArea1.append("\nError: no bucket selected.");
        }
        calibrateTextArea();
    }//GEN-LAST:event_jButton11ActionPerformed


    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if (active_bucket > 0) {
            //syncing_to_S3 = true;
            SyncToS3.running = true;
            jTextArea1.setText("\nStarted Sync.");
            calibrateTextArea();
            reloadObjects();

            if (bucket_item[active_bucket].isSelected()) {
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

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
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
                    if (account_item[i].isSelected()) {
                        active_account = i;
                        account = account_array[i].split("@");
                        jTextField1.setText(account[0]);
                        jTextField2.setText(account[1]);
                        jTextField3.setText(account[2]);
                        jTextField4.setText(account[3]);
                        jTextField5.setText(account[4]);
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
                if (NewJFrame.jCheckBox1.isSelected()) {
                    HostChecker hostchecker = new HostChecker(jTextField3.getText(), this);
                    hostchecker.startc();
                }

            } else {
                jTextArea1.append("\nError: No account has been selected.");
            }
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String save = cred.writeConfig(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), jTextField5.getText());
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
                jTextArea1.setText("\nStarted Sync.");
                calibrateTextArea();

                if (bucket_item[active_bucket].isSelected()) {

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
                bg_choose.setControlButtonsAreShown(false);
                bg_choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                final JButton bg_button = new JButton("Save");

                bg_button.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        File choice = new File(bg_choose.getSelectedFile().toString());
                        try {
                            FileWriter fr = new FileWriter(Home + File.separator + "s3config.sync");
                            BufferedWriter bfr = new BufferedWriter(fr);
                            bfr.write(bg_choose.getSelectedFile().toString() + " " + bucket_item[active_bucket].getText());
                            bfr.close();
                        } catch (Exception writeConfig) {
                            jTextArea1.append("\n" + writeConfig.getMessage());
                        }
                        jTextArea1.append("\nWritten config: " + Home + File.separator + "s3config.sync");
                        calibrateTextArea();
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
                    if (account_item[i].isSelected()) {
                        jTextArea1.append("\nDeleting Account: " + account_item[i].getText() + "\n");
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
            downloadChooser.setControlButtonsAreShown(false);
            downloadChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            final JButton downloadButton = new JButton("OK");

            downloadButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    jTextArea1.append("\nPlease wait for the download operation to complete.");
                    calibrateTextArea();
                    if (downloadChooser.getSelectedFile().getAbsolutePath() != null) {

                        File File_Destination = new File(downloadChooser.getSelectedFile().getAbsolutePath());

                        if (versionDownload) {
                            int i = 0;
                            for (String what : versioning_name) {
                                if (object_item[i].isSelected()) {
                                    download.setVisible(false);
                                    String new_object_name = convertObject(versioning_name.get(i), "download");
                                    get = new Get(versioning_name.get(i), cred.access_key, cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), File_Destination.toString() + File.separator + new_object_name, versioning_id.get(i));
                                    get.startc(versioning_name.get(i), cred.access_key, cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), File_Destination.toString() + File.separator + new_object_name, versioning_id.get(i));
                                    object_item[i].setSelected(false);
                                    versionDownload = false;
                                    break;
                                }
                                i++;
                            }
                        } else {
                            for (int i = 1; i != previous_objectarray_length; i++) {
                                if (object_item[i] != null) {

                                    if (object_item[i].isSelected()) {
                                        download.setVisible(false);
                                        String new_object_name = convertObject(object_item[i].getText(), "download");
                                        get = new Get(object_item[i].getText(), cred.access_key, cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), File_Destination.toString() + File.separator + new_object_name, null);
                                        get.startc(object_item[i].getText(), cred.access_key, cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), File_Destination.toString() + File.separator + new_object_name, null);
                                        object_item[i].setSelected(false);
                                    }
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

            if (!versionDownload) {
                try {
                    for (int i = 1; i != objectarray.length; i++) {
                        if (object_item[i] != null) {
                            if (object_item[i].isSelected()) {
                                download.setVisible(true);
                            }
                        }
                    }
                } catch (Exception GetThreadRUN) {
                }
            }

            if (versionDownload) {
                try {
                    int i = 0;
                    for (String what : versioning_name) {
                        if (object_item[i] != null) {
                            if (object_item[i].isSelected()) {
                                download.setVisible(true);
                            }
                        }
                        i++;
                    }
                } catch (Exception GetThreadRUN) {
                }
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
                if (versionDownload) {
                    for (int i = 0; i != versioning_name.size(); i++) {
                        if (object_item[i].isSelected()) {
                            del = new Delete(versioning_name.get(i), cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), versioning_id.get(i));
                            del.startc(versioning_name.get(i), cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), versioning_id.get(i));
                        }
                    }
                } else {
                    for (int i = 1; i != previous_objectarray_length; i++) {
                        if (object_item[i].isSelected()) {
                            if (delcounter < 500) {
                                del = new Delete(object_item[i].getText(), cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), null);
                                del.startc(object_item[i].getText(), cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), null);
                            }
                        }
                    }
                    delcounter++;
                }
            } else {
                jTextArea1.append("\nError: No bucked selected.");
            }
        } catch (Exception checkbox) {
        }
        versionDownload = false;
        objectarray = null;
        reloadObjects();
        jTextField10.setText("");
        jTextArea1.append("\nDelete operation finished.");
        calibrateTextArea();
        jButton6.doClick();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        if (active_bucket > 0) {
            ObjectProperties properties = new ObjectProperties(this);
            properties.startc();
        } else {
            jTextArea1.append("\nError: No bucket has been selected\n");
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            temp_file = (Home + File.separator + "object.tmp");

            for (int i = 1; i != previous_objectarray_length; i++) {
                if (object_item[i].isSelected()) {
                    String new_object_name = convertObject(object_item[i].getText(), "download");
                    get = new Get(object_item[i].getText(), cred.access_key, cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), temp_file, null);
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
                    jTextField6.setText(object_item[i].getText());
                }

            }

        } catch (Exception Download) {
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {
            if (versionDownload) {
                for (int i = 0; i != versioning_id.size(); i++) {
                    if (object_item[i].isVisible()) {
                        object_item[i].setSelected(true);
                    }
                }
            } else {
                for (int i = 1; i != previous_objectarray_length; i++) {
                    if (object_item[i].isVisible()) {
                        object_item[i].setSelected(true);
                    }
                }
            }
        } catch (Exception SelectALL) {
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            if (versionDownload) {
                for (int i = 0; i != versioning_id.size(); i++) {
                    if (object_item[i].isVisible()) {
                        object_item[i].setSelected(false);
                    }
                }
            } else {
                for (int i = 1; i != previous_objectarray_length; i++) {
                    if (object_item[i].isVisible()) {
                        object_item[i].setSelected(false);
                    }
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
            Abort abortToS3 = new Abort("To");
            abortToS3.run();
        }

        if (SyncFromS3.running) {
            Abort abortFromS3 = new Abort("From");
            abortFromS3.run();
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if (active_bucket > 0) {
            jTextArea1.append(bucket.controlVersioning(cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), cred.getRegion(), true));
            calibrateTextArea();
        } else {
            jTextArea1.append("\nError: No bucket has been selected");
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        if (active_bucket > 0) {
            jTextArea1.append(bucket.controlVersioning(cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), cred.getRegion(), false));
            calibrateTextArea();
        } else {
            jTextArea1.append("\nError: No bucket has been selected");
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if (active_bucket > 0) {
            jTextArea1.append("\nPlease wait, loading MP3 player.");
            calibrateTextArea();
            MusicPlayer musicplayer = new MusicPlayer(this);
            musicplayer.startc();
            jTextArea1.append("\nMusic player has been started. Please observe for any errors.");
            calibrateTextArea();
        } else {
            jTextArea1.append("\nError: No bucket has been selected");
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if (active_bucket > 0) {
            boolean countSelected = false;
            jButton7.setEnabled(false);
            jButton12.setEnabled(false);
            jButton1.setEnabled(false);
            jButton17.setEnabled(false);
            jButton18.setEnabled(false);
            jButton19.setEnabled(false);

            for (int i = 1; i != objectarray.length; i++) {
                if (object_item[i].isSelected()) {
                    countSelected = true;
                    showVersions = new ShowVersions(object_item[i].getText(), cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), this);
                    showVersions.startc(object_item[i].getText(), cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), this);;
                    break;
                }
            }

            if (!countSelected) {
                showVersions = new ShowVersions(null, cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), this);
                showVersions.startc(null, cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), this);
            }

        } else {
            jTextArea1.append("\nError: No bucket has been selected");
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if (active_bucket > 0) {
            imageviewer = new ImageViewer(this);
            imageviewer.startc();
        } else {
            jTextArea1.append("\nError: No bucket has been selected");
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if (active_bucket > 0) {
            DeleteEverything delEverything = new DeleteEverything(this);
            Versioning.delete = true;
            delEverything.startc(this);
        } else {
            jTextArea1.append("\nError: No bucket has been selected");
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        if (active_bucket > 0) {
            ConfigureObjectTransition trans = new ConfigureObjectTransition(this);
            trans.startc();
        } else {
            jTextArea1.append("\nError: No bucket has been selected");
        }

    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        if (active_bucket > 0) {
            jTextArea1.append("\nScreen shot will start in 5 seconds.");
            calibrateTextArea();
            ScreenShot foo = new ScreenShot(null, cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), null, this);
            foo.startc(null, cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), null, this);
        } else {
            jTextArea1.append("\nError: No bucket has been selected");
            calibrateTextArea();
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        if (active_bucket > 0) {
            for (int i = 1; i != previous_objectarray_length; i++) {
                if (object_item[i] != null) {
                    if (object_item[i].isSelected()) {
                        RestoreObject restoreOBJ = new RestoreObject(object_item[i].getText(), cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint());
                        restoreOBJ.startc(object_item[i].getText(), cred.access_key, cred.getSecret_key(), cred.getBucket(), cred.getEndpoint());
                    }
                }
            }

        } else {
            jTextArea1.append("\nError: No bucket has been selected");
        }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        if (active_bucket > 0) {

            MakeDestinationBucket makeDestbucket = new MakeDestinationBucket(this);
            makeDestbucket.startc();
        } else {
            jTextArea1.append("\nError: No bucket has been selected");
        }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if (active_account > 0) {
            String save = cred.writeMigrateConfig(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), jTextField5.getText());
            jTextArea1.append(save);
            calibrateTextArea();
        } else {
            jTextArea1.append("\nError: No account has been selected.");
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
    public static javax.swing.JButton jButton17;
    public static javax.swing.JButton jButton18;
    public static javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    public static javax.swing.JCheckBox jCheckBox1;
    public javax.swing.JFileChooser jFileChooser1;
    public static javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    public static javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    public static javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane27;
    public static javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    public static javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    public javax.swing.JTextField jTextField7;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private java.awt.Panel panel1;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables

}

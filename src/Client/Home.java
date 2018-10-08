import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.TableRowSorter;

/*
Authors: Mohammed Riaz Khan - 215099613
         Clayton Petersen - 216155231
*/

public class Home extends javax.swing.JFrame {
    
    ClientDvdRental clientCode = new ClientDvdRental();

    static String status = "";
    
    String na = "";
    static boolean newRel;
    private final String[] movieCategories = {"--Genre--","Horror", "Sci-fi", "Drama", "Romance", "Comedy", "Action", "Cartoon"};
    static String valueInItem;
    
    static DefaultComboBoxModel<String> movieTypeComboBoxModel = new DefaultComboBoxModel<String>();
    static DefaultComboBoxModel<String> dailyRental = new DefaultComboBoxModel<String>();
    
    String[] rentalNum;
    String[] customerTel;      
    
    static ArrayList<Rental> rList;
    ArrayList<Customer>cList;
    ArrayList<DVD>allDvds;
    
    static String rentalInNum = "";

    static ArrayList<Rental> extras = new ArrayList<>();
    
    public Home() {
       
        look();
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        
        rList = clientCode.populateDateComboBox();
        cList = clientCode.populatePhoneNums();
        allDvds = clientCode.populateDvdTitle();
        
        clientCode.populateCustomerTable();
        clientCode.populateMovieTable();
        clientCode.populateRentalTable();
   
        
        for (String eventItem : movieCategories) {
            
            movieTypeComboBoxModel.addElement(eventItem);
            
        }
        
        rentalNum = new String[rList.size()];
        
        
        //removing duplicates if any
        ArrayList<String> rlist = new ArrayList<>();
        
        for(int i = 0; i < rList.size(); i++){
            
            String date = rList.get(i).getDateRented();
            rlist.add(date);
            
        }
        
        Set<String> hs = new HashSet<>();
        
        hs.addAll(rlist);
        rlist.clear();
        rlist.addAll(hs);
        
        //sort in ascending order before being added
        Collections.sort(rlist, new SortString());
        
        dailyRental.addElement("-");
        
        for(int i = 0; i < rlist.size(); i++){
            
            String num = rlist.get(i);
            
            rentalNum[i] = num;

            dailyRental.addElement(rentalNum[i]);
         
        }
        
        //removes duplicates
  
        //adding customers to the clist
         customerTel = new String[cList.size()];
         
         for(int i = 0; i < cList.size(); i++){
            
            String cNum = cList.get(i).getFirstName();
            
            customerTel[i] = cNum;
            
        }
        
        dateComboBox.setSelectedIndex(0);
        dateComboBox.setSelectedItem("-");
    
        //rentalNA.setVisible(false);
        
        dat.setText(clientCode.getCurrentDate());
        tim.setText(clientCode.getCurrentTime());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Main = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        addCust = new javax.swing.JLabel();
        addDVD = new javax.swing.JLabel();
        rentDVD = new javax.swing.JLabel();
        returnDVD = new javax.swing.JLabel();
        movieList = new javax.swing.JLabel();
        customerList = new javax.swing.JLabel();
        reports = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tim = new javax.swing.JLabel();
        dat = new javax.swing.JLabel();
        addCustomerPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        custNm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        custSnm = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        custPhNum = new javax.swing.JTextField();
        addCustBtn = new javax.swing.JButton();
        cLabel = new javax.swing.JLabel();
        sLabel = new javax.swing.JLabel();
        phLabel = new javax.swing.JLabel();
        addMoviePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        movieTitle = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        categoryComboBox = new javax.swing.JComboBox<>();
        yesBtn = new javax.swing.JRadioButton();
        noBtn = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        addMovieBtn = new javax.swing.JButton();
        mtLabel = new javax.swing.JLabel();
        gLabel = new javax.swing.JLabel();
        nrLabel = new javax.swing.JLabel();
        customerTable = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        movieTable = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        rentalTable = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        dateComboBox = new javax.swing.JComboBox<>();
        rentalNA = new javax.swing.JButton();
        allRentals = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        returnDate = new javax.swing.JButton();
        returnDate1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("JustRent Movie Rental ");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Main.setBackground(new java.awt.Color(255, 102, 0));
        Main.setLayout(new java.awt.CardLayout());

        homePanel.setBackground(new java.awt.Color(51, 51, 51));

        addCust.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addCust.setForeground(new java.awt.Color(255, 255, 255));
        addCust.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N
        addCust.setText("Add customer");
        addCust.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addCust.setIconTextGap(15);
        addCust.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addCust.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCustMouseClicked(evt);
            }
        });

        addDVD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addDVD.setForeground(new java.awt.Color(255, 255, 255));
        addDVD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dvd.png"))); // NOI18N
        addDVD.setText("Add new movie");
        addDVD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addDVD.setIconTextGap(15);
        addDVD.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addDVD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addDVDMouseClicked(evt);
            }
        });

        rentDVD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rentDVD.setForeground(new java.awt.Color(255, 255, 255));
        rentDVD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rentals2.png"))); // NOI18N
        rentDVD.setText("Rent a DVD");
        rentDVD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rentDVD.setIconTextGap(15);
        rentDVD.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rentDVD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rentDVDMouseClicked(evt);
            }
        });

        returnDVD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        returnDVD.setForeground(new java.awt.Color(255, 255, 255));
        returnDVD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/returnDVD.png"))); // NOI18N
        returnDVD.setText("Return DVD");
        returnDVD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        returnDVD.setIconTextGap(15);
        returnDVD.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        returnDVD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnDVDMouseClicked(evt);
            }
        });

        movieList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        movieList.setForeground(new java.awt.Color(255, 255, 255));
        movieList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/movie list.png"))); // NOI18N
        movieList.setText("Movies/DVD Llst");
        movieList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        movieList.setIconTextGap(15);
        movieList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        movieList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                movieListMouseClicked(evt);
            }
        });

        customerList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        customerList.setForeground(new java.awt.Color(255, 255, 255));
        customerList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer list.png"))); // NOI18N
        customerList.setText("Customer list");
        customerList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        customerList.setIconTextGap(15);
        customerList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        customerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerListMouseClicked(evt);
            }
        });

        reports.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        reports.setForeground(new java.awt.Color(255, 255, 255));
        reports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reports.png"))); // NOI18N
        reports.setText("Reports/Rental list");
        reports.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reports.setIconTextGap(15);
        reports.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportsMouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("JustRent  ");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DVDbox3.png"))); // NOI18N

        tim.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tim.setForeground(new java.awt.Color(255, 255, 255));
        tim.setText("12:01");

        dat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        dat.setForeground(new java.awt.Color(255, 255, 255));
        dat.setText("2018/10/08");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dat)
                    .addComponent(jLabel12)
                    .addComponent(tim))
                .addGap(125, 125, 125)
                .addComponent(jLabel13)
                .addGap(165, 165, 165))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(dat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rentDVD)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addCust)
                            .addComponent(customerList))
                        .addGap(100, 100, 100)
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addDVD)
                            .addComponent(movieList))
                        .addGap(112, 112, 112)
                        .addComponent(reports)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(returnDVD)
                .addGap(58, 58, 58))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addComponent(addCust)
                        .addGap(38, 38, 38)
                        .addComponent(customerList))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addComponent(addDVD)
                        .addGap(38, 38, 38)
                        .addComponent(movieList))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rentDVD)
                            .addComponent(returnDVD))
                        .addGap(38, 38, 38)
                        .addComponent(reports, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );

        Main.add(homePanel, "home");

        addCustomerPanel.setBackground(new java.awt.Color(51, 51, 51));
        addCustomerPanel.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Customer");

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Homesml.png"))); // NOI18N
        jLabel25.setText("Back to home");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(160, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(161, 161, 161)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        custNm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                custNmKeyReleased(evt);
            }
        });

        jLabel3.setText("Name");

        jLabel4.setText("Surname");

        custSnm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                custSnmKeyReleased(evt);
            }
        });

        jLabel5.setText("Phone no.");

        custPhNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                custPhNumKeyReleased(evt);
            }
        });

        addCustBtn.setBackground(new java.awt.Color(255, 102, 0));
        addCustBtn.setForeground(new java.awt.Color(255, 102, 0));
        addCustBtn.setText("Add");
        addCustBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        addCustBtn.setContentAreaFilled(false);
        addCustBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustBtnActionPerformed(evt);
            }
        });

        cLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cLabel.setForeground(new java.awt.Color(255, 51, 0));

        sLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sLabel.setForeground(new java.awt.Color(255, 51, 0));

        phLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        phLabel.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addCustBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(custSnm, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(custPhNum, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(custNm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(186, 186, 186))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(custNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(custSnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(custPhNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(addCustBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addCustomerPanelLayout = new javax.swing.GroupLayout(addCustomerPanel);
        addCustomerPanel.setLayout(addCustomerPanelLayout);
        addCustomerPanelLayout.setHorizontalGroup(
            addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCustomerPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addCustomerPanelLayout.setVerticalGroup(
            addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Main.add(addCustomerPanel, "customer");

        addMoviePanel.setBackground(new java.awt.Color(51, 51, 51));
        addMoviePanel.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dvd.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Add Movie");

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Homesml.png"))); // NOI18N
        jLabel24.setText("Back to home");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(141, 141, 141)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        movieTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                movieTitleKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Movie title");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Genre");

        jButton2.setBackground(new java.awt.Color(255, 102, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton2.setContentAreaFilled(false);

        categoryComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        categoryComboBox.setModel(movieTypeComboBoxModel);
        categoryComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryComboBoxItemStateChanged(evt);
            }
        });
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        buttonGroup1.add(yesBtn);
        yesBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        yesBtn.setText("Yes");
        yesBtn.setContentAreaFilled(false);
        yesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(noBtn);
        noBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        noBtn.setText("No");
        noBtn.setContentAreaFilled(false);
        noBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noBtnActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("New release");

        addMovieBtn.setBackground(new java.awt.Color(255, 102, 0));
        addMovieBtn.setForeground(new java.awt.Color(255, 102, 0));
        addMovieBtn.setText("Add");
        addMovieBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        addMovieBtn.setContentAreaFilled(false);
        addMovieBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMovieBtnActionPerformed(evt);
            }
        });

        mtLabel.setForeground(new java.awt.Color(255, 51, 0));

        gLabel.setForeground(new java.awt.Color(255, 51, 0));

        nrLabel.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noBtn)
                    .addComponent(yesBtn)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(movieTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(184, 184, 184))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(addMovieBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mtLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(movieTitle))
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(categoryComboBox))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(nrLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(yesBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(noBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMovieBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addMoviePanelLayout = new javax.swing.GroupLayout(addMoviePanel);
        addMoviePanel.setLayout(addMoviePanelLayout);
        addMoviePanelLayout.setHorizontalGroup(
            addMoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addMoviePanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addMoviePanelLayout.setVerticalGroup(
            addMoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Main.add(addMoviePanel, "movie");

        customerTable.setBackground(new java.awt.Color(51, 51, 51));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Customer Table");

        jTable1.setModel(ClientDvdRental.cusModel);
        jScrollPane1.setViewportView(jTable1);

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Homesml.png"))); // NOI18N
        jLabel21.setText("Back to home");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout customerTableLayout = new javax.swing.GroupLayout(customerTable);
        customerTable.setLayout(customerTableLayout);
        customerTableLayout.setHorizontalGroup(
            customerTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addContainerGap(688, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerTableLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(customerTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(customerTableLayout.createSequentialGroup()
                    .addGap(339, 339, 339)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(339, 339, 339)))
        );
        customerTableLayout.setVerticalGroup(
            customerTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(customerTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(customerTableLayout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(535, Short.MAX_VALUE)))
        );

        Main.add(customerTable, "customerTable");

        movieTable.setBackground(new java.awt.Color(51, 51, 51));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Movie Table");

        jTable2.setModel(ClientDvdRental.dvdModel);
        jScrollPane2.setViewportView(jTable2);

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Homesml.png"))); // NOI18N
        jLabel22.setText("Back to home");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarKeyReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search icon.png"))); // NOI18N
        jLabel28.setText("Search Title");
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel28.setIconTextGap(10);

        javax.swing.GroupLayout movieTableLayout = new javax.swing.GroupLayout(movieTable);
        movieTable.setLayout(movieTableLayout);
        movieTableLayout.setHorizontalGroup(
            movieTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(movieTableLayout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addGap(339, 339, 339))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, movieTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(movieTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(movieTableLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(movieTableLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75))
        );
        movieTableLayout.setVerticalGroup(
            movieTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(movieTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(movieTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(16, 16, 16)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        Main.add(movieTable, "movieTable");

        rentalTable.setBackground(new java.awt.Color(51, 51, 51));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Rental Table");

        jScrollPane3.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jTable3.setModel(ClientDvdRental.rentModel);
        jTable3.setGridColor(new java.awt.Color(204, 204, 204));
        jTable3.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jTable3.setShowVerticalLines(false);
        jScrollPane3.setViewportView(jTable3);

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Homesml.png"))); // NOI18N
        jLabel23.setText("Back to home");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        dateComboBox.setModel(dailyRental);
        dateComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dateComboBoxItemStateChanged(evt);
            }
        });

        rentalNA.setBackground(new java.awt.Color(255, 102, 0));
        rentalNA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rentalNA.setForeground(new java.awt.Color(255, 255, 255));
        rentalNA.setText("Outstanding Rentals");
        rentalNA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        rentalNA.setContentAreaFilled(false);
        rentalNA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalNAActionPerformed(evt);
            }
        });

        allRentals.setBackground(new java.awt.Color(255, 102, 0));
        allRentals.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        allRentals.setForeground(new java.awt.Color(255, 255, 255));
        allRentals.setText("All Rentals");
        allRentals.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        allRentals.setContentAreaFilled(false);
        allRentals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allRentalsActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Daily Rentals");

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Please choose a date");

        returnDate.setBackground(new java.awt.Color(255, 102, 0));
        returnDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        returnDate.setForeground(new java.awt.Color(255, 255, 255));
        returnDate.setText("Check Date");
        returnDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        returnDate.setContentAreaFilled(false);
        returnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnDateActionPerformed(evt);
            }
        });

        returnDate1.setBackground(new java.awt.Color(255, 102, 0));
        returnDate1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        returnDate1.setForeground(new java.awt.Color(255, 255, 255));
        returnDate1.setText("RESET");
        returnDate1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        returnDate1.setContentAreaFilled(false);
        returnDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnDate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rentalTableLayout = new javax.swing.GroupLayout(rentalTable);
        rentalTable.setLayout(rentalTableLayout);
        rentalTableLayout.setHorizontalGroup(
            rentalTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rentalTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(65, 65, 65))
            .addGroup(rentalTableLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(rentalTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rentalNA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(allRentals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(returnDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(returnDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(rentalTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE))
                .addContainerGap())
        );
        rentalTableLayout.setVerticalGroup(
            rentalTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rentalTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGroup(rentalTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rentalTableLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rentalTableLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(allRentals, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(rentalNA, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(returnDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(179, Short.MAX_VALUE))
        );

        Main.add(rentalTable, "rentTable");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCustMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCustMouseClicked
       
        CardLayout card = (CardLayout) Main.getLayout();
        card.show(Main, "customer");
    }//GEN-LAST:event_addCustMouseClicked

    private void addCustBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustBtnActionPerformed
        
        boolean numberExists = false;
     
         for(int i = 0; i < cList.size(); i++){

                String nm = cList.get(i).getPhoneNum();

                customerTel[i] = nm;

                if(custPhNum.getText().equals(customerTel[i])){

                    numberExists = true;
                    break;

                }
                
         }
        
        try{
         
            //All empty fields
            if(custNm.getText().isEmpty() && custSnm.getText().isEmpty() && custPhNum.getText().isEmpty()){

               JOptionPane.showMessageDialog(null, "Please fill in all fields!");
               cLabel.setText("*");
               sLabel.setText("*");
               phLabel.setText("*");

            }
            
            if(custNm.getText().isEmpty()){
            
                cLabel.setText("*");
                
            }
            
            if(!custNm.getText().isEmpty() && (custNm.getText().matches("^[0-9]+") || !custNm.getText().matches("^[a-z,A-Z]+"))){
            
                JOptionPane.showMessageDialog(null, custNm.getText() + " is an invalid input!");
                custNm.setText("");
                cLabel.setText("*");
                
            }
            
            if(custSnm.getText().isEmpty()){
            
                sLabel.setText("*");
                
            }
            
            if(!custSnm.getText().isEmpty() && (custSnm.getText().matches("^[0-9]+") || !custSnm.getText().matches("^[a-z,A-Z]+"))){
            
                JOptionPane.showMessageDialog(null, custSnm.getText() + " is an invalid input!");
                custSnm.setText("");
                sLabel.setText("*");
                
            }
            
            if(custPhNum.getText().isEmpty()){
            
                phLabel.setText("*");
            
            }
       
            //conditions for customer number
            if (!custPhNum.getText().isEmpty()){
            
                 
                  if(custPhNum.getText().matches("^[a-z,A-Z]+") || !custPhNum.getText().matches("^[0-9]+")){
                 
                      JOptionPane.showMessageDialog(null, custPhNum.getText() + "invalid input!");
                      phLabel.setText("*");
                      custPhNum.setText("");
                 
                 }
                 
                  if(custPhNum.getText().matches("^[0-9]+") && custPhNum.getText().length() != 10){
                 
                      JOptionPane.showMessageDialog(null, "Invalid cell/tel length! number must be 10 digits long!");
                      phLabel.setText("*");
                      custPhNum.setText("");
                 
                 }
                  
                  if(numberExists == true){
                
                     JOptionPane.showMessageDialog(null, custPhNum.getText() + " already exists for another customer!");
                     phLabel.setText("*");
                     custPhNum.setText("");
                 
                 }
            
            }

        }
        
        catch(InputMismatchException ie){
        
            System.out.println(ie.getMessage());
        
        }
        
        finally{
            
            if((!custNm.getText().isEmpty() && custNm.getText().matches("^[a-z,A-Z]+")) && (!custSnm.getText().isEmpty() && custSnm.getText().matches("^[a-z,A-Z]+")) && (!custPhNum.getText().isEmpty() && custPhNum.getText().matches("^[0-9]+") && numberExists == false)){
                
//                ArrayList<Customer> allCustomers = clientCode.getAllCustomers();
//                boolean cusExists = false;
//            
//                for(int i = 0; i < allCustomers.size(); i++){
//
//                    if(custNm.getText().equals(allCustomers.get(i).getFirstName()) && custSnm.getText().equals(allCustomers.get(i).getSurname())){
//                        
//                        cusExists = true;
//                        
//                    }
//
//                }
//                
//                if(cusExists == false){
                    
                    String name = custNm.getText();
                    String surname = custSnm.getText();
                    String phone = custPhNum.getText();

                    int id = clientCode.getLatestCusNumber();
        
                    Customer me = new Customer(id, name, surname, phone, 100, true);
                    clientCode.addNewCustomer(me);

                    ClientDvdRental.cusModel.addData(me);
                    ClientDvdRental.cusModel.fireTableDataChanged();
//                }
//                
//                else if(cusExists == true){
//                    
//                    JOptionPane.showMessageDialog(null, "Customer Already Exists!");
//                    
//                }
//                
//
//            }
//
            custNm.setText("");
            custSnm.setText("");
            custPhNum.setText("");
            
          }
            
        }
    
    }//GEN-LAST:event_addCustBtnActionPerformed

    private void addDVDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addDVDMouseClicked
        CardLayout card = (CardLayout) Main.getLayout();
        card.show(Main, "movie");
    }//GEN-LAST:event_addDVDMouseClicked

    private void customerListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerListMouseClicked

        
        CardLayout card = (CardLayout) Main.getLayout();
        card.show(Main, "customerTable");
        
        //clientCode.populateCustomerTable();
        
    }//GEN-LAST:event_customerListMouseClicked

    private void movieListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movieListMouseClicked
        
        CardLayout card = (CardLayout) Main.getLayout();
        card.show(Main, "movieTable");
        
    }//GEN-LAST:event_movieListMouseClicked

    private void rentDVDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rentDVDMouseClicked

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RentalForm();
            }
        });        
        
    }//GEN-LAST:event_rentDVDMouseClicked

    private void addMovieBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMovieBtnActionPerformed
        
        
        boolean dvdExist = false;
        //Checking for matching dvd number in MOVIES table
        for (int i = 0; i < allDvds.size(); i++) {
            
              String dvdInList = allDvds.get(i).getTitle();
            
            if(movieTitle.getText().equalsIgnoreCase(dvdInList)){
            
               dvdExist = true;
               break;
              
            }
            
        }
        
        try {
            
        if(movieTitle.getText().isEmpty() && (categoryComboBox.getSelectedIndex() == 0) && status.equals("")){
        
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
            mtLabel.setText("*");
            gLabel.setText("*");
            nrLabel.setText("*");
        
        }
        
        if(categoryComboBox.getSelectedIndex() == 0){
        
        JOptionPane.showMessageDialog(null, "please select a genre");
        gLabel.setText("*");
            
        }
        
        if(movieTitle.getText().isEmpty()){
        
             mtLabel.setText("*");
        
        }
        
        if(dvdExist == true){
        
           JOptionPane.showMessageDialog(null, movieTitle.getText() + " already exists!");
            mtLabel.setText("*");
        
        }
        
        if(status.equals("")){
        
            nrLabel.setText("*");
        
        }
        
        }catch(InputMismatchException ie){
        
            System.out.println(ie.getMessage());
        
        }finally {
            
            if((!movieTitle.getText().isEmpty() && dvdExist == false) && (categoryComboBox.getSelectedIndex() != 0) && (status.equals("true") || status.equals("false"))){
                
                String title = movieTitle.getText();
                
                int category = categoryComboBox.getSelectedIndex();       

                int id = clientCode.getLatestDvdNumber();
                
                DVD newDvd = new DVD(id, title, category, newRel, true);

                clientCode.addNewDvd(newDvd);
                
                ClientDvdRental.dvdModel.addData(newDvd);
                ClientDvdRental.dvdModel.fireTableDataChanged();
                
                //Resets the components
                movieTitle.setText("");
                categoryComboBox.setSelectedIndex(0);
                buttonGroup1.clearSelection();
                
            }
            
           movieTitle.setText("");
           categoryComboBox.setSelectedIndex(0);
           buttonGroup1.clearSelection();
    
        }
        
    }//GEN-LAST:event_addMovieBtnActionPerformed

    private void yesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesBtnActionPerformed
        
        status = "true";
        newRel = true;
        nrLabel.setText("");
        
    }//GEN-LAST:event_yesBtnActionPerformed

    private void noBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noBtnActionPerformed
        
       status = "false";
       newRel = false;
       nrLabel.setText("");
        
    }//GEN-LAST:event_noBtnActionPerformed

    private void categoryComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryComboBoxItemStateChanged

        
        gLabel.setText("");
        
         Object item = categoryComboBox.getSelectedItem();


            if(evt.getStateChange() == ItemEvent.SELECTED){

                if(movieCategories[0] == item){

                    valueInItem = String.valueOf(item);

                }

                else if(movieCategories[1] == item){

                    valueInItem = String.valueOf(item);

                }

                else if(movieCategories[2] == item){

                    valueInItem = String.valueOf(item);

                }

                else if(movieCategories[3] == item){

                    valueInItem = String.valueOf(item);

                }

                else if(movieCategories[4] == item){

                    valueInItem = String.valueOf(item);

                }

                else if(movieCategories[5] == item){

                    valueInItem = String.valueOf(item);

                }

                else if(movieCategories[6] == item){

                    valueInItem = String.valueOf(item);

                }

                else if(movieCategories[7] == item){

                    valueInItem = String.valueOf(item);

                }

            }
        
    }//GEN-LAST:event_categoryComboBoxItemStateChanged

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        
        CardLayout card = (CardLayout) Main.getLayout();
        card.show(Main, "home");
        
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        
        CardLayout card = (CardLayout) Main.getLayout();
        card.show(Main, "home");
        
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        
         CardLayout card = (CardLayout) Main.getLayout();
         card.show(Main, "home");
        
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        
        CardLayout card = (CardLayout) Main.getLayout();
         card.show(Main, "home");
        
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        
        CardLayout card = (CardLayout) Main.getLayout();
         card.show(Main, "home");
         
    }//GEN-LAST:event_jLabel25MouseClicked

    private void returnDVDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnDVDMouseClicked
       
        new ReturnDvd();
        
    }//GEN-LAST:event_returnDVDMouseClicked

    private void reportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseClicked
        
        CardLayout card = (CardLayout) Main.getLayout();
        card.show(Main, "rentTable");
        
        clientCode.populateRentalTable();
        
    }//GEN-LAST:event_reportsMouseClicked

    private void dateComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dateComboBoxItemStateChanged

        
        Object item = dateComboBox.getSelectedItem();
   
        for(int i = 0; i < rList.size(); i++){
            
                String rentalInList = rList.get(i).getDateRented();        
                String rentalInItem = (String) item;
               
            
            if(rentalInItem.equals(rentalInList)){
               
                rentalInNum = rList.get(i).getDateRented();
                
               
                break;
               
            }
        
        }
        
        
        
        
    }//GEN-LAST:event_dateComboBoxItemStateChanged

   
    
    
    private void allRentalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRentalsActionPerformed
       
        clientCode.populateRentalTable();
       na = "";
       TableRowSorter<RentTableModel> sorter = new TableRowSorter<RentTableModel>(ClientDvdRental.rentModel);
        
        jTable3.setRowSorter(sorter);
        
        sorter.setRowFilter(RowFilter.regexFilter(na, 2));
        
    }//GEN-LAST:event_allRentalsActionPerformed

    private void returnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnDateActionPerformed
        
        TableRowSorter<RentTableModel> sorter = new TableRowSorter<RentTableModel>(ClientDvdRental.rentModel);
        
         jTable3.setRowSorter(sorter);
        
        sorter.setRowFilter(RowFilter.regexFilter(rentalInNum, 1));

        
        //clientCode.getSelectedDate(rentalInNum);
        
    }//GEN-LAST:event_returnDateActionPerformed

    private void searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyReleased
        
        TableRowSorter<DvdTableModel> sorter = new TableRowSorter<DvdTableModel>(ClientDvdRental.dvdModel);
        
        jTable2.setRowSorter(sorter);
        
        String filterText = searchBar.getText();
        filterText = filterText.toUpperCase();
        
        if(filterText.length() == 0){
         
            sorter.setRowFilter(null);
        
        }
        
        else{
        
            String search = String.valueOf(filterText.charAt(0));
            sorter.setRowFilter(RowFilter.regexFilter("^" + search,1));
        
        }
        
    }//GEN-LAST:event_searchBarKeyReleased

    private void custNmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custNmKeyReleased
        
        cLabel.setText("");
        
    }//GEN-LAST:event_custNmKeyReleased

    private void custSnmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custSnmKeyReleased
        
        sLabel.setText("");
        
    }//GEN-LAST:event_custSnmKeyReleased

    private void custPhNumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custPhNumKeyReleased
        
        phLabel.setText("");
        
    }//GEN-LAST:event_custPhNumKeyReleased

    private void movieTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_movieTitleKeyReleased
        
        mtLabel.setText("");
        
    }//GEN-LAST:event_movieTitleKeyReleased

    private void returnDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnDate1ActionPerformed
        
        dateComboBox.setSelectedIndex(0);
        
        rentalInNum = "";
        
        TableRowSorter<RentTableModel> sorter = new TableRowSorter<RentTableModel>(ClientDvdRental.rentModel);
        
         jTable3.setRowSorter(sorter);
        
        sorter.setRowFilter(RowFilter.regexFilter(rentalInNum, 1));
        
    }//GEN-LAST:event_returnDate1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
        ClientDvdRental.closeConnection();
        System.exit(0);
        
        
    }//GEN-LAST:event_formWindowClosing

    private void rentalNAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentalNAActionPerformed

        //clientCode.populateRentalComboBox();
        na = "NA";

        TableRowSorter<RentTableModel> sorter = new TableRowSorter<RentTableModel>(ClientDvdRental.rentModel);
        
        jTable3.setRowSorter(sorter);
        
        sorter.setRowFilter(RowFilter.regexFilter(na, 2));
         
    }//GEN-LAST:event_rentalNAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    
    public void look(){
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        
        catch(Exception e){
            
            System.out.println("Couldnt apply laf");
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Main;
    private javax.swing.JLabel addCust;
    private javax.swing.JButton addCustBtn;
    private javax.swing.JPanel addCustomerPanel;
    private javax.swing.JLabel addDVD;
    private javax.swing.JButton addMovieBtn;
    private javax.swing.JPanel addMoviePanel;
    private javax.swing.JButton allRentals;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel cLabel;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JTextField custNm;
    private javax.swing.JTextField custPhNum;
    private javax.swing.JTextField custSnm;
    private javax.swing.JLabel customerList;
    private javax.swing.JPanel customerTable;
    private javax.swing.JLabel dat;
    public static javax.swing.JComboBox<String> dateComboBox;
    private javax.swing.JLabel gLabel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel movieList;
    private javax.swing.JPanel movieTable;
    private javax.swing.JTextField movieTitle;
    private javax.swing.JLabel mtLabel;
    private javax.swing.JRadioButton noBtn;
    private javax.swing.JLabel nrLabel;
    private javax.swing.JLabel phLabel;
    private javax.swing.JLabel rentDVD;
    private javax.swing.JButton rentalNA;
    private javax.swing.JPanel rentalTable;
    private javax.swing.JLabel reports;
    private javax.swing.JLabel returnDVD;
    private javax.swing.JButton returnDate;
    private javax.swing.JButton returnDate1;
    private javax.swing.JLabel sLabel;
    private javax.swing.JTextField searchBar;
    private javax.swing.JLabel tim;
    private javax.swing.JRadioButton yesBtn;
    // End of variables declaration//GEN-END:variables

    
    public class SortString implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
    
        }

       
        
        
    }

}

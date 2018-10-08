
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class ImportDataToDatabaseGUI extends javax.swing.JFrame {

    JFileChooser fChooser;
    
    public ImportDataToDatabaseGUI() {
        
        super("Import Data...");
        
        look();
        
        initComponents();
        
        fChooser = new JFileChooser();
        fChooser.addChoosableFileFilter(new ImportDataToDatabase.SerializedFileFilter());
        
        setVisible(true);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AddCustomers = new javax.swing.JLabel();
        AddDvd = new javax.swing.JLabel();
        AddRental = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(236, 67, 3));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Click the Icons to Import Data into Database");

        AddCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N
        AddCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddCustomersMouseClicked(evt);
            }
        });

        AddDvd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dvd.png"))); // NOI18N
        AddDvd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddDvdMouseClicked(evt);
            }
        });

        AddRental.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rentals3.png"))); // NOI18N
        AddRental.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddRentalMouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(236, 67, 3));
        jButton1.setText("OK");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(AddCustomers)
                        .addGap(57, 57, 57)
                        .addComponent(AddDvd)
                        .addGap(52, 52, 52)
                        .addComponent(AddRental))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AddRental)
                    .addComponent(AddCustomers)
                    .addComponent(AddDvd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddCustomersMouseClicked
       
         if(fChooser.showOpenDialog(ImportDataToDatabaseGUI.this) == JFileChooser.APPROVE_OPTION){
            
            ImportDataToDatabase.loadCusFromFile(fChooser.getSelectedFile());
  
            ImportDataToDatabase.checkIfAllTablesFilledYet();
        }
        
        
    }//GEN-LAST:event_AddCustomersMouseClicked

    private void AddDvdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddDvdMouseClicked
       
        if(fChooser.showOpenDialog(ImportDataToDatabaseGUI.this) == JFileChooser.APPROVE_OPTION){
            
          ImportDataToDatabase.loadDvdFromFile(fChooser.getSelectedFile());
          
          ImportDataToDatabase.checkIfAllTablesFilledYet();
          
        } 
        
    }//GEN-LAST:event_AddDvdMouseClicked

    private void AddRentalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddRentalMouseClicked
        
        if(fChooser.showOpenDialog(ImportDataToDatabaseGUI.this) == JFileChooser.APPROVE_OPTION){
            
            ImportDataToDatabase.loadRentalFromFile(fChooser.getSelectedFile());
      
            ImportDataToDatabase.checkIfAllTablesFilledYet();
            
            
        }   
        
    }//GEN-LAST:event_AddRentalMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
         System.exit(0);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
         
        JOptionPane.showMessageDialog(null, "Populate Database before closing");
        
        /*if(JOptionPane.showConfirmDialog(evt.getComponent(), "Close Window Without Populating Database?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
               
            try {
                ImportDataToDatabase.db.deleteTables();
                
                System.exit(0);
            } catch (SQLException ex) {
                Logger.getLogger(ImportDataToDatabaseGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
        }
        else{
            
            System.out.println("Not closing");
            
        }
        */    
        
    }//GEN-LAST:event_formWindowClosing

    
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
    private javax.swing.JLabel AddCustomers;
    private javax.swing.JLabel AddDvd;
    private javax.swing.JLabel AddRental;
    public static javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

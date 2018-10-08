import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/*
Authors: Mohammed Riaz Khan - 215099613
         Clayton Petersen - 216155231
*/

public class RentalForm extends javax.swing.JFrame {

    ClientDvdRental cCode = new ClientDvdRental();
    
    DefaultComboBoxModel<String> cusModels = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> catModels = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> titleModels = new DefaultComboBoxModel<>();
    
    ArrayList<Customer> customerlist ;
    ArrayList<DVD> dvdList;
    int[] customerNums;
    String[] cate;
    
    ArrayList<DVD> titles = new ArrayList<>();
    
    static int cusNumber;
    static int dvdNumber;
    
    static double cusCredit;
    static double dvdPrice;  
    
    double newCredit;
    
    
    
    public RentalForm() {
        look();
        initComponents();
        
        //cusbox.setSelectedIndex(-1);
        
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        
        customerlist = cCode.populateCusCombobox();
        dvdList = cCode.populateDvdCatCombobox();
        
        //this will populate the combo boxes
        customerNums = new int[customerlist.size()];
        
        //customerNums[0] = 0;
        //cusbox.addItem(customerNums[0]);
        
        for(int i = 0; i < customerlist.size(); i++){
            
            int num = customerlist.get(i).getCustNumber();
            
            customerNums[i]  = num;
            
            cusbox.addItem(customerNums[i]);
         
        }
        
        cusbox.setSelectedItem(0);
        
        cate = new String[dvdList.size()+1];
        
        //cate[0] = "-";
        //catBox.addItem(cate[0]);
        
        for(int i = 0; i < dvdList.size(); i++){
            
            String category = dvdList.get(i).getCategory();
            
            cate[i] = category;
            
            catBox.addItem(cate[i]);
            
        }
        
        catBox.setSelectedItem("-");
       
        jLabel12.setText(cCode.getCurrentDate());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cusbox = new javax.swing.JComboBox();
        catBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        titleBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        p = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rent Movie");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 350));

        cusbox.setModel(cusModels);
        cusbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cusboxItemStateChanged(evt);
            }
        });

        catBox.setModel(catModels);
        catBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                catBoxItemStateChanged(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Rent");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        titleBox.setModel(titleModels);
        titleBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                titleBoxItemStateChanged(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                 R");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First Name");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone Number");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Credit");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel6");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("jLabel7");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Surname");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("jLabel9");

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rentals3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(52, 52, 52))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        p.setForeground(new java.awt.Color(255, 255, 255));
        p.setText("10");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Date");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("jLabel7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(catBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(13, 13, 13))
                                .addComponent(cusbox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(80, 80, 80))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(cusbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(catBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titleBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cusboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cusboxItemStateChanged
        
        Object item = cusbox.getSelectedItem();
        
        for(int i = 0; i < customerlist.size(); i++){
            
            int numInList = customerlist.get(i).getCustNumber();
            int numInItem = (int) item;
            
            if(numInItem == numInList){
                
                String cName = customerlist.get(i).getFirstName();
                
                jLabel3.setText(cName);
                
                String surname = customerlist.get(i).getSurname();
                jLabel9.setText(surname);
                
                String phoneNum = customerlist.get(i).getPhoneNum();
                jLabel6.setText(phoneNum);
                
                double cre = customerlist.get(i).getCredit();
                String credit = String.valueOf(cre);
                
                jLabel7.setText(credit);
                
                cusNumber = numInItem;
                cusCredit = customerlist.get(i).getCredit();
                
                break;
                     
                
            }
            else if(numInItem == 0){
                
                jLabel7.setText("");
                jLabel6.setText("");
                jLabel9.setText("");
                jLabel3.setText("");
                
            }
     
        }
           
    }//GEN-LAST:event_cusboxItemStateChanged

    private void catBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_catBoxItemStateChanged
        
       titles.clear();
       titleBox.removeAllItems();
       
       Object item = catBox.getSelectedItem();
        
       for(int i = 0; i < dvdList.size(); i++){
            
            String catInList = dvdList.get(i).getCategory();
            String catInItem = (String) item;
            
            if(catInItem.equals(catInList)){
              
                String title = dvdList.get(i).getTitle();
                
                titles.add(dvdList.get(i));
                
                titleBox.addItem(title);
                
                //dvdNumber = dvdList.get(i).getDvdNumber();
               
            }
        
       }
    }//GEN-LAST:event_catBoxItemStateChanged

    private void titleBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_titleBoxItemStateChanged
      
       Object item = titleBox.getSelectedItem();
       
       for(int i = 0; i < titles.size(); i++){
            
            String titleInList = titles.get(i).getTitle();
            String titleInItem = (String) item;
            
            if(titleInItem.equals(titleInList)){
             
                dvdNumber = titles.get(i).getDvdNumber();
                dvdPrice = titles.get(i).getPrice();
                p.setText(String.valueOf(dvdPrice));
                break;
               
            }
       
       }
        
        
    }//GEN-LAST:event_titleBoxItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
          cCode.rentDvd(customerlist, cusNumber, dvdList, dvdNumber);
          System.out.println("Working");
          dispose();
          
      
       
    }//GEN-LAST:event_jButton1ActionPerformed


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
    public static javax.swing.JComboBox catBox;
    private javax.swing.JComboBox cusbox;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel p;
    public static javax.swing.JComboBox<String> titleBox;
    // End of variables declaration//GEN-END:variables
}

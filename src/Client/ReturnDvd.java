
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;

/*
Authors: Mohammed Riaz Khan - 215099613
         Clayton Petersen - 216155231
*/


public class ReturnDvd extends javax.swing.JFrame {

    ClientDvdRental cCode = new ClientDvdRental();
    
    DefaultComboBoxModel<String> rentNum = new DefaultComboBoxModel<>();
    
    ArrayList<Rental> rList;
    ArrayList<Customer> cList;
    ArrayList<DVD> dList;
    
    int[] rentalNumber;
    int[] customerNum;  
    int[] dvdNum;
    
    String[] rentalNums;
    
    int rentCode;
    int cusCode;
    int dvdCode;
    
  
    public ReturnDvd() {
        
        look();
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(ReturnDvd.DISPOSE_ON_CLOSE);
        setResizable(false);
        //adding rentals to the rList 
        rList = cCode.populateRentalComboBox();
        cList = cCode.populateReturnCustComboBox();
        dList = cCode.populateReturnDvdTitle();
        
        rentalNumber = new int[rList.size()];
        
        for(int i = 0; i < rList.size(); i++){
            
            int num = rList.get(i).getRentalNumber();
            
            rentalNumber[i] = num;
            
            rentalComboBox.addItem(rentalNumber[i]);
         
        }
        
         rentalComboBox.setSelectedItem(0);
         
         //adding customers to the clist
         customerNum = new int[cList.size()];
         
         for(int i = 0; i < cList.size(); i++){
            
            int cName = cList.get(i).getCustNumber();
            
            customerNum[i] = cName;
            
        }
         
         dvdNum = new int[dList.size()];
        
         for(int i = 0; i < dList.size(); i++){
         
             int mTitle = dList.get(i).getDvdNumber();
             
             dvdNum[i] = mTitle; 
             
         }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rentalComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        rentDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        custNm = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        movTitle = new javax.swing.JLabel();
        returnCopy = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fee = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Return Movie");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        rentalComboBox.setModel(rentNum);
        rentalComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rentalComboBoxItemStateChanged(evt);
            }
        });
        rentalComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Choose a rental number");

        rentDate.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Date Rented ");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Customer name:");

        custNm.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MovieTitle");

        movTitle.setForeground(new java.awt.Color(255, 255, 255));

        returnCopy.setBackground(new java.awt.Color(255, 102, 0));
        returnCopy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        returnCopy.setForeground(new java.awt.Color(255, 255, 255));
        returnCopy.setText("Return");
        returnCopy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        returnCopy.setContentAreaFilled(false);
        returnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnCopyActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Late Fee");

        fee.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/returnDVD.png"))); // NOI18N

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rentalComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(movTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(custNm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fee, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(returnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rentalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rentDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(custNm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(movTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(fee, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addComponent(returnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        movTitle.getAccessibleContext().setAccessibleName("movieTitle");

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

    private void rentalComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rentalComboBoxItemStateChanged
        
        
        int rentalInNum = 0;
        int rentalDvdNum = 0;
        
        Date today = new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        String dat = sdf.format(today);
        
        Object item = rentalComboBox.getSelectedItem();
        
        for(int i = 0; i < rList.size(); i++){
            
                int rentalInList = rList.get(i).getRentalNumber();        
                int rentalInItem = (int) item;
               
            
            if(rentalInItem == rentalInList){
              
                rentDate.setText(rList.get(i).getDateRented());  
                rentalInNum = rList.get(i).getCustNumber();
                rentalDvdNum = rList.get(i).getDvdNumber();
                rentCode = rentalInItem;
               
                double calc = determineTotalPenaltyCost(rList.get(i).getDateRented(), dat);
                
                String tempCalc = String.valueOf(calc);
                
                fee.setText("R" + tempCalc);
                break;
               
            }
            
        
        }
        
        //Checking for matching customer number in CUSTOMER table
        for(int i = 0; i < cList.size(); i++){
            
                  int custInList = cList.get(i).getCustNumber();
            
                        if(custInList == rentalInNum){

                            custNm.setText(cList.get(i).getFirstName());
                            cusCode = custInList; 
                            break;

                        }
            
        
        }
        
         //Checking for matching dvd number in MOVIES table
        for (int i = 0; i < dList.size(); i++) {
            
              int dvdInList = dList.get(i).getDvdNumber();
            
            if(dvdInList == rentalDvdNum){
            
              movTitle.setText(dList.get(i).getTitle());
              dvdCode = dvdInList;
              break;
              
            }
            
        }
   
        
    }//GEN-LAST:event_rentalComboBoxItemStateChanged

    
    public double determineTotalPenaltyCost(String rent, String ret){
        
        return numberOfDaysOverdue(rent, ret) * 5;
        
    }
    
    private int dateDifference(String dateRented, String dateReturned) {
        int yyyy, mm, dd;
        StringTokenizer token;
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        
        token = new StringTokenizer(dateRented, "/");
        yyyy = Integer.parseInt(token.nextToken());
        mm = Integer.parseInt(token.nextToken());
        dd = Integer.parseInt(token.nextToken());
        cal1.set(yyyy, mm, dd); 
        if (!dateReturned.equalsIgnoreCase("NA")){
            token = new StringTokenizer(dateReturned, "/");
            yyyy = Integer.parseInt(token.nextToken());
            mm = Integer.parseInt(token.nextToken());
            dd = Integer.parseInt(token.nextToken());
            cal2.set(yyyy, mm, dd);
            return (daysBetween(cal1.getTime(),cal2.getTime()));
        }
        else
            return (0);
    }
    
    private int daysBetween(Date d1, Date d2){
        
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24)+1);
        
    }
 
    public int numberOfDaysOverdue(String dateRented, String dateReturned){        
        
        int days = dateDifference(dateRented, dateReturned)-2;
        if (days < 0)
            return 0;
        else
            return days;
        
    }
    
    
    private void returnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnCopyActionPerformed
        
        cCode.returnDvd(rentCode);
        dispose();
        
    }//GEN-LAST:event_returnCopyActionPerformed

    private void rentalComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentalComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentalComboBoxActionPerformed

   
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
    private javax.swing.JLabel custNm;
    private javax.swing.JLabel fee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel movTitle;
    private javax.swing.JLabel rentDate;
    private javax.swing.JComboBox rentalComboBox;
    private javax.swing.JButton returnCopy;
    // End of variables declaration//GEN-END:variables
}

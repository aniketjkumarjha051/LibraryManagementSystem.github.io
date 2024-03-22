/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author anike
 */
public final class ManageStudents extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form ManageBooks
     */
    private String studentName;
    /**
     * Creates new form ManageBooks
     */
    private String Course;
    private String branch;
    private int studentID;
    private DefaultTableModel model;
    
    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }
    // to set the Student detail into the table 
    public void setStudentDetailsToTable(){
        
        try {
              Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library_ms","root","aniket&12"); 
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs =  st.executeQuery("select * from student_details");
            
            while(rs.next()){
                String StudentId = rs.getString("student_id");
                String StudentName = rs.getString("student_name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");
                
                Object[] obj = {StudentId,StudentName,course,branch};
                setModel((DefaultTableModel) tbl_StudentDetails.getModel());
                getModel().addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //to add student to student_details table
    public boolean addStudent(){
        boolean isAdded = false;
        studentID = Integer.parseInt(txt_StudentId.getText());
        studentName =txt_StudentName.getText();
        Course = Combo_CourseName.getSelectedItem().toString();
        branch = Combo_Branch.getSelectedItem().toString();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into student_details value (?,?,?,?)";
            PreparedStatement  pst = con.prepareStatement(sql);
            pst.setInt(1, studentID);
            pst.setString(2, studentName);
            pst.setString(3, Course);
            pst.setString(4, branch);
              
            int rowCount =  pst.executeUpdate();
            if(rowCount >0){
              isAdded = true;
            }else{
                isAdded = false;
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
    //to update student details
    public boolean updateStudent(){
         boolean isUpdated = false;
        studentID = Integer.parseInt(txt_StudentId.getText());
        studentName =txt_StudentName.getText();
        Course = Combo_CourseName.getSelectedItem().toString();
        branch = Combo_Branch.getSelectedItem().toString();
        
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "Update student_details set student_name = ?,course = ?,branch = ? where Student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentName);
            pst.setString(2,Course );
            pst.setString(3, branch);
            pst.setInt(4, studentID);
            
             int rowCount = pst.executeUpdate();
              if (rowCount >0){
                isUpdated = true;
            }else{
                isUpdated= false;
              }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
//method to delete book details
    public boolean deleteStudent(){
        boolean isDeleted = false;
        studentID = Integer.parseInt(txt_StudentId.getText());
        
        try {
             Connection con = DBConnection.getConnection();
             String sql = "delete from student_details where student_id = ?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, studentID);
             
              int rowCount = pst.executeUpdate();
               if (rowCount >0){
                isDeleted = true;
            }else{
                isDeleted= false;
              }
              
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    
    
    // method to clear table
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_StudentDetails.getModel();
        model.setRowCount(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_StudentName = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_StudentId = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        Combo_Branch = new javax.swing.JComboBox<>();
        Combo_CourseName = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_StudentDetails = new rojerusan.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 50));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel13.setText("Username");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 50, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Verdana", 0, 23)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Enter Student Name:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        txt_StudentName.setBackground(new java.awt.Color(102, 102, 255));
        txt_StudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_StudentName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_StudentName.setPlaceholder("Enter Student Name: ......");
        txt_StudentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_StudentNameFocusLost(evt);
            }
        });
        txt_StudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_StudentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 340, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jLabel14.setText("Username");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 50, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Verdana", 0, 23)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Select Branch");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Verdana", 0, 23)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Select Course");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel15.setText("Username");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 50, 50));

        txt_StudentId.setBackground(new java.awt.Color(102, 102, 255));
        txt_StudentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_StudentId.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_StudentId.setPlaceholder("Enter Student Id.......");
        txt_StudentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_StudentIdFocusLost(evt);
            }
        });
        txt_StudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_StudentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_StudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 340, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Verdana", 0, 23)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Enter Student Id");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jLabel16.setText("Username");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 50, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("DELETE");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, 140, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 140, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("Update");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 140, 70));

        Combo_Branch.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        Combo_Branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "ELECTRONIC", "CIVIL", "CSE", "MECHANICAL" }));
        jPanel1.add(Combo_Branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 360, 40));

        Combo_CourseName.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        Combo_CourseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B-Tech", "BSC", "MSC", "PHD", " " }));
        Combo_CourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_CourseNameActionPerformed(evt);
            }
        });
        jPanel1.add(Combo_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 350, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setFont(new java.awt.Font("Verdana", 1, 35)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(102, 102, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 0, 110, 40));

        tbl_StudentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_StudentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_StudentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_StudentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_StudentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_StudentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_StudentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_StudentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_StudentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        tbl_StudentDetails.setRowHeight(40);
        tbl_StudentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_StudentDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_StudentDetails);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 760, 300));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText(" Manage Students");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, 360, -1));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 170, 370, 10));

        setSize(new java.awt.Dimension(1544, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_StudentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_StudentNameFocusLost

    }//GEN-LAST:event_txt_StudentNameFocusLost

    private void txt_StudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_StudentNameActionPerformed

    }//GEN-LAST:event_txt_StudentNameActionPerformed

    private void txt_StudentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_StudentIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_StudentIdFocusLost

    private void txt_StudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_StudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_StudentIdActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Homepage home = new Homepage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        int rowNo = tbl_StudentDetails.getSelectedRow();
        TableModel model = tbl_StudentDetails.getModel();
        
        txt_StudentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_StudentName.setText(model.getValueAt(rowNo, 1).toString());
       
    }//GEN-LAST:event_formMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
       if (addStudent()== true){
           JOptionPane.showMessageDialog(this, "Student Added");
           clearTable();
           setStudentDetailsToTable();
       }else{
           JOptionPane.showMessageDialog(this, "Student Addition Failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if (updateStudent()== true){
           JOptionPane.showMessageDialog(this, "Student Updated");
           clearTable();
           setStudentDetailsToTable();
       }else{
           JOptionPane.showMessageDialog(this, "Student Updation Failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
         if (deleteStudent()== true){
           JOptionPane.showMessageDialog(this, "student Delete");
           clearTable();
          setStudentDetailsToTable();
       }else{
           JOptionPane.showMessageDialog(this, "student Deletion Failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void Combo_CourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_CourseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_CourseNameActionPerformed

    private void tbl_StudentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_StudentDetailsMouseClicked
         int rowNo = tbl_StudentDetails.getSelectedRow();
        TableModel model = tbl_StudentDetails.getModel();
        
        txt_StudentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_StudentName.setText(model.getValueAt(rowNo, 1).toString());
       Combo_CourseName.setSelectedItem(model.getValueAt(rowNo, 2).toString());
       Combo_Branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tbl_StudentDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_Branch;
    private javax.swing.JComboBox<String> Combo_CourseName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSTableMetro tbl_StudentDetails;
    private app.bolivia.swing.JCTextField txt_StudentId;
    private app.bolivia.swing.JCTextField txt_StudentName;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the book_name
     */
    public String getStudent_name() {
        return studentName;
    }

    /**
     * @param Student_name
     */
    public void setStudent_name(String Student_name) {
        this.studentName = Student_name;
    }

    /**
     * @return the author
     */
    public String getcourse() {
        return Course;
    }

    /**
     * @param course
     */
    public void setcourse(String course) {
        this.Course = Course;
    }

    /**
     * @return the book_id
     */
    public int getBook_id() {
        return studentID;
    }

    /**
     * @param book_id the book_id to set
     */
    public void setstudent_id(int book_id) {
        int Student_id = 0;
        this.studentID = Student_id;
    }

    /**
     * @return the quantity
     */
    public String getbranch() {
        return branch;
    }

    /**
     * @param branch the quantity to set
     */
    public void setbranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return the model
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
}

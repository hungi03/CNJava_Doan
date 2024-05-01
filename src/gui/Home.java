/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author HUNG
 */
public class Home extends javax.swing.JFrame {

 
    public Home() {
        initComponents();
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
        roundPanel1 = new jpanel.RoundPanel();
        btn_one = new jpanel.RoundPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_one1 = new jpanel.RoundPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_one2 = new jpanel.RoundPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btn_one3 = new jpanel.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btn_one4 = new jpanel.RoundPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        roundPanel2 = new jpanel.RoundPanel();
        imageAvatar1 = new jpanel.ImageAvatar();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setRoundBottomLeft(10);
        roundPanel1.setRoundBottomRight(10);
        roundPanel1.setRoundTopLeft(10);
        roundPanel1.setRoundTopRight(10);

        btn_one.setBackground(new java.awt.Color(51, 51, 51));
        btn_one.setRoundBottomLeft(20);
        btn_one.setRoundBottomRight(20);
        btn_one.setRoundTopLeft(20);
        btn_one.setRoundTopRight(20);
        btn_one.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_oneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_oneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_oneMouseExited(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Trang chủ");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_home.png"))); // NOI18N

        javax.swing.GroupLayout btn_oneLayout = new javax.swing.GroupLayout(btn_one);
        btn_one.setLayout(btn_oneLayout);
        btn_oneLayout.setHorizontalGroup(
            btn_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_oneLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        btn_oneLayout.setVerticalGroup(
            btn_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_oneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(btn_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btn_one1.setBackground(new java.awt.Color(51, 51, 51));
        btn_one1.setRoundBottomLeft(20);
        btn_one1.setRoundBottomRight(20);
        btn_one1.setRoundTopLeft(20);
        btn_one1.setRoundTopRight(20);
        btn_one1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_one1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_one1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_one1MouseExited(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_home.png"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Trang chủ");

        javax.swing.GroupLayout btn_one1Layout = new javax.swing.GroupLayout(btn_one1);
        btn_one1.setLayout(btn_one1Layout);
        btn_one1Layout.setHorizontalGroup(
            btn_one1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_one1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_one1Layout.setVerticalGroup(
            btn_one1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_one1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_one1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btn_one2.setBackground(new java.awt.Color(51, 51, 51));
        btn_one2.setRoundBottomLeft(20);
        btn_one2.setRoundBottomRight(20);
        btn_one2.setRoundTopLeft(20);
        btn_one2.setRoundTopRight(20);
        btn_one2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_one2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_one2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_one2MouseExited(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Trang chủ");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_home.png"))); // NOI18N

        javax.swing.GroupLayout btn_one2Layout = new javax.swing.GroupLayout(btn_one2);
        btn_one2.setLayout(btn_one2Layout);
        btn_one2Layout.setHorizontalGroup(
            btn_one2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_one2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        btn_one2Layout.setVerticalGroup(
            btn_one2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_one2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(btn_one2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel8))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btn_one3.setBackground(new java.awt.Color(51, 51, 51));
        btn_one3.setRoundBottomLeft(20);
        btn_one3.setRoundBottomRight(20);
        btn_one3.setRoundTopLeft(20);
        btn_one3.setRoundTopRight(20);
        btn_one3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_one3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_one3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_one3MouseExited(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Trang chủ");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_home.png"))); // NOI18N

        javax.swing.GroupLayout btn_one3Layout = new javax.swing.GroupLayout(btn_one3);
        btn_one3.setLayout(btn_one3Layout);
        btn_one3Layout.setHorizontalGroup(
            btn_one3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_one3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        btn_one3Layout.setVerticalGroup(
            btn_one3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_one3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(btn_one3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel10))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btn_one4.setBackground(new java.awt.Color(51, 51, 51));
        btn_one4.setRoundBottomLeft(20);
        btn_one4.setRoundBottomRight(20);
        btn_one4.setRoundTopLeft(20);
        btn_one4.setRoundTopRight(20);
        btn_one4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_one4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_one4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_one4MouseExited(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Trang chủ");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_home.png"))); // NOI18N

        javax.swing.GroupLayout btn_one4Layout = new javax.swing.GroupLayout(btn_one4);
        btn_one4.setLayout(btn_one4Layout);
        btn_one4Layout.setHorizontalGroup(
            btn_one4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_one4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        btn_one4Layout.setVerticalGroup(
            btn_one4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_one4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(btn_one4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel12))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_one, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_one1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_one2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_one3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_one4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btn_one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_one1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_one2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_one3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_one4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel2.setRoundBottomLeft(10);
        roundPanel2.setRoundBottomRight(10);
        roundPanel2.setRoundTopLeft(10);
        roundPanel2.setRoundTopRight(10);

        imageAvatar1.setForeground(new java.awt.Color(102, 204, 255));
        imageAvatar1.setBorderSize(3);
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image_example (1).jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Admin");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 700));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 767, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(668, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 800, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
        int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát khỏi phần mềm ?", "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {

            System.exit(0);
        } else {

        }
    }//GEN-LAST:event_jLabel2MouseClicked

    boolean click_item_menu=true;
    private void btn_oneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_oneMouseEntered
        // TODO add your handling code here:
          btn_one.setBackground(new Color(52, 125, 252));
          click_item_menu=true;
    }//GEN-LAST:event_btn_oneMouseEntered

    private void btn_oneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_oneMouseExited
        // TODO add your handling code here:
         System.out.println(click_item_menu);
        if(click_item_menu){
             btn_one.setBackground(new Color(51, 51, 51));
        }
         
    }//GEN-LAST:event_btn_oneMouseExited

    private void btn_one1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_one1MouseEntered
        // TODO add your handling code here:
         btn_one1.setBackground(new Color(52, 125, 252));
            click_item_menu=true;
    }//GEN-LAST:event_btn_one1MouseEntered

    private void btn_one1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_one1MouseExited
        // TODO add your handling code here:
         System.out.println(click_item_menu);
          if(click_item_menu){
             btn_one1.setBackground(new Color(51, 51, 51));
        }
          System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_one1MouseExited

    private void btn_oneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_oneMouseClicked
        // TODO add your handling code here:
        click_item_menu=true;
         System.out.println(click_item_menu);
        if(click_item_menu){
            btn_one.setBackground(new Color(52, 125, 252));
             btn_one1.setBackground(new Color(51, 51, 51));
             btn_one2.setBackground(new Color(51, 51, 51));
             btn_one3.setBackground(new Color(51, 51, 51));
             btn_one4.setBackground(new Color(51, 51, 51));
        }
        click_item_menu=false;
         System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_oneMouseClicked

    private void btn_one1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_one1MouseClicked
        // TODO add your handling code here:
        click_item_menu=true;
         System.out.println(click_item_menu);
        if(click_item_menu){
             btn_one1.setBackground(new Color(52, 125, 252));
             btn_one.setBackground(new Color(51, 51, 51));
             btn_one2.setBackground(new Color(51, 51, 51));
             btn_one3.setBackground(new Color(51, 51, 51));
             btn_one4.setBackground(new Color(51, 51, 51));
        }
        click_item_menu=false;
         System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_one1MouseClicked

    private void btn_one2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_one2MouseClicked
        // TODO add your handling code here:
         click_item_menu=true;
         System.out.println(click_item_menu);
        if(click_item_menu){
                btn_one2.setBackground(new Color(52, 125, 252));
             btn_one.setBackground(new Color(51, 51, 51));
             btn_one1.setBackground(new Color(51, 51, 51));
             btn_one3.setBackground(new Color(51, 51, 51));
             btn_one4.setBackground(new Color(51, 51, 51));
        }
        click_item_menu=false;
         System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_one2MouseClicked

    private void btn_one2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_one2MouseEntered
        // TODO add your handling code here:
        btn_one2.setBackground(new Color(52, 125, 252));
        click_item_menu=true;
    }//GEN-LAST:event_btn_one2MouseEntered

    private void btn_one2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_one2MouseExited
        // TODO add your handling code here:
             // TODO add your handling code here:
         System.out.println(click_item_menu);
          if(click_item_menu){
             btn_one2.setBackground(new Color(51, 51, 51));
        }
          System.out.println(click_item_menu);
       
    }//GEN-LAST:event_btn_one2MouseExited

    private void btn_one3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_one3MouseClicked
        // TODO add your handling code here:
         click_item_menu=true;
         System.out.println(click_item_menu);
        if(click_item_menu){
                btn_one3.setBackground(new Color(52, 125, 252));
             btn_one.setBackground(new Color(51, 51, 51));
             btn_one1.setBackground(new Color(51, 51, 51));
             btn_one2.setBackground(new Color(51, 51, 51));
             btn_one4.setBackground(new Color(51, 51, 51));
        }
        click_item_menu=false;
         System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_one3MouseClicked

    private void btn_one4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_one4MouseClicked
        // TODO add your handling code here:
         click_item_menu=true;
         System.out.println(click_item_menu);
        if(click_item_menu){
                btn_one4.setBackground(new Color(52, 125, 252));
             btn_one.setBackground(new Color(51, 51, 51));
             btn_one1.setBackground(new Color(51, 51, 51));
             btn_one3.setBackground(new Color(51, 51, 51));
             btn_one2.setBackground(new Color(51, 51, 51));
        }
        click_item_menu=false;
         System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_one4MouseClicked

    private void btn_one3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_one3MouseEntered
        // TODO add your handling code here:
          btn_one3.setBackground(new Color(52, 125, 252));
          click_item_menu=true;
    }//GEN-LAST:event_btn_one3MouseEntered

    private void btn_one4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_one4MouseEntered
        // TODO add your handling code here:
          btn_one4.setBackground(new Color(52, 125, 252));
          click_item_menu=true;
    }//GEN-LAST:event_btn_one4MouseEntered

    private void btn_one3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_one3MouseExited
        // TODO add your handling code here:
         System.out.println(click_item_menu);
          if(click_item_menu){
             btn_one3.setBackground(new Color(51, 51, 51));
        }
          System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_one3MouseExited

    private void btn_one4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_one4MouseExited
        // TODO add your handling code here:
          System.out.println(click_item_menu);
          if(click_item_menu){
             btn_one4.setBackground(new Color(51, 51, 51));
        }
          System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_one4MouseExited

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jpanel.RoundPanel btn_one;
    private jpanel.RoundPanel btn_one1;
    private jpanel.RoundPanel btn_one2;
    private jpanel.RoundPanel btn_one3;
    private jpanel.RoundPanel btn_one4;
    private jpanel.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private jpanel.RoundPanel roundPanel1;
    private jpanel.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.frames;

import core.db.entity.Bank;
import core.db.impl.BankDaoImpl;
import core.db.ints.BankDao;

/**
 *
 * @author Slavomír
 */
public class bankSadzbaFrame extends javax.swing.JFrame
{

					private static BankDao bankDao = new BankDaoImpl();
					/**
					 * Creates new form bankSadzbaFrame
					 */
					private javax.swing.JFrame parent = null;
					private long bankId;

					public bankSadzbaFrame(Long idB, javax.swing.JFrame aThis)
					{
										initComponents();
										this.bankId = idB.longValue();
										this.parent = aThis;

										Bank bank = bankDao.getById(idB);
										double primeInterestRate = bank.getPrimeInterestRate();

										sadzbaOknoText.setText("" + primeInterestRate);
					}

					/**
					 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
					 */
					@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents()
     {

          sadzbaOknoText = new javax.swing.JTextField();
          zmenZakladnyUrokButton = new javax.swing.JButton();
          jLabel1 = new javax.swing.JLabel();

          sadzbaOknoText.setText("0.0");

          zmenZakladnyUrokButton.setText("Zmeniť");
          zmenZakladnyUrokButton.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    zmenZakladnyUrokButtonActionPerformed(evt);
               }
          });

          jLabel1.setText("Základná úroková sadzba");

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(zmenZakladnyUrokButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(sadzbaOknoText, javax.swing.GroupLayout.Alignment.TRAILING)
                         .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                    .addContainerGap())
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(sadzbaOknoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(zmenZakladnyUrokButton)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void zmenZakladnyUrokButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_zmenZakladnyUrokButtonActionPerformed
     {//GEN-HEADEREND:event_zmenZakladnyUrokButtonActionPerformed
										String interestRateString = sadzbaOknoText.getText();
										double interestRate = 2.0;
										try
										{
															interestRate = Double.parseDouble(interestRateString);
										}
										catch(NumberFormatException e)
										{
															return;
										}
										Bank bank = bankDao.getById(bankId);
										if(bank == null)
															return;

										bank.setPrimeInterestRate(interestRate);
										bankDao.updadeBank(bank);

										if(parent instanceof bankFrame)
										{
															bankFrame bf = (bankFrame)parent;
															bf.prepareLabels();
										}
											if(parent instanceof adminBankFrame)
										{
															adminBankFrame bf = (adminBankFrame)parent;
															bf.prepareTable();
										}
										this.setVisible(false);
     }//GEN-LAST:event_zmenZakladnyUrokButtonActionPerformed


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JLabel jLabel1;
     private javax.swing.JTextField sadzbaOknoText;
     private javax.swing.JButton zmenZakladnyUrokButton;
     // End of variables declaration//GEN-END:variables
}

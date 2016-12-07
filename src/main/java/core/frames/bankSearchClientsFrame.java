/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.frames;

import core.db.entity.BankCondition;
import core.db.entity.Condition;
import core.db.entity.DescriptedBankCondition;
import core.db.entity.Mark;
import core.db.impl.BankConditionDaoImpl;
import core.db.impl.ConditionDaoImpl;
import core.db.ints.BankConditionDao;
import core.db.ints.ConditionDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;

/**
 *
 * @author Slavomír
 */
public class bankSearchClientsFrame extends javax.swing.JFrame
{

					/**
					 * Creates new form bankSearchClientsFrame
					 */
					private Long idB = null;
					private BankConditionDao bankConditionDao = new BankConditionDaoImpl();
					private ConditionDao conditionDao = new ConditionDaoImpl();

					public bankSearchClientsFrame(Long idB)
					{
										initComponents();
										this.idB = idB;

										klientsList.removeAll();
										bankConditionsList.removeAll();
										List<Condition> conditions = conditionDao.getAll();

										List<BankCondition> bankConditions = bankConditionDao.getByBankId(idB);

										List<DescriptedBankCondition> dscBc = new ArrayList<DescriptedBankCondition>();

										for(BankCondition bc : bankConditions)
										{
															Long id = bc.getId();

															String description = "";
															Condition con = conditionDao.getById(bc.getIdC());

															
															DescriptedBankCondition ds = new DescriptedBankCondition(bc,con);
															dscBc.add(ds);
														
										}

										bankConditionsList.setListData(dscBc.toArray());
										setVisible(true);
					}

					/**
					 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
					 */
					@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents()
     {

          jComboBox1 = new javax.swing.JComboBox();
          jScrollPane1 = new javax.swing.JScrollPane();
          bankConditionsList = new javax.swing.JList();
          jScrollPane2 = new javax.swing.JScrollPane();
          klientsList = new javax.swing.JList();
          hladajButton = new javax.swing.JButton();

          jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

          setTitle("Banka Hladanie Klientov");

          bankConditionsList.addMouseListener(new java.awt.event.MouseAdapter()
          {
               public void mouseClicked(java.awt.event.MouseEvent evt)
               {
                    bankConditionsListMouseClicked(evt);
               }
          });
          jScrollPane1.setViewportView(bankConditionsList);

          jScrollPane2.setViewportView(klientsList);

          hladajButton.setText("Hľadaj");
          hladajButton.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    hladajButtonActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                         .addComponent(hladajButton, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                         .addComponent(jScrollPane1))
                    .addContainerGap())
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(13, 13, 13)
                    .addComponent(hladajButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void hladajButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_hladajButtonActionPerformed
     {//GEN-HEADEREND:event_hladajButtonActionPerformed
										// TODO add your handling code here:
     }//GEN-LAST:event_hladajButtonActionPerformed

     private void bankConditionsListMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bankConditionsListMouseClicked
     {//GEN-HEADEREND:event_bankConditionsListMouseClicked
										ListModel model = bankConditionsList.getModel();
										
     }//GEN-LAST:event_bankConditionsListMouseClicked


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JList bankConditionsList;
     private javax.swing.JButton hladajButton;
     private javax.swing.JComboBox jComboBox1;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JScrollPane jScrollPane2;
     private javax.swing.JList klientsList;
     // End of variables declaration//GEN-END:variables
}

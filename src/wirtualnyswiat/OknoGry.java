/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wirtualnyswiat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Dave
 */
public class OknoGry extends javax.swing.JFrame {

    /**
     * Creates new form MyJFrame
     */
    
   
    //pole swiat
    private Swiat swiat;
    //konstruktor generowany automatycznie
    public OknoGry() {
            initComponents();
        }
    private void pokazLegende()//wypisujemy legende
    {
        Graphics2D gfx = (Graphics2D)jPanel2.getGraphics();
        gfx.drawString("LEGENDA", 0, 25);
               gfx.setColor(Color.cyan);
        gfx.fillRect(0,45,20,20);   
               gfx.setColor(Color.green);
        gfx.fillRect(0,70,20,20);   
               gfx.setColor(Color.black);
        gfx.fillRect(0,95,20,20);   
               gfx.setColor(Color.yellow);
        gfx.fillRect(0,120,20,20);   
               gfx.setColor(Color.gray);
        gfx.fillRect(0,145,20,20);   
               gfx.setColor(Color.LIGHT_GRAY);
        gfx.fillRect(0,170,20,20);   
               gfx.setColor(Color.pink);
        gfx.fillRect(0,195,20,20);   
               gfx.setColor(Color.red);
        gfx.fillRect(0,220,20,20);   
               
        gfx.setColor(Color.black);
        gfx.drawString("Ciern", 25, 60);
        gfx.drawString("Trawa", 25, 85);
        gfx.drawString("Wilk", 25, 110);
        gfx.drawString("Owca", 25, 135);
        gfx.drawString("Zmija", 25, 160);
        gfx.drawString("Komar", 25, 185);
        gfx.drawString("Koza", 25, 210);
        gfx.drawString("Mlecz", 25, 235);
        
    
    }
    
    //rysowanie mapy
    private void rysujMape()
    {
        pokazLegende();
                
        //stworzenie obiektu klasy do rysowania na panelu 1
        Graphics2D gfx = (Graphics2D)jPanel1.getGraphics();
        
        //zamalowanie calej mapy 
        gfx.setColor(Color.white);
        gfx.fillRect(0,0,400,400);
        
        //RYSOWANIE organizmow na mapie
     
        for (Organizm org : swiat.getOrganizmy())
        {
            String nazwa = org.getNazwa();
            //ustawienie odpowiedniego koloru
            switch (nazwa)
            {
                case "Ciern": gfx.setColor(Color.cyan); break;
                case "Komar": gfx.setColor(Color.LIGHT_GRAY); break;
                case "Koza":  gfx.setColor(Color.pink); break;
                case "Mlecz": gfx.setColor(Color.red); break;
                case "Owca":  gfx.setColor(Color.yellow); break;
                case "Trawa": gfx.setColor(Color.green); break;
                case "Wilk":  gfx.setColor(Color.black); break;
                case "Zmija": gfx.setColor(Color.gray); break;    
            }
            //RYSOWANIE kwadratu odpowiadajacego za organizm
            gfx.fillRect(org.getPozX()* 20, org.getPozY() * 20, 20, 20);
        }
    
        //licznik organizmow
        jTextField1.setText("Organizmy: " + swiat.getOrganizmy().size());
        
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wirtualny Swiat");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setText("Kolejna tura");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setPreferredSize(new java.awt.Dimension(400, 64));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nowy świat");
        jButton2.setPreferredSize(new java.awt.Dimension(95, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Zapisz świat");
        jButton4.setPreferredSize(new java.awt.Dimension(95, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Otwórz świat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 5, Short.MAX_VALUE))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel1, jScrollPane1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(9, 9, 9)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    //akcja gdy nacisnie sie przycisk nastepna tura
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        swiat.wykonajTure();
        
        rysujMape();
            
        //jesli cos sie wydarzylo niech wypisze do pola tekstowego
        if(!swiat.getListaLog().isEmpty())
            for (String log : swiat.getListaLog())
                jTextArea1.append(log);

    }//GEN-LAST:event_jButton1ActionPerformed

    //akcja gdy nacisnie sie przycisk nowy swiat
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedOption = 0;
        if ( swiat != null)
             selectedOption = JOptionPane.showConfirmDialog(null, 
                                  "Swiat juz istnieje, chcesz nowy?", 
                                  "Jestes pewny?", 
                                  JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION)
        {
            //tworzymy swiat
            swiat = new Swiat();
            //usuwamy wszystko z logu
            jTextArea1.setText("");
            //rysujemy swiat
            rysujMape();
            //wlaczamy mozliwosc nacisniecia przycisku nastepna tura
            jButton1.setEnabled(true);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
        fileChooser.showSaveDialog(null);
        
        //dodawanie rozszerzenia txt jesli zapisujemy lub nie dodawanie jesli nadpisujemy istniejacy .txt
      
        File file;
        if (!fileChooser.getSelectedFile().getPath().contains(".txt"))
            file = new File(fileChooser.getSelectedFile()+".txt");
        else 
            file = fileChooser.getSelectedFile();
        try {
           
           
            try (FileWriter f = new FileWriter(file)) {
                for (Organizm org : swiat.getOrganizmy())
                {
                    f.write(org.getNazwa() + " " + org.getPozX() + " " + org.getPozY() + System.lineSeparator());
                }
           }
        } catch (IOException ex) {
            Logger.getLogger(OknoGry.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        //tymczasowa lista przechowujaca dane do stworzenia mapy z organizmami
        List<String> wczytanaMapa = new ArrayList<>();
        
        //utworzenieokno dialogowe wybierania pliku, filtry, 
        //i zeby nie mozna bylo kazdego pliku wybrac
        //i przypisanie wybranego pliku do "File" z ktorego sie bedzie korzystac
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        
        
        //wczytywanie z pliku, wczytujemy cala linie do strina a potem dzielimy na czesci
        //nazwa_organizmu - x - y
        try {
            try(Scanner reader = new Scanner(file))
            {
            while (reader.hasNext())
            {
                String line = reader.nextLine();
                String[] tokens = line.split(" ");
                if(tokens.length != 3)
                {
                    JOptionPane.showMessageDialog(null, "Zly plik mapy.");
                    throw new IllegalArgumentException();
                }
                String nazwa = tokens[0];
                String pozX = tokens[1];
                String pozY = tokens[2];
                wczytanaMapa.add(nazwa);
                wczytanaMapa.add(pozX);
                wczytanaMapa.add(pozY);
            }
            
            //usuwamy wszystko z logu
            jTextArea1.setText("");
            //wlaczenie mozliwosci kolejnej tury jesli jest wyl
            if (!jButton1.isEnabled())
                jButton1.setEnabled(true);
            swiat = new Swiat(wczytanaMapa);
            rysujMape();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OknoGry.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoGry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OknoGry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

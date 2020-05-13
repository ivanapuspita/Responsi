
package responsi123180125;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Tampil extends JFrame {
  JButton btnHome = new JButton("Home");
  JButton btnGaji = new JButton("Tambah");
  JButton btnData = new JButton("Data");
  JButton btnPetunjuk = new JButton("Petunjuk");
  JButton btnAdmin = new JButton("Karyawan");
  JLabel lText = new JLabel("Selamat Datang");
  JLabel lText2 = new JLabel("Silakan Masuk Menu Tambah untuk Menambah data");
  JLabel lText3 = new JLabel("Menu Petunjuk Jika Kesulitan");
  JLabel lText4 = new JLabel("APP PERHITUNGAN GAJI PT Veteran Jaya");

     public Tampil() {
     setTitle("Gaji");
     setDefaultCloseOperation(3);
     setSize(600,500);
     setLayout(null);
        

        add(btnHome);
        btnHome.setBounds(10, 20, 100,30);
        add(btnGaji);
        btnGaji.setBounds(10, 95, 100,30);
        add(btnData);
        btnData.setBounds(10, 130, 100,30);
        add(btnPetunjuk);
        btnPetunjuk.setBounds(10, 165, 100,30);
        add(btnAdmin);
        btnAdmin.setBounds(470,10, 100,30);
        
        add(lText);
        lText.setBounds(150, 100, 200,20);
         add(lText2);
        lText2.setBounds(150, 120, 300,20);
         add(lText3);
        lText3.setBounds(150, 140, 200,20);
         add(lText4);
        lText4.setBounds(180, 320, 250,80);
        
        setVisible(true);
          
        
        btnHome.addActionListener((ActionEvent e) -> {
          new Tampil();
           dispose();
        });
        btnGaji.addActionListener((ActionEvent e) -> {
           new Create();
           dispose();
           });
       
        btnData.addActionListener((ActionEvent e) -> {
           new Karyawan();
           dispose();
        });
        
        btnPetunjuk.addActionListener((ActionEvent e) -> {
           new PetunjukAdmin();
           dispose();
        });
        btnAdmin.addActionListener((ActionEvent e) -> {
           new GUI();
           dispose();
        });
        
        
       
        
       
        
    }   
}
